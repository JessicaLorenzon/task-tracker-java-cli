package model.entities;

import model.entities.enums.TarefaStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {

    private List<Tarefa> tarefas = new ArrayList<>();
    private Integer proximoId = 1;

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public Integer getProximoId() {
        return proximoId;
    }

    public void setProximoId(Integer proximoId) {
        this.proximoId = proximoId;
    }

    public void adicionarTarefa(String conteudo) {
        if (conteudo.isBlank()) {
            imprimir("Tarefa em branco. Tente novamente!");
        } else {
            tarefas.add(new Tarefa(proximoId, conteudo, TarefaStatus.PENDENTE));
            imprimir("Tarefa adicionada com sucesso (ID: " + getProximoId() + ")");
            proximoId++;
        }
    }

    public void removerTarefa(Integer id) {
        Tarefa tarefaRemover = procurarPorId(id);
        if (tarefaRemover != null) {
            tarefas.remove(tarefaRemover);
            imprimir("Tarefa com ID: " + id + " removida com sucesso!");
        }
    }

    public void atualizarTarefa(Integer id, String conteudo) {
        Tarefa tarefaAtualizar = procurarPorId(id);
        if (tarefaAtualizar != null) {
            tarefaAtualizar.setConteudo(conteudo);
            tarefaAtualizar.setDataAtualizacao(LocalDateTime.now());
            imprimir("Tarefa com ID: " + id + " atualizada com sucesso!");
        }
    }

    public void marcarEmAndamento(Integer id) {
        alterarStatus(TarefaStatus.EM_ANDAMENTO, id);
    }

    public void marcarConcluida(Integer id) {
        alterarStatus(TarefaStatus.CONCLUIDA, id);
    }

    public void listarTodas() {
        if (tarefas.isEmpty()) {
            imprimir("Lista de tarefas vazia. Adicione uma tarefa!");
        }
        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa);
        }
    }

    public void listarConcluidas() {
        procurarPorStatus(TarefaStatus.CONCLUIDA);
    }

    public void listarPendentes() {
        procurarPorStatus(TarefaStatus.PENDENTE);
    }

    public void listarEmAndamento() {
        procurarPorStatus(TarefaStatus.EM_ANDAMENTO);
    }

    public Tarefa procurarPorId(Integer id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                return tarefa;
            }
        }
        imprimir("Tarefa com ID: " + id + " não encontrada!");
        return null;
    }

    public void procurarPorStatus(TarefaStatus status) {
        boolean statusEncontrado = false;
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getStatus() == status) {
                System.out.println(tarefa);
                statusEncontrado = true;
            }
        }
        if (!statusEncontrado) {
            imprimir("Nenhuma tarefa com o status " + status + " encontrada.");
        }
    }

    public void alterarStatus(TarefaStatus status, Integer id) {
        Tarefa tarefaAlterarStatus = procurarPorId(id);
        if (tarefaAlterarStatus != null) {
            tarefaAlterarStatus.setStatus(status);
            tarefaAlterarStatus.setDataAtualizacao(LocalDateTime.now());
            imprimir("Status da tarefa com ID: " + id + " alterado com sucesso!");
        }
    }

    public void imprimir(String texto) {
        System.out.println(texto);
    }
}

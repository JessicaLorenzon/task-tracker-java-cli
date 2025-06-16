package models;

import enums.TarefaStatus;
import views.View;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {

    private List<Tarefa> tarefas = new ArrayList<>();
    private Integer proximoId = 1;

    private View view = new View();

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public Integer getProximoId() {
        return proximoId;
    }

    public void adicionarTarefa(String conteudo) {
        if (conteudo.isBlank()) {
            view.imprimirMensagem("Tarefa em branco. Tente novamente!");
        } else {
            tarefas.add(new Tarefa(proximoId, conteudo, TarefaStatus.PENDENTE));
            view.imprimirMensagem("Tarefa adicionada com sucesso (ID: " + getProximoId() + ")");
            proximoId++;
        }
    }

    public void removerTarefa(Integer id) {
        Tarefa tarefaRemover = procurarPorId(id);
        if (tarefaRemover != null) {
            tarefas.remove(tarefaRemover);
            view.imprimirMensagem("Tarefa com ID: " + id + " removida com sucesso!");
        }
    }

    public void atualizarTarefa(Integer id, String conteudo) {
        Tarefa tarefaAtualizar = procurarPorId(id);
        if (conteudo.isBlank()) {
            view.imprimirMensagem("Tarefa em branco. Tente novamente!");
        } else if (tarefaAtualizar != null) {
            tarefaAtualizar.setConteudo(conteudo);
            tarefaAtualizar.setDataAtualizacao(LocalDateTime.now());
            view.imprimirMensagem("Tarefa com ID: " + id + " atualizada com sucesso!");
        }
    }

    public void marcarEmAndamento(Integer id) {
        atualizarStatus(TarefaStatus.EM_ANDAMENTO, id);
    }

    public void marcarConcluida(Integer id) {
        atualizarStatus(TarefaStatus.CONCLUIDA, id);
    }

    public void listarTodas() {
        if (tarefas.isEmpty()) {
            view.imprimirMensagem("Lista de tarefas vazia. Adicione uma tarefa!");
        }
        for (Tarefa tarefa : tarefas) {
            System.out.println(view.exibirTarefa(tarefa));
        }
    }

    public void listarConcluidas() {
        buscarPorStatus(TarefaStatus.CONCLUIDA);
    }

    public void listarPendentes() {
        buscarPorStatus(TarefaStatus.PENDENTE);
    }

    public void listarEmAndamento() {
        buscarPorStatus(TarefaStatus.EM_ANDAMENTO);
    }

    public Tarefa procurarPorId(Integer id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                return tarefa;
            }
        }
        view.imprimirMensagem("Tarefa com ID: " + id + " não encontrada!");
        return null;
    }

    public void buscarPorStatus(TarefaStatus status) {
        boolean statusEncontrado = false;
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getStatus() == status) {
                System.out.println(view.exibirTarefa(tarefa));
                statusEncontrado = true;
            }
        }
        if (!statusEncontrado) {
            view.imprimirMensagem("Nenhuma tarefa com o status " + status + " encontrada.");
        }
    }

    public void atualizarStatus(TarefaStatus status, Integer id) {
        Tarefa tarefaAlterarStatus = procurarPorId(id);
        if (tarefaAlterarStatus != null) {
            tarefaAlterarStatus.setStatus(status);
            tarefaAlterarStatus.setDataAtualizacao(LocalDateTime.now());
            view.imprimirMensagem("Status da tarefa com ID: " + id + " alterado com sucesso!");
        }
    }
}

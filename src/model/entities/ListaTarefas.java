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
        Tarefa tarefaRemover = procurarTarefaPorId(id);
        if (tarefaRemover != null) {
            tarefas.remove(tarefaRemover);
            imprimir("Tarefa com ID: " + id + " removida com sucesso!");
        }
    }

    public void atualizarTarefa(Integer id, String conteudo) {
        Tarefa tarefaAtualizar = procurarTarefaPorId(id);
        if (tarefaAtualizar != null) {
            tarefaAtualizar.setConteudo(conteudo);
            tarefaAtualizar.setDataAtualizacao(LocalDateTime.now());
            imprimir("Tarefa com ID: " + id + " atualizada com sucesso!");
        }
    }

    public Tarefa procurarTarefaPorId(Integer id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                return tarefa;
            }
        }
        imprimir("Tarefa com ID: " + id + " não encontrada!");
        return null;
    }

    public void imprimir(String texto) {
        System.out.println(texto);
    }

}

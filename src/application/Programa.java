package application;

import model.entities.ListaTarefas;
import model.entities.services.JsonService;

public class Programa {

    public static void main(String[] args) {
        JsonService jsonService = new JsonService();

        ListaTarefas listaTarefas = jsonService.carregarTarefas();

//        listaTarefas.adicionarTarefa("tarefaTeste");
//        listaTarefas.adicionarTarefa("tarefaTeste2");
//        listaTarefas.adicionarTarefa("tarefaTeste3");

//        listaTarefas.removerTarefa(2);

        listaTarefas.atualizarTarefa(1, "aaaa");

        jsonService.salvarTarefas(listaTarefas);
    }
}

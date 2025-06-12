package application;

import model.entities.Tarefa;
import model.entities.enums.TarefaStatus;
import model.entities.services.JsonService;

import java.util.ArrayList;

public class Programa {

    public static void main(String[] args) {
        ArrayList<Tarefa> tarefas = new ArrayList<>();

        Tarefa tarefa1 = new Tarefa(1, "teste1", TarefaStatus.EM_ANDAMENTO);
        Tarefa tarefa2 = new Tarefa(2, "teste2", TarefaStatus.CONCLUIDO);

        tarefas.add(tarefa1);
        tarefas.add(tarefa2);

        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa);
        }

        JsonService jsonService = new JsonService();

        jsonService.salvarTarefas(tarefas);

        ArrayList<Tarefa> tarefasArquivo = jsonService.carregarTarefas();

        for (Tarefa tarefa : tarefasArquivo) {
            System.out.println(tarefa);
        }
    }
}

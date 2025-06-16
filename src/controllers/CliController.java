package controllers;

import models.ListaTarefas;

import static views.View.exibirAjuda;

public class CliController {

    public void cliMain(ListaTarefas listaTarefas, String[] args) {
        if (args.length == 0) {
            System.out.println("Entrada inválida. Use o comando 'ajuda' para ver os comandos disponíveis.");
            return;
        }

        switch (args[0]) {
            case "adicionar":
                listaTarefas.adicionarTarefa(args[1]);
                break;
            case "remover":
                listaTarefas.removerTarefa(Integer.valueOf(args[1]));
                break;
            case "atualizar":
                listaTarefas.atualizarTarefa(Integer.valueOf(args[1]), args[2]);
                break;
            case "em-andamento":
                listaTarefas.marcarEmAndamento(Integer.valueOf(args[1]));
                break;
            case "concluir":
                listaTarefas.marcarConcluida(Integer.valueOf(args[1]));
                break;
            case "listar":
                if (args.length == 1) {
                    listaTarefas.listarTodas();
                } else {
                    switch (args[1]) {
                        case "concluidas" -> listaTarefas.listarConcluidas();
                        case "pendentes" -> listaTarefas.listarPendentes();
                        case "em-andamento" -> listaTarefas.listarEmAndamento();
                        default -> System.out.println("Parâmetro inválido para 'listar'.");
                    }
                }
                break;
            case "ajuda":
                System.out.println(exibirAjuda());
                break;
            default:
                System.out.println("Comando inválido. Use 'ajuda' para ver os comandos disponíveis.");
        }
    }
}

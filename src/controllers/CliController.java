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
                validacaoArgumentos(args, 2);
                listaTarefas.adicionarTarefa(args[1]);
                break;
            case "remover":
                validacaoArgumentos(args, 2);
                listaTarefas.removerTarefa(idValidado(args[1]));
                break;
            case "atualizar":
                validacaoArgumentos(args, 3);
                listaTarefas.atualizarTarefa(idValidado(args[1]), args[2]);
                break;
            case "em-andamento":
                validacaoArgumentos(args, 2);
                listaTarefas.marcarEmAndamento(idValidado(args[1]));
                break;
            case "concluir":
                validacaoArgumentos(args, 2);
                listaTarefas.marcarConcluida(idValidado(args[1]));
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
                System.out.println("Entrada inválida. Use 'ajuda' para ver os comandos disponíveis.");
        }
    }

    public void validacaoArgumentos(String[] args, int quantidadeEsperada) {
        if (args.length < quantidadeEsperada) {
            throw new IllegalArgumentException("Entrada inválida. Use 'ajuda' para ver os comandos disponíveis.");
        }
    }

    public int idValidado(String args) {
        try {
            return Integer.parseInt(args);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID inválido. Use um número inteiro.");
        }
    }
}

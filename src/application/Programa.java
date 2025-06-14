package application;

import model.entities.ListaTarefas;
import model.entities.services.JsonService;

public class Programa {

    public static void main(String[] args) {
        JsonService jsonService = new JsonService();

        ListaTarefas listaTarefas = jsonService.carregarTarefas();

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

        jsonService.salvarTarefas(listaTarefas);
    }

    public static String exibirAjuda() {
        return """
                MENU DE AÇÕES
                adicionar "descrição da tarefa": Adiciona uma tarefa;
                remover <id da tarefa>: Remove uma tarefa;
                atualizar <id da tarefa> "descrição da tarefa": Atualiza o conteudo da tarefa;
                em-andamento <id da tarefa>: Atualiza o status para em andamento;
                concluir <id da tarefa>: Atualiza o status para concluida;
                listar: Lista todas as tarefas;
                listar concluidas: Lista as tarefas concluidas;
                listar pendentes: Lista as tarefas pendentes;
                listar em-andamento: Lista as tarefas em andamento;
                ajuda: Exibe o menu de ações;
                """;
    }
}

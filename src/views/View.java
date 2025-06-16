package views;

import models.Tarefa;

import java.time.format.DateTimeFormatter;

public class View {

    private static final DateTimeFormatter formatacaoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public String exibirTarefa(Tarefa tarefa) {
        return "Id: " + tarefa.getId() +
                ", Conteudo: " + tarefa.getConteudo() +
                ", Status: " + tarefa.getStatus() +
                ", Criação: " + tarefa.getDataCriacao().format(formatacaoData) +
                ", Atualizaçao: " + tarefa.getDataAtualizacao().format(formatacaoData);
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

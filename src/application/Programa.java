package application;

import controllers.CliController;
import models.ListaTarefas;
import services.JsonService;
import views.View;

public class Programa {

    public static void main(String[] args) {
        JsonService jsonService = new JsonService();

        CliController cliController = new CliController();

        ListaTarefas listaTarefas = jsonService.carregarTarefas();

        cliController.cliMain(listaTarefas, args);

        jsonService.salvarTarefas(listaTarefas);
    }
}

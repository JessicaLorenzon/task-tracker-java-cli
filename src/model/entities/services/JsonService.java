package model.entities.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.entities.Tarefa;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JsonService {

    Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
            .create();

    public void salvarTarefas(List<Tarefa> tarefas) {
        String json = gson.toJson(tarefas);

        try (FileWriter writer = new FileWriter("tarefas.json")) {
            writer.write(json);
            System.err.println("Tarefas salvas com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar tarefas: " + e.getMessage());
        }
    }

    public ArrayList<Tarefa> carregarTarefas() {
        try (FileReader reader = new FileReader("tarefas.json")) {
            Type tipoArrayList = new TypeToken<ArrayList<Tarefa>>() {
            }.getType();

            System.err.println("Tarefas carregadas com sucesso!");

            return gson.fromJson(reader, tipoArrayList);

        } catch (IOException e) {
            System.err.println("Erro ao carregar tarefas: " + e.getMessage());
        }
        return null;
    }
}

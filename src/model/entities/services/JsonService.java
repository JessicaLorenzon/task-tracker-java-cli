package model.entities.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.entities.ListaTarefas;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class JsonService {

    private static final String NomeDoArquivo = "tarefas.json";
    public static Path caminhoDoArquivo = Paths.get("C:\\Users\\Jessi\\Documents\\dev\\projects\\task-tracker-java-cli\\tarefas.json");

    Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
            .create();

    public void salvarTarefas(ListaTarefas listaTarefas) {
        String json = gson.toJson(listaTarefas);

        try (FileWriter writer = new FileWriter(NomeDoArquivo)) {
            writer.write(json);
            System.err.println("Tarefas salvas com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar tarefas: " + e.getMessage());
        }
    }

    public ListaTarefas carregarTarefas() {
        if (Files.exists(caminhoDoArquivo)) {
            try (FileReader reader = new FileReader(NomeDoArquivo)) {
                Type tipagem = new TypeToken<ListaTarefas>() {
                }.getType();

                System.err.println("Tarefas carregadas com sucesso!");

                return gson.fromJson(reader, tipagem);

            } catch (IOException e) {
                System.err.println("Erro ao carregar tarefas: " + e.getMessage());
                return null;
            }
        } else {
            System.out.println("Nao encontrado");
            return new ListaTarefas();
        }
    }
}

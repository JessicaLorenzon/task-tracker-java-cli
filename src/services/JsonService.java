package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import models.ListaTarefas;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class JsonService {

    public static String caminhoDoArquivo = new File("tarefas.json").getAbsolutePath();

    Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
            .create();

    public void salvarTarefas(ListaTarefas listaTarefas) {
        String json = gson.toJson(listaTarefas);

        try (FileWriter writer = new FileWriter(caminhoDoArquivo)) {
            writer.write(json);
        } catch (IOException e) {
            System.err.println("Erro ao salvar tarefas: " + e.getMessage());
        }
    }

    public ListaTarefas carregarTarefas() {
        if (Files.exists(Path.of(caminhoDoArquivo))) {
            try (FileReader reader = new FileReader(caminhoDoArquivo)) {
                Type tipagem = new TypeToken<ListaTarefas>() {
                }.getType();

                return gson.fromJson(reader, tipagem);

            } catch (IOException e) {
                System.err.println("Erro ao carregar tarefas: " + e.getMessage());
                return null;
            }
        }
        return new ListaTarefas();
    }
}

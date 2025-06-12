import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class TesteLib {
    public static void main(String[] args) {

        ArrayList<Object> lista = new ArrayList<>();

        lista.add(new Pessoa("João", 30));
        lista.add(new Pessoa("Maria", 25));

        Gson gson = new Gson();

        String json = gson.toJson(lista);

        //escrever
        try (FileWriter writer = new FileWriter("pessoas.json")) {
            writer.write(json);
            System.err.println("Escrita finalizada!");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }

        //ler
        try (FileReader reader = new FileReader("pessoas.json")) {
            Type tipoArrayList = new TypeToken<ArrayList<Pessoa>>() {
            }.getType();
            ArrayList<Pessoa> listaPessoas = gson.fromJson(reader, tipoArrayList);

            for (Pessoa pessoa : listaPessoas) {
                System.out.println("Nome: " + pessoa.getNome() + ", Idade: " + pessoa.getIdade());
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }

    static class Pessoa {
        String nome;
        int idade;

        public Pessoa(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }
    }
}

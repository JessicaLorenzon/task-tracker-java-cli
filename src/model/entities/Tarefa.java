package model.entities;

import model.entities.enums.TarefaStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Tarefa {

    private Integer id;
    private String conteudo;
    private TarefaStatus status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    private static final DateTimeFormatter formatacaoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Tarefa(Integer id, String conteudo, TarefaStatus status) {
        this.id = id;
        this.conteudo = conteudo;
        this.status = status;
        this.dataCriacao = LocalDateTime.now();
        this.dataAtualizacao = this.dataCriacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public TarefaStatus getStatus() {
        return status;
    }

    public void setStatus(TarefaStatus status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public String toString() {
        return "Id: " + getId() +
                ", Conteudo: " + getConteudo() +
                ", Status: " + getStatus() +
                ", Criação: " + getDataCriacao().format(formatacaoData) +
                ", Atualizaçao: " + getDataAtualizacao().format(formatacaoData);
    }
}

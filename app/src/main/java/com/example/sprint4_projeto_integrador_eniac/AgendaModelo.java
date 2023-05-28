package com.example.sprint4_projeto_integrador_eniac;

public class AgendaModelo {
    int id;
    String cliente, data, horario;

    public AgendaModelo() {
    }

    public AgendaModelo(int id, String nome, String data, String horario) {
        this.id = id;
        this.cliente = nome;
        this.data = data;
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}

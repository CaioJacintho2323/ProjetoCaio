package entities;

import java.time.LocalDate;

public class Venda {
    private LocalDate data;
    private double valor;

    public Venda(LocalDate data, double valor) {
        this.data = data;
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }
}


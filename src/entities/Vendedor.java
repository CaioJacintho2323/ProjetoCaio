package entities;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Funcionario {
    private List<Venda> vendas = new ArrayList<>();

    public Vendedor(String nome, Cargo cargo, LocalDate dataContratacao) {
        super(nome, cargo, dataContratacao);
    }

    // com a lista criada emcima, fiz uma funcao para registrar a venda do vendedor para depois calcularmos o beneficio.
    public void registrarVenda(LocalDate data, double valor) {
        vendas.add(new Venda(data, valor));
    }

    // Aqui estou fazendo um polimorfismo da classe funcionario
    // esse metodo fiz para calcular o beneficio do vendedor.
    @Override
    public double calcularBeneficio(int ano, int mes) {
        double totalVendas = 0;
        for (Venda venda : vendas) {
            if (venda.getData().getYear() == ano && venda.getData().getMonthValue() == mes) {
                totalVendas += venda.getValor();
            }
        }
        return totalVendas * 0.30;
    }
}

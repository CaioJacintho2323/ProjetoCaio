package application;

import entities.Cargo;
import entities.Funcionario;
import entities.Vendedor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Services.CalculadoraDePagamentos.CalculadoraPagamentos;


public class Main {
    public static void main(String[] args) {

        Cargo secretario = new Cargo("Secretário", 7000, 1000, 0.20);
        Cargo vendedor = new Cargo("Vendedor", 12000, 1800, 0.30);
        Cargo gerente = new Cargo("Gerente", 20000, 3000, 0);

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Jorge Carvalho", secretario, LocalDate.of(2018, 1, 1)));
        funcionarios.add(new Funcionario("Maria Souza", secretario, LocalDate.of(2015, 12, 1)));

        Vendedor anaSilva = new Vendedor("Ana Silva", vendedor, LocalDate.of(2021, 12, 1));
        anaSilva.registrarVenda(LocalDate.of(2021, 12, 1), 5200);
        anaSilva.registrarVenda(LocalDate.of(2022, 1, 1), 4000);
        anaSilva.registrarVenda(LocalDate.of(2022, 2, 1), 4200);
        anaSilva.registrarVenda(LocalDate.of(2022, 3, 1), 5850);
        anaSilva.registrarVenda(LocalDate.of(2022, 4, 1), 7000);
        funcionarios.add(anaSilva);

        Vendedor joaoMendes = new Vendedor("João Mendes", vendedor, LocalDate.of(2021, 12, 1));
        joaoMendes.registrarVenda(LocalDate.of(2021, 12, 1), 3400);
        joaoMendes.registrarVenda(LocalDate.of(2022, 1, 1), 7700);
        joaoMendes.registrarVenda(LocalDate.of(2022, 2, 1), 5000);
        joaoMendes.registrarVenda(LocalDate.of(2022, 3, 1), 5900);
        joaoMendes.registrarVenda(LocalDate.of(2022, 4, 1), 6500);
        funcionarios.add(joaoMendes);

        funcionarios.add(new Funcionario("Juliana Alves", gerente, LocalDate.of(2017, 7, 1)));
        funcionarios.add(new Funcionario("Bento Albino", gerente, LocalDate.of(2014, 3, 1)));

        int ano = 2022;
        int mes = 3;

        System.out.println("***********Resposta do código************");
        System.out.println("Total pago (salário e benefício) em " + mes + "/" + ano + ": " + "R$" + CalculadoraPagamentos.calcularTotalPago(funcionarios, ano, mes));
        System.out.println("Total pago em salários em " + mes + "/" + ano + ": " + "R$" + CalculadoraPagamentos.calcularTotalSalarios(funcionarios, ano, mes));
        System.out.println("Total pago em benefícios em " + mes + "/" + ano + ": " + "R$" + CalculadoraPagamentos.calcularTotalBeneficios(funcionarios, ano, mes));
        System.out.println("Funcionário com maior pagamento em " + mes + "/" + ano + ": " + CalculadoraPagamentos.funcionarioMaiorPagamento(funcionarios, ano, mes).getNome());
        System.out.println("Funcionário com maior benefício em " + mes + "/" + ano + ": " + CalculadoraPagamentos.funcionarioMaiorBeneficio(funcionarios, ano, mes));
        System.out.println("Vendedor com maior venda em " + mes + "/" + ano + ": " + CalculadoraPagamentos.vendedorTopVendas(Arrays.asList(anaSilva, joaoMendes), ano, mes).getNome());
    }
}

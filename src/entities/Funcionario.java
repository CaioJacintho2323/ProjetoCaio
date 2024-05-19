package entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Funcionario {
    private String nome;
    private Cargo cargo;
    private LocalDate dataContratacao;

    public Funcionario (){

    }

    public Funcionario(String nome, Cargo cargo, LocalDate dataContratacao) {
        this.nome = nome;
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
    }

    //esse metodo CalcularSalario fiz uma comparacao entre datas que me dê a quantidade de anos que ele está na empresa,assim posso calcular a quantidade de beneficio que ele teve até hoje;
    public double calcularSalario(int ano, int mes) {
        long anosDeServico = ChronoUnit.YEARS.between(dataContratacao, LocalDate.of(ano, mes, 1));
        return cargo.getSalarioBase() + (anosDeServico * cargo.getBeneficioPorAno());
    }

    //esse metodo é para calcular o beneficio e como parametro coloquei ano e mes, e fiz uma condicao pra ver se o funcionario daquele cargo tenha beneficio.
    public double calcularBeneficio(int ano, int mes) {
        if (cargo.getPercentualBeneficio() > 0) {
            return calcularSalario(ano, mes) * cargo.getPercentualBeneficio();
        }
        return 0;
    }

    //esse metodo fiz a soma dos 2 anteriores para dar como resposta o calculo do Pagamento(salario + beneficio)
    public double calcularPagamentoTotal(int ano, int mes) {
        return calcularSalario(ano, mes) + calcularBeneficio(ano, mes);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
}

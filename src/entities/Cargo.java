package entities;

public class Cargo {
    private String nome;
    private double salarioBase;
    private double beneficioPorAno;
    private double percentualBeneficio;

    public Cargo() {
    }

    public Cargo(String nome, double salarioBase, double beneficioPorAno, double percentualBeneficio) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.beneficioPorAno = beneficioPorAno;
        this.percentualBeneficio = percentualBeneficio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getBeneficioPorAno() {
        return beneficioPorAno;
    }

    public void setBeneficioPorAno(double beneficioPorAno) {
        this.beneficioPorAno = beneficioPorAno;
    }

    public double getPercentualBeneficio() {
        return percentualBeneficio;
    }

    public void setPercentualBeneficio(double percentualBeneficio) {
        this.percentualBeneficio = percentualBeneficio;
    }
}

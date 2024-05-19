package Services;

import entities.Funcionario;
import entities.Vendedor;

import java.util.List;

public class CalculadoraDePagamentos {
    public static CalculadoraDePagamentos CalculadoraPagamentos;


    public static double calcularTotalPago(List<Funcionario> funcionarios, int ano, int mes) {
        double total1 = 0;
        for (Funcionario f : funcionarios) {
            total1 += f.calcularPagamentoTotal(ano, mes);
        }
        return total1;
    }

    public static double calcularTotalSalarios(List<Funcionario> funcionarios, int ano, int mes) {
        double total2 = 0;
        for (Funcionario f : funcionarios) {
            total2 += f.calcularSalario(ano, mes);
        }
        return total2;
    }

    public static double calcularTotalBeneficios(List<Funcionario> funcionarios, int ano, int mes) {
        double total3 = 0;
        for (Funcionario f : funcionarios) {
            if (f.getCargo().getPercentualBeneficio() > 0 || f instanceof Vendedor) {
                total3 += f.calcularBeneficio(ano, mes);
            }
        }
        return total3;
    }

    public static Funcionario funcionarioMaiorPagamento(List<Funcionario> funcionarios, int ano, int mes) {
        Funcionario maior = null;
        double maiorPagamento = 0;
        for (Funcionario f : funcionarios) {
            double pagamento = f.calcularPagamentoTotal(ano, mes);
            if (pagamento > maiorPagamento) {
                maiorPagamento = pagamento;
                maior = f;
            }
        }
        return maior;
    }

    public static String funcionarioMaiorBeneficio(List<Funcionario> funcionarios, int ano, int mes) {
        Funcionario maior2 = null;
        double maiorBeneficio = 0;
        for (Funcionario fun : funcionarios) {
            if (fun.getCargo().getPercentualBeneficio() > 0 || fun instanceof Vendedor) {
                double beneficio = fun.calcularBeneficio(ano, mes);
                if (beneficio > maiorBeneficio) {
                    maiorBeneficio = beneficio;
                    maior2 = fun;
                }
            }
        }
        return maior2 != null ? maior2.getNome() : "N/A";
    }

    public static Vendedor vendedorTopVendas(List<Vendedor> vendedores, int ano, int mes) {
        Vendedor top = null;
        double maiorVenda = 0;
        for (Vendedor v : vendedores) {
            double venda = v.calcularBeneficio(ano, mes) / 0.30;
            if (venda > maiorVenda) {
                maiorVenda = venda;
                top = v;
            }
        }
        return top;
    }
}

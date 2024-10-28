package modelos;

import java.util.Date;

public class Funcionario extends Pessoa {
    private double salario;
    private int cargaHoraria;
    private String cpf;
    private Date dataAdmissao;
    private Date dataRecisao;

    // Construtor
    public Funcionario() {}

    // Métodos getters e setters

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Date getDataRecisao() {
        return dataRecisao;
    }

    public void setDataRecisao(Date dataRecisao) {
        this.dataRecisao = dataRecisao;
    }

    // Métodos específicos para Funcionario

    public void cadastrarPedido() {}

    public void realizarVenda() {}

    public void entregarProduto() {}
}

package br.com.jgbank.modelo;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public abstract class Conta implements IConta {

    private int agencia;
    private int numero;
    private Cliente cliente;
    private BigDecimal saldo;

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    @Override
    public void saca(double valor) {
        var valorBigDecimal = converteValor(valor);
        if (this.saldo.compareTo(valorBigDecimal) >= 0) {
            if (valorBigDecimal.compareTo(BigDecimal.ZERO) > 0) {
                this.saldo.subtract(valorBigDecimal);
            } else System.out.println("Valor inválido");
        } else System.out.println("Saldo insuficiente");
        
    }

    @Override
    public void deposita(double valor) {
        if (valor > 0){
            var valorBigDecimal = converteValor(valor);
            this.saldo.add(valorBigDecimal);
        } else System.out.println("Valor inválido");
    }

    @Override
    public void transfere(double valor, @NotNull IConta destino) {
        saca(valor);
        destino.deposita(valor);
    }

    @Override
    public void imprimeExtrato() {

    }
    
    private BigDecimal converteValor (double valor) {
        String valorString = String.valueOf(valor);
        var valorBigDecimal = new BigDecimal(valorString);
        return valorBigDecimal;
    }
}

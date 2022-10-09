package br.com.jgbank.modelo;

public interface IConta {

    void saca(double valor);
    void deposita(double valor);
    void transfere(double valor, IConta destino);
    void imprimeExtrato();


}

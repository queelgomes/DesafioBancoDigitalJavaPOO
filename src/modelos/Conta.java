package modelos;

import principal.ProgramaBancario;

import java.util.Scanner;

public abstract class Conta{
    Scanner sc = new Scanner(System.in);


    private static final int AGENCIA_PADRAO = 3257;
    private static int SEQUENCIAL = 1001;
    private int agencia;
    private int numero;
    private double saldo;
    private Cliente cliente;


    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        System.out.print("Depósito incial: R$");
        this.saldo = Double.parseDouble(sc.nextLine());
    }


    public int getConta() {
        return numero;
    }


    public void sacar(double valor) {
        saldo -= valor;
    }
    public void depositar(double valor) {
        saldo += valor;
    }
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }


    @Override
    public String toString() {
        return String.format("""
                 
                 -- Titular: %s
                 -- Agencia: %d | Conta: %d | Saldo: R$%.2f""",
                this.cliente.getNome(), this.agencia, this.numero, this.saldo);
    }
}
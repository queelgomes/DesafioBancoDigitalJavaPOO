package modelos;

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

    public int getAgencia() {
        return agencia;
    }

    public void sacar(double valor) {
        if(saldo >= valor){
            saldo -= valor;
            System.out.println("Saque efetuado com sucesso!");
        } else {
            System.out.printf("Saldo insuficiente. Valor disponivel para saque R$%.2f.\n", saldo);
        }
    }
    public void depositar(double valor, int agencia) {
        saldo += valor;
        System.out.printf("Valor de R$ %.2f depositado com sucesso na Agencia %d Conta %d.", valor, agencia, numero);
    }
    public void transferir(double valor, Conta contaDestino, int agencia) {
        if(saldo >= valor){
            this.sacar(valor);
            if (contaDestino.getAgencia() == agencia){
                contaDestino.depositar(valor, agencia);
            }
        } else {
            System.out.printf("Saldo insuficiente. Valor disponivel para transferência R$%.2f.\n", saldo);
        }
    }


    @Override
    public String toString() {
        return String.format("""
                 
                 -- Titular: %s
                 -- Agencia: %d | Conta: %d | Saldo: R$%.2f""",
                this.cliente.getNome(), this.agencia, this.numero, this.saldo);
    }
}
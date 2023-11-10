package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    Scanner sc = new Scanner(System.in);
    private String name;
    private List<Conta> accounts = new ArrayList<>();


    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void criarContaCorrente(){
        Cliente cliente = new Cliente();
        this.accounts.add(new ContaCorrente(cliente));

    }
    public void criarContaPoupanca(){
        Cliente cliente = new Cliente();
        this.accounts.add(new ContaPoupanca(cliente));
    }
    public void consultarContas(){
        for(Conta c: accounts){
            System.out.println(c);
        }
    }
    public void imprimirSaldo(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Consulta Conta: ");
        int conta = Integer.parseInt(sc.nextLine());
        for(Conta c: accounts){
            if (conta == c.getConta()){
                System.out.println(c);
            }
        }
    }
    public void sacar(){
        System.out.print("Conta: ");
        int conta = Integer.parseInt(sc.nextLine());
        System.out.print("Valor a sacar: R$");
        double valor = Double.parseDouble(sc.nextLine());
        for (Conta c: accounts){
            if (c.getConta() == conta){
                c.sacar(valor);
                System.out.println("Saque efetuado com sucesso!");
            }
        }
    }
    public void transferir(){
        System.out.print("Conta Origem: ");
        int contaOrigem = Integer.parseInt(sc.nextLine());
        System.out.print("Conta Destino: ");
        int contaDestino = Integer.parseInt(sc.nextLine());
        System.out.print("Valor a transferir: R$");
        double valor = Double.parseDouble(sc.nextLine());
        for(Conta c: accounts){
            if (c.getConta() == contaOrigem){
                for (Conta cd: accounts){
                    if(cd.getConta() == contaDestino){
                        c.transferir(valor, cd);
                        System.out.println("Transferência realizada com sucesso!");
                    }
                }
            }
        }
    }
    public void depositar(){
        System.out.print("Conta: ");
        int conta = Integer.parseInt(sc.nextLine());
        System.out.print("Valor a depositar: R$");
        double valor = Double.parseDouble(sc.nextLine());
        for (Conta c: accounts){
            if (c.getConta() == conta){
                c.depositar(valor);
                System.out.println("Depósito realizado com sucesso!");
            }
        }
    }

}
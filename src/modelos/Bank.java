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
        System.out.println("Conta Corrente criada com sucesso!");
    }
    public void criarContaPoupanca(){
        Cliente cliente = new Cliente();
        this.accounts.add(new ContaPoupanca(cliente));
        System.out.println("Conta Poupança criada com sucesso!");
    }
    public void consultarContas(){
        for(Conta c: accounts){
            System.out.println(c);
        }
    }
    public void imprimirSaldo(){
        System.out.print("Consulta Agência: ");
        int agencia = Integer.parseInt(sc.nextLine());
        System.out.print("Consulta Conta: ");
        int conta = Integer.parseInt(sc.nextLine());
        int contagem = 0;

        for(Conta c: accounts){
            if (conta == c.getConta() && c.getAgencia() == agencia){
                System.out.println(c);
                contagem = 1;
            }
        }

        if(contagem == 0) System.out.println("Agência e Conta inválidos.");
    }
    public void sacar(){
        System.out.print("Agencia: ");
        int agencia = Integer.parseInt(sc.nextLine());
        System.out.print("Conta: ");
        int conta = Integer.parseInt(sc.nextLine());
        System.out.print("Valor a sacar: R$");
        double valor = Double.parseDouble(sc.nextLine());

        int contagem = 0;
        for (Conta c: accounts){
            if (c.getConta() == conta && c.getAgencia() == agencia){
                c.sacar(valor);
                contagem = 1;
            }
        }
        if (contagem == 0) System.out.println("Agência e Conta inválidos.");
    }
    public void transferir(){
        System.out.print("Agencia Origem: ");
        int agenciaOrigem = Integer.parseInt(sc.nextLine());
        System.out.print("Conta Origem: ");
        int contaOrigem = Integer.parseInt(sc.nextLine());
        System.out.print("Agencia Destino: ");
        int agenciaDestino = Integer.parseInt(sc.nextLine());
        System.out.print("Conta Destino: ");
        int contaDestino = Integer.parseInt(sc.nextLine());
        System.out.print("Valor a transferir: R$");
        double valor = Double.parseDouble(sc.nextLine());

        int contagemOrigem = 0;
        int contagemDestino = 0;

        for(Conta c: accounts){
            if (c.getConta() == contaOrigem && c.getAgencia() == agenciaOrigem){
                for (Conta cd: accounts){
                    if(cd.getConta() == contaDestino && cd.getAgencia() == agenciaDestino){
                        c.transferir(valor, cd, agenciaDestino);
                        contagemDestino = 1;
                    }

                }
                contagemOrigem = 1;
            }
        }

        if (contagemOrigem == 0){
            System.out.println("Transferência não realizada. -> ERRO: Conta origem não encontrada.");
        } else if (contagemDestino == 0){
            System.out.println("Transferência não realizada. -> ERRO: Conta destino não encontrada.");
        }
    }
    public void depositar(){
        System.out.print("Agencia: ");
        int agencia = Integer.parseInt(sc.nextLine());
        System.out.print("Conta: ");
        int conta = Integer.parseInt(sc.nextLine());
        System.out.print("Valor a depositar: R$");
        double valor = Double.parseDouble(sc.nextLine());

        int contagem = 0;

        for (Conta c: accounts){
            if (c.getConta() == conta && c.getAgencia() == agencia){
                c.depositar(valor, agencia);
                contagem = 1;
            }
        }
        if (contagem == 0) System.out.println("Agência e Conta inválidos.");
    }

}
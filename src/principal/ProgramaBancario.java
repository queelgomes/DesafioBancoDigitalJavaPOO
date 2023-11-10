package principal;

import modelos.*;

import java.util.Scanner;

public class ProgramaBancario {

    public static void main(String[] args) {
        Bank bancoDigital = new Bank("Banco Digital New Tech");
        Scanner sc = new Scanner(System.in);

        while(true) {
            try {
                System.out.println("""
                        
                        |-----------------------------------------|
                        |        ####   TELA INICIAL   ####       |
                        |-----------------------------------------|
                           [ 1 ] - Criar Conta Corrente
                           [ 2 ] - Criar Conta Poupança
                           [ 3 ] - Listar contas existentes
                           [ 4 ] - Imprimir saldo
                           [ 5 ] - Sacar
                           [ 6 ] - Depositar
                           [ 7 ] - Transferir
                           [ 8 ] - Sair""");
                System.out.print(" -- Opção desejada: ");
                int option = Integer.parseInt(sc.nextLine());
                if (option == 1) {
                    bancoDigital.criarContaCorrente();
                    System.out.println("Conta aberta com sucesso!");
                } else if (option == 2) {
                    bancoDigital.criarContaPoupanca();
                    System.out.println("Conta aberta com sucesso!");
                } else if (option == 3) {
                    System.out.println(" \n       LISTA DE CONTAS ABERTAS\n       " +
                            bancoDigital.getName().toUpperCase() );
                    bancoDigital.consultarContas();
                } else if (option == 4) {
                    bancoDigital.imprimirSaldo();
                } else if (option == 5){
                    bancoDigital.sacar();
                } else if (option == 6) {
                    bancoDigital.depositar();
                } else if (option == 7){
                    bancoDigital.transferir();
                }
                else if (option == 8) break;
                else System.out.println("Opção inválida");

            }catch (Exception e){
                System.out.println(" -- Opção inválida. Entre novamente.");
            }
        }
    }
}
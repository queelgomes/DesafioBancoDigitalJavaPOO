package principal;

import Commands.*;
import modelos.*;

import java.util.Scanner;

public class ProgramaBancario {

    public static void main(String[] args) {
        CommandExecutor commandExecutor = new CommandExecutor();
        Scanner sc = new Scanner(System.in);

        while(true) {
            try {
                exibirMenu();
                int option = Integer.parseInt(sc.nextLine());

                switch (option){
                    case 1 -> commandExecutor.executor(new CriarContaCorrenteCommand());
                    case 2 -> commandExecutor.executor(new CriarContaPoupancaCommand());
                    case 3 -> commandExecutor.executor(new ConsultarContasCommand());
                    case 4 -> commandExecutor.executor(new ImprimirSaldoCommand());
                    case 5 -> commandExecutor.executor(new SacarCommand());
                    case 6 -> commandExecutor.executor(new DepositarCommand());
                    case 7 -> commandExecutor.executor(new TransferirCommand());
                    case 8 -> {
                        System.out.println("Finalizando programa");
                        System.exit(0);
                    }
                    default -> System.out.println("Opção inválida!");
                }

            }catch (Exception e){
                System.out.println(" -- Opção inválida. Entre novamente.");
            }
        }
    }

    public static void exibirMenu(){
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
    }

}
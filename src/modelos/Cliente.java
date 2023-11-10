package modelos;

import java.util.Scanner;

public class Cliente {
    Scanner sc = new Scanner(System.in);

    private String nome;
    private long cpf;

    public Cliente() {
        System.out.print("Nome Completo: ");
        this.nome = sc.nextLine();
        while (true) {
            try {
                System.out.print("CPF: ");
                this.cpf = Long.parseLong(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("CPF invalido! Digite novamente!");
            }
        }
    } // caso tenha mais informações para registrar do cliente, adicionar aqui e criar os atributos


    public String getNome() {
        return nome;
    }

}
package Commands;

import modelos.Bank;

public class CriarContaCorrenteCommand implements Command{
    @Override
    public void execute(Bank bank) {
        bank.criarContaCorrente();
    }
}

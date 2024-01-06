package Commands;

import modelos.Bank;

public class CriarContaPoupancaCommand implements Command{
    @Override
    public void execute(Bank bank) {
        bank.criarContaPoupanca();
    }
}

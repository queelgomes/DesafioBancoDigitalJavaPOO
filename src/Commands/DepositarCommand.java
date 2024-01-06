package Commands;

import modelos.Bank;

public class DepositarCommand implements Command{
    @Override
    public void execute(Bank bank) {
        bank.depositar();
    }
}

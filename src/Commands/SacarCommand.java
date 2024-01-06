package Commands;

import modelos.Bank;

public class SacarCommand implements Command{
    @Override
    public void execute(Bank bank) {
        bank.sacar();
    }
}

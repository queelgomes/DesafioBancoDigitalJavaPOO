package Commands;

import modelos.Bank;

public class TransferirCommand implements Command{
    @Override
    public void execute(Bank bank) {
        bank.transferir();
    }
}

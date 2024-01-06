package Commands;

import modelos.Bank;

public class ImprimirSaldoCommand implements Command {

    @Override
    public void execute(Bank bank) {
        bank.imprimirSaldo();
    }
}

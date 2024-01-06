package Commands;

import modelos.Bank;

public class ConsultarContasCommand implements Command{
    @Override
    public void execute(Bank bank) {
        bank.consultarContas();
    }
}

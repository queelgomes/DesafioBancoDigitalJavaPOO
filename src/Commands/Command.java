package Commands;

import modelos.Bank;

public interface Command {
    void execute(Bank bank);
}

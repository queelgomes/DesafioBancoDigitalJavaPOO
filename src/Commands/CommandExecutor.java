package Commands;

import modelos.Bank;

public class CommandExecutor {
    private Bank bancodigital;
    public CommandExecutor() {
        this.bancodigital = new Bank("Banco Digital New Tech");
    }

    public void executor(Command command){
        command.execute(bancodigital);
    }

    public Bank getBank() {
        return bancodigital;
    }
}

package common.network;

import java.io.Serializable;

public class CommandDTO implements Serializable {
    private String commandName;
    public CommandDTO(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}

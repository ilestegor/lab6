package common.command;

import common.interfaces.CommandInterface;
import common.manager.ServerCollectionManager;
import common.network.Request;
import common.network.Response;
import stuff.utility.Printer;

/**
 * Abstract class contains basic methods for executing commands
 *
 * @author ilestegor
 */
public abstract class Command implements CommandInterface {
    private String name;
    private String description;

    private String[] args;
    private ServerCollectionManager serverCollectionManager;



    /**
     * Constructor for Command abstract class
     *
     * @param description
     * @param serverCollectionManager
     */
    public Command(String name, String description, ServerCollectionManager serverCollectionManager) {
        this.name = name;
        this.description = description;
        this.serverCollectionManager = serverCollectionManager;
    }

    public Command() {}



    public abstract Response execute(Request request);
    public abstract Request execute(Printer printer);


    @Override
    public abstract boolean checkArgument(Printer printer, String[] inputArgs);


    /**
     * Method gets description of stuff.command
     *
     * @return description of stuff.command
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets arguments that were entered by user
     *
     * @return stuff.command's arguments
     */
    public String[] getArgs() {
        return args;
    }

    /**
     * Method sets arguments for executing stuff.command
     *
     * @param args
     */
    public void setArgs(String[] args) {
        this.args = args;
    }

    public ServerCollectionManager getMusicBandCollectionManager() {
        return serverCollectionManager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

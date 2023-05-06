import common.manager.ServerCollectionManager;
import common.manager.CommandManager;
import common.manager.UserManager;
import stuff.parse.YamlReader;
import stuff.utility.Printer;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.printNextLine("---------- " + LocalDateTime.now().toString().substring(0, 10) + " ---------");
        ServerCollectionManager serverCollectionManager = new ServerCollectionManager();
//        YamlReader yamlReader = new YamlReader(new Printer());
//        serverCollectionManager.readToCollection(yamlReader);
        CommandManager commandManager = new CommandManager(serverCollectionManager);
        while (UserManager.isIsInWork()) {
            UserManager.requestCommand();
        }
    }
}

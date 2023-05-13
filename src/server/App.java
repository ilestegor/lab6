package server;

import common.manager.CommandManager;
import common.manager.ServerCollectionManager;
import common.manager.UserManager;
import common.network.Request;
import common.network.Response;
import common.network.ResponseFactory;
import common.porcessors.ServerCommandProcessor;
import common.utility.Printer;
import server.network.ServerConnection;
import server.parse.YamlReader;
import server.parse.YamlWriter;

import java.io.IOException;
import java.net.SocketException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class App {

    public static void main(String[] args) {
        Printer printer = new Printer();
        try {
            Response response;
            ServerConnection serverConnection = new ServerConnection(32458);
            ServerCollectionManager sc = new ServerCollectionManager();
            CommandManager cm = new CommandManager(sc, new UserManager());
            YamlReader yamlReader = new YamlReader(new Printer());
            sc.readToCollection(yamlReader);
            YamlWriter yamlWriter = new YamlWriter(new Printer(), sc);


            while (true) {
                try {
                    Request request = serverConnection.receiveDataFromClient();
                    System.out.println(serverConnection.getDpack().getAddress().getHostAddress() + " " + serverConnection.getDpack().getPort());
                    System.out.println(request.getCommandDTO().getCommandName());
                    ResponseFactory responseFactory = new ResponseFactory();
                    ServerCommandProcessor scm = new ServerCommandProcessor();
                    response = scm.processCommand(request);
                    serverConnection.sendDataToClient(response);
                    yamlWriter.write(System.getenv("YamlFile"));
                    serverConnection.disconnect();
                } catch (IOException ex){
                    ex.printStackTrace();
                    printer.printError("Ошибка IO");
                } catch (ClassNotFoundException ex){
                    printer.printError("Проблема сериализации данных");
                }
        }
        } catch (SocketException ex){
            printer.printError("Проблема соединения!");
        }
    }
}

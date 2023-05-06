package server;

import common.manager.CommandManager;
import common.manager.ServerCollectionManager;
import common.network.Request;
import common.network.Response;
import common.network.ResponseFactory;
import common.porcessors.ServerCommandProcessor;
import server.network.ServerConnection;
import stuff.parse.YamlReader;
import stuff.utility.Printer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;

public class App {

    public static void main(String[] args) throws SocketException, IOException, ClassNotFoundException {
        Response response;
        ServerConnection serverConnection = new ServerConnection(6754);
        ServerCollectionManager sc = new ServerCollectionManager();
        CommandManager cm = new CommandManager(sc);
        YamlReader yamlReader = new YamlReader(new Printer());
        sc.readToCollection(yamlReader);
        while (true){
            Request request = serverConnection.receiveDataFromClient();
            System.out.println(request.getCommandDTO().getCommandName());
            ResponseFactory responseFactory = new ResponseFactory();
            ServerCommandProcessor scm = new ServerCommandProcessor();
            response = scm.processCommand(request);
            serverConnection.sendDataToClient(response);
        }

    }
}

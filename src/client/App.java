package client;

import client.network.ClientConnection;
import common.manager.CommandManager;
import common.manager.ServerCollectionManager;
import common.manager.UserManager;
import common.network.Request;
import common.network.Response;
import common.network.ResponseFactory;
import common.porcessors.ClientCommandProcessor;
import common.utility.Printer;
import common.exception.CommandIsNotExecutedException;

import java.io.IOException;
import java.net.InetAddress;
import java.net.PortUnreachableException;
import java.time.LocalDateTime;
import java.util.Objects;


public class App {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Printer printer = new Printer();
        printer.printNextLine("---------- " + LocalDateTime.now().toString().substring(0, 10) + " ---------");
        ClientConnection clientConnection = new ClientConnection(InetAddress.getLocalHost(), 32458);
        clientConnection.connect(clientConnection.getAddress().getAddress(), clientConnection.getPort());
        UserManager userManager = new UserManager();
        printer.printNextLine("Приложение запущено!");
        printer.printNextLine("Чтобы ознакомиться c командами, введите команду help");


        CommandManager manager = new CommandManager(new ServerCollectionManager(), userManager);
        ClientCommandProcessor cmp = new ClientCommandProcessor();
        while (userManager.isIsInWork()) {
            userManager.requestCommand();
            while (userManager.getInputCommand().size() != 0) {
                String[] str = userManager.requestPlainCommand(Objects.requireNonNull(userManager.getInputCommand().poll()));
                if (cmp.commandChecker(str)) {
                    try {
                        Request l = cmp.commandRequest(str);
                        if (l == null) {
                            continue;
                        }
                        clientConnection.sendCommand(l);
                        ResponseFactory responseFactory = new ResponseFactory();
                        Response response = clientConnection.receiveResult();
                        responseFactory.createResponse(response.getMessage());
                        System.out.println("\n" + response.getMessage() + "\n");

                    } catch (CommandIsNotExecutedException ex) {
                        printer.printError(ex.getMessage());
                    } catch (PortUnreachableException ex){
                        printer.printError("Сервер недоступен!");
                    }
                }
            }

        }
        if (clientConnection.getClient().isConnected()) {
            clientConnection.getClient().disconnect();
            clientConnection.getClient().close();
        }
    }

}


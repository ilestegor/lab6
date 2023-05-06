package client;

import client.network.ClientConnection;
import common.manager.CommandManager;
import common.manager.ServerCollectionManager;
import common.manager.UserManager;
import common.network.Request;
import common.network.RequestFactory;
import common.network.Response;
import common.network.ResponseFactory;
import common.porcessors.ClientCommandProcessor;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;


public class App {


    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        RequestFactory factory = new RequestFactory();
//        Request request =  factory.createRequest("info",null);
        ClientConnection clientConnection = new ClientConnection(InetAddress.getLocalHost(), 6754);
        clientConnection.connect(clientConnection.getAddress().getAddress(), clientConnection.getPort());


        CommandManager manager = new CommandManager(new ServerCollectionManager());
        ClientCommandProcessor cmp = new ClientCommandProcessor();

        while (UserManager.isIsInWork()){
            String[] str = UserManager.requestCommand();
            if (cmp.commandChecker(str)){
                Request l = cmp.commandRequest(str);
                clientConnection.sendCommand(l);
                ResponseFactory responseFactory = new ResponseFactory();
                Response response = clientConnection.receiveResult();
                responseFactory.createResponse(response.getMessage());
                System.out.println(response.getMessage());;
            }
        }
        if (clientConnection.getClient().isConnected()){
            clientConnection.getClient().disconnect();
            clientConnection.getClient().close();
        }
    }

}


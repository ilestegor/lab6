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


public class MainClientApp {


    public static void main(String[] args){
        Client client = new Client();
        client.run();
    }
}


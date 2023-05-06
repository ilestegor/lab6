package common.network;

import java.io.Serializable;

public class RequestFactory implements Serializable {
    public Request createRequest(String nameOfCommand, String[] args){
        return new Request(new CommandDTO(nameOfCommand), RequestBodyFactory.createRequestBody(args));
    }
}

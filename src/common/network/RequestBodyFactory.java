package common.network;

import java.io.Serializable;

public class RequestBodyFactory implements Serializable {
    public static RequestBody createRequestBody(String[] args){
        return new RequestBody(args);
    }
}

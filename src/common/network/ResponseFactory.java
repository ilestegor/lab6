package common.network;

import java.io.Serializable;

public class ResponseFactory implements Serializable {
    public Response createResponse(String message) {
        return new Response(message);
    }
}

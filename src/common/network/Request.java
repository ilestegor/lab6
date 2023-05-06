package common.network;

import java.io.Serializable;

public class Request implements Serializable {
    private CommandDTO commandDTO;
    private RequestBody requestBody;

    public Request(CommandDTO commandDTO, RequestBody requestBody) {
        this.commandDTO = commandDTO;
        this.requestBody = requestBody;
    }

    public CommandDTO getCommandDTO() {
        return commandDTO;
    }

    public RequestBody getRequestBody() {
        return requestBody;
    }
}

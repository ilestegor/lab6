package common.network;

import java.io.Serializable;

public class Request implements Serializable {
    private final CommandDTO commandDTO;
    private RequestBody requestBody;
    private RequestBodyMusicBand requestBodyMusicBand;

    public Request(CommandDTO commandDTO, RequestBody requestBody) {
        this.commandDTO = commandDTO;
        this.requestBody = requestBody;
    }

    public Request(CommandDTO commandDTO, RequestBodyMusicBand requestBodyMusicBand) {
        this.commandDTO = commandDTO;
        this.requestBodyMusicBand = requestBodyMusicBand;
    }

    public Request(CommandDTO commandDTO, RequestBody requestBody, RequestBodyMusicBand requestBodyMusicBand) {
        this.commandDTO = commandDTO;
        this.requestBody = requestBody;
        this.requestBodyMusicBand = requestBodyMusicBand;
    }

    public CommandDTO getCommandDTO() {
        return commandDTO;
    }

    public RequestBody getRequestBody() {
        return requestBody;
    }

    public RequestBodyMusicBand getRequestBodyMusicBand() {
        return requestBodyMusicBand;
    }
}

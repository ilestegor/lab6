package common.network;

import server.model.MusicBand;

import java.io.Serializable;

public class RequestFactory implements Serializable {
    public Request createRequest(String nameOfCommand, String[] args) {
        return new Request(new CommandDTO(nameOfCommand), RequestBodyFactory.createRequestBody(args));
    }

    public Request createRequestMusicBand(String nameOfCommand, MusicBand musicBand) {
        return new Request(new CommandDTO(nameOfCommand), RequestBodyFactory.createRequestBodyMusicBand(musicBand));
    }

    public Request createRequestMusicBandWithArgs(String nameOfCommand, String[] args, MusicBand musicBand) {
        return new Request(new CommandDTO(nameOfCommand), RequestBodyFactory.createRequestBody(args), RequestBodyFactory.createRequestBodyMusicBand(musicBand));
    }
}

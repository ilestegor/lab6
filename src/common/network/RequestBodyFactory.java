package common.network;

import server.model.MusicBand;

import java.io.Serializable;

public class RequestBodyFactory implements Serializable {
    public static RequestBody createRequestBody(String[] args) {
        return new RequestBody(args);
    }

    public static RequestBodyMusicBand createRequestBodyMusicBand(MusicBand musicBand) {
        return new RequestBodyMusicBand(musicBand);
    }
}

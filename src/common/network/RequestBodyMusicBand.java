package common.network;

import server.model.MusicBand;

import java.io.Serializable;

public class RequestBodyMusicBand implements Serializable {
    private final MusicBand musicBand;

    public RequestBodyMusicBand(MusicBand musicBand) {
        this.musicBand = musicBand;
    }

    public MusicBand getMusicBand() {
        return musicBand;
    }
}

package server.model;

import java.io.Serializable;

/**
 * Contains enums MusicGenre
 *
 * @author ilestegor
 */
public enum MusicGenre implements Serializable {
    ROCK("1"),
    PROGRESSIVE_ROCK("2"),
    PSYCHEDELIC_CLOUD_RAP("3"),
    SOUL("4"),
    PUNK_ROCK("5");

    public final String s;

    MusicGenre(String s) {
        this.s = s;
    }

    /**
     * Method for checking values of enum when add stuff.command is running
     *
     * @param label
     * @return MusicGenre object
     */
    public static MusicGenre valueOfLabel(String label) {
        for (MusicGenre m : values()) {
            if (m.s.equals(label)) {
                return m;
            }
        }
        return null;
    }
}

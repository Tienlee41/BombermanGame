package uet.oop.bomberman.utils;

import java.io.InputStream;
import java.net.URL;
import java.util.Objects;

import uet.oop.bomberman.BombermanGame;

public class PathFile {
    
    public static InputStream getStream(String path) {
        return BombermanGame.class.getResourceAsStream(path);
    }

    public static String getPath(String path) throws Exception {
        try {
            return Objects.requireNonNull(BombermanGame.class.getResource(path)).getPath();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "res" + path;
    }

    public static URL getURL(String path) throws Exception {
        return new URL("file","",PathFile.getPath(path)); 
    }
}

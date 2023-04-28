package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application; 
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Brick;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Grass;
import uet.oop.bomberman.entities.Wall;
import uet.oop.bomberman.graphics.Sprite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MakeMap {
    private static List<Entity> stillObjects = new ArrayList<>();
    public static List<Entity> createMap(int level)  {
        try {
            String line;
            FileReader fr = new FileReader("res/levels/Level" + level + ".txt");
            BufferedReader reader = new BufferedReader(fr);
            line = reader.readLine();
            String[] lines = line.split(" ");

            int width = Integer.parseInt(lines[1]); //   width of board
            int length = Integer.parseInt(lines[2]); // length of board

            int y = 0; // co-ordinates y
            while(width >= y) {
                line = reader.readLine();
                for(int i = 0; i < length; i++) {
                    Entity object;
                    if(line.charAt(i) == '#') {
                        object = new Wall(i, y, Sprite.wall.getFxImage());
                    } else if (line.charAt(i) == '*') {
                        object = new Brick(i, y, Sprite.brick.getFxImage());
                    } else if (line.charAt(i) == ' ') {
                        object = new Grass(i, y, Sprite.grass.getFxImage());
                    }   else {
                        object = new Grass(i, y, Sprite.grass.getFxImage());
                    }
                    stillObjects.add(object);
                }
                y++;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return stillObjects;
    }
}
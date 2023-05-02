package uet.oop.bomberman.map;

import java.util.List;
import java.util.Scanner;

import uet.oop.bomberman.Level;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class Map {
    public int widthTitle;
    public int heightTitle;
    public Level currentLevel;
    private List<Entity> movableEntities;
    private Entity[][] mapInfo;
    protected Entity[][] grassList;
    protected Entity[][] bombList;
    protected List<Entity> bombArray;

    public int getWidth_pixel() {
        return widthTitle * Sprite.SCALED_SIZE;
    }

    public int getHeight_pixel() {
        return heightTitle * Sprite.SCALED_SIZE;
    }

    public void readMapInfo() {
        Scanner sc;
        try {
            sc = new Scanner(getClass().getResource("/levels/Level" + (currentLevel.getLevelCode().get() + 1) + ".txt").openStream());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}

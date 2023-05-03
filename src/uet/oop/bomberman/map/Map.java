package uet.oop.bomberman.map;

import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

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
        Scanner sc = null;
        try {
            sc = new Scanner(getClass().getResource("/levels/Level" + (currentLevel.getLevelCode().get() + 1) + ".txt").openStream());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String row; // info of a row
        assert sc != null;
        row = sc.nextLine();

        // Line 1 splits  : LEVEL, WIDTH, HEIGHT
        StringTokenizer specs = new StringTokenizer(row,"");
        specs.nextToken();
        heightTitle = Integer.parseInt(specs.nextToken());
        widthTitle = Integer.parseInt(specs.nextToken());

        mapInfo = new Entity[heightTitle][widthTitle];
        grassList = new Entity[heightTitle][widthTitle];
        bombList = new Entity[heightTitle][widthTitle];

    }

    public Entity getEntityAt(int curX, int curY) {
        return null;
    }

    public static int dx_gc = 0, dy_gc = 0;

}

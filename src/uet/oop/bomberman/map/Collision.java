package uet.oop.bomberman.map;

import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Movable_Objects.Movable_Object;
import uet.oop.bomberman.entities.Movable_Objects.enemies.*;
import uet.oop.bomberman.graphics.Sprite;

import java.util.List;

public class Collision {
    private final Map map;
    private final int CENTER_OBJECT_HEIGHT;
    private final int CENTER_OBJECT_WIDTH;

    /**
     * Constructor for collision.
     */
    public Collision(Map map, int objectWidth, int objectHeight) {
        this.map = map;
        CENTER_OBJECT_WIDTH = objectWidth;
        CENTER_OBJECT_HEIGHT = objectHeight;
    }

    public Map getMap() {
        return map;
    }

    public Entity topLeftCorner;
    public Entity topRightCorner;
    public Entity downLeftCorner;
    public Entity downRightCorner;

}

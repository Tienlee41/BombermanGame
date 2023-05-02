package uet.oop.bomberman.entities.Movable_Objects;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import uet.oop.bomberman.map.Collision;
import uet.oop.bomberman.GameControll;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Immovable_Objects.Brick;
//import uet.oop.bomberman.entities.stillo
//import uet.oop.bomberman.entities.movingobject.enemies.Enemy;
import uet.oop.bomberman.entities.Immovable_Objects.Wall;
import uet.oop.bomberman.entities.Movable_Objects.Movable_Object;
import uet.oop.bomberman.graphics.Sprite;

import java.util.*;



public class Bomber extends Movable_Object {
    public Bomber(int xUnit, int yUnit, Image img, Collision collision) {
        super(xUnit, yUnit, img, collision);
        //TODO Auto-generated constructor stub
    }

    public static final List<Class> cannotPassEntityList = Arrays.asList(new Class[]{Wall.class, Brick.class});
    public static final int MAX_LIVES = 3;
    int numOfLives = 3;
    public static int speed = 3;
    private int maxBomb = 3;
    public int bombRadius = 1;

    public int getBombRadius() {
        return bombRadius;
    }

    Map<KeyCode, Boolean> keyCodeMap = new HashMap<>();

    public void setNumOfLives(int numOfLives) {
        this.numOfLives = numOfLives;
    }

    public int getNumOfLives() {
        return numOfLives;
    }

    /**
     * Bomber size
     */
    public static final int WIDTH = Sprite.SCALED_SIZE * 20 / 32;
    public static final int HEIGHT = Sprite.SCALED_SIZE * 28 / 32;
    private static final int FIX_SIZE = Sprite.SCALED_SIZE / 2;
    /**
     * Direction check and bombed check.
     */
    private boolean bombed = false;
    private KeyCode latestDirectKey = KeyCode.RIGHT;
    private final List<Entity> movingEntitiesList;

}

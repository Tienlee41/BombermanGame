package uet.oop.bomberman.entities.Movable_Objects.enemies;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.map.Collision;
import uet.oop.bomberman.entities.Movable_Objects.Bomber;
import uet.oop.bomberman.entities.Movable_Objects.Movable_Object;
import uet.oop.bomberman.entities.Movable_Objects.Bomber;
import uet.oop.bomberman.graphics.Sprite;

public abstract class Enemy extends Movable_Object {
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;
    Collision collision;
    protected int SPEED;
    protected String dir = "";
    protected boolean changeDirection = false;
    Sprite[] leftSprites;
    Sprite[] rightSprites;
    Sprite[] deadSprites;

    /**
     * Load sprite of types of enemies into sprites lists.
     */
    public abstract void loadSprite();

    /**
     * Constructor for enemy.
     */
    public Enemy(int xUnit, int yUnit, Image img, Collision collision) {
        super(xUnit, yUnit, img, collision);
        this.collision = collision;
        this.SPEED = 1;
        loadSprite();
        objectStatus = MovingObjectStatus.ALIVE;
    }

    public abstract void move();

    @Override
    public void update() {
        if (objectStatus == MovingObjectStatus.ALIVE) {
            move();
        }
        if (objectStatus == MovingObjectStatus.MORIBUND) {
            if (indexOfSprite == 20) objectStatus = MovingObjectStatus.DEAD;
            else setImg(deadSprites[indexOfSprite % deadSprites.length]);
            indexOfSprite++;
        }
    }

    /**
     * Check if enemy collide with bomber.
     *
     * @param xPixel int
     * @param yPixel int
     * @return true/false
     */
    public boolean collideBomber(int xPixel, int yPixel) {
        return yPixel + Bomber.HEIGHT - Sprite.SCALED_SIZE / 10 >= y
                && yPixel + Sprite.SCALED_SIZE / 10 <= y + Enemy.HEIGHT
                && xPixel + Bomber.WIDTH - Sprite.SCALED_SIZE / 10 >= x
                && xPixel + Sprite.SCALED_SIZE / 10 <= x + Enemy.WIDTH;
    }


    /**
     * Random new speed for enemy.
     *
     * @param x is lower bound.
     * @param y is upper bound.
     */
    public void randomSpeed(int x, int y) {
        SPEED = ((int) (Math.random() * (y - x)) + x);
    }
}

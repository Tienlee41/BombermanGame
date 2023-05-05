package uet.oop.bomberman.entities.Movable_Objects.enemies;

import uet.oop.bomberman.map.Collision;
import uet.oop.bomberman.entities.Immovable_Objects.Bomb.Bomb;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Arrays;
import java.util.List;

public class Kondoria extends Enemy implements NormalEnemy {
    public static final List<Class> cannotPassEntityList = Arrays.asList(new Class[]{Bomb.class});
    @Override
    public void loadSprite() {
        leftSprites = new Sprite[3];
        rightSprites = new Sprite[3];
        deadSprites = new Sprite[1];
        leftSprites[0] = Sprite.kondoria_left1;
        leftSprites[1] = Sprite.kondoria_left2;
        leftSprites[2] = Sprite.kondoria_left3;
        rightSprites[0] = Sprite.kondoria_right1;
        rightSprites[1] = Sprite.kondoria_right2;
        rightSprites[2] = Sprite.kondoria_right3;
        deadSprites[0] = Sprite.kondoria_dead;
    }

    /**
     * Constructor for Kondoria.
     */
    public Kondoria(int xUnit, int yUnit, Collision collision) {
        super(xUnit, yUnit, Sprite.kondoria_right1.getFxImage(), collision);
    }

    @Override
    public void move() {
        randomMovingWhenCollidingWithWall();
    };

    @Override
    public List<Class> getCannotPassEnityList() {
        return cannotPassEntityList;
    }

    public void randomMovingWhenCollidingWithWall() {
        indexOfSprite++;
        if (!changeDirection) {
            int rand = (int) (Math.random() * 10);
            switch (rand % 4) {
                case 0:
                    dir = "LEFT";
                    break;
                case 1:
                    dir = "RIGHT";
                    break;
                case 2:
                    dir = "UP";
                    break;
                case 3:
                    dir = "DOWN";
                    break;
                default:
                    break;
            }
        }
        if (collision.collideWallAtEdge(x, y, dir, SPEED)) {
            changeDirection = false;
            indexOfSprite = 0;
        } else {
            switch (dir){
                case "LEFT":
                    x -= SPEED;
                    setImg(Sprite.movingSprite(
                            leftSprites[0],
                            leftSprites[1],
                            leftSprites[2], indexOfSprite, 20));
                    break;
                case "RIGHT":
                    x += SPEED;
                    setImg(Sprite.movingSprite(
                            rightSprites[0],
                            rightSprites[1],
                            rightSprites[2], indexOfSprite, 20));
                    break;
                case "UP":
                    y -= SPEED;
                    setImg(Sprite.movingSprite(
                            rightSprites[0],
                            rightSprites[1],
                            rightSprites[2], indexOfSprite, 20));
                    break;
                case "DOWN":
                    y += SPEED;
                    setImg(Sprite.movingSprite(
                            leftSprites[0],
                            leftSprites[1],
                            leftSprites[2], indexOfSprite, 20));
                    break;

            }
            changeDirection = true;
        }
    }
}

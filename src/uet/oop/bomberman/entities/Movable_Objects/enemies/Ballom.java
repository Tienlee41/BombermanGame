package uet.oop.bomberman.entities.Movable_Objects.enemies;

import java.util.Arrays;
import java.util.List;

import uet.oop.bomberman.entities.Immovable_Objects.Brick;
import uet.oop.bomberman.entities.Immovable_Objects.Wall;
import uet.oop.bomberman.entities.Movable_Objects.Bomb.Bomb;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.map.Collision;

public class Ballom extends Enemy implements EasyEnemy {
    
    public static final List<Class> CannotPassEntityList = Arrays.asList(new Class[]{Wall.class, Brick.class, Bomb.class});

    @Override
    public void loadSprite() {
        leftSprites = new Sprite[3];
        rightSprites = new Sprite[3];
        deadSprites = new Sprite[1];
        leftSprites[0] = Sprite.balloom_left1;
        leftSprites[1] = Sprite.balloom_left2;
        leftSprites[2] = Sprite.balloom_left3;
        rightSprites[0] = Sprite.balloom_right1;
        rightSprites[1] = Sprite.balloom_right2;
        rightSprites[2] = Sprite.balloom_right3;
        deadSprites[0] = Sprite.balloom_dead;
    }

    public Ballom(int xUnit, int yUnit, Collision collision) {
        super(xUnit, yUnit,Sprite.balloom_left1.getFxImage(), collision);
    }

    @Override
    public void move() {
        randomMovingWhenCollidingWithWall();
    }

    @Override
    public List<Class> getCannotPassEnityList() {
        return CannotPassEntityList;
    }
    
    
}

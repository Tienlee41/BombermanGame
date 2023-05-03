package uet.oop.bomberman.entities.Movable_Objects.enemies;

import java.util.Arrays;
import java.util.List;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Immovable_Objects.Wall;
import uet.oop.bomberman.entities.Movable_Objects.Bomb.Bomb;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.map.Collision;

public class Doll extends Enemy implements NormalEnemy {

    public static final List<Class> CannotPassEntityList = Arrays.asList(new Class[] {Wall.class, Bomb.class});

    
    public Doll(int xUnit, int yUnit, Image img, Collision collision) {
        super(xUnit, yUnit, Sprite.doll_right1.getFxImage(), collision);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void loadSprite() {
        leftSprites = new Sprite[3];
        rightSprites = new Sprite[3];
        deadSprites = new Sprite[1];
        leftSprites[0] = Sprite.doll_left1;
        leftSprites[1] = Sprite.doll_left2;
        leftSprites[2] = Sprite.doll_left3;
        rightSprites[0] = Sprite.doll_right1;
        rightSprites[1] = Sprite.doll_right2;
        rightSprites[2] = Sprite.doll_right3;
        deadSprites[0] = Sprite.doll_dead;
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

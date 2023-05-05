package uet.oop.bomberman.entities.Movable_Objects.enemies;

import java.util.Arrays;
import java.util.List;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Immovable_Objects.Bomb.Bomb;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.map.Collision;

public class Kondoria extends Enemy implements NormalEnemy {

    public Kondoria(int xUnit, int yUnit, Collision collision) {
        super(xUnit, yUnit, Sprite.kondoria_right1.getFxImage(), collision);
        //TODO Auto-generated constructor stub
    }

    public static final List<Class> CannotPassEntityList = Arrays.asList(new Class[]{Bomb.class});
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

    @Override
    public void move() {
        randomMovingWhenCollidingWithWall();
    }

    @Override
    public List<Class> getCannotPassEnityList() {
        return CannotPassEntityList;
    }
    
    
}

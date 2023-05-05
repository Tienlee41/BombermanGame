package uet.oop.bomberman.entities.Immovable_Objects.item;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.map.Map;

public class BombItem extends Item {

    public BombItem(int xUnit, int yUnit, Map map) {
        super(xUnit, yUnit, Sprite.powerup_bombs.getFxImage(), map);
    }
    
}

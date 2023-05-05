package uet.oop.bomberman.entities.Immovable_Objects;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.map.Map;

public class Portal extends Immovable_Object {

    public Portal(int xUnit, int yUnit, Map map) {
        super(xUnit, yUnit, Sprite.grass.getFxImage(), map);
        //TODO Auto-generated constructor stub
    }
    
    @Override
    public void update() {
    }
}

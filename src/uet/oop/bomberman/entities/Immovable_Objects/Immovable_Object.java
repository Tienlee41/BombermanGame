package uet.oop.bomberman.entities.Immovable_Objects;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.map.Map;

public class Immovable_Object extends Entity {

    protected Map map;
    
    public Immovable_Object(int xUnit, int yUnit, Image img, Map map) {
        super(xUnit, yUnit, img);
        this.map = map;
    }

    @Override
    public void update() {
    }

}

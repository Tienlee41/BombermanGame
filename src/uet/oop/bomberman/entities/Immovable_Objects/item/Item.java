package uet.oop.bomberman.entities.Immovable_Objects.item;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Immovable_Objects.Immovable_Object;
import uet.oop.bomberman.map.Map;

public abstract class Item extends Immovable_Object {

    public Item(int xUnit, int yUnit, Image img, Map map) {
        super(xUnit, yUnit, img, map);
    }
    
    @Override
    public void update() {
    }
}

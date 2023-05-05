package uet.oop.bomberman.entities.Immovable_Objects.Bomb;

import uet.oop.bomberman.entities.Immovable_Objects.Immovable_Object;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.map.Map;

public class Bomb extends Immovable_Object {

    public Bomb(int x, int y, Map map) {
        super(x, y, Sprite.bomb.getFxImage(), map);
    }

    public Object getBombStatus() {
        return null;
    }
    
}

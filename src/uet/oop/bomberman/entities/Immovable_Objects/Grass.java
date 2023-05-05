package uet.oop.bomberman.entities.Immovable_Objects;

import uet.oop.bomberman.graphics.Sprite;

public class Grass extends Immovable_Object {

    public Grass(int x, int y) {
        super(x, y, Sprite.grass.getFxImage(), null);
    }

    @Override
    public void update() {

    }
}

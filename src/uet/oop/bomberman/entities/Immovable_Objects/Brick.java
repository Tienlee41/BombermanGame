package uet.oop.bomberman.entities.Immovable_Objects;


import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.map.Map;

public class Brick extends Immovable_Object {
    int indexOfSprite = 0;

    public Brick(int xUnit, int yUnit,Map map) {
        super(xUnit, yUnit,Sprite.brick.getFxImage(), map);
    }

    public void destroyBrick(int xTile, int yTile) {
        indexOfSprite++;
        setImg(Sprite.movingSprite(Sprite.brick_exploded,
                Sprite.brick_exploded1,
                Sprite.brick_exploded2, indexOfSprite, 40));
        if (indexOfSprite == 40) {
            indexOfSprite = 0;
            map.removeInMapInfo(yTile, xTile);
        }
    }

    @Override
    public void update() {
        
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
    }
}

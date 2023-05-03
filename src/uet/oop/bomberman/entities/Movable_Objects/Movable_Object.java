package uet.oop.bomberman.entities.Movable_Objects;

import javafx.scene.image.Image;
import uet.oop.bomberman.map.Collision;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.map.Map;

import java.util.List;

public abstract class Movable_Object extends Entity {
    protected MovingObjectStatus objectStatus;
    protected int indexOfSprite;
    Map map;
    Collision collision;

    public abstract List<Class> getCannotPassEnityList();

    public enum MovingObjectStatus {
        ALIVE,
        MORIBUND,
        DEAD
    }

    /**
     * Constructor of MovingObject.
     */
    public Movable_Object(int xUnit, int yUnit, Image img, Collision collision) {
        super(xUnit, yUnit, img);
        this.collision  = collision;
        map = collision.getMap();
        indexOfSprite = 0;
        objectStatus = MovingObjectStatus.ALIVE;
    }

    public void setObjectStatus(MovingObjectStatus objectStatus) {
        this.objectStatus = objectStatus;
        if (objectStatus == MovingObjectStatus.MORIBUND) indexOfSprite = 0;
    }

    public MovingObjectStatus getObjectStatus() {
        return objectStatus;
    }
}

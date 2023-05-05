package uet.oop.bomberman.map;

import uet.oop.bomberman.entities.Immovable_Objects.Brick;
import uet.oop.bomberman.entities.Immovable_Objects.Wall;
import uet.oop.bomberman.entities.Immovable_Objects.Bomb.Bomb;

public class Vertices {
    /**
     * Tile position on map.
     */
    private int xTilePos;
    private int yTilePos;

    public Vertices(int xTilePos, int yTilePos) {
        this.xTilePos = xTilePos;
        this.yTilePos = yTilePos;
    }

    public int getxTilePos() {
        return xTilePos;
    }

    public int getyTilePos() {
        return yTilePos;
    }


    @Override
    public String toString() {
        return String.format("(%d,%d)", xTilePos, yTilePos);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vertices) {
            Vertices vertice = (Vertices) obj;
            if (vertice.getxTilePos() == xTilePos && vertice.getyTilePos() == yTilePos) return true;
        }
        return false;
    }
}
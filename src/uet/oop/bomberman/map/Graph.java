package uet.oop.bomberman.map;

import java.util.ArrayList;
import java.util.List;

import uet.oop.bomberman.graphics.Sprite;

public class Graph {

    private int numOfVertices;
    private final List<Vertices> verticesList;
    private final List<Edge>[] adjList;

    public Graph(int numOfVertices, List<Vertices> verticesList) {
        this.numOfVertices = numOfVertices;
        this.verticesList = verticesList;
        adjList = new List[numOfVertices];
        for (int i = 0; i < numOfVertices; i++) {
            adjList[i] = new ArrayList<>();
        }
    }
    
    private void addEdge(Edge edge) {
        adjList[edge.getDes()].add(edge);
        adjList[edge.getScr()].add(edge);
    }

    public void completeBuildingGraph(Map map) {
        for (int i = 0; i < verticesList.size() - 1; i++) {
            int firstX = verticesList.get(i).getxTilePos();
            int firstY = verticesList.get(i).getyTilePos();

            for (int j = i + 1; j < verticesList.size(); j++) {
                {
                    int secondX = verticesList.get(j).getxTilePos();
                    int secondY = verticesList.get(j).getyTilePos();

                    // Case vertice i and j on same column.
                    if (secondX == firstX) {
                        boolean check = true;
                        int start = Math.min(firstY, secondY) + 1;
                        int end = Math.max(firstY, secondY) - 1;
                        int distance = end - start + 2;
                        while (start <= end) {
                            Vertices vertice = new Vertices(secondX, start);
                            if (!(map.getEntityAt(secondX * Sprite.SCALED_SIZE, start * Sprite.SCALED_SIZE) == null)
                                    || verticesList.contains(vertice)) {
                                check = false;
                                break;
                            }
                            start++;
                        }
                        if (check) {
                            Edge edge = new Edge(i, j, distance);
                            addEdge(edge);
                        }
                    }

                    // Case vertice i and j on same row.
                    if (secondY == firstY) {
                        boolean check = true;
                        int start = Math.min(firstX, secondX) + 1;
                        int end = Math.max(firstX, secondX) - 1;
                        int distance = end - start + 2;
                        while (start <= end) {
                            Vertices vertice = new Vertices(start, secondY);
                            if (!(map.getEntityAt(start * Sprite.SCALED_SIZE, secondY * Sprite.SCALED_SIZE) == null)
                                    || verticesList.contains(vertice)) {
                                check = false;
                                break;
                            }
                            start++;
                        }
                        if (check) {
                            Edge edge = new Edge(i, j, distance);
                            addEdge(edge);
                        }
                    }
                }
            }
        }
    }

    public boolean isConnected() {
        return false;
    }

    public List<Vertices> findWay(int i, int j) {
        return null;
    }
}

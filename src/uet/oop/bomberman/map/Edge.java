package uet.oop.bomberman.map;

public class Edge implements Comparable<Edge> {

    int scr;
    int des;
    int weight;

    public Edge(int scr, int des, int weight) {
        this.scr = scr;
        this.des = des;
        this.weight = weight;
    }

    public int getScr() {
        return scr;
    }

    public int getDes() {
        return des;
    }

    public int getWeight() {
        return weight;
    }

    public void setDes(int des) {
        this.des = des;
    }

    public void setScr(int scr) {
        this.scr = scr;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }

    public int getOther(int a) {
        if (a == des) {
            return this.scr;
        }
        return this.des;
    }
}

public class Shiplacer {
    private int size;
    private int health;
    private int startrow, startcol;
    private int endrow, endcol;

    public Shiplacer(int size) {

        this.size = size;
        this.health = size;

    }

    public void setLocation(int startrow, int startcol, int endrow, int endcol) {
        this.startrow = startrow;
        this.startcol = startcol;
        this.endrow = endrow;
        this.endcol = endcol;

    }

    public void hit() {
        if (health > 0) {
            health--;

        }
    }

    public boolean sunk() {

            return health == 0;

    }
public int getSize(){
        return size;
}
}

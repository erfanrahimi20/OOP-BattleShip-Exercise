import java.util.Random;

public class Shiplacer {
    private int size;
    private int health;
    private int startRow, startCol;
    private int endRow, endCol;

    public Shiplacer(int size) {

        this.size = size;
        this.health = size;

    }

    public void setLocation(int startRow, int startCol, int endRow, int endCol) {
        this.startRow = startRow;
        this.startCol = startCol;
        this.endRow = endRow;
        this.endCol = endCol;

    }
    public void setRandomPosition(int boardSize) {
        Random random = new Random();
        boolean isHorizontal = random.nextBoolean();
        if (isHorizontal) {
            startRow = random.nextInt(boardSize);
            startCol = random.nextInt(boardSize - size + 1);
            endRow = startRow;
            endCol = startCol + size - 1;
        }else{
            startRow = random.nextInt(boardSize - size + 1);
            startCol = random.nextInt(boardSize);
            endRow = startRow + size - 1;
            endCol = startCol;
        }
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

public class Board {
    private int size;
    private char[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new char[size][size];
        initializeGrid();
    }


    public void initializeGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = ' ';

            }
        }
    }

    public void printBoard() {
        System.out.println("  ");
        for (int i = 0; i < size; i++) {
            System.out.print((char) ('A' + i) + ' ');

        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");

            }

            System.out.println();
        }


    }
public int getSize(){

        return size;
}

    public void setSize(int size) {
        this.size = size;

    }
    public char[][] getGrid(){
        return grid;
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }
}

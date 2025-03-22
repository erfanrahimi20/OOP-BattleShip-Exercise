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
        System.out.print("  ");
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
    public boolean canPlaceShip(Shiplacer ship) {
        char[][] grid = this.getGrid();
        if (ship.getStartRow() < 0 || ship.getStartCol() < 0 ||
                ship.getEndRow() >= grid.length || ship.getEndCol() >= grid[0].length) {
            return false;
        }
        for (int i = ship.getStartRow(); i <= ship.getEndRow(); i++) {
            for (int j = ship.getStartCol(); j <= ship.getEndCol(); j++) {
                if (grid[i][j] != ' ') {
                    return false;
                }
            }
        }
        return true;
    }

}

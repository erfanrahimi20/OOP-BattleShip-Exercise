public class Board {
    private int size;
    private char[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new char[size][size];
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public void print(boolean showShips) {
        System.out.print("  ");
        for (int i = 0; i < size; i++) {
            System.out.print((char)('A' + i) + " ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < size; j++) {
                char c = grid[i][j];
                if (!showShips && c == 'S') {
                    System.out.print("  ");
                } else {
                    System.out.print(c + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean canPlaceShip(Ship ship) {
        if (ship.getStartRow() < 0 || ship.getStartCol() < 0 ||
                ship.getEndRow() >= size || ship.getEndCol() >= size) {
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

    public void placeShip(Ship ship) {
        for (int i = ship.getStartRow(); i <= ship.getEndRow(); i++) {
            for (int j = ship.getStartCol(); j <= ship.getEndCol(); j++) {
                grid[i][j] = 'S';
            }
        }
    }

    public boolean attack(int row, int col) {
        if (grid[row][col] == 'S') {
            grid[row][col] = 'X';
            return true;
        } else if (grid[row][col] == ' ') {
            grid[row][col] = 'O';
        }
        return false;
    }

    public int getSize() { return size; }
    public char[][] getGrid() { return grid; }
}
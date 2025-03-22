public class SpecialAttack {

    public static void radarScan(Board enemyBoard, int row, int col) {
        char[][] grid = enemyBoard.getGrid();
        int size = enemyBoard.getSize();

        int startRow = Math.max(0, row - 1);
        int endRow = Math.min(size - 1, row + 1);
        int startCol = Math.max(0, col - 1);
        int endCol = Math.min(size - 1, col + 1);

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if (grid[i][j] == 'S') {
                    System.out.println("Ship detected at: (" + i + ", " + j + ")");
                }
            }
        }
    }

    public static void multiStrike(Board enemyBoard, int row, int col) {
        char[][] grid = enemyBoard.getGrid();
        int size = enemyBoard.getSize();
        System.out.println("Radar scan activated");
        attackCell(grid, row, col);


        if (row - 1 >= 0) attackCell(grid, row - 1, col);

            if (row + 1 < size) attackCell(grid, row + 1, col);

            if (col - 1 >= 0) attackCell(grid, row, col - 1);

           if (col + 1 < size) attackCell(grid, row, col + 1);
    }

    private static void attackCell(char[][] grid, int row, int col) {
        if (grid[row][col] == 'S') {
            grid[row][col] = 'X';
            System.out.println("Hit at (" + row + ", " + col + ")!");
        } else if (grid[row][col] == ' ') {
            grid[row][col] = 'O';
            System.out.println("Miss at (" + row + ", " + col + ").");
        } else {
            System.out.println("Already attacked at (" + row + ", " + col + ").");
        }
    }
}



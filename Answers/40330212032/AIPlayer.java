import java.util.Random;
public class AIPlayer extends Player {
    private Random random;
    public AIPlayer(String name, Board boardSize, int maxShips) {
        super(name, boardSize, maxShips);
        this.random = new Random();
    }
    public int[] makeMove() {
        int row = random.nextInt(getBoard().getSize());
        int col = random.nextInt(getBoard().getSize());
        return new int[]{row, col};
    }
    public void placeShipsRandomly() {
        for (int i = 0; i < getShips().length; i++) {
            boolean placed = false;
            while (!placed) {
                Shiplacer ship = new Shiplacer(random.nextInt(3) + 2);
                ship.setRandomPosition(getBoard().getSize());
                if (canPlaceShip(ship)) {  addShip(ship);
                    placeShipOnBoard(ship);
                    placed = true;
                }
            }
        }
    }
    private boolean canPlaceShip(Shiplacer ship) {
        char[][] grid = getBoard().getGrid();
        for (int i = ship.getStartRow(); i <= ship.getEndRow(); i++) {
            for (int j = ship.getStartCol(); j <= ship.getEndCol(); j++) {
                if (grid[i][j] != ' ') {
                    return false;
                }
            }
        }
        return true;
    }


    private void placeShipOnBoard(Shiplacer ship) {
        char[][] grid = getBoard().getGrid();
        for (int i = ship.getStartRow(); i <= ship.getEndRow(); i++) {
            for (int j = ship.getStartCol(); j <= ship.getEndCol(); j++) {
                grid[i][j] = 'S';
            }
        }
    }
}


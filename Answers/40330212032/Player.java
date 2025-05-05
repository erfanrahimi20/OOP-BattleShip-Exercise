import java.util.Scanner;

public class Player {
    private String name;
    private Board board;
    protected Ship[] ships;
    protected int shipCount;

    public Player(String name, int boardSize, int maxShips) {
        this.name = name;
        this.board = new Board(boardSize);
        this.ships = new Ship[maxShips];
        this.shipCount = 0;
    }

    public boolean placeShip(int row, int col, String direction, int size) {
        Ship ship = new Ship(size);
        int endRow = row;
        int endCol = col;

        if (direction.equalsIgnoreCase("H")) {
            endCol = col + size - 1;
        } else if (direction.equalsIgnoreCase("V")) {
            endRow = row + size - 1;
        }

        ship.setLocation(row, col, endRow, endCol);

        if (board.canPlaceShip(ship)) {
            board.placeShip(ship);
            ships[shipCount++] = ship;
            return true;
        }
        return false;
    }

    public boolean attack(Player opponent, int row, int col) {
        if (row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize()) {
            return false;
        }

        boolean hit = opponent.getBoard().attack(row, col);
        if (hit) {
            System.out.println("HIT!");
            for (Ship ship : opponent.getShips()) {
                if (ship != null && row >= ship.getStartRow() && row <= ship.getEndRow() &&
                        col >= ship.getStartCol() && col <= ship.getEndCol()) {
                    ship.hit();
                    break;
                }
            }
        } else {
            System.out.println("MISS!");
        }
        return true;
    }

    public boolean allShipsSunk() {
        for (Ship ship : ships) {
            if (ship != null && !ship.isSunk()) {
                return false;
            }
        }
        return true;
    }

    public String getName() { return name; }
    public Board getBoard() { return board; }
    public Ship[] getShips() { return ships; }
}
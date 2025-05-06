import java.util.Random;

public class AIPlayer extends Player {
    private Random random;
    private int[][] possibleMoves;
    private int movesLeft;

    public AIPlayer(String name, int boardSize, int maxShips) {
        super(name, boardSize, maxShips);
        this.random = new Random();
        initializePossibleMoves(boardSize);
    }

    private void initializePossibleMoves(int boardSize) {
        possibleMoves = new int[boardSize * boardSize][2];
        movesLeft = boardSize * boardSize;

        int index = 0;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                possibleMoves[index][0] = i;
                possibleMoves[index][1] = j;
                index++;
            }
        }
    }

    public void placeShipsRandomly() {
        int[] shipSizes = {5, 4, 3, 3, 2};

        for (int size : shipSizes) {
            boolean placed = false;
            while (!placed) {
                Ship ship = new Ship(size);
                ship.setRandomPosition(getBoard().getSize());

                if (getBoard().canPlaceShip(ship)) {
                    getBoard().placeShip(ship);
                    ships[shipCount++] = ship;
                    placed = true;
                }
            }
        }
    }

    public int[] makeMove() {
        if (movesLeft <= 0) {
            return new int[]{0, 0};
        }

        int index = random.nextInt(movesLeft);
        int[] move = possibleMoves[index];


        possibleMoves[index] = possibleMoves[movesLeft - 1];
        movesLeft--;

        return move;
    }
}
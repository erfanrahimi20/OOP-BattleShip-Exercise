import java.util.Scanner;

public class Game {

    private Player player1;
    private Player player2;
    private boolean isGameOver;
    private boolean isTwoPlayerMode;

    public Game(String player1Name, String player2Name, int boardSize, int maxShips, boolean isTwoPlayerMode) {
        this.player1 = new Player(player1Name, new Board(boardSize), maxShips);
        this.isTwoPlayerMode = isTwoPlayerMode;

        if (isTwoPlayerMode) {
            this.player2 = new Player(player2Name, new Board(boardSize), maxShips);
        } else {
            this.player2 = new AIPlayer(player2Name, boardSize, maxShips);
        }

        this.isGameOver = false;
    }

    public void start() {
        System.out.println("Welcome to BattleShip!");

        placeShips(player1);

        if (isTwoPlayerMode) {
            placeShips(player2);
        } else {
            ((AIPlayer) player2).placeShipsRandomly();
        }

        while (!isGameOver) {
            playTurn(player1, player2);
            if (player2.ifSunks()) {
                System.out.println(player1.getName() + " Wins!");
                isGameOver = true;
                break;
            }

            playTurn(player2, player1);
            if (player1.ifSunks()) {
                System.out.println(player2.getName() + " Wins!");
                isGameOver = true;
            }
        }
    }

    private void placeShips(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(player.getName() + " Determine the location for the target.");

        for (int i = 0; i < player.getShips().length; i++) {
            System.out.println("Enter the starting row, starting col, and ship size:");
            int startRow = scanner.nextInt();
            int startCol = scanner.nextInt();
            String direction = scanner.next();
            int size = scanner.nextInt();

            int endRow = startRow;
            int endCol = startCol;

            if (direction.equalsIgnoreCase("H")) {
                endCol = startCol + size - 1;
            } else if (direction.equalsIgnoreCase("V")) {
                endRow = startRow + size - 1;
            }

            Shiplacer ship = new Shiplacer(size);
            ship.setLocation(startRow, startCol, endRow, endCol);

            if (player.getBoard().canPlaceShip(ship)) {
                player.addShip(ship);
                System.out.println("Ship placed successfully!");
            } else {
                System.out.println("Invalid position.");
                i--;
            }
        }
    }

    private void playTurn(Player currentPlayer, Player opponent) {
        Scanner scanner = new Scanner(System.in);

        if (currentPlayer instanceof AIPlayer) {
            int[] move = ((AIPlayer) currentPlayer).makeMove();
            System.out.println("AI attacking: (" + move[0] + ", " + move[1] + ")");
            currentPlayer.attack(opponent, move[0], move[1]);
        } else {
            System.out.println(currentPlayer.getName() + "'s turn. Enter row and col to attack:");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (!currentPlayer.attack(opponent, row, col)) {
                System.out.println("This move is invalid.");
            }
        }
    }
}



import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private boolean isTwoPlayerMode;
    private Scanner scanner;

    public Game(String player1Name, String player2Name, int boardSize, int maxShips, boolean isTwoPlayerMode) {
        this.player1 = new Player(player1Name, boardSize, maxShips);
        this.isTwoPlayerMode = isTwoPlayerMode;
        this.scanner = new Scanner(System.in);

        if (isTwoPlayerMode) {
            this.player2 = new Player(player2Name, boardSize, maxShips);
        } else {
            this.player2 = new AIPlayer(player2Name, boardSize, maxShips);
        }
    }

    public void start() {
        System.out.println("  === SHIP PLACEMENT PHASE ===");
        placeShips(player1);

        if (isTwoPlayerMode) {
            System.out.println("  === " + player2.getName() + "'s SHIP PLACEMENT ===");
            placeShips(player2);
        } else {
            ((AIPlayer)player2).placeShipsRandomly();
            System.out.println("AI has placed its ships randomly.");
        }

        System.out.println("  === BATTLE PHASE ===");
        Player currentPlayer = player1;
        Player opponent = player2;

        while (true) {
            playTurn(currentPlayer, opponent);

            if (opponent.allShipsSunk()) {
                System.out.println("  === GAME OVER ===");
                System.out.println(currentPlayer.getName() + " WINS!");
                break;
            }

            Player temp = currentPlayer;
            currentPlayer = opponent;
            opponent = temp;

            System.out.println(" Press Enter to continue...");
            scanner.nextLine();
        }
    }

    private void placeShips(Player player) {
        System.out.println("\n" + player.getName() + ", place your ships:");
        int[] shipSizes = {5, 4, 3, 3, 2};

        for (int size : shipSizes) {
            boolean placed = false;
            while (!placed) {
                System.out.println(" Your board:");
                player.getBoard().print(true);
                System.out.println(" Placing ship of size " + size);

                System.out.println("Enter start row (0-9), start column (0-9), and direction (H/V):");
                System.out.print("Example: 3 4 H (for horizontal at row 3, column 4): ");

                int row = scanner.nextInt();
                int col = scanner.nextInt();
                String direction = scanner.next();

                placed = player.placeShip(row, col, direction, size);

                if (!placed) {
                    System.out.println("Invalid position. Try again.");
                }
            }
        }
    }

    private void playTurn(Player currentPlayer, Player opponent) {
        System.out.println(" === " + currentPlayer.getName() + "'s TURN ===");
        System.out.println("Your board:");
        currentPlayer.getBoard().print(true);
        System.out.println(" Enemy board:");
        opponent.getBoard().print(false);

        boolean validMove = false;
        while (!validMove) {
            int[] move;

            if (currentPlayer instanceof AIPlayer) {
                move = ((AIPlayer)currentPlayer).makeMove();
                System.out.println("AI attacking: " + move[0] + " " + move[1]);
            } else {
                System.out.print("Enter attack coordinates (row column): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                move = new int[]{row, col};
            }

            validMove = currentPlayer.attack(opponent, move[0], move[1]);

            if (!validMove && !(currentPlayer instanceof AIPlayer)) {
                System.out.println("Invalid move. Try again.");
            }
        }
    }
}
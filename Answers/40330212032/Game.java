import java.util.Scanner;
public class Game {

        private Player player1;
        private AIPlayer player2;
        private boolean isGameOver;

        public Game(String player1Name, int boardSize, int maxShips) {
            player1 = new Player(player1Name, new Board(boardSize), maxShips);
            player2 = new AIPlayer("AI", boardSize, maxShips);
            isGameOver = false;
        }

        public void start() {
            System.out.println("Welcome to Game!");
            placeShips(player1);
            player2.placeShipsRandomly();

            while (!isGameOver) {
                playTurn(player1, player2);
                if (player2.ifSunks()) {
                    System.out.println(player1.getName() + " Wins!");
                    isGameOver = true;
                    break;
                }

                playTurn(player2, player1);
                if (player1.ifSunks()) {
                    System.out.println("AI Wins!");
                    isGameOver = true;
                }
            }
        }

        private void placeShips(Player player) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(player.getName() + ", place your ships on the board.");
            for (int i = 0; i < player.getShips().length; i++) {
                System.out.println("Enter the starting row, starting col and your ships size:");
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
                    System.out.println("Invalid position");
                    i--;
                }
            }
        }

        private void playTurn(Player currentPlayer, Player opponent) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(currentPlayer.getName() + "'s turn. Enter row and col to attack:");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (!currentPlayer.attack(opponent, row, col)) {
                System.out.println("This move is invalid.");
            }
        }
    }



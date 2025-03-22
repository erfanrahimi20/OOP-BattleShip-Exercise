import java.util.Scanner;
public class BatteleshipMain {




        public static  void main(String[] args){

                    Scanner scanner = new Scanner(System.in);

                    System.out.println("Welcome to BattleShip!");
                    System.out.println("Choose Game Mode: ");
                    System.out.println("1_ Player and AI");
                    System.out.println("2_ Player and Player");

                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    if (choice == 1) {
                        System.out.println("Enter your name:");
                        String playerName = scanner.nextLine();

                        int boardSize = 10;
                        int maxShips = 2;

                        Game game = new Game(playerName, "AI", boardSize, maxShips, false);
                        game.start();
                    } else if (choice == 2) {
                        System.out.println("Enter Player 1 name:");
                        String player1Name = scanner.nextLine();

                        System.out.println("Enter Player 2 name:");
                        String player2Name = scanner.nextLine();

                        int boardSize = 10;
                        int maxShips = 5;

                        Game game = new Game(player1Name, player2Name, boardSize, maxShips, true);
                        game.start();
                    } else {
                        System.out.println("Invalid choice.please try again");
                    }

                    scanner.close();
                }
            }














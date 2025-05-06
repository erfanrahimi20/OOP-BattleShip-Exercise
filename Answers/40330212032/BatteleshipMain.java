import java.util.Scanner;
public class BatteleshipMain {




        public static  void main(String[] args){

            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to BattleShip!");
            System.out.println("Choose Game Mode: ");
            System.out.println("1. Player vs AI");
            System.out.println("2. Player vs Player");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
switch (choice){
    case 1:
                System.out.print("Enter your name: ");
                String playerName = scanner.nextLine();

                Game game = new Game(playerName, "AI", 10, 5, false);
                game.start();
                break;
    case 2:
                System.out.print("Enter Player 1 name: ");
                String player1Name = scanner.nextLine();

                System.out.print("Enter Player 2 name: ");
                String player2Name = scanner.nextLine();

                Game game1 = new Game(player1Name, player2Name, 10, 5, true);
                game1.start();
                break;
    default:
                System.out.println("Invalid choice. Please try again.");
            }
            }
    }













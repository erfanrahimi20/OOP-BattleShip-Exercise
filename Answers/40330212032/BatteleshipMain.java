import java.util.Scanner;
public class BatteleshipMain {




        public static  void main(String[] args) {

            Display display = new Display();
            Match match = new Match();

            display.showTitle("BattleShip Game");

            Scanner scanner = new Scanner(System.in);
            boolean isExiting = false;

            while (!isExiting) {

                System.out.println("1_ Two-Player Mode");
                System.out.println("2_ Play Against AI");
                System.out.println("3_ Exit Game");
                System.out.print("What's your choice? ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        match.twoPlayerMode();
                        break;
                    case 2:
                        match.playAgainstAI();
                        break;
                    case 3:
                        display.showTitle("Exiting program, Sayonara!");
                        isExiting = true;
                        break;
                    default:
                        display.showTitle("Invalid input, try again");
                        break;
                }
            }
        }
    }

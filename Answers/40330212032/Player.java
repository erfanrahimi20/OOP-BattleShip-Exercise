
public class Player {
    private String name;
    private Board board;
    private Shiplacer[] ships;
    private int count;

    public Player(String name, Board boardSize, int maxShips) {
        this.name = name;
        this.board = new Board(boardSize.getSize());
        this.ships = new Shiplacer[maxShips];
        this.count=0;

    }
    public String getName(){
        return name;
    }
    public Board getBoard(){
        return board;
    }
    public void addShip(Shiplacer ship){
        if (count < ships.length) {
ships[count]= ship;
count++;
        }
        else{
            System.out.println("cannot add ship");
        }

    }

    public boolean ifSunks(){
        for (int i = 0; i <count ; i++) {
            if (!ships[i].sunk()) {
                return false;
            }

        }
            return true;

    }
    public boolean attack(Player opponent,int row , int col){
char[][] opponentGird=opponent.getBoard().getGrid();
if(opponentGird[row][col]=='S'){
    opponentGird[row][col]='X';
    System.out.println("HIT!");
    return true;
}else{
    opponentGird[row][col]='O';
    System.out.println("MISS!");
    return false;
}

    }

    public Shiplacer[] getShips() {
        return ships;
    }


}
import java.util.*;

//Start from part 3; making a jump method.
public class MazeRunner {
    static Maze myMap = new Maze();

    public static void main(String[] args){

        intro();
        int movement = userMove();
        System.out.println(movement);


    }

    public  static void intro(){
        System.out.println("Welcome to Maze Runner!\nHere is your current position:");
        myMap.printMap();

    }

    public static int userMove(){
        String direction = "";
        int moves = 0;
        System.out.println("Where would you like to move? (R, L, U, D)");
        while (myMap.didIWin() != true) {
            while (!direction.equals("R") && !direction.equals("L") && !direction.equals("U") && !direction.equals("D")) {

                Scanner input = new Scanner(System.in);
                direction = input.next();

                if (!direction.equals("R") && !direction.equals("L") && !direction.equals("U") && !direction.equals("D")) {
                    System.out.println("Please only enter one of these values: R, L, U, D");
                    direction = "";
                }

            }
            if (myMap.isThereAPit(direction))
            {
                Scanner input = new Scanner(System.in);
                System.out.println("Watch out! There's a pit ahead, jump it?");
                String ShouldiMove = input.next();

                    if (ShouldiMove.startsWith("y") || ShouldiMove.startsWith("Y")){
                        myMap.jumpOverPit(direction);
                    }
            }

            else {
                if (direction.equals("R") && myMap.canIMoveRight()) {
                    myMap.moveRight();
                } else if (direction.equals("L") && myMap.canIMoveLeft()) {
                    myMap.moveLeft();
                } else if (direction.equals("U") && myMap.canIMoveUp()) {
                    myMap.moveUp();
                } else if (direction.equals("D") && myMap.canIMoveDown()) {
                    myMap.moveDown();
                } else {
                    System.out.println("Sorry, you’ve hit a wall.");
                }
            }
            moves = moves + 1;
            myMap.printMap();
            direction = "";
            System.out.println("You've made " + moves + " move(s)");
            movesMessege(moves);
            System.out.println("Where would you like to move next: R  L  U  D");
        }
        System.out.println("Congratulations! You've made it out alive!\nAnd you did it in " + moves + " moves");
        return moves;
    }


    public static void movesMessege(int movess){

        if (movess > 0 && movess <100){
            if (movess == 50){
            System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
                 }
            if (movess == 75){
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
                }
             if (movess == 90){
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
                }
        }

        else {
            System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[ \nSorry, but you didn't escape in time- you lose!");
            System.exit(0);
        }

    }
}

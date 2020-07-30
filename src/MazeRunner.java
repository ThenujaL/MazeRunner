import java.util.*;

//Start from part 2; making a counter.
public class MazeRunner {
    static Maze myMap = new Maze();

    public static void main(String[] args){

        intro();
        String movement = userMove();
        System.out.println(movement);

    }

    public  static void intro(){
        System.out.println("Welcome to Maze Runner!\nHere is your current position:");
        myMap.printMap();

    }

    public static String userMove(){
        String direction = "";
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

            myMap.printMap();
            System.out.println("Where would you like to move next: R  L  U  D");
            direction = "";
        }
        System.out.println("Congratulations! You've made it out alive!");
            return direction;
    }
}

import java.util.*;

//Countinue for Part 1, number 6: moving the character.
public class MazeRunner {
    public Maze myMap = new Maze();
    public static void main(String[] args){

        intro();
        userMove();
    }

    public  static void intro(){
        Maze myMap = new Maze();

        System.out.println("Welcome to Maze Runner!\nHere is your current position:");
        myMap.printMap();

    }

    public static void userMove(){
        Scanner input = new Scanner(System.in);
        System.out.println("Where would you like to move? (R, L, U, D)");
        String direction = input.next();

            if (!direction.equals("R") && !direction.equals("L") && !direction.equals("U") && !direction.equals("D")){
                System.out.println("Please only enter one of these value: R, L, U, D");
                userMove();
            }
    }
}

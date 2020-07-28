public class MazeRunner {
    public Maze myMap = new Maze();
    public static void main(String[] args){

        intro();
    }

    public  static void intro(){
        Maze myMap = new Maze();

        System.out.println("Welcome to Maze Runner!\nHere is your current position:");
        myMap.printMap();
    }

}

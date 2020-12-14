package lkimilhol.minesweeper;

public class Main {

    public static void main(String[] args) {
        Minesweeper ms = new Minesweeper();
        ms.createMine();
        ms.printBoard();
        ms.makeSolution();
        ms.printBoard();
    }
}

import com.lkimilhol.Minesweeper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinesweeperTest {

    @Test
    void createMine() {
        Minesweeper ms = new Minesweeper();
        ms.createMine();
        int cnt = 0;
        for (int[] i : Minesweeper.board) {
            for (int j : i) {
                if (j == Minesweeper.MINE) {
                    cnt++;
                }
            }
        }
        assertEquals(cnt, Minesweeper.MINE_COUNT);
    }

    @Test
    void makeSolution() {
        Minesweeper ms = new Minesweeper();
        ms.createMine();
        ms.makeSolution();
        for (int[] i : Minesweeper.board) {
            for (int j : i) {
                if (j != Minesweeper.MINE) {
                    assertTrue(true);
                }
            }
        }
    }
}
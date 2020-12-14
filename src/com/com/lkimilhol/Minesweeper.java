package com.lkimilhol;

import java.util.Random;

public class Minesweeper {
    private final static int W = 10;
    private final static int H = 10;
    public final static int MINE_COUNT = 10;
    public final static int MINE = -1;
    public static int[][] board;

    public Minesweeper() {
        board = new int[W][H];
    }

    public void createMine() {
        makeRand();
    }

    public void printBoard() {
        for(int i[] : board) {
            for (int j : i) {
                if (j == MINE) {
                    System.out.print("*" + "\t");
                } else {
                    System.out.print(j + "\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private void makeRand() {
        int makeCnt = 0;
        Random random = new Random();
        while (makeCnt != MINE_COUNT) {
            random.setSeed(System.currentTimeMillis());
            int tmpW = random.nextInt(W);
            int tmpH = random.nextInt(H);

            if (board[tmpW][tmpH] != MINE) {
                board[tmpW][tmpH] = MINE;
                makeCnt++;
            }
        }
    }

    /*
    지뢰를 발견하면 8방향을 체크한다
     */
    public void makeSolution() {
        for (int i = 0; i < W ; i++) {
            for (int j = 0; j < H; j++) {
                findMine(i, j);
            }
        }
    }

    private void findMine(int x, int y) {
        if (board[x][y] != MINE) {
            return;
        }

        check(x-1, y);
        check(x-1, y-1);
        check(x, y-1);
        check(x+1, y-1);
        check(x+1, y);
        check(x+1, y+1);
        check(x, y+1);
        check(x-1, y+1);
    }

    private void check(int x, int y) {
        if (x < 0 || y < 0 || x >= W || y >= H) {
            return;
        }
        if (board[x][y] != MINE) {
            board[x][y] += 1;
        }
    }
}

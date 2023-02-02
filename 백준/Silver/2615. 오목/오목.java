import java.io.*;
import java.util.*;

public class Main {
    private static int wx = 0, wy = 0, winner = 0;
    private static int[][] board = new int[19][19];
    private static boolean[][][] isSearch = new boolean[19][19][4];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findWinner();

        sb.append(winner);
        if(winner != 0) sb.append('\n').append(wx + 1).append(' ').append(wy + 1);

        System.out.println(sb);
    }

    private static void findWinner() {
        loop:
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if(board[j][i] != 0){
                    int x = j;
                    int y = i;
                    if(!isSearch[x][y][0] && x + 4 < 19) column(x, y, 1);
                    if(winner != 0) {
                        wx = x; wy = y;
                        break loop;
                    }
                    if(!isSearch[x][y][1] && y + 4 < 19) row(x, y, 1);
                    if(winner != 0) {
                        wx = x; wy = y;
                        break loop;
                    }
                    if(!isSearch[x][y][2] && x + 4 < 19 && y + 4 < 19) diagonal1(x, y, 1);
                    if(winner != 0) {
                        wx = x; wy = y;
                        break loop;
                    }
                    if(!isSearch[x][y][3] && x - 4 >= 0 && y + 4 < 19) diagonal2(x, y, 1);
                    if(winner != 0) {
                        wx = x; wy = y;
                        break loop;
                    }
                }
            }
        }
    }

     private static void column(int x, int y, int d){
        isSearch[x][y][0] = true;
        if(d == 5) {
            if(x + 1 < 19 && board[x][y] == board[x + 1][y]) {
                isSearch[x + 1][y][0] = true;
                return;
            }
            winner = board[x][y];
        } else if(board[x][y] == board[x + 1][y]) column(x + 1, y, d + 1);
    }

    private static void row(int x, int y, int d){
        isSearch[x][y][1] = true;
        if(d == 5) {
            if(y + 1 < 19 && board[x][y] == board[x][y + 1]) {
                isSearch[x][y + 1][1] = true;
                return;
            }
            winner = board[x][y];
        } else if(board[x][y] == board[x][y + 1]) row(x, y + 1, d + 1);
    }

    private static void diagonal1(int x, int y, int d){
        isSearch[x][y][2] = true;
        if(d == 5) {
            if(x + 1 < 19 && y + 1 < 19 && board[x][y] == board[x + 1][y + 1]) {
                isSearch[x + 1][y + 1][2] = true;
                return;
            }
            winner = board[x][y];
        } else if(board[x][y] == board[x + 1][y + 1]) diagonal1(x + 1, y + 1, d + 1);
    }

    private static void diagonal2(int x, int y, int d){
        isSearch[x][y][3] = true;
        if(d == 5) {
            if(x - 1 >= 0 && y + 1 < 19 && board[x][y] == board[x - 1][y + 1]) {
                isSearch[x - 1][y + 1][3] = true;
                return;
            }
            winner = board[x][y];
        } else if(board[x][y] == board[x - 1][y + 1]) diagonal2(x - 1, y + 1, d + 1);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    private static ArrayList<int[]> cctv = new ArrayList<>();
    private static int N, M, min;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = N * M;
        int[][] office = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if(office[i][j] != 0 && office[i][j] != 6) cctv.add(new int[]{office[i][j], i, j});
            }
        }

        check(office, 0);
        System.out.println(min);
    }

    private static void check(int[][] arr, int index) {
        if(index == cctv.size()) count(arr);
        else{
            int cctvCase = cctv.get(index)[0];
            int x = cctv.get(index)[1];
            int y = cctv.get(index)[2];
            int office[][] = new int[N][M];
            copy(arr, office);
            switch (cctvCase) {
                case 1 :
                    check(search(office, x, y, 1), index + 1);
                    copy(arr, office);
                    check(search(office, x, y, 2), index + 1);
                    copy(arr, office);
                    check(search(office, x, y, 3), index + 1);
                    copy(arr, office);
                    check(search(office, x, y, 4), index + 1);
                    break;
                case 2 :
                    check(search(search(office, x, y, 1), x, y, 3), index + 1);
                    copy(arr, office);
                    check(search(search(office, x, y, 2), x, y, 4), index + 1);
                    break;
                case 3 :
                    check(search(search(office, x, y, 1), x, y, 4), index + 1);
                    copy(arr, office);
                    check(search(search(office, x, y, 1), x, y, 2), index + 1);
                    copy(arr, office);
                    check(search(search(office, x, y, 2), x, y, 3), index + 1);
                    copy(arr, office);
                    check(search(search(office, x, y, 3), x, y, 4), index + 1);
                    break;
                case 4 :
                    check(search(search(search(office, x, y, 1), x, y, 3), x, y, 4), index + 1);
                    copy(arr, office);
                    check(search(search(search(office, x, y, 1), x, y, 2), x, y, 4), index + 1);
                    copy(arr, office);
                    check(search(search(search(office, x, y, 1), x, y, 2), x, y, 3), index + 1);
                    copy(arr, office);
                    check(search(search(search(office, x, y, 2), x, y, 3), x, y, 4), index + 1);
                    break;
                case 5 :
                    check(search(search(search(search(office, x, y, 1), x, y, 2), x, y, 3), x, y, 4), index + 1);
                    break;
            }
        }
    }

    private static int[][] search(int[][] office, int x, int y, int direction) {
        switch (direction) {
            case 1 :
                for (int i = y; i < M; i++) {
                    if(office[x][i] == 6) break;
                    if(office[x][i] == 0) office[x][i] = -1;
                }
                break;
            case 2 :
                for (int i = x; i < N; i++) {
                    if(office[i][y] == 6) break;
                    if(office[i][y] == 0) office[i][y] = -1;
                }
                break;
            case 3 :
                for (int i = y; i >= 0; i--) {
                    if(office[x][i] == 6) break;
                    if(office[x][i] == 0) office[x][i] = -1;
                }
                break;
            case 4 :
                for (int i = x; i >= 0; i--) {
                    if(office[i][y] == 6) break;
                    if(office[i][y] == 0) office[i][y] = -1;
                }
                break;
        }
        return office;
    }

    private static void count(int[][] office){
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(office[i][j] == 0) count++;
            }
        }
        min = Math.min(count, min);
    }

    private static void copy(int[][] a, int[][] b) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) b[i][j] = a[i][j];
        }
    }
}
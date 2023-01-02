import java.util.*;
import java.io.*;

public class Main {
    private static int M, N;
    private static int empty;
    private static int count1;
    private static int count0;
    private static int time;
    private static Queue<int[]> point = new LinkedList<>();

    private static int[][] tomato;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer MN = new StringTokenizer(br.readLine());

        M = Integer.parseInt(MN.nextToken());
        N = Integer.parseInt(MN.nextToken());

        tomato = new int[N][M];
        empty = 0;
        count0 = 0;
        count1 = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == -1) empty++;
                if(input == 0) count0++;
                if (input == 1) {
                    point.offer(new int[] {i, j});
                    count1++;
                }
                tomato[i][j] = input;
            }
        }

        time = 0;

        if (empty + count1 != M * N) {
            dfs();
            if (count0 != 0) {
                time = -1;
            }
        }

        System.out.println(time);
    }

    public static void dfs() {
        while(count0 > 0 && !point.isEmpty()) {
            int count_new = count1;
            count1 = 0;
            while(count_new-- > 0) {
                int[] point_temp = point.poll();
                int x = point_temp[0];
                int y = point_temp[1];
                if (x - 1 >= 0 && tomato[x - 1][y] == 0) {
                    tomato[x - 1][y] = 1;
                    point.offer(new int[] {x - 1, y});
                    count1++;
                    count0--;
                }
                if (x + 1 <= N - 1 && tomato[x + 1][y] == 0) {
                    tomato[x + 1][y] = 1;
                    point.offer(new int[] {x + 1, y});
                    count1++;
                    count0--;
                }
                if (y - 1 >= 0 && tomato[x][y - 1] == 0) {
                    tomato[x][y - 1] = 1;
                    point.offer(new int[] {x, y - 1});
                    count1++;
                    count0--;
                }
                if (y + 1 <= M - 1 && tomato[x][y + 1] == 0) {
                    tomato[x][y + 1] = 1;
                    point.offer(new int[] {x, y + 1});
                    count1++;
                    count0--;
                }
            }
            time++;
        }
    }
}
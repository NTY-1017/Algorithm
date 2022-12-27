import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, flag_count;
    private static int[][] graph;
    private static boolean[] flag;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            graph[x][y] = graph[y][x] = 1;
        }

        flag = new boolean[N];
        flag_count = 0;
        dfs(0);

        System.out.println(flag_count - 1);    // 1번 컴퓨터 제외
    }

    private static void dfs(int start) {
        flag[start] = true;
        flag_count++;
        for(int i = 0; i < N; i++) {
            if (graph[start][i] == 1 && !flag[i]) dfs(i);
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, max;
    private static boolean[][] graph;
    private static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = max = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) q.offer(Integer.parseInt(st.nextToken()));

        graph = new boolean[M][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) graph[i][Integer.parseInt(st.nextToken())] = true;
        }

        bfs();

        System.out.println(max);
    }

    private static void bfs() {
        boolean[] check = new boolean[M];
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 0; i < M; i++) {
                if(!check[i] && graph[i][x]) {
                    graph[i][x] = false;
                    check[i] = true;
                    for (int j = 1; j <= N; j++) if(graph[i][j]) q.offer(j);
                    max--;
                }
            }
        }
    }
}
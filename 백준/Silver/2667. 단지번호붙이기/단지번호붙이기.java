import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] graph;
    private static ArrayList<Integer> counts = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        Collections.sort(counts);
        sb.append(counts.size()).append("\n");
        for (int i = 0; i < counts.size(); i++) {
            sb.append(counts.get(i)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        queue.offer(y);
        graph[x][y] = 0;
        int count = 1;
        while (!queue.isEmpty()) {
            int a = queue.poll();
            int b = queue.poll();
            if (a - 1 >= 0 && graph[a - 1][b] == 1) {
                queue.offer(a - 1);
                queue.offer(b);
                graph[a-1][b] = 0;
                count++;
            }
            if (a + 1 <= N -1 && graph[a + 1][b] == 1) {
                queue.offer(a + 1);
                queue.offer(b);
                graph[a + 1][b] = 0;
                count++;
            }
            if (b - 1 >= 0 && graph[a][b - 1] == 1) {
                queue.offer(a);
                queue.offer(b - 1);
                graph[a][b - 1] = 0;
                count++;
            }
            if (b + 1 <= N -1 && graph[a][b + 1] == 1) {
                queue.offer(a);
                queue.offer(b + 1);
                graph[a][b + 1] = 0;
                count++;
            }
        }
        counts.add(count);
    }
}
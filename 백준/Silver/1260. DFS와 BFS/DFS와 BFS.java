import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer NMV = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(NMV.nextToken());
        int M = Integer.parseInt(NMV.nextToken());
        int V = Integer.parseInt(NMV.nextToken());

        int[][] graph = new int[N][N];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            graph[x][y]++;
            graph[y][x]++;
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] flag = new boolean[N];
        stack.push(V-1);
        while(!stack.empty()) {
            int pop = stack.pop();
            if(!flag[pop]){
                flag[pop] = true;
                sb.append(pop + 1).append(" ");
            }
            for (int i = N - 1; i >= 0; i--) {
                if (graph[pop][i] != 0 && !flag[i]) {
                    stack.push(i);
                }
            }

        }

        sb.append("\n");

        Queue<Integer> queue = new LinkedList<>();
        flag = new boolean[N];
        queue.offer(V-1);
        while(!queue.isEmpty()) {
            int poll = queue.poll();
            if(!flag[poll]){
                flag[poll] = true;
                sb.append(poll + 1).append(" ");
            }
            for (int i = 0; i < N; i++) {
                if (graph[poll][i] != 0 && !flag[i]) {
                    queue.offer(i);
                }
            }
        }

        System.out.println(sb);
    }
}
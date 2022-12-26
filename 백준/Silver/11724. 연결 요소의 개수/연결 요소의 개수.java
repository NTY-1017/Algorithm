import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int M;
    private static int start;
    private static int count_flag;
    private static int count_connect;
    private static int[][] graph;
    private static boolean[] flag;
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer NM = new StringTokenizer(br.readLine());
        N = Integer.parseInt(NM.nextToken());
        M = Integer.parseInt(NM.nextToken());

        graph = new int[N][N];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            graph[x][y]++;
            graph[y][x]++;
        }

        flag = new boolean[N];
        count_connect = 0;

        for (int i = 0; i < N; i++){
            if(!flag[i]){
                dfs(i);
                count_connect++;
            }
        }

        System.out.println(count_connect);
    }

    private static void dfs(int start) {
        flag[start] = true;
        for (int i = 0; i < N; i++) {
            if(graph[start][i] == 1 && !flag[i]){
                dfs(i);
            }
        }
    }

}
import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] graph = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            Arrays.fill(graph[i], 2000 * (K-1));
            graph[i][i] = 0;
        }
        
        for(int i = 0; i < road.length; i++) {
            int a = road[i][0] - 1;
            int b = road[i][1] - 1;
            int d = road[i][2];
            if(graph[a][b] != 0) graph[a][b]= graph[b][a] = Math.min(graph[a][b], d);
            else graph[a][b] = graph[b][a] = d;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1] - p2[1]);
        boolean[] check = new boolean[N];
        for(int i = 0; i < N; i++) {
            if(graph[0][0] != 2000 * (K-1)) pq.add(new int[]{i, graph[0][i]});
        }
        check[0] = true;
        while(!pq.isEmpty()) {
            int[] head = pq.poll();
            check[head[0]] = true;
            for(int i = 0; i < N; i++){
                if(!check[i] && graph[0][i] > graph[0][head[0]] + graph[head[0]][i]) {
                    graph[0][i] = graph[0][head[0]] + graph[head[0]][i];
                    pq.add(new int[]{i, graph[0][i]});
                }
            }
        }
        
        for(int i = 0; i < N; i++) if(graph[0][i] <= K) answer++;
        
        return answer;
    }
}
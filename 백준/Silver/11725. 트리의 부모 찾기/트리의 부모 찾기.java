import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] parentNode;
    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();    // 인접리스트(인접행렬로 진행하면 런타임에러 발생)

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        parentNode = new int[N + 1];

        bfs(1);

        for (int j = 2; j <= N; j++) {
            sb.append(parentNode[j]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void bfs(int root) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offer(root);
        parentNode[root] = root;

        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty()) {
            int parent = queue.poll();
            for(int child : list.get(parent)) {
                if (parentNode[child] == 0) {
                    parentNode[child] = parent;
                    queue.offer(child);
                }
            }
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] arr;
    private static boolean[] flag;
    private static int count;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken()) - 1;
            }
            test();
            sb.append(count).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static void test() {
        flag = new boolean[arr.length];
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!flag[i]) {
                dfs(i);
                count++;
            }
        }
    }


    private static void dfs(int start) {
        flag[start] = true;
        if(start == arr[start]);
        else if(!flag[arr[start]]) dfs(arr[start]);
    }
}

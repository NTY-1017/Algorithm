import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] flag;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        flag = new boolean[N];

        recursion(0);

        System.out.println(sb);
    }

    private static void recursion(int R){
        if (R == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int j = 0; j < N; j++) {
            if (!flag[j]) {
                arr[R] = j + 1;
                flag[j] = true;
                recursion(R + 1);
                flag[j] = false;
            }
        }
    }
}
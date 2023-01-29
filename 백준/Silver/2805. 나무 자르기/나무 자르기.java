import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] tree = new int[N];
        for (int i = 0; i < N; i++) tree[i] = Integer.parseInt(st.nextToken());

        long low = 0;
        long high = 2000000000;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (check(tree, M, mid)) low = mid + 1;
            else high = mid - 1;
        }

        System.out.println(high);
    }

    private static boolean check(int[] tree, int M, long size) {
        long sum = 0;
        for (int n : tree) {
            if (n > size) sum += n - size;
        }
        return sum >= M;
    }
}
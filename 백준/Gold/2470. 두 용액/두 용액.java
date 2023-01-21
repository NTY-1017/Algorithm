import java.io.*;
import java.util.*;

public class Main {
    private static int N, x1, x2;
    private static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        f();

        sb.append(x1).append(" ").append(x2);
        System.out.println(sb);
        br.close();
    }

    private static void f() {
        int low = 0;
        int high = N - 1;
        int min = 2000000000;
        while (low < high) {
            if(arr[low] + arr[high] == 0) {
                x1 = arr[low];
                x2 = arr[high];
                break;
            }
            if(Math.abs(arr[low] + arr[high]) < min) {
                x1 = arr[low];
                x2 = arr[high];
                min = Math.abs(arr[low] + arr[high]);
            }
            if (arr[low] + arr[high] > 0) high -= 1;
            else low += 1;
        }
    }
}
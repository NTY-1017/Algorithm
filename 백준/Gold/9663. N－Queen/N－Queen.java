import java.io.*;

public class Main {
    private static int N, count = 0;
    private static int[] column;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        column = new int[N];
        check(0);
        System.out.println(count);
    }

    private static void check(int d) {
        if(d == N) count++;
        else {
            for (int i = 0; i < N; i++) {
                if(isOk(d, i)){
                    column[d] = i;
                    check(d + 1);
                }
            }
        }
    }

    private static boolean isOk(int r, int c) {
        for (int i = 0; i < r; i++) {
            if(column[i] == c) return false;
            if(Math.abs(i - r) == Math.abs(column[i] - c)) return false;
        }
        return true;
    }
}
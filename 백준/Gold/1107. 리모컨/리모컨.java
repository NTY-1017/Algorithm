import java.util.*;
import java.io.*;

public class Main {
    private static boolean[] remote = new boolean[10];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(remote, true);
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        if(M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) remote[Integer.parseInt(st.nextToken())] = false;
        }

        int min = Math.abs(N - 100);
        for (int i = 0; i < 999999; i++) {
            int ch = i;
            if(check(ch)) {
                min = Math.min(Math.abs(ch - N) + String.valueOf(ch).length(), min);
                if(ch == N) break;
            }

        }

        System.out.println(min);
    }

    private static boolean check(int ch) {
        boolean result = true;

        if(ch == 0) {
            if(!remote[ch]) result = false;
        } else {
            while (ch > 0) {
                if(!remote[ch % 10]) {
                    result = false;
                    break;
                } else ch /= 10;
            }
        }

        return result;
    }
}
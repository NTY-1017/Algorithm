import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int i = M; i <= N; i++) {
            if(i < 2) continue;
            if(i == 2 || i == 3) {
                sb.append(i).append("\n");
                continue;
            }
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) break;
                if (j == (int)Math.sqrt(i)) sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
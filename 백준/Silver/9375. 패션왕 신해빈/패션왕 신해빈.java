import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Map<String, Integer> hm = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String kind = st.nextToken();
                if (hm.containsKey(kind)) {
                    hm.put(kind, hm.get(kind) + 1);
                }
                else hm.put(kind, 1);
            }
            int count = 1;
            for (int n : hm.values()) count *= (n + 1);
            sb.append(count - 1).append('\n');
        }
        System.out.print(sb);
    }
}
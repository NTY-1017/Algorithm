import java.io.*;
import java.util.*;


public class Main {
    /*
    우선순위큐 2개 선언해서도 가능(두 큐 동기화 위해 체크 필요)
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            TreeMap<Integer, Integer> duePQ = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                if(s.equals("I")) duePQ.put(n, duePQ.getOrDefault(n, 0) + 1);
                else {
                    if(duePQ.isEmpty()) continue;
                    int key = n == 1 ? duePQ.lastKey() : duePQ.firstKey();
                    if(duePQ.get(key) == 1) duePQ.remove(key);
                    else duePQ.put(key, duePQ.get(key) - 1);
                }
            }
            if (duePQ.isEmpty()) sb.append("EMPTY").append('\n');
            else sb.append(duePQ.lastKey()).append(' ').append(duePQ.firstKey()).append('\n');
        }

        System.out.println(sb);
    }
}
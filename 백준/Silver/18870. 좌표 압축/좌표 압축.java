import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] X = new int[N];
        int[] X_1 = new int[N];
        HashMap<Integer, Integer> hm = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = st.nextToken();
            X[i] = Integer.parseInt(s);
            X_1[i] = Integer.parseInt(s);
        }

        Arrays.sort(X_1);

        int index = 0;

        for (int i = 0; i < N; i++) {
            if(!hm.containsKey(X_1[i])){
                hm.put(X_1[i], index);
                index++;
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(hm.get(X[i])).append(" ");
        }

        sb.delete(sb.lastIndexOf(" "), sb.lastIndexOf(" "));

        System.out.println(sb);
    }
}
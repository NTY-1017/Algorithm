import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<String> al = new ArrayList<>(N);
        HashMap<String, Integer> hm = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String name = br.readLine();
            al.add(i, name);
            hm.put(name, i);
        }

        for(int j = 0; j < M; j++) {
            String findName = br.readLine();
            try {
                bw.write(al.get(Integer.parseInt(findName) - 1) + "\n");
            } catch (NumberFormatException n) {
                bw.write(hm.get(findName) + 1 + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
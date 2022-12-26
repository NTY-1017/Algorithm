import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> ll = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            ll.add(i, i+1);
        }

        int t = 1;
        int index = 0;

        while(N > 1) {
            int out = (index + (t % N * t % N * t % N) % N  - 1 ) % N;
            if (out < 0) out += N;
            ll.remove(out);
            index = out;
            t++;
            N--;
        }
        System.out.println(ll.get(0));
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long compare = 0L;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        while(N-- > 0) pq.add(Long.parseLong(br.readLine()));
        while(pq.size() > 1) {
            long mix = pq.poll() + pq.poll();
            compare += mix;
            pq.add(mix);
        }
        System.out.println(compare);
    }
}
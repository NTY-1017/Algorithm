import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
       
        if(N == 1) queue.offer(1);
        else if (N % 2 == 0) {
            for (int i = 2; i <= N; i+=2) {
                queue.offer(i);
            }
        }
        else {
            for (int i = 4; i <= N; i+=2) {
                queue.offer(i);
            }
            queue.offer(2);
        }

        while (queue.size() != 1) {
            queue.poll();
            queue.offer(queue.poll());
        }

        bw.write(String.valueOf(queue.peek()));
        bw.flush();
        bw.close();
        br.close();
    }
}
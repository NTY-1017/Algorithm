import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            pq.offer(temp);
        }

        for(int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int temp = Integer.parseInt(st.nextToken());

                if(pq.peek() < temp) {  // 추가
                    pq.poll();
                    pq.offer(temp);
                }
            }
        }

        System.out.println(pq.poll());  // 우선순위큐에 맨 앞에 있는 수(큐에 있는 수 중 제일 작은 수), 즉 1~N 번째 수중 N 번째
        br.close();
    }
}
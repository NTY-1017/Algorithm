import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            List<int[]> applicant = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int paper = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                applicant.add(new int[]{paper, interview});
            }
            Collections.sort(applicant, (a1, a2) -> a1[0] - a2[0]);

            int min = applicant.get(0)[1];
            int fail = 0;
            for (int i = 1; i < N; i++) {
                int interview = applicant.get(i)[1];
                if(interview < min) min = interview;
                else fail++;
            }
            sb.append(N - fail).append('\n');
        }
        System.out.print(sb);
    }
}
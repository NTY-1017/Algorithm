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
                applicant.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }
            Collections.sort(applicant, (a1, a2) -> a1[0] - a2[0]);    // 서류기준 정렬
            int min = applicant.get(0)[1];
            int fail = 0;
            for (int i = 1; i < N; i++) {    // 인터뷰 최소 등수 갱신 or 탈락
                int interview = applicant.get(i)[1];
                if(interview < min) min = interview;
                else fail++;
            }
            sb.append(N - fail).append('\n');
        }
        System.out.print(sb);
    }
}
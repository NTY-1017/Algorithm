import java.io.*;
import java.util.*;

public class Main {
    private static boolean[] prime = new boolean[100001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        setPrime();    // 입력범위 내 존재하는 소수 세팅

        for (int i = 0; i < T; i++) {
            int input = Integer.parseInt(br.readLine());
            for (int j = input / 2; j >= 2; j--) {    // 중간부터 체크
                if(!prime[j] && !prime[input - j]) {
                    sb.append(j).append(" ").append(input - j).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
        br.close();
    }

    private static void setPrime() {
        prime[0] = prime[1] = true;
        for(int i = 2; i < Math.sqrt(prime.length); i++){
            if(prime[i]) continue;
            for(int j = i * i; j < prime.length; j += i){
                prime[j] = true;
            }
        }
    }
}
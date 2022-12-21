import java.io.*;

public class Main {
    private static int[] array;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        array = new int[8001];    // 입력값: -4000 ~ 4000

        for (int i = 0; i < N; i++) {
            int index = Integer.parseInt(br.readLine());
            array[index+4000]++;
        }

        arithmetic_mean();;
        median();
        mode();
        range();
    }

    private static void arithmetic_mean() {
        int sum = 0;

        for (int i = 0; i < 4000; i++) {
            if(array[i] > 0) {
                sum += (i-4000) * array[i];
            }
        }

        for (int i = 4000; i < 8001; i++) {
            if(array[i] > 0) {
                sum += (i-4000) * array[i];
            }
        }

        System.out.println((int)Math.round(sum/(double)N));
    }

    private static void median() {
        int count = 0;
        int median = 4001;
        for (int i = 0; i < 8001; i++) {
            if(array[i] > 0) {
                count += array[i];
                if(count >= N/2 + 1) {  // N은 홀수
                    median = i-4000;
                    break;
                }
            }
        }
        System.out.println(median);
    }

    private static void mode() {
        int mode = 0;
        int max = 0;
        boolean first = false;
        for (int i = 0; i < 8001; i++) {
            if(array[i] > max) {
                 max = array[i];
                 mode = i-4000;
                 first = true;
            }
            else if(array[i] == max && first == true){
                mode = i-4000;
                first = false;
            }
        }
        System.out.println(mode);
    }

    private static void range() {
        int max = Integer.MIN_VALUE;    // 최대값의 최소
        int min = Integer.MAX_VALUE;    // 최소값의 최대

        for (int i = 0; i < 8001; i++) {
            if(array[i] > 0){
                if(i-4000 < min) {
                    min = i-4000;
                }
                if(i-4000 > max) {
                    max = i-4000;
                }
            }
        }
        System.out.println(max-min);
    }
}

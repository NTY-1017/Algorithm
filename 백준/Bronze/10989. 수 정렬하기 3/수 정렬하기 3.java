import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[10001];

        int count = 0;

        for (int i = 0; i < N; i++) {
            int index = Integer.parseInt(br.readLine());
            array[index] += 1;
        }

        for (int j = 0; j < 10001; j++) {
            if(array[j] > 0) {
                while(array[j] > 0) {
                    sb.append(j).append("\n");
                    array[j]--;
                }
            }
        }

        System.out.println(sb);
    }
}
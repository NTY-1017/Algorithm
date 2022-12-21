import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[10001];

        for (int i = 0; i < N; i++) {
            int index = Integer.parseInt(br.readLine());
            array[index]++;
        }

        for (int j = 1; j < 10001; j++) {
            if(array[j] > 0) {
                while (array[j] > 0) {
                    sb.append(j).append("\n");
                    array[j]--;
                }
            }
        }
        
        br.close();
        System.out.println(sb);
    }
}
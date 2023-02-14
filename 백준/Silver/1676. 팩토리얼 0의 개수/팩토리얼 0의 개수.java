import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int two = 0;
        int five = 0;
        for (int i = 1; i <= N; i++) {
            if (i % 2 == 0) two += countX(i, 2);
            if (i % 5 == 0) five += countX(i, 5);
        }

        System.out.println(two >= five ? five : two);
    }

    private static int countX(int i, int x) {
        int count = 0;
        while (i % x == 0) {
            i /= x;
            count++;
        }
        return count;
    }
}
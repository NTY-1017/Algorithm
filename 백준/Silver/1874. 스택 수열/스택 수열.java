import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();
        int x = 1;
        int index = 0;
        while(index <= n - 1){
            if (!s.isEmpty() && s.peek() == arr[index]) {
                s.pop();
                sb.append('-').append('\n');
                index++;
            } else if (x <= n){
                s.push(x);
                sb.append("+").append('\n');
                x++;
            } else if(x > n) break;
        }

        System.out.println(s.isEmpty() ? sb : "NO");
    }
}
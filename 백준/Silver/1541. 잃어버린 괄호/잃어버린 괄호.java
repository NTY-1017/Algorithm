import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine() + "-";
        
        int plus = 0;
        int minus = 0;
        String temp = "";
        char symbol = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '+' || c == '-') {
                if(symbol == '+') {
                    plus += Integer.parseInt(temp);
                    if(c == '-') symbol = '-';
                } else minus += Integer.parseInt(temp);
                temp = "";
            } else temp += String.valueOf(s.charAt(i));
        }
        
        System.out.println(plus-minus);
    }
}
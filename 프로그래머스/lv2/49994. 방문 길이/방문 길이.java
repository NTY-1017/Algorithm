import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][] row = new boolean[11][10];
        boolean[][] column = new boolean[11][10];
        int x = 5; 
        int y = 5;
        for(int i = 0; i < dirs.length(); i++) {
            switch(dirs.charAt(i)) {
                case 'U': 
                    if(x - 1 >= 0) {
                        x -= 1; 
                        if(!column[y][x]) {
                            column[y][x] = true; 
                            answer++;
                        }
                    } break;
                case 'D': 
                    if(x + 1 <= 10) {
                        if(!column[y][x]) {
                            column[y][x] = true; 
                            answer++;
                        }
                        x += 1;
                    } break;
                case 'R': 
                    if(y + 1 <= 10) {
                        if(!row[x][y]) {
                            row[x][y] = true; 
                            answer++;
                        }
                        y += 1;
                    } break;
                case 'L':
                    if(y - 1 >= 0) {
                        y -= 1;
                        if(!row[x][y]) {
                            row[x][y] = true; 
                            answer++;
                        }
                    } break;
            }
        }
        return answer;
    }
}
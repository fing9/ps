import java.util.Scanner;
import java.util.*;
import java.math.*;

class Pair {
    int x, y;
    
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static int calc(Pair a, Pair b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    @Override
    public String toString() {
        return "[y : "+ + y + ", x = " + x + "]";
    }

}

public class Main {

    public static List<Pair> list = new ArrayList<>();
    public static Stack<Pair> st = new Stack<>();
    public static Pair start = new Pair(0, 0);
    public static Pair end = new Pair(0, 0);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] grid = new String[N];
        for (int i = 0; i < N; i++) {
            grid[i] = sc.next();
            for (int j = 0; j < N; j++) {
                if (grid[i].charAt(j) == 'S') {
                    start = new Pair(i, j);
                }
                if (grid[i].charAt(j) == 'E') {
                    end = new Pair(i, j);
                }
            }
        }

        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (grid[j].charAt(k) - '0' == i) {
                        list.add(new Pair(j, k));
                    }
                }
            }
        }

        // Please write your code here.
        
        int ret = solve(grid, N, 0, 3);
        System.out.print(ret == 2147483647 ? -1 : ret);
    }

    public static int solve(String[] map, int n, int s, int remainCoin) {
        if (remainCoin == 0) {
            return getDistance();
        }
        
        int minMove = 2147483647;
        for (int i=s;i<list.size();i++) {
            st.add(list.get(i));
            int ret = solve(map, n, i + 1, remainCoin - 1);
            if (ret < minMove) {
                minMove = ret;
            }
            st.pop();
        }
        return minMove;
    }

    public static int getDistance() {
        int dist = 0;
        Pair now = start;
        for (int i=0;i<st.size();i++) {
            Pair next = st.get(i);
            dist += Pair.calc(now, next);
            now = next;
        }
        dist += Pair.calc(now, end);

        return dist;
    }

}
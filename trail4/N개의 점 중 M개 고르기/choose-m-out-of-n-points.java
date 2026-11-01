import java.util.Scanner;
import java.util.*;
import java.math.*;

public class Main {

    public static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public static double calcDist(Pair a, Pair b) {
            return Math.sqrt( Math.pow(a.first - b.first, 2) + Math.pow(a.second - b.second, 2));
        }

        @Override
        public String toString() {
            return "[x : " + first + ", y : " + second + "]";
        }
    }

    public static Stack<Pair> st = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        // Please write your code here.
        System.out.printf("%.0f", Math.pow(solve(points, n, m, 0), 2));
    }

    public static double solve(int[][] points, int n, int m, int s) {
        if (m == 0) {
            return calc();
        }

        double min = 2147483647;
        for (int i=s;i<n;i++) {
            st.add(new Pair(points[i][0], points[i][1]));
            double ret = solve(points, n, m-1, i+1);
            st.pop();

            if (min > ret) {
                min = ret;
            }
        }

        return min;
    }

    public static double calc() {
        double max = 0;
        for (int i=0;i<st.size();i++) {
            Pair now = st.get(i);
            for (int j=i+1;j<st.size();j++) {
                Pair next = st.get(j);
                double ret = Pair.calcDist(now, next);

                if (max < ret) {
                    max = ret;
                }
            }
        }
        return max;
    }

}
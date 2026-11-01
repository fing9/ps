import java.util.Scanner;
import java.util.*;
import java.math.*;

public class Main {

    public static Stack<Integer> group = new Stack<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        System.out.println(solve(arr, n, 0, 0));
    }

    public static int solve(int[] arr, int n, int s, int cnt) {
        if (cnt == n) {
            return calc(n, arr);
        }

        int min = 2147483647;
        for (int i=s;i<n*2;i++) {
            group.add(arr[i]);
            int ret = solve(arr, n, i + 1, cnt + 1);
            group.pop();

            if (ret < min) {
                min = ret;
            }
        }

        return min;
    }

    public static int calc(int n, int[] arr) {
        int sumA = 0, sumOfArr = 0;

        for (int i=0;i<group.size();i++) {
            sumA += group.get(i);
        }
        for (int i=0;i<arr.length;i++) {
            sumOfArr += arr[i];
        }

        return Math.abs(sumOfArr - sumA - sumA);
    }

}
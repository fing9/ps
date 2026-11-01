import java.util.Scanner;
import java.util.*;

public class Main {

    public static Stack<Integer> st = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        
        System.out.print(solve(0, n, m, A));
    }

    public static Integer solve(int s, int n, int m, int[] A) {
        if (m == 0) {
            return xor(st);
        }

        Integer max = 0;
        for (int i=s;i<n;i++) {
            st.add(A[i]);
            Integer ret = solve(i + 1, n, m - 1, A);
            if (ret > max) {
                max = ret;
            }
            st.pop();
        }

        return max;
    }

    public static Integer xor(Stack<Integer> stack) {
        Integer cur = stack.get(0);
        for (int i=1;i<stack.size();i++) {
            cur = cur ^ stack.get(i);
        }
        return cur;
    }

}
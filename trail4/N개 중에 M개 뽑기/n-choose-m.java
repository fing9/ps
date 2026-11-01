import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Main {

    public static Stack<Integer> st = new Stack<Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        combination(1, n, m);
    }

    private static void combination(int s, int n, int m) {
        if (m == 0) {
            for (int i=0;i<st.size();i++) {
                System.out.print(st.get(i));
                if (i == st.size() - 1) {
                    System.out.print("\n");
                } else {
                    System.out.print(" ");
                }
            }
            return;
        }

        for (int i=s;i<=n;i++) {
            st.push(i);
            combination(i + 1, n, m - 1);
            st.pop();
        }
    }

}
// https://www.hackerrank.com/challenges/java-dequeue/problem
import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int max = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            set.add(num);
            if (i >= m - 1) {
                if (set.size() > max) {
                    max = set.size();
                }
                int removed = deque.remove();
                if (!deque.contains(removed)) {
                    set.remove(removed);
                }
            }
        }
        in.close();

        System.out.println(max);
    }
}

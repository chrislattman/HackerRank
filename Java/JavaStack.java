// https://www.hackerrank.com/challenges/java-stack/problem
import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            //Complete the code
            Stack<Character> stack = new Stack<>();
            boolean returned = false;
            int length = input.length();
            for (int i = 0; i < length; i++) {
                char bracket = input.charAt(i);
                if (bracket == '(' || bracket == '{' || bracket == '[') {
                    stack.push(bracket);
                }
                else {
                    if (stack.isEmpty()) {
                        System.out.println("false");
                        returned = true;
                        break;
                    }

                    char top = stack.peek();
                    if (bracket == ')' && top == '(') {
                        stack.pop();
                    }
                    else if (bracket == '}' && top == '{') {
                        stack.pop();
                    }
                    else if (bracket == ']' && top == '[') {
                        stack.pop();
                    }
                    else {
                        System.out.println("false");
                        returned = true;
                        break;
                    }
                }
            }

            if (stack.isEmpty() && !returned) {
                System.out.println("true");
            }
            else if (!returned) {
                System.out.println("false");
            }
        }
        sc.close();
    }
}

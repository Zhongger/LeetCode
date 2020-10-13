package Day14.使括号有效的最少添加;

import java.util.Stack;

public class MinAddToMakeValidSolution {
    public static void main(String[] args) {
        MinAddToMakeValidSolution solution = new MinAddToMakeValidSolution();
        System.out.println(solution.minAddToMakeValid("()"));
    }
    public int minAddToMakeValid(String S) {
        char[] chars = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            switch (c){
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if (!stack.isEmpty()&&stack.peek().equals('(')){
                        stack.pop();
                    }else {
                        stack.push(c);
                    }
                    break;
            }
         //   stack.push(chars[i]);
        }
        return stack.size();
    }
}

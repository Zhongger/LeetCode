package Day15.删除最外层的括号;

import java.util.Stack;

public class RemoveOuterParentheseSolution {
    public static void main(String[] args) {
        RemoveOuterParentheseSolution solution = new RemoveOuterParentheseSolution();
        System.out.println(solution.removeOuterParentheses("(()())(())"));
    }
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        char[] chars = S.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='('){
                if (!stack.isEmpty()){
                    stringBuffer.append(chars[i]);
                }
                stack.push(chars[i]);
            }
            if (chars[i]==')'){
                stack.pop();
                if (!stack.isEmpty()){
                    stringBuffer.append(chars[i]);
                }
            }
        }
        return stringBuffer.toString();
    }
}

package Day15.反转每对括号间的子串;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 给出一个字符串 s（仅含有小写英文字母和括号）
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 */
public class ReverseParentheseSolution {
    public static void main(String[] args) {
        ReverseParentheseSolution solution = new ReverseParentheseSolution();
        System.out.println(solution.reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }
    public String reverseParentheses(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuffer stringBuffer = new StringBuffer();
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]){
                case ')':
                    while (!stack.isEmpty()&&stack.peek()!='('){
                        deque.add(stack.pop());
                    }
                    stack.pop();
                    while (!deque.isEmpty()){
                        stack.push(deque.remove());
                    }
                    break;
                default:
                    stack.push(chars[i]);
                    break;
            }
        }
        for (Character c : stack) {
            stringBuffer.append(c);
        }
        return stringBuffer.toString();

    }
}

package Day16.不同字符的最小子序列;

import java.util.Stack;

/**
 * 返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。
 */
public class SmallestSubsequenceSolution {
    public static void main(String[] args) {
        SmallestSubsequenceSolution solution = new SmallestSubsequenceSolution();
        System.out.println(solution.smallestSubsequence("leetcode"));
    }

    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();//字符串栈
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (stack.contains(chars[i])) {
                continue;
            }
            while (!stack.isEmpty() && chars[i] < stack.peek() && s.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(chars[i]);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Character c : stack) {
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }
}

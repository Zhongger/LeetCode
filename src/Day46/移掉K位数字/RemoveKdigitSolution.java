package Day46.移掉K位数字;

import java.util.Stack;

public class RemoveKdigitSolution {
    public static void main(String[] args) {
        RemoveKdigitSolution solution = new RemoveKdigitSolution();
        String num = "10200";
        int k = 1;
        System.out.println(solution.removeKdigits(num, k));
    }
    public String removeKdigits(String num, int k) {
        StringBuffer stringBuffer = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        char[] chars = num.toCharArray();
        int count = 0;//删了的字符个数
        for (int i = 0; i < chars.length; i++) {
            while (!stack.isEmpty() && chars[i] < stack.peek() && count < k) {
                stack.pop();
                count++;
            }
            stack.push(chars[i]);
        }

        while (count < k) {
            stack.pop();
            count++;
        }

        //删除字符串前面的0
        boolean leadingZero = true;
        for (char digit : stack) {
            if (leadingZero && digit == '0') continue;
            leadingZero = false;
            stringBuffer.append(digit);
        }

        if (stringBuffer.toString().equals("")) {
            return "0";
        }
        return stringBuffer.toString();
    }
}

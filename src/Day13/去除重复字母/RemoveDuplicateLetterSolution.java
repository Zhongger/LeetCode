package Day13.去除重复字母;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 */
public class RemoveDuplicateLetterSolution {
    public static void main(String[] args) {

    }

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Integer> map = new HashMap<>();//用于存放当前字符以及字符的位置
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                while (!stack.isEmpty() && c < stack.peek() && map.get(stack.peek()) > i) {
                    Character pop = stack.pop();
                    set.remove(pop);
                }
            }
            set.add(c);
            stack.add(c);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Character c : stack) {
            stringBuffer.append(c);
        }
        return stringBuffer.toString();

    }
}

package 无重复字符的最长子串;

import java.util.HashSet;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入 abcabcabc 返回 3
 */
public class LengthOfLongestSubstringSolution {
    public static void main(String[] args) {
        LengthOfLongestSubstringSolution solution = new LengthOfLongestSubstringSolution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcabc"));
        System.out.println(solution.lengthOfLongestSubstring("aaaaaaa"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("qrsvbspk"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] array = s.toCharArray();
        int result = 0;
        HashSet<Character> set = new HashSet<>();//集合，判断每个字符是否出现过
        int right = -1;//右指针，滑动窗口边界
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                set.remove(array[i - 1]);//左指针向右移动一格，滑动窗口移除一个值
            }
            while (right + 1 < array.length && !set.contains(array[right + 1])) {
                set.add(array[right + 1]);
                right++;
            }
            result = Math.max(result, right + 1 - i);

        }
        return result;
    }
}

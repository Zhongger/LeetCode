package 反转字符串;

import java.util.Arrays;

/**
 * @author zhongmingyi
 * @date 2021/9/5 3:55 下午
 */
public class ReverseStringSolution {
    public static void main(String[] args) {
        ReverseStringSolution solution = new ReverseStringSolution();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(s);
        System.out.println(Arrays.toString(s));

        char[] s2 = {'H','a','n','n','a','h'};
        solution.reverseString(s2);
        System.out.println(Arrays.toString(s2));
    }

    public void reverseString(char[] s) {
        int n = s.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            exchange(s, left, right);
            left++;
            right--;
        }

    }

    public void exchange(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}

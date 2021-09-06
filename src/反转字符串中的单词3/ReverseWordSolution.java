package 反转字符串中的单词3;

/**
 * @author zhongmingyi
 * @date 2021/9/5 4:08 下午
 */
public class ReverseWordSolution {
    public static void main(String[] args) {
        ReverseWordSolution solution = new ReverseWordSolution();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));

    }

    public String reverseWords(String s) {
        StringBuffer ret = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                ret.append(s.charAt(start + i - 1 - p));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }
}

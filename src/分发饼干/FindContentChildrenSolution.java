package 分发饼干;

import java.util.Arrays;

public class FindContentChildrenSolution {
    public static void main(String[] args) {
        FindContentChildrenSolution solution = new FindContentChildrenSolution();
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(solution.findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {
        //从小到大排列
        Arrays.sort(g);
        Arrays.sort(s);
        int numOfChildren = g.length, numOfCookies = s.length;
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < numOfChildren && j < numOfCookies) {
            if (g[i] <= s[j]) {
                count++;
                i++;
            }
            j++;
        }
        return count;
    }
}

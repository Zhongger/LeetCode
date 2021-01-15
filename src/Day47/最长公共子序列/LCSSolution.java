package Day47.最长公共子序列;

public class LCSSolution {
    public int LCS(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j]=0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (chars1[i-1]==chars2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;

                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}

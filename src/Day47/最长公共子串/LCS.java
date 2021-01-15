package Day47.最长公共子串;

public class LCS {
    public static void main(String[] args) {
        LCS lcs = new LCS();
        String s1="1AB2345CD",s2="12345EF";
        System.out.println(lcs.getLcs(s1, s2));
    }
    public String getLcs(String str1,String str2){
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        //处理空串
        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i]=0;
        }

        int max = 0;
        int end = 0;

        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if (str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=0;
                }
                if (dp[i][j]>max){
                    max=dp[i][j];
                    end=i;
                }
            }
        }

        if (max==0){
            return "-1";
        }
        return str1.substring(end-max,end);
    }
}

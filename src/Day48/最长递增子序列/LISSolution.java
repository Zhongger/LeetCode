package Day48.最长递增子序列;

import java.util.ArrayList;
import java.util.Arrays;

public class LISSolution {
    public static void main(String[] args) {
        LISSolution solution = new LISSolution();
        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        System.out.println(Arrays.toString(solution.LIS2(arr)));
    }

    //不能找到字典序最小的
    public int[] LIS(int[] arr) {
        // write code here
        int[] dp = new int[arr.length];//dp[i]表示以arr[i]结尾时，子序列的最大长度
        ArrayList<Integer> list = new ArrayList<>();
        dp[0] = 1;
        int maxLen = 1;
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (maxLen < dp[i]) {
                maxLen = dp[i];
                list.add(arr[i]);
            }

        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    //可以找到字典序最小的序列
    public static int[] LIS2(int[] arr) {

        int[] dp = new int[arr.length];
        int[] end = new int[arr.length];

        if (arr.length == 0) {
            return null;
        }
        //索引0的长度为1
        dp[0] = 1;
        end[0] = arr[0];
        int length = 1;

        for (int i = 1; i < arr.length; i++) {
            //放在end后面
            if (arr[i] > end[length - 1]) {
                end[length] = arr[i];
                length++;
                dp[i] = length;
            } else if (arr[i] == end[length - 1]) {
                //长度是相等的，复制长度
                dp[i] = length;
            } else if (arr[i] < end[length - 1]) {
                //二分查找 ， 求出当前i的最长递增子序列，不是所有的最长子序列
                // 查找第一个大于该数的位置
                int l = 0;
                int r = length - 1;
                while (l <= r) {
                    int m = (l + r) / 2;
                    if (end[m] < arr[i]) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
                //以索引i结尾的长度为 l + 1
                dp[i] = l + 1;
                //end存储的是递增序列,替换第一个大于arr[i]的数
                end[l] = arr[i];
            }

        }

        //数组初始化
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = Integer.MAX_VALUE;
        }

        //反向推出数据，因为最大的数肯定在最后面，
        for (int i = dp.length - 1; i >= 0; i--) {
            if (dp[i] == length) {
                length--;
                res[length] = Math.min(res[length], arr[i]);
            }
        }

        return res;
    }
}

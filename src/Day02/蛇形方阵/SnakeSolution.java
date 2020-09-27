package Day02.蛇形方阵;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 2021网易互娱校招笔试第一题
 */
public class SnakeSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int C = scanner.nextInt(); //数据组数
        for (int i = 0; i < C; i++) {
            String s1 = scanner.next();
            String s2 = scanner.next();
            int N = Integer.parseInt(s1);//方阵维度
            int M = Integer.parseInt(s2);//查询维度
            int[][] snakeArray = getSnakeArray(N);
            List<Integer> result = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                String xStr = scanner.next();
                String yStr = scanner.next();
                int x = Integer.parseInt(xStr);
                int y = Integer.parseInt(yStr);
                result.add(snakeArray[x][y]);
            }
            for (Integer res : result) {
                System.out.println(res);
            }
        }
    }

    public static int[][] getSnakeArray(int n) {
        if (n <= 0) {
            return null;
        }
        boolean down = false;
        boolean left = false;
        boolean top = false;
        boolean right = true;
        int sum = n * n;
        int i = 0;
        int j = 0;
        int[][] arr = new int[n][n];
        arr[0][0] = 1;
        for (int k = 2; k <= sum; k++) {
            if (right && j + 1 < n && arr[i][j + 1] == 0) {
                j++;
                arr[i][j] = k;
            } else if (right) {
                down = true;
                left = false;
                top = false;
                right = false;
                k--;
                continue;
            }

            if (down && i + 1 < n && arr[i + 1][j] == 0) {
                i++;
                arr[i][j] = k;
            } else if (down) {
                left = true;
                down = false;
                top = false;
                right = false;
                k--;
                continue;
            }

            if (left && j - 1 >= 0 && arr[i][j - 1] == 0) {
                j--;
                arr[i][j] = k;
            } else if (left) {
                top = true;
                down = false;
                right = false;
                left = false;
                k--;
                continue;
            }

            if (top && i - 1 >= 0 && arr[i - 1][j] == 0) {
                i--;
                arr[i][j] = k;
            } else if (top) {
                right = true;
                down = false;
                left = false;
                top = false;
                k--;
                continue;
            }
        }
        return arr;
    }
}

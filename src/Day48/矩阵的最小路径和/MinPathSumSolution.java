package Day48.矩阵的最小路径和;

public class MinPathSumSolution {
    public int minPathSum(int[][] matrix) {
        // write code here
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) matrix[i][j] += matrix[i][j - 1];
                else if (j == 0) matrix[i][j] += matrix[i - 1][j];
                else matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i][j - 1]);
            }
        }

        return matrix[n - 1][m - 1];

    }
}

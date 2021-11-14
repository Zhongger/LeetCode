package 二维数组中的查找;

/**
 * @author zhongmingyi
 * @date 2021/11/14 12:05 下午
 */
public class FindNumberIn2DArraySolution {
    public static void main(String[] args) {
        FindNumberIn2DArraySolution solution = new FindNumberIn2DArraySolution();
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(solution.findNumberIn2DArray(matrix, 20));

        int[][] matrix2 = {{-5}};
        System.out.println(solution.findNumberIn2DArray(matrix2, -10));

    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        int i = 0;
        int j = columns - 1;

        while (i < rows && j >= 0) {
            int num = matrix[i][j];
            if (num == target) {
                return true;
            } else if (num < target) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}

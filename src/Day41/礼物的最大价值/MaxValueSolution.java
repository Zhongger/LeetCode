package Day41.礼物的最大价值;

import java.util.ArrayList;
import java.util.List;

public class MaxValueSolution {

    private List<Integer> resList = new ArrayList<>();

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MaxValueSolution solution = new MaxValueSolution();
        System.out.println(solution.maxValue(grid));
    }

    public int maxValue(int[][] grid) {
        helper(grid, grid.length, grid[0].length);
        return grid[grid.length-1][grid[0].length-1];
    }

    public void helper(int[][] grid, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               if (i==0&&j==0) continue;
               if (i==0) grid[i][j]+=grid[i][j-1];
               else if (j==0) grid[i][j]+=grid[i-1][j];
               else grid[i][j]+=Math.max(grid[i][j-1],grid[i-1][j]);
            }
        }
    }
}

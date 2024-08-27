package solutions.pack7;

public class GridPaths_660988 {
    public static int numberOfPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //DP table regarding number of possible path to each block
        int[][] dp = new int[m][n];

        //DP base case
        dp[0][0] = (grid[0][0] == 0) ? 1 : 0;

        // Fill the DP table
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0; // obstacle so the avaliable path will be 0
                } else {
                    if (i > 0) {
                        dp[i][j] += dp[i - 1][j]; // From above
                    }
                    if (j > 0) {
                        dp[i][j] += dp[i][j - 1]; // From left
                    }
                }
            }
        }

        //Bottom right
        return dp[m - 1][n - 1];
    }

    public static void testGridPaths() {
        int[][] grid = {
            {0, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 0, 1},
            {1, 0, 0, 0}
        };
        System.out.println("Number of paths: " + numberOfPaths(grid));
    }

    public static void main(String[] args) {
        testGridPaths();
    }
}


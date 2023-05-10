class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int count = 1;
        for (int i = 0; i < (n + 1) / 2; i++) {
            // direction 1 - traverse from left to right
            for (int j = i; j < n - i; j++) {
                ans[i][j] = count++;
            }
            // direction 2 - traverse from top to bottom
            for (int j = i + 1; j < n - i; j++) {
                ans[j][n - i - 1] = count++;
            }
            // direction 3 - traverse from right to left
            for (int j = i + 1;j < n - i; j++) {
                ans[n - i - 1][n - j - 1] = count++;
            }
            // direction 4 - traverse from bottom to top
            for (int j = i + 1; j < n - i - 1; j++) {
                ans[n - j - 1][i] = count++;
            }
        }
        return ans;
    }
}
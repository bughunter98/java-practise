package org.example.Programs.Patterns;

public class NumberPatterns {
    public static void main(String[] args) {
        int n = 4; // Number of rows and columns
        int[][] pattern = new int[n][n];

        int num = 1;

        // chat gpt code
        /*for (int col = 0; col < n; col++) {
            int row = 0, currentCol = col;
            while (currentCol >= 0 && row < n) {
                pattern[row][currentCol] = num;
                num++;
                row++;
                currentCol--;
            }
        }

        for (int row = 1; row < n; row++) {
            int col = n - 1, currentRow = row;
            while (currentRow < n) {
                pattern[currentRow][col] = num;
                num++;
                currentRow++;
                col--;
            }
        }
*/ 

        // filling the uppper diagonal
        for (int i=0;i<n;i++){
            int rowCount = 0;
            int colCount = i;
            while (colCount >=0 && rowCount<n){
                pattern[rowCount][colCount]=num;
                num++;
                rowCount++;
                colCount--;
            }
        }

        int x=1;
        // filling the lower diagonal
        for (int i=n-1; i>=1;i--){
            int rowCount = x;
            int colCount = n-1;
            while (colCount>=1 && rowCount<n){
                pattern[rowCount][colCount]=num;
                num++;
                rowCount++;
                colCount--;
            }
            x++;
        }
        // Print the pattern
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(pattern[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
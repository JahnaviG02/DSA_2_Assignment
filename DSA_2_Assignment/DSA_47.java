class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
    
    private boolean solve(char[][] board, int row, int col) {
        if (row == 9) {
           
            return true;
        }
        
        if (col == 9) {
          
            return solve(board, row + 1, 0);
        }
        
        if (board[row][col] != '.') {
            
            return solve(board, row, col + 1);
        }
        
       
        for (char digit = '1'; digit <= '9'; digit++) {
            if (isValid(board, row, col, digit)) {
                board[row][col] = digit;
                if (solve(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        
       
        return false;
    }
    
    private boolean isValid(char[][] board, int row, int col, char digit) {
    
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit || board[i][col] == digit) {
                return false;
            }
        }
        
        int subBoxRow = (row / 3) * 3;
        int subBoxCol = (col / 3) * 3;
        for (int i = subBoxRow; i < subBoxRow + 3; i++) {
            for (int j = subBoxCol; j < subBoxCol + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }
      
        return true;
    }
}

/*
for each empty cell 
check if number is safe to be pushed on to blank space
push 1 ,if safe, backtrack for the rest of blank spaces
=> false?
push 2 backtrack for the rest of blank spaces
=> false? ------> push 9
when we dont find any empty space => puzzle is solved

*/
class Solution {
    public void solveSudoku(char[][] board) {
       if(dfs(board,0));
    }
    boolean dfs(char[][] board,int last_col){
       int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board[i][j] == '.')
                {
                    row = i;
                    col = j;
 
                    // We still have some remaining
                    // missing values in Sudoku
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }
 
        // No empty space left
        if (isEmpty)
        {
            return true;
        }
        for(char num='1';num<='9';num++){
            if(isSafe(num,row,col,board)){
                board[row][col]=num;
            if(dfs(board,col)) return true;
            else{
                board[row][col]='.';
            }
        }     
    }
        return false;
    }
    boolean noEmptySpace(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') return false;
            }
        }
        return true;
    }
    boolean isSafe(char cur,int row,int col,char[][] board){
        for(int i=0;i<9;i++){
            if(board[row][i]==cur) return false;
        }
        for(int i=0;i<9;i++){
            if(board[i][col]==cur) return false;
        }
        //search in box
        int rr=row-row%3;
        int cc=col-col%3;
        for(int i=rr;i<rr+3;i++){
            for(int j=cc;j<cc+3;j++){
                if(board[i][j]==cur) return false;
            }
        }
        return true;
    }
    boolean inRange(int i,int j){
        return (i>=0&& j>=0 && i<9 && j<9);
    }
}

import java.util.*;
class Sudoku
{
    public static boolean isSafe(char board[][] , int row , int col , int num)
    {
        //row & col
        for(int i = 0 ; i < board.length;i++)
        {
            if(board[row][i] == (char)(num + '0'))
                return false;
        }
        for(int j=0; j<board.length; j++) {
            if(board[j][col] == (char)(num + '0'))
                return false;
        }
        //grid
        int sr = (row/3)*3;
        int sc = (col/3)*3; 
        for(int i = sr; i < sr+3;i++)
        {    
            for(int j = sc; j < sc+3;j++)
            {
                if(board[i][j] == (char)(num + '0'))
                    return false;
            }
        }
        return true;
    }
    public static boolean helper(char board[][],int row,int col)
    {
        int nrow = 0;
        int ncol = 0;
        if(row == board.length)
            return true;
        if(col != board.length - 1)
        {
            nrow = row;
            ncol = col+1;
        }
        else
        {
            nrow = row+1;
            ncol = 0;
        }
        if(board[row][col]!= '.')
        {
            if(helper(board,nrow,ncol))
            {
                return true;
            }
        }
        else{
            for(int i = 1; i <= 9;i++)
            {
                if(isSafe(board,row,col,i))
                {
                    board[row][col] = (char)(i+'0');
                    if(helper(board,nrow,ncol))
                        return true;
                    else
                        board[row][col] = '.';
                }
            }
        }
        return false;
    }
    public static void main(String args[])
    {
        char board[][] = new char[9][9];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 9;i++)
        {   
            for(int j = 0; j < 9;j++)
            {
                board[i][j] = sc.next().charAt(0); 
            } 
        }
        helper(board,0,0);
        for(int i = 0; i < 9;i++)
        {   
            for(int j = 0; j < 9;j++)
            { 
                System.out.print(board[i][j]+ " ");   
            }
            System.out.println(" "); 
        }
    }
}
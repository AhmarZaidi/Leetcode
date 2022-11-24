class Solution 
{
    private static boolean exist(char[][] board, int x, int y, String word, int i)
    {
        if(i == word.length()) 
            return true;
        if(x > board.length-1 || x <0 || y<0 || y >board[0].length-1 || board[x][y]!=word.charAt(i))
            return false;

        board[x][y]='*';
        boolean result =   exist(board, x-1, y, word, i+1) ||
                           exist(board, x, y-1, word, i+1) ||
                           exist(board, x, y+1, word, i+1) ||
                           exist(board, x+1, y, word, i+1);
        board[x][y] = word.charAt(i);
        return result;
    }
    
    public boolean exist(char[][] board, String word) 
    {
        for(int x = 0; x < board.length; x++)
        {
            for(int y = 0; y < board[0].length; y++)
            {
                if(exist(board, x, y, word, 0))
                    return true;
            }
        }
        return false;
    }
}
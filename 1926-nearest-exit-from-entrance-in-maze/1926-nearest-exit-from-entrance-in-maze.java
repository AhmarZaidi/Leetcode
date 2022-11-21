class Solution 
{
    public int nearestExit(char[][] maze, int[] entrance) 
    {
        int rows = maze.length, cols = maze[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // right left up down

        // Mark the entrance as visited since its not a exit.
        int startRow = entrance[0];
        int startCol = entrance[1];
        maze[startRow][startCol] = '+';

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol, 0});

        while(!queue.isEmpty())
        {
            int[] currState = queue.poll();
            int currRow = currState[0];
            int currCol = currState[1];
            int currDistance = currState[2];
            for (int[] dir : dirs) // runs 4 times for 4 directions
            {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];

                if (0 <= nextRow && nextRow < rows && 0 <= nextCol && nextCol < cols && maze[nextRow][nextCol] == '.') // if neighbour is unvisited & empty
                {    
                    // If this empty cell is an exit, return distance + 1.
                    if (nextRow == 0 || nextRow == rows - 1 || nextCol == 0 || nextCol == cols - 1) // nearest exit found
                        return currDistance + 1;
                    
                    // Otherwise, add this cell to 'queue' and mark it as visited.
                    maze[nextRow][nextCol] = '+';
                    queue.offer(new int[]{nextRow, nextCol, currDistance + 1});
                }  
            }
        }
        return -1; // no possible exit 
    }
}
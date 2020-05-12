import java.util.LinkedList;
import java.util.Queue;

/*
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

Example 1:

Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 */
public class RottingOranges {
    public static void main(String[] args) {
        int matrix[][] = {{1,2}};

        System.out.println(orangesRotting(matrix));

    }

    private static class Pair {
        int row;
        int column;
        Pair (int r, int c) {
            row = r;
            column = c;
        }
    }

    public static int orangesRotting(int[][] grid) {
        Pair[] directions = new Pair[] {new Pair(0,1), new Pair(0,-1), new Pair(-1,0), new Pair(1, 0)};
        int totalMinutes = 0;
        if (grid == null || grid.length == 0) {
            return totalMinutes;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int freshOranges = 0;
        // find count of freshOranges and positions of rotten oranges in O(rows*columns) time complexity
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
            }
        }
        if (freshOranges == 0) return totalMinutes;
        while (!queue.isEmpty()) {
            int size = queue.size();
            totalMinutes++;
            for (int i = 0; i < size; i++) {
                Pair remove = queue.poll();
                int row = remove.row;
                int column = remove.column;
                for (int k = 0; k < directions.length; k++) {
                    int newRow = row + directions[k].row;
                    int newColumn = column + directions[k].column;
                    if ((newRow < 0) || (newColumn < 0) || (newRow >= rows) || (newColumn >= columns) || (grid[newRow][newColumn] != 1)) continue;
                    queue.add(new Pair(newRow, newColumn));
                    grid[newRow][newColumn] = 2;
                    freshOranges--;
                }
            }
        }
        return freshOranges == 0 ? totalMinutes - 1 : -1;
    }

}

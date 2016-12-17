/*
 *date:08/12/2016
 * goal:solve the 8-puzzle problem (and its natural generalizations) using the A* search algorithm
 */
// import edu.princeton.cs.algs4.MinPQ;
// import edu.princeton.cs.algs4.StdRandom;
import java.util.Stack;

public class Board {
    
    private final int n;
    private char[] blocks;
    // private int[][] blocks; // should make a new array to keep original immutable or not?
    private int hammingNum;
    private int manhattanNum;
    private int boardX, boardY;
    public Board(int[][] blo)           // construct a board from an n-by-n array of blocks
    {
        if (blo.length == 0)
            throw new java.lang.NullPointerException();
        this.n = blo.length;
        blocks = new char[n*n];
        // this.blocks = blocks;
        hammingNum = 0;
        manhattanNum = 0;
        int num = 0;
        int num1 = 0;
        int currentNum = 0;
        int horizontal = 0;
        int vertical = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
               this.blocks[i*n + j] = (char) blo[i][j];
               // calculate hamming distance
                    // if the position is right, no need to count
                    if (blocks[i*n + j] != 0) {
                        currentNum = i*n + j + 1;
                        if (blocks[i*n + j] != currentNum)
                        num++;
                        // calculate manhattanNum
                        // if the position is right, no need to count
                        if (blocks[i*n + j] == (n * i + j + 1))
                            continue;
                        if (blocks[i*n + j] % n == 0) {
                            vertical = blocks[i*n + j]/n - 1 - i;
                            horizontal = n - 1 - j; 
                        } else {
                            vertical = blocks[i*n + j]/n - i;
                            horizontal = blocks[i*n + j] % n -1 - j;
                        }
                        // get the distance in the vertical direction
                        // vertical = (blocks[i][j]-j-1)/n - i;
                        vertical = Math.abs(vertical);
                        // get the distance in the horizontal direction
                        // horizontal = (blocks[i][j]-1) % n-j;
                        horizontal = Math.abs(horizontal);
                        num1 += vertical + horizontal;
                    } else {
                        boardX = i;
                        boardY = j;
                    }
                this.hammingNum = num;
                this.manhattanNum = num1;
        }
    }
                                           // (where blocks[i][j] = block in row i, column j)
    public int dimension()                 // board dimension n
    {
        return n;
    }
    public int hamming()                   // number of blocks out of place
    {
        return hammingNum;
    }
    public int manhattan()                 // sum of Manhattan distances between blocks and goal
    { 
        return manhattanNum;
    }
    public boolean isGoal()                // is this board the goal board?
    {
        return hammingNum == 0;
    }
    public Board twin()                    // a board that is obtained by exchanging any pair of blocks
    {
        int[][] twin = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
            twin[i][j] = (int) blocks[(i * n) + j];
        }
        if ((twin[0][0] == 0) || (twin[0][1] == 0))
            swap(twin, 1, 0, 1, 1);
        else
            swap(twin, 0, 0, 0, 1);
        return new Board(twin);
        // any->random?
//        int[][] blocksCopy = new int[n][n];
//        for (int i = 0; i < n; i++) 
//            for (int j = 0; j < n; j++)
//            blocksCopy[i][j] = (int) blocks[i*n + j];
//        int row = StdRandom.uniform(1, n);
//        int col = StdRandom.uniform(1, n);
//        int col1 = 0;
//        int row1 = 0;
//        if (blocks[row*n + col] == 0)
//        {
//            if (row > 0)
//                row -= 1;
//            else
//                row += 1;
//        }
//        // get the other block
//        if (col > 0) {
//            col1 = col - 1;
//            row1 = row;
//            if (blocks[row1*n + col1] == 0)
//            {
//                if (row > 0)
//                    row1 = row - 1;
//                else
//                    row1 = row + 1;
//                col1 = col;
//            }
//        } else {
//            col1 = col + 1;
//            row1 = row;
//            if (blocks[row1*n + col1] == 0)
//            {
//                if (row > 0)
//                    row1 = row - 1;
//                else
//                    row1 = row + 1;
//                col1 = col;
//            }
//        }
//       // System.out.println("Before swapping:" + blocksCopy[row][col]);
//        // swap
//        swap(blocksCopy, row, col, row1, col1);
//       // System.out.println("After swapping:" + blocksCopy[row][col]);
//        return new Board(blocksCopy);
    }
    public boolean equals(Object y)        // does this board equal y?
    {
        // equals or ==
        if (this == y)
            return true;
        if (y == null)
            return false;
           // throw new java.lang.NullPointerException();
        if (this.getClass() != y.getClass())
            return false;
        Board that = (Board) y;
        if (that.dimension() != n) return false;
        char[] blocksThat = that.blocks;
         for (int j = 0; j < n*n; j++) {
            if (blocksThat[j] != blocks[j])
                return false;
        }
        return true;
    }
    // how to create an iterable object?
    public Iterable<Board> neighbors()     // all neighboring boards, take care not to change original blocks
    {
        Stack<Board> neighbors = new Stack<Board>();
        // find neighbors by moving all the neighbor cells into the empty cell
       int[] dX = {0, 0, -1, 1};
       int[] dY = {1, -1, 0, 0};
       int[][] tmp = new int[n][n];
       for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++)
            tmp[i][j] = (int) blocks[i*n + j];
            // the cell to be exchanged
           // System.out.println("row is " + row + " col is " + col);
            
                for (int j = 0; j < 4; j++) {
                    int x = boardX + dX[j];
                    int y = boardY + dY[j];
                    if (x >= 0 && x < n && y >= 0 && y < n) {
                    tmp[boardX][boardY] = tmp[x][ y];
                    tmp[x][y] = 0;
                    // create the neighbor
                    Board neighbor1 = new Board(tmp);
                    // boards.add(neighbor1);
                    neighbors.push(neighbor1);
                    // remember to recover the blocks 
                    tmp[x][y] = tmp[boardX][boardY];
                    tmp[boardX][boardY] = 0;
                    }
            }
         return neighbors;
    }
    public String toString()               // string representation of this board (in the output format specified below)
    {
        if (blocks.length == 0)
            throw new java.lang.NullPointerException();
        StringBuilder s = new StringBuilder();
        s.append(n + "\n");
        for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++)
           s.append(String.format("%2d ", (int) blocks[i*n + j]));
        s.append("\n");
        }
        return s.toString();
    }
    private void swap(int[][] array, int row1, int col1, int row2, int col2) {
        int temp = 0;
        temp = array[row1][col1];
        array[row1][col1] = array[row2][col2];
        array[row2][col2] = temp;
    }
    
}

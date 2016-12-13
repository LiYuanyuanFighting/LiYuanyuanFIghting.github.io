/*
 *date:08/12/2016
 * goal:solve the 8-puzzle problem (and its natural generalizations) using the A* search algorithm
 */
import java.lang.Math;
// import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Stack;

public class Board {
    
    private final int N;
    private int[][] blocks; // should make a new array to keep original immutable or not?
    public Board(int[][] blocks)           // construct a board from an n-by-n array of blocks
    {
        if (blocks.length == 0)
            throw new java.lang.NullPointerException();
        this.N = blocks.length;
        this.blocks = blocks;
    }
                                           // (where blocks[i][j] = block in row i, column j)
    public int dimension()                 // board dimension n
    {
        return N;
    }
    public int hamming()                   // number of blocks out of place
    {
        int num = 0;
        int currentNum = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
             // if the position is right, no need to count
            if (blocks[i][j] == 0)
                continue;
            currentNum = i*N + j;
            if (blocks[i][j] != currentNum)
                num++;
        }
        return num;
    }
    public int manhattan()                 // sum of Manhattan distances between blocks and goal
    {
        int num = 0;
        int horizontal = 0;
        int vertical = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
            // if the position is right, no need to count
            if (blocks[i][j] == (N * i + j + 1))
                continue;
            // get the distance in the vertical direction
            vertical = (blocks[i][j]-j-1)/N - i;
            vertical = Math.abs(vertical);
            // get the distance in the horizontal direction
            horizontal = (blocks[i][j]-1) % N-j;
            horizontal = Math.abs(horizontal);
            num += vertical + horizontal;
        }
        return num;
    }
    public boolean isGoal()                // is this board the goal board?
    {
        int moves = hamming();
        if (moves == 0)
            return true;
        return false;
    }
    public Board twin()                    // a board that is obtained by exchanging any pair of blocks
    {
        // any->random?
        int[][] blocksCopy = copy();
        int row = StdRandom.uniform(1, N);
        int col = StdRandom.uniform(1, N);
        int col1 = 0;
        int row1 = 0;
        if (blocks[row][col] == 0)
        {
            if (row > 0)
                row -= 1;
            else
                row += 1;
        }
        // get the other block
        if (col >0) {
            col1 = col - 1;
            row1 = row;
            if (blocks[col1].equals(null))
            {
                if (row > 0)
                    row1 = row - 1;
                else
                    row1 = row + 1;
                col1 = col;
            }
        } else {
            col1 = col + 1;
            row1 = row;
            if (blocks[row1][col1] == 0)
            {
                if (row > 0)
                    row1 = row - 1;
                else
                    row1 = row + 1;
                col1 = col;
            }
        }
        // swap
        swap(blocksCopy[row][col], blocksCopy[row1][col1]);
        return new Board(blocksCopy);
    }
    public boolean equals(Object y)        // does this board equal y?
    {
        // equals or ==
        if (this == y)
            return true;
        if (y == null)
            throw new java.lang.NullPointerException();
        if (this.getClass() != y.getClass())
            return false;
        Board that = (Board) y;
        if (that.dimension() != N) return false;
        int[][] blocksThat = that.blocks;
        for (int i = 0; i < N; i++) 
            for (int j = 0; j < N; j++) {
            if (blocksThat[i][j] != blocks[i][j])
                return false;
        }
        return true;
    }
    // how to create an iterable object?
    public Iterable<Board> neighbors()     // all neighboring boards, take care not to change original blocks
    {
        Stack<Board> neighbors = new Stack<Board>();
        
        // 1st find the empth cell
        int ii = 0, jj = 0;
        // record the position of empty cell
       int row = 0;
       int col = 0;
        mainLoop:
       for (ii = 0; ii < N; ii++) {
            for (jj = 0; jj < N; jj++) {
            System.out.println("blocks[ii][jj] is " + blocks[ii][jj]);
            if (blocks[ii][jj]== 0){
                System.out.println("0");
                break mainLoop;
            }
        }
       }
         row = ii;
         col = jj;
        System.out.println("ii is " + ii + " jj is " + jj);
       
       int exchange = 0;
       
       
        // find neighbors by moving all the neighbor cells into the empty cell
       
        // 1.check up
        if (row > 0) {
            int[][] blocksCopy1 = new int[N][N];
            // the cell to be exchanged
            System.out.println("row is " + row + " col is " + col);
            exchange = blocks[row-1][col];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++) {
                if (blocks[i][j] == exchange)
                     blocksCopy1[i][j] = 0;
                else {
                    if (blocks[i][j] == 0)
                    blocksCopy1[i][j] = exchange;
                    else 
                        blocksCopy1[i][j] = blocks[i][j];
                }
            }
            // create the neighbor
            Board neighbor1 = new Board(blocksCopy1);
            // boards.add(neighbor1);
            neighbors.push(neighbor1);
            System.out.println("I added up neighbor");
        }
        // 2.check bottom
        if (row < N - 1) {
            int[][] blocksCopy2 = new int[N][N];
            // the cell to be exchanged
            exchange = blocks[row+1][col];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++) {
                if (blocks[i][j] == exchange)
                     blocksCopy2[i][j] = 0;
                else {
                    if (blocks[i][j] == 0)
                    blocksCopy2[i][j] = exchange;
                    else 
                        blocksCopy2[i][j] = blocks[i][j];
                }
            }
            // create the neighbor
            Board neighbor2 = new Board(blocksCopy2);
            // boards.add(neighbor1);
            neighbors.push(neighbor2);
            System.out.println("added bottom neighbor " + neighbor2);
             System.out.println("I added bottom neighbor");
        }
        // 3.check left
         if (col > 0) {
             int[][] blocksCopy3 = new int[N][N];
            // the cell to be exchanged
            exchange = blocks[row][col-1];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++) {
                if (blocks[i][j] == exchange)
                     blocksCopy3[i][j] = 0;
                else {
                    if (blocks[i][j] == 0)
                    blocksCopy3[i][j] = exchange;
                    else 
                        blocksCopy3[i][j] = blocks[i][j];
                }
            }
            // create the neighbor
            Board neighbor3 = new Board(blocksCopy3);
            // boards.add(neighbor1);
            neighbors.push(neighbor3);
            System.out.println("added left neighbor " + neighbor3);
             System.out.println("I added left neighbor");
        }
         // 4.check right
         if (col < N - 1) {
             int[][] blocksCopy4 = new int[N][N];
            // the cell to be exchanged
            exchange = blocks[row][col+1];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++) {
                if (blocks[i][j] == exchange)
                     blocksCopy4[i][j] = 0;
                else {
                    if (blocks[i][j] == 0)
                    blocksCopy4[i][j] = exchange;
                    else 
                        blocksCopy4[i][j] = blocks[i][j];
                }
            }
            // create the neighbor
            Board neighbor4 = new Board(blocksCopy4);
            // boards.add(neighbor1);
            neighbors.push(neighbor4);
            System.out.println("added right neighbor " + neighbor4);
             System.out.println("I added right neighbor");
        }
         for (Board check: neighbors) {
            System.out.println("2121212traverse neighbors " + check);
            }
         
         return neighbors;
    }
    public String toString()               // string representation of this board (in the output format specified below)
    {
        if (blocks.length == 0)
            throw new java.lang.NullPointerException();
        StringBuilder s = new StringBuilder();
        s.append(N + "\n");
        for (int j = 0; j < N; j++) {
        for (int i = 0; i < N; i++)
           s.append(String.format("%2d ", blocks[i][j]));
        s.append("\n");
        }
        return s.toString();
    }
    private void swap(int a, int b) {
        int temp = 0;
        temp = a;
        a = b;
        b = temp;
    }
    private int[][] copy() {
        int[][]  blocksCopy = new int[N][N];
        for (int i = 0; i < N; i++) 
            for (int j = 0; j < N; j++)
            blocksCopy[i][j] = blocks[i][j];
        return blocksCopy;
    }
    public static void main(String[] args) // unit tests (not graded)
    {
    
    }
}

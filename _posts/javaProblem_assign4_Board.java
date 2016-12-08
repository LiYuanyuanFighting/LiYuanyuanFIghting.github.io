/*
 *date:08/12/2016
 * goal:solve the 8-puzzle problem (and its natural generalizations) using the A* search algorithm
 */
import java.lang.Math;
import edu.princeton.cs.algs4.StdRandom;

public class Board {
    
    private final int N = null;
    private int[] blocks = null; // should make a new array to keep original immutable or not?
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
        if (N == null)
            throw new java.lang.NullPointerException();
        return N;
    }
    public int hamming()                   // number of blocks out of place
    {
        int num = 0;
        int currentNum = null;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
             // if the position is right, no need to count
            if (blocks[i][j].equals(0))
                continue;
            currentNum = i*N + j;
            if (!blocks[i][j].equaks(currentNum))
                num++;
        }
        return num;
    }
    public int manhattan()                 // sum of Manhattan distances between blocks and goal
    {
        int num = 0;
        int horizontal = null;
        int vertical = null;
        for (int i = 0; i < N; j++)
            for (int j = 0; j < N; j++) {
            // if the position is right, no need to count
            if (blocks[i][j].equals(3*i+j))
                continue;
            // get the distance in the vertical direction
            vertical = blocks[i][j]/N - i;
            vertical = Math.abs(vertical);
            // get the distance in the horizontal direction
            horizontal = blocks[i][j] % N;
            horizontal = Math.abs(horizontal);
            num += vertical + horizontal;
        }
        return num;
    }
    public boolean isGoal()                // is this board the goal board?
    {
        int moves = hamming();
        if (moves.equals(0))
            return true;
        return false;
    }
    public Board twin()                    // a board that is obtained by exchanging any pair of blocks
    {
        // any->random?
        int row = StdRandom.uniform(1, N);
        int col = StdRandom.uniform(1, N);
        int col1 = null;
        int row1 = null;
        if (blocks[row][col].equals(0))
        {
            if (row > 0)
                row -= 1;
            else
                row += 1;
        }
        // get the other block
        if (col >0) {
            col1 = col1 - 1;
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
            col1 = col1 + 1;
            row1 = row;
            if (blocks[row1][col1].equals(null))
            {
                if (row > 0)
                    row1 = row - 1;
                else
                    row1 = row + 1;
                col1 = col;
            }
        }
        // swap
        swap(blocks[row][col], blocks[row1][col1]);
    }
    public boolean equals(Object y)        // does this board equal y?
    {
        // ?
        if (this.equals(y))
            return true;
        return false;
    }
    // how to create an iterable object?
    public Iterable<Board> neighbors()     // all neighboring boards, take care not to change original blocks
    {
        Iterator<Board> boards = new Iterator<Board>();
        // 1st find the empth cell
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
            if (blocks[i][j].equals(0))
                break;
        }
       // record the position of empty cell
       int row = i;
       int col = j;
       int exchange = null;
       int[] blocksCopy = new int[N*N];
       
        // find neighbors by moving all the neighbor cells into the empty cell
       
        // 1.check up
        if (row > 0) {
            // the cell to be exchanged
            exchange = blocks[row-1][col];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++) {
                if (blocks[i][j].equals(exchange))
                     blocksCopy[i][j] = 0;
                else {
                    if (blocks[i][j] = null)
                    blocksCopy[i][j] = 0;
                    else 
                        blocksCopy[i][j] = blocks[i][j];
                }
            }
            // create the neighbor
            Board neighbor1 = new Board(blocksCopy);
            boards.add(neighbor1);
        }
        // 2.check bottom
        if (row < N) {
            // the cell to be exchanged
            exchange = blocks[row+1][col];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++) {
                if (blocks[i][j].equals(exchange))
                     blocksCopy[i][j] = 0;
                else {
                    if (blocks[i][j] = null)
                    blocksCopy[i][j] = 0;
                    else 
                        blocksCopy[i][j] = blocks[i][j];
                }
            }
            // create the neighbor
            Board neighbor2 = new Board(blocksCopy);
            boards.add(neighbor1);
        }
        // 3.check left
         if (col > 0) {
            // the cell to be exchanged
            exchange = blocks[row][col-1];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++) {
                if (blocks[i][j].equals(exchange))
                     blocksCopy[i][j] = 0;
                else {
                    if (blocks[i][j] = null)
                    blocksCopy[i][j] = 0;
                    else 
                        blocksCopy[i][j] = blocks[i][j];
                }
            }
            // create the neighbor
            Board neighbor3 = new Board(blocksCopy);
            boards.add(neighbor1);
        }
         // 4.check right
         if (col > 0) {
            // the cell to be exchanged
            exchange = blocks[row][col+1];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++) {
                if (blocks[i][j].equals(exchange))
                     blocksCopy[i][j] = 0;
                else {
                    if (blocks[i][j] = null)
                    blocksCopy[i][j] = 0;
                    else 
                        blocksCopy[i][j] = blocks[i][j];
                }
            }
            // create the neighbor
            Board neighbor3 = new Board(blocksCopy);
            boards.add(neighbor1);
        }
    }
    public String toString()               // string representation of this board (in the output format specified below)
    {
        if (blocks.length == 0)
            throw new java.lang.NullPointerException();
        System.out.println(N);
        for (int j = 0; j < N; j++)
        for (int i = 0; i < N; i++)
            System.out.print(" " + blocks[i + j*N]);
        System.out.println();
    }
    private void swap(int a, int b) {
        int temp = null;
        temp = a;
        a = b;
        b = temp;
    }
    public static void main(String[] args) // unit tests (not graded)
}

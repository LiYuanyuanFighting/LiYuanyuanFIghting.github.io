import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;
public class Solver {
    
    private final Board initial;
    private final Board goal;
    public Solver(Board initial)           // find a solution to the initial board (using the A* algorithm)
    {
        if (initial == null)
            throw new java.lang.NullPointerException();
        this.initial = initial;
        int[][] blocksGoal = { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} };
        Board goal = new Board(blocksGoal);
        this.goal = goal;
    }
    public boolean isSolvable()            // is the initial board solvable?
    {
       
        Board twinBoard = initial.twin();
        if (twinBoard.equals(goal))
            return false;
        Board min = null;
        MinPQ<Board> q = initial.neighbors();
        
        min = q.delMin();
        while (min.manhattan() != 0) {
            q = min.neighbors();
            min = q.delMin();
        }
        return true;
    }
    public int moves()                     // min number of moves to solve initial board; -1 if unsolvable
    {
     if (!isSolvable())
         return -1;
     int num = 0;
     Board min = null;
     Iterable<Board> q = initial.neighbors();
     min = q.delMin();
     num++;
     while (min.manhattan() != 0) {
            q = min.neighbors();
            min = q.delMin();
            num++;
        }
     return num;
    }
    public Iterable<Board> solution()      // sequence of boards in a shortest solution; null if unsolvable
    {
        if (!isSolvable())
            return null;
        MinPQ<Board> sol = new MinPQ<Board>();
         Board min = null;
     Iterable<Board> q = initial.neighbors();
     min = q.delMin();
     sol.insert(min);
     while (min.manhattan() != 0) {
            q = min.neighbors();
            min = q.delMin();
            sol.insert(min);
        }
     return sol;
    }
    public static void main(String[] args) // solve a slider puzzle (given below)
    {

    // create initial board from file
    In in = new In(args[0]);
    int n = in.readInt();
    int[][] blocks = new int[n][n];
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            blocks[i][j] = in.readInt();
    Board initial = new Board(blocks);

    // solve the puzzle
    Solver solver = new Solver(initial);

    // print solution to standard output
    if (!solver.isSolvable())
        StdOut.println("No solution possible");
    else {
        StdOut.println("Minimum number of moves = " + solver.moves());
        for (Board board : solver.solution())
            StdOut.println(board);
    }
}
}

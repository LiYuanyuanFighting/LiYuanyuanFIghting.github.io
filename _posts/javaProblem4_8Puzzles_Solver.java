import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;
import java.util.Stack;

public class Solver {
    
    private final Board initial;
    private final Board goal;
    private MinPQ<GameNode> pqSearch;
    private boolean solvable;
    private int moveTotal;
    public Solver(Board initial)           // find a solution to the initial board (using the A* algorithm)
    {
        if (initial == null)
            throw new java.lang.NullPointerException();
        this.initial = initial;
        int[][] blocksGoal = { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} };
        Board goal = new Board(blocksGoal);
        this.goal = goal;
        this.solvable = true;
        // A* algorithm: (Board current, GameNode prev, int moves, boolean isTwin)
        MinPQ<GameNode> pq = new MinPQ<GameNode>();
        MinPQ<GameNode> pqSearch = new MinPQ<GameNode>(); 
        boolean isTwin = false;
        int move = 0;
        // check unsolvable case
        if (initial.twin().equals(goal)) {
            solvable = false;
        }
        GameNode gn = new GameNode(initial, null, 0, isTwin);
        // 1st: insert the initial search node
        pq.insert(gn);
        // 2nd: delete from the priority queue the search nodes with minimu priority
        GameNode searchNode = pq.delMin();
        pqSearch.insert(searchNode);
        while (!searchNode.board.equals(goal)) {
        // And insert neighbors
        for (Board board : searchNode.board.neighbors()) {
            if (board.twin().equals(goal)) {
                isTwin = false;
                break;
            }
            
            GameNode searchGN = new GameNode(board, searchNode,searchNode.moves + 1, isTwin);
            pq.insert(searchGN);
        }
        searchNode = pq.delMin();
        pqSearch.insert(searchNode);
        }
        moveTotal = searchNode.moves;
        if (searchNode.isTwin == true)
            solvable = false;
    }
    public boolean isSolvable()            // is the initial board solvable?
    {
        return solvable;
    }
    public int moves()                     // min number of moves to solve initial board; -1 if unsolvable
    {
     return moveTotal;
    }
    public Iterable<Board> solution()      // sequence of boards in a shortest solution; null if unsolvable
    {
     if (!isSolvable())
            return null;
     Stack<Board> neighbors = new Stack<Board>();
     for (GameNode gn:pqSearch)
         neighbors.push(gn.board);
     return neighbors;
    }
    
    private class GameNode implements Comparable<GameNode> {
        private Board board;
        private int moves;
        private GameNode prev;
        private boolean isTwin;
        
        public GameNode(Board current, GameNode prev, int moves, boolean isTwin) {
            this.board = current;
            this.prev = prev;
            this.moves = moves;
            this.isTwin = isTwin;
        }
        
        public int compareTo(GameNode that) {
            int priority1 = this.board.manhattan() + this.moves;
            int priority2 = this.board.manhattan() + that.moves;
            
            if (priority1 == priority2) {
                return 0;
            } else if (priority1 > priority2) {
                return 1;
            } else {
                return -1;
            }
        }
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

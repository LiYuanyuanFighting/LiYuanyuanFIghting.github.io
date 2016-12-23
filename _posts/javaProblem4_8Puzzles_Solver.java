 import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;
import java.util.Stack;

public class Solver {
    
    private boolean solvable;
    private GameNode last; // = null;
    
    public Solver(Board initial)           // find a solution to the initial board (using the A* algorithm)
    {
        if (initial == null)
            throw new java.lang.NullPointerException();
        
        solvable = true;
        
        // A* algorithm: (Board current, GameNode prev, int moves, boolean isTwin)
        MinPQ<GameNode> pq = new MinPQ<GameNode>();
        
        // 1st: insert the initial search node
        pq.insert(new GameNode(initial, null, 0, false));
        // insert the twin of searchNode
        pq.insert(new GameNode(initial.twin(), null, 0, true));
        
       // System.out.println("My twin is " + initial.twin());
       while (!pq.isEmpty()) {
      // 2nd: delete from the priority queue the search nodes with minimu priority
            GameNode searchNode = pq.delMin();
            
            if (!searchNode.isTwin) {
                last = searchNode;
            }
           // System.out.println("check " + searchNode.board);
            if (searchNode.board.isGoal()) {
                if (searchNode.isTwin) {
                    solvable = false;
                }
                break;
            }
            
            // And insert neighbors
            for (Board neighbor : searchNode.board.neighbors()) {
            if (searchNode.prev == null ||
                !searchNode.prev.board.equals(neighbor)) {
            pq.insert(new GameNode(neighbor, searchNode, searchNode.moves + 1, searchNode.isTwin));
            }
        }
        }
    }
    public boolean isSolvable()            // is the initial board solvable?
    {
        return solvable;
    }
    public int moves()                     // min number of moves to solve initial board; -1 if unsolvable
    {
       if (!solvable)
            return -1;
     return last.moves; 
    }
    public Iterable<Board> solution()      // sequence of boards in a shortest solution; null if unsolvable
    {
     if (!isSolvable())
            return null;
     Stack<Board> solutions = new Stack<Board>();
     Stack<Board> solutions2 = new Stack<Board>();
     GameNode search = last;
   //  int i = 0;
    // int j = 0;
     while (search.prev != null) {
         solutions.push(search.board);
         search = search.prev;
       //  i++;
     }
     solutions.push(search.board);
    // while (j <= i) {
      //   j++;
     while (!solutions.empty()) {
         solutions2.push(solutions.pop());
     }
     return solutions2; 
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
System.out.println("Initiation board finished!");
 StdOut.println(initial);
    // solve the puzzle
    Solver solver = new Solver(initial);
System.out.println("Initiation finished!");
    // print solution to standard output
    if (!solver.isSolvable())
        StdOut.println("No solution possible");
    else {
        StdOut.println("Minimum number of moves = " + solver.moves());
        for (Board board : solver.solution())
            StdOut.println(board);
    }
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
             int priority2 = that.board.manhattan() + that.moves;
 
             if (priority1 == priority2) {
                 return 0;
             } else if (priority1 > priority2) {
                 return 1;
             } else {
                 return -1;
             }
         }
     }
}

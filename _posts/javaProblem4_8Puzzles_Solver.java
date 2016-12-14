// import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
// import edu.princeton.cs.algs4.StdOut;
import java.util.Stack;

public class Solver {
    
    // private MinPQ<GameNode> pqSearch  = new MinPQ<GameNode>();;
    private boolean solvable;
    private GameNode last = null;
    private int moveTotal;
    public Solver(Board initial)           // find a solution to the initial board (using the A* algorithm)
    {
        if (initial == null)
            throw new java.lang.NullPointerException();
        this.solvable = true;
        // A* algorithm: (Board current, GameNode prev, int moves, boolean isTwin)
        MinPQ<GameNode> pq = new MinPQ<GameNode>();
        // check unsolvable case
       // if (initial.twin().equals(goal)) {
         //   solvable = false;
        // }
        GameNode gn = new GameNode(initial, null, 0, false);
        // 1st: insert the initial search node
        pq.insert(gn);
        // insert the twin of searchNode
        pq.insert(new GameNode(initial.twin(), null, 0, true));
       // System.out.println("My twin is " + initial.twin());
        while (!pq.isEmpty()) {
             // 2nd: delete from the priority queue the search nodes with minimu priority
            GameNode searchNode = pq.delMin();
           // pqSearch.insert(searchNode);
        moveTotal = searchNode.moves;
            
           // System.out.println("searchNode move is " + searchNode.moves);
            if (searchNode.board.isGoal()) {
                if (searchNode.isTwin) {
                    solvable = false;
                   // System.out.println("not solvable!!!!");
                }
               // System.out.println("I found goal!"  + searchNode.board);
               last = searchNode;
                break;
            }
            // And insert neighbors
            for (Board neighbor : searchNode.board.neighbors()) {
            if (searchNode.prev == null || !searchNode.prev.board.equals(neighbor)) {
            GameNode searchGN = new GameNode(neighbor, searchNode, searchNode.moves + 1, searchNode.isTwin);
            pq.insert(searchGN);
           // StdOut.println("checkhjhkj " + searchGN.board);
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
     return moveTotal;
    }
    public Iterable<Board> solution()      // sequence of boards in a shortest solution; null if unsolvable
    {
     if (!isSolvable())
            return null;
     Stack<Board> solutions = new Stack<Board>();
     Stack<Board> solutions2 = new Stack<Board>();
     GameNode search = last;
     int i = 0;
     int j = 0;
     while (search.prev != null) {
         solutions.push(search.board);
         search = search.prev;
         i++;
     }
     while (j < i) {
         j++;
         solutions2.push(solutions.pop());
     }
     // for (GameNode gn:pqSearch)
        // solutions.push(gn.board);
     return solutions2;
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
    
//    public static void main(String[] args) // solve a slider puzzle (given below)
//    {

//    // create initial board from file
//    In in = new In(args[0]);
//    int n = in.readInt();
//    int[][] blocks = new int[n][n];
//    for (int i = 0; i < n; i++)
//        for (int j = 0; j < n; j++)
//            blocks[i][j] = in.readInt();
//    Board initial = new Board(blocks);

//    // solve the puzzle
//    Solver solver = new Solver(initial);

//    // print solution to standard output
//    if (!solver.isSolvable())
//        StdOut.println("No solution possible");
//    else {
//        StdOut.println("Minimum number of moves = " + solver.moves());
//        for (Board board : solver.solution())
//            StdOut.println(board);
//    }
//}
}

**return a list of the neighbors of vertex**  
    public class GraphAdjList extends Graph {
    	private Map<Integer, ArrayList<Integer>> adjListsMap;
    	
    	// getNumVertices and getNumEdges are defined here
    
    	// return a list of the neighbors of v 
    	public List<Integer> getNeighbors (int v) {
    		// return adjListsMap.get(v);  // return v's list, then the outside can also change the list
    		return new ArrayList<Integer>(adjListMap.get(v)); // return a COPY of v's list, which is a bit safer
    	}
    }
[![Java design](http://imgur.com/12Hi4ha "Java design")](http://imgur.com/12Hi4ha "Java design")
[![example1](http://imgur.com/XIU4WTy "example1")](http://imgur.com/XIU4WTy "example1")
[![example2](http://imgur.com/cBaTMSx "example2")](http://imgur.com/cBaTMSx "example2")   

**Materials of DFS and BFS**  
videos:https://www.youtube.com/watch?v=bIA8HEEUxZI  
doc:http://www.programmerinterview.com/index.php/data-structures/dfs-vs-bfs/ (Talking about the differences)

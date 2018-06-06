package business;

class AdjMatrix{
	float[][] adj;
	/**
	 * The number of oupied indexes. Is always less than equal than the length of adj.
	 */
	int occupied;
	
	/**
	 * Constructor for <code>AdjMatrix</code> of a given size
	 * @param size
	 */
	public AdjMatrix(int size) {
		//Creates a square matrix
		this.adj= new float[size][size];
	}
	
	/**
	 * Constructor for <code>AdjMatrix</code> with a fixed size of 10
	 */
	public AdjMatrix() {
		this(10);
	}
	
	/**
	 * Resizes the adjacency matrix by an integer factor and copies all elements into the new matrix.
	 * @param factor
	 */
	public void resize(int factor) {
		int size=adj[0].length;
		float[][] resized = new float[size*factor][size*factor];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				resized[i][j]=adj[i][j];
			}
		}
	}
	
	/**
	 * Resizes by two by default
	 */
	public void resize() {
		resize(2);
	}
	
	public boolean isFull() {
		return occupied==adj[0].length;
	}
	/**
	 * Inserts <code>weigth</code> at position (u,v) and (v,u) Since the graph is undirected
	 * @param weigth
	 */
	public void insert(int u, int v,float weigth) {
		adj[u][v]=weigth;
		adj[v][u]=weigth;
		occupied++;
	}
}

public class Graph {
	/**
	 * Ajacency matrix to represent the wieghted connections between Articles. 
	 * Each index indicates the id of the Article.
	 */
	AdjMatrix articlesAdj;
	
	/**
	 * Constructor for Graph. Initializes the adjacency matrix of articles with a given size.
	 * @param size fixed intial size for the Graph. Is intended whenever the final size is known.
	 */
	public Graph(int size) {
		articlesAdj= new AdjMatrix(size);
	}
	
	/**
	 * Constructor for a Graph with no given size. It initializes the size in 10.
	 */
	
	public Graph() {
		this(10);
	}
        
	public void addArticle(int id) {
            
	}
	
        
	
}

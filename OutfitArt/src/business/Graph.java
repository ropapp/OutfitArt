package businessLogic;

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
	
	public 
}

public class Graph {
	int size;
	/**
	 * Ajacency matrix to represent the wieghted connections between Articles. 
	 * Each index indicates the id of the Article.
	 */
	float[][] articlesAdj;
	
	/**
	 * Constructor for Graph. Initializes the adjacency matrix of articles with a given size.
	 * @param size fixed intial size for the Graph. Is intended whenever the final size is known.
	 */
	public Graph(int size) {
		this.size=size;
		articlesAdj= new float[size][size];
	}
	
	/**
	 * Constructor for a Graph with no given size. It initializes the size in 10.
	 */
	
	public Graph() {
		this(10);
	}
	
	public void resizeAdj()
	
	List users=new List();
	List outfits = new List();
	
	public void addArticle(Article a) {
		Article temp=(Article)articles.head;
		while(temp!=null) {
			Edge e = new Edge(temp,a);
			temp.Adjacency.put(e);
			a.Adjacency.put(e);
			temp=(Article)temp.next;
		}
		articles.put(a);
	}
	
	public void addWardrobe(List articles) {
		Article temp = (Article) articles.head;
		while(temp!=null) {
			addArticle(temp);
		}
	}
	
	public void addOutfit(User u,List items) {
		Outfit o = new Outfit(items);
		outfits.put(o);
		u.getAdjacency().put(o);
	}
	
	public void addOutfit(List items) {
		Outfit o = new Outfit(items);
		outfits.put(o);
	}
	
	public void addOutfit(User u, Outfit o) {
		outfits.put(o);
		u.getAdjacency().put(o);
	}
	
	public void addUser(User u) {
		users.put(u);
	}
	
	
	public List generate(User u,float[] metadata) {
		List filtered = BFSfilter(u,metadata);
		List generated = new List();
		Outfit o = (Outfit)filtered.head;
		while(o!=null) {
			Article temp = (Article) o.getAdjacency().head;
			while(temp!=null) {
				List items = generateOutfit(temp,new int[] {0,0,0,0});
				if(!items.isEmpty())
					generated.put(new Outfit(items));
				temp=(Article)temp.next;
			}
			o=(Outfit) o.next;
		}
		return generated;
	}
	
	public List generateOutfit(Article a, int[] types) {
		List items = new List();
		Article temp = (Article) a.Adjacency.max.oppositeNode(a);
		types[a.type-1]=1;
		if(types[temp.type-1]==0) {
			items.put(generateOutfit(temp,types));
			items.put(temp);
		}
		//temp=(Article) temp.next;
		return items;
	}
	
	public List BFSfilter(User u, float[] metadata) {
		List adj = u.getAdjacency();
		List output=new List();
		Outfit temp = (Outfit) adj.head;
		while(temp!=null) {
			if(Graph.distance(temp.metadata, metadata)<=0.25) {
				output.put(temp);;
			}
			temp=(Outfit)temp.next;
		}
		
		return output;
	}
	
	
	public static float distance(float[] m1, float[] m2) {
		return (float) Math.sqrt(Math.pow(m1[0]-m2[0], 2)+Math.pow(m1[1]-m2[1], 2));
	}
	
}

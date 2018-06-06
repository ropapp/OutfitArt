/*package data;

import business.*;

public class DataSet {
	
	public static void generateDataSet(Graph G, User u,int N) {
		
		List outfit1=new List();
		for(int i=0;i<N;i++) {
			double start = System.currentTimeMillis();
			Article a = Article.random();
			if((int) (Math.random()*10)%2==0) {
				outfit1.put(a);
			}
			G.addArticle(a.getID());
			double finish = System.currentTimeMillis();
			System.out.println(a.toString()+" || EXE: "+Double.toString(finish-start));
			
		}
		if(!outfit1.isEmpty()) {
			Outfit o = new Outfit(outfit1);
			G.addOutfit(u, o);
			System.out.println("OUTFIT CREATED\n"+o.toString());
		}
		System.out.println(u.getAdjacency().getSize());
	}
	
	public static List generateWardrobe(int N) {
		List items = new List();
		for(int i=0;i<N;i++) {
			items.put(Article.random());
		}
		return items;
	}
	
	
	public static void main(String[] args) {
		Graph G = new Graph();
		User u = new User("Camilo",'M');
		G.addUser(u);
		generateDataSet(G,u,5);
		generateDataSet(G,u,5);
		generateDataSet(G,u,5);
		if(!G.generate(u, new float[] {0f,0f}).isEmpty())
			System.out.println("EUREKA!!!");
	}
}
*/
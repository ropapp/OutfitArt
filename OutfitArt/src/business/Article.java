package business;

import java.awt.Color;

/**
 * This class is used to manage a single instance of an article of clothing and its 
 * relationships with other articles of clothing.
 * @author jucat
 *
 */
public class Article extends Clothes{
	int type;
	Color color;
	String description="";
	float[] metadata=new float[]{0,0};
	/**
	 * Creates a new clothing article
	 * @param type 		1	jacket
	 * 					2	shirt/blouse
	 * 					3	pants/troussers
	 * 					4	footwear
	 * @param Color ans instance of java.awt.Color
	 */
	public Article(int type, Color color) {
		super();
		this.type = type;
		this.color= color;
	}
	
	public Article(int type, Color rgb, float[] metadata) {
		this(type, rgb);
		this.metadata=metadata;
	}
	
	public Article(int type, Color rgb, float[] metadata, String description) {
		this(type,rgb,metadata);
		this.description=description;
	}

	
	/**
	 * This functions compares two pieces of clothes and evaluate how well they behave according to the four types of combination:
	 * Monochromatic, Complementary, Analogous and Split-Complemenetary. 
	 * It uses the colour int the HSL space, and gives them a nummeric punctuation ranging from 0 to 1.
	 * @param a An article
	 * @return The matching score ranging from -1 to 1
	 */
	
	public static float matchColor (Article a1, Article a2) {
		double[] c1=HSL.fromRGB(a1.color);
		double[] c2=HSL.fromRGB(a2.color);
		float matchingScore=0f;
		
		double distance = Math.abs(c1[0]-c2[0])/360;
		//matches Monochromatic:
		float treshold=30f/360f;
		if (distance<=treshold) 
			matchingScore+=(float)(1/Math.exp(distance));
		
		//matches Complemmentary:
		if(distance<=0.5+treshold && distance>=0.5-treshold) 
			matchingScore+=(float)(1/Math.exp(distance));
		
		//matches Split-Complemmentary:
		if(distance<=0.5+2*treshold && distance>=0.5-2*treshold) 
			matchingScore+=(float)(1/Math.exp(distance));
		
		//matches Analogous:
		treshold=90f/360f;
		if (distance<=treshold) 
			matchingScore+=(float)(1/Math.exp(-distance));
		return matchingScore/4;
	}
	/**
	 * Evaluates the Euclidean Distance between this metadata and other metadata, 
	 * and gives a score ranging from 0 to 1.
	 * @param a An article
	 * @return the matching score between the metadata of this article and another article a
	 * @see Node
	 */
	public float matchStyle(Article a) {
		double f1=this.metadata[0];
		double f2=a.metadata[0];
		double w1=this.metadata[1];
		double w2=a.metadata[1];
		
		double eDistance = Math.sqrt(Math.pow(f1-f2,2)+Math.pow(w1-w2,2));
		
		return (float) (1/(Math.expm1(eDistance)+1));
		
	}
	
	public static float matchStyle(Article a1, Article a2) {
		return a1.description.equals(a2.description)?1.0f:0.0f;
	}
	
	/**
	 * Randomly generates an object Article. It is intended for testing only
	 * and should be avoided
	 * @return randomArticle
	 */
	public static Article random() {
		Color c = HSL.randomColor();
		int par =(int) (Math.random()*7+1);
		if(par%2==0) {
			int type = (int)(Math.random()*4 + 1);
			float m1 = (float) Math.random();
			float m2 = (float) Math.random();
			float[] meta = new float[] {m1,m2};
			Article randomArticle = new Article(type, c, meta);
			return randomArticle;
			
		}else {
			int metadata = (int) (Math.random()*5);
			int type = (int)(Math.random()*4 + 1);
			String[] str= new String[]{"formal","cold","rainy","sport","sunny","hot"};
			float[] meta = new Clothes().hmap.get(str[metadata]);
			Article randomArticle = new Article(type, c, meta);
			return randomArticle;
		}
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String toString() {
		return this.description;
	}
}

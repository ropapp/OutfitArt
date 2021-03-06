package business;

import java.awt.Color;

/**
 * This class is used to manage a single instance of an article of clothing and its 
 * relationships with other articles of clothing.
 * @author jucat
 *
 */
public class Article{
	int type;
        int id;
	Color color;
	String ocassion="";
	float[] metadata=new float[]{0,0};
        Article next;
        String description="";
        EdgeList edges=new EdgeList();
        
	/**
	 * Creates a new clothing article
	 * @param type 		<ul> <li>1	jacket
	 * 				<li>	2	shirt/blouse
	 * 				<li>	3	pants/troussers
	 * 				<li>	4	footwear
         * </ul>
	 * @param color an instance of java.awt.Color
	 */
	public Article(int type, Color color) {
		super();
		this.type = type;
		this.color= color;
	}
	
	public Article(int type, Color rgb, String ocassion) {
		this(type, rgb);
		this.ocassion = ocassion;
	}
        
        public Article(int type, Color rgb, String ocassion, String description){
            this(type,rgb,ocassion);
            this.description=description;
        }
        
        public Article(){}

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getOcassion() {
        return ocassion;
    }

    public void setOcassion(String ocassion) {
        this.ocassion = ocassion;
    }

    public float[] getMetadata() {
        return metadata;
    }

    public void setMetadata(float[] metadata) {
        this.metadata = metadata;
    }

    public Article getNext() {
        return next;
    }

    public void setNext(Article next) {
        this.next = next;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
		return a1.ocassion.equals(a2.ocassion)?1.0f:0.0f;
	}
	
	/**
	 * Randomly generates an object Article. It is intended for testing only
	 * and should be avoided
	 * @return randomArticle
	 */
	public static Article random() {
            Color c = HSL.randomColor();
            int param = (int) (Math.random() * 4)+1;
            String str="";//ocassion
            switch(param){
                case(1):
                    str="Universidad";
                    break;
                case(2):
                    str="Cita";
                    break;
                case(3):
                    str="Evento Formal";
                    break;
                case(4):
                    str="Deporte";
                    break;
                default:
                    str="";
                    break;
            }
            
            return new Article(param,c,str);
	}

	public int getType() {
		return type;
	}
        
	public void setType(int type) {
		this.type = type;
	}
        
        public int getID(){
            return this.id;
        }

        @Override
	public String toString() {
		return this.ocassion+" "+Integer.toString(type)+" "+Integer.toHexString(color.getRGB());
	}
        
        public Article copy(){
            Article cloned = new Article(this.type,this.color,this.ocassion);
            return cloned;
        }
}

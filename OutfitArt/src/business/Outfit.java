/*package business;

public class Outfit {
	String name;
	
	
	public Outfit(List items) {
		this.metadata=new float[] {0f,0f};
		if(!items.isEmpty()) {
			Article temp = (Article) items.head;
			int counter=1;
			while(temp!=null) {
				this.getAdjacency().put(temp);
				this.metadata[0]+=temp.metadata[0];
				this.metadata[1]+=temp.metadata[1];
				counter++;
				temp=(Article) temp.next;
			}

			this.metadata[0]=this.metadata[0]/counter;
			this.metadata[1]=this.metadata[1]/counter;
		}
	}
	
	public String toString() {
		return Float.toString(metadata[0])+" "+Float.toString(metadata[1])+": "+this.getAdjacency().toString();
	}
	
	
	
}*/

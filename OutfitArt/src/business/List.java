package business;

class Node {
	Node prev=null,next=null;
	String id;
	private List Adjacency=new List();
	/**
	 * This parameters intends to represent the intrinsic characteristics 
	 * with wich one may describe wether an <code>Article</code> or an 
	 * <code>Outfit</code> in a two-dimensional space where:
	 * <ul>
	 * <li><code>metadata[0]</code> Is the formality index, it ranges from -1 to 1, where 1 indicates very formal 
	 * and -1 indicates not formal at all.
	 * <li><code>metadata[1]</code> Is the weather index, it ranges from -1 to 1, with 1 indicating the preference
	 * 			 of use in enviroments with high temperature, and -1 for the use in enviroments with low temperatures
	 * </ul>
	 * <p>
	 * formal (1 very formal/-1 not formal at all)- weather(1 hot/cold)
	 */
	float[] metadata;
	
	public List getAdjacency() {
		return Adjacency;
	}

}

public class List {
	Node head = null;
	Node tail = null;
	int size;
	
	public boolean isEmpty() {
		return (head==null);
	}
	
	public void put(Node node) {
		if(this.isEmpty()) {
			this.head=node;
			this.tail=head;
		}else {
		
			this.tail.next=node;
			this.tail=node;
		}
		this.size++;
	}
	
	public void put(List list) {
		if(this.isEmpty()) {
			this.head=list.head;
			this.tail=list.tail;
		}else if(!list.isEmpty()) {
			this.tail.next=list.head;
			this.tail=list.tail;
		}
		this.size+=list.size;
	}
	
	public Node remove(int index) {
		Node temp = this.head;
		
		for(int i=0;i<index && temp!=null;i++) {
			temp=temp.next;
		}
		if(temp!=null) size--;
		return temp;
	}
	
	//Dirty Linear Search:
	public Node searchByID(String id) {
		Node temp = this.head;
		while(temp!=null) {
			if(temp.id.equals(id)) return temp;
			temp=temp.next;
		}
		return null;
	}
	
	public String toString() {
		String output ="";
		Node temp = this.head;
		while(temp!=null) {
			output = output+temp.toString()+";";
			temp=temp.next;
		}
		return output;
	}
	
	public int getSize() {
		return this.size;
	}

}






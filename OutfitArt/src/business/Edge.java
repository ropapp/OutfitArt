package businessLogic;

public class Edge extends Node{
	Node inputNode, outputNode;
	float weight;
	
	public Edge(Article u, Article v) {
		if(u.type!=v.type) {
			this.inputNode=u;
			this.outputNode=v;
					
			this.weight=u.matchColor(v)+u.matchStyle(v);
		}
	}
	
	public Node oppositeNode(Node n) {
		if(n.equals(this.inputNode)) {
			return this.outputNode;
		}else if(n.equals(this.outputNode)) {
			return this.inputNode;
		}else {
			return null;
		}
		
	}
	
	public Edge(Outfit o, Article a) {
		this.inputNode=o;
		this.outputNode=a;
		
	}
	
	public String toString() {
		return inputNode.toString()+","+outputNode.toString()+";";
	}
	

	public float getWeight() {
		return weight;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	
}

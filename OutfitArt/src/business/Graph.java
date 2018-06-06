package business;


public class Graph {
        ArticleList[][] articles;
	/**
	 * 
	 */
        
	public Graph() {
            articles = new ArticleList[4][4];
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++)
                    articles[i][j]=new ArticleList();
            }
	}
        
	public void addArticle(Article a) {
            String ocassion=a.getOcassion();
            int i=-1;
            switch(ocassion){
                case("Universidad"):{
                    i=0;
                }case("Cita"):{
                    i=1;
                }case("Evento Formal"):{
                    i=2;
                }case("Deporte"):{
                    i=3;
                }
            }
            int j=a.getType()-1;
            articles[i][j].insertAtEnd(a);
            //Creating new connections
            if(j>-1 & j<3){
                Article temp=articles[i][j+1].head;
                while(temp!=null){
                    float weigth= Article.matchColor(a,temp);
                    a.edges.add(new Edge(weigth,temp));
                    temp=temp.next;
                }    
            }
            //Updating connections
            if(j>0 & j<4){
                Article temp=articles[i][j-1].head;
                while(temp!=null){
                    float weigth=Article.matchColor(a, temp);
                    temp.edges.add(new Edge(weigth,a));
                    temp=temp.next;
                }
            }
            
            
                
	}
        
        public Article[] generateOutfit(String ocassion){
            Article[] outfit=new Article[4];
            int i=-1;
            switch(ocassion){
                case("Universidad"):{
                    i=0;
                }case("Cita"):{
                    i=1;
                }case("Evento Formal"):{
                    i=2;
                }case("Deporte"):{
                    i=3;
                }
            }
            int n=articles[i][1].size;
            //Chooses randomly an article from the type 1 List
            int j=(int)(Math.random()*n);
            //Depth Search:
            outfit[0]=articles[i][0].get(j);
            //Finds the maximum weighted
            
            for(int k =1;k<4;k++){
                //The Node with the maximum weight
                EdgeList edges=outfit[k-1].edges;
                if(edges!=null | !edges.isEmpty()){
                    Edge e=edges.toArray()[k-1];
                    outfit[k]=articles[i][k].search(e.output.id);
                }
            }
            
            return outfit;
        }
	
        
	
}

package business;


public class Graph {
        ArticleList[][] articles;
	/**
	 * 
	 */
	
	public Graph() {
            articles = new ArticleList[4][4];
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
            if(j>-1 & j<3){
                Article temp=(Article)articles[i][j+1].head;
                while(temp!=null){
                    
                }
                
            }
                
	}
	
        
	
}

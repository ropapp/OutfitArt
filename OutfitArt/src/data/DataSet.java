package data;
import business.*;
public class DataSet{
    Graph G = new Graph();
    Article[] articles ;
    public DataSet(int size){
        articles = new Article[size];
        for(int i=0;i<size;i++){
            Article a =Article.random();
            G.addArticle(a);
            articles[i]=a;
        }
    }
    
    
    public static void main(String[] args){
        for(int i=0;i<10;i++){
            DataSet d= new DataSet(50);
            Article[] outfit=d.G.generateOutfit("Deporte");
            for(int j=0;j<4;j++){
                Article a= outfit[j];
                if(a!=null)
                    System.out.println(a.toString());
            }
        }
    }
}
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
        DataSet d= new DataSet(5);
        
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author jucat
 */

public class ArticleArray {
    public Article[] articleArr;
    /**
     * Number of not null indexes
     */
    public int index=0;
    public ArticleArray(int size){
        articleArr=new Article[size];
    }
    
    public boolean isFull(){
        int size= articleArr.length;
        return articleArr[size-1]!=null;
    }
    public void resize(){
        int size=articleArr.length;
        Article[] resized=new Article[size*2];
        System.arraycopy(articleArr, 0, resized, 0, size);
        this.articleArr=resized;
    }
    public void insert(Article a){
        if(this.isFull()){
            this.resize();
            this.insert(a);
        }else{
            a.id=index;
            articleArr[index]=a;
            index++;
        }
        
    }
    public ArticleArray(){
        this(30);
    }
    public void delete(int index){
        articleArr[index]=null;
    }
    
    public Article search(int id){
        return articleArr[id];
    }
}

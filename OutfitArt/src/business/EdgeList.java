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

class Edge{
    float weigth;
    Article output;
    Edge next;
    
}
/**
 * A sorted list using a Stack
 * @author jucat
 */
public class EdgeList {
    Edge head=null;
    
    public Edge pop(){
        if(this.isEmpty())
            return null;
        else{
            Edge temp=head;
            this.head=temp.next;
            temp.next=null;
            return temp;
        }
    }
    
    public void push(Edge e){
        e.next=head;
        head=e;
    }
    /**
     * recuersive function to implement insertionSort
     * @param e
     * @param eL 
     */
    public static void pushSort(Edge e, EdgeList eL){
        Edge temp = eL.pop();
    }
    
    public boolean isEmpty(){
        return head==null;
    }
    
}

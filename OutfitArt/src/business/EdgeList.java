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
    float weight;
    Article output;
    Edge next;

    public Edge(float w, Article output) {
        this.weight = w;
        this.output = output;
    }
    
}
/**
 * The list of conncections of a single Article
 * @author jucat
 */
public class EdgeList {
    Edge head=null;
    Edge tail=null;

    int size=0;
    
    public Edge poll(){
        if(this.isEmpty())
            return null;
        else{
            Edge temp=head;
            this.head=temp.next;
            temp.next=null;
            size--;
            return temp;
        }
    }
    
    public void add(Edge e){
        if(this.isEmpty()){
            head=e;
            tail=head;
        }else{
            tail.next=e;
            tail=e;
        }
        size++;
    }
        
    public boolean isEmpty(){
        return size==0;
    }
    
    public Edge[] toArray(){
        Edge[] edges = new Edge[size];
        for(int i=0;i<size;i++){
            Edge temp = this.poll();
            edges[i]=temp;
            this.add(temp);
        }
        return mergeSort(edges);
    }
    
        public Edge[] mergeSort(Edge[] unsorted) {
        
        if(unsorted.length>1) {
            
            size=unsorted.length/2;
            Edge[] left_array = new Edge[size];
            Edge[] right_array = new Edge[unsorted.length-size];//si es impar lo crea de tamaño size+1
            //LLenando el arreglo izquierdo
            System.arraycopy(unsorted, 0, left_array, 0, size);
            
            //LLenando el arreglo derecho            
            for(int i=size;i<unsorted.length;i++)
                right_array[i-size]=unsorted[i];
            
            left_array = mergeSort(left_array);
            right_array = mergeSort(right_array);
            
            return merge(left_array,right_array);
        }
        return unsorted;
    }
    
    public Edge[] merge(Edge[] a, Edge[] b) {
        int length = a.length + b.length; 
        Edge[] c = new Edge[length];
        
        int indexA=0, indexB=0, indexC =0;
        
        while(indexA<a.length && indexB<b.length) {
            if(a[indexA].weight<b[indexB].weight) {
                c[indexC]=a[indexA];
                indexA++;
            }else {
                c[indexC]=b[indexB];
                indexB++;
            }
            indexC++;
        }
        
        while(indexA<a.length) {
            c[indexC]=a[indexA];
            indexA++;
            indexC++;
        }
        
        while(indexB<b.length) {
            c[indexC]=b[indexB];
            indexB++;
            indexC++;
        }
        
        return c;
    }
}

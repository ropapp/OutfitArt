package business;

import business.Article;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class ArticleList {

	Article head=null;
        int size = 0;

		 public boolean isEmpty(){
                    return size==0;
		 
		  }
                 
                public int getSize(){
                    return size;
                }
                
                public Article get(int pos){
                    // Crea una copia de la lista.
                    Article aux = head;
                    // Recorre la lista hasta encontrar el elemento o hasta 
                    // llegar al final de la lista.
                    for (int i = 0; i != pos; i++) {
                        if(aux!=null)
                            aux=aux.next;
                        else
                            return null;    
                    }
                    return aux;
                    
                }
                //Dirty linear Search
                public Article search(int id){
                    Article aux = head;
                    while(aux!=null){
                        if(aux.getID()==id)
                            return aux;
                        aux=aux.next;
                    }
                    //not found
                    return null;
                }

		 public void printList(){
			  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			  Article temp=head;

			  try{
				  bw.write("Articles: \n");
				  while(temp != null){
					  bw.write(temp.toString() );
					  temp=(Article)temp.next;
				  }
				  bw.flush();
			  } 
			  catch(Exception ex){ex.printStackTrace();}
		  }

		 public void insertAtBegin(Article newNode){
			  newNode.next=head;
			  head = newNode;
                          size++;
		  }

		 public void insertAtEnd(Article newNode){
			  if (isEmpty())
				  head=newNode;
			  else{
				  Article temp=head;
				  while(temp.next != null)
					  temp=temp.next;
				  temp.next=newNode;
			  }
                          size++;
		  }

		 public void insert(Article newNode, int pos){
			  Article temp=head;

		   	  for (int i = 0; i < pos; i++)
		   		temp = temp.next;

		   	  newNode.next=temp.next;
		   	  temp.next=newNode;
                          size++;

		   }

		 public void deleteAtBegin(){
			  Article temp=head;
			  head =head.next;
			  temp = null;
			  System.gc();
                          size--;
		  }

                 public Article poll(){
                     Article temp=this.head;
                     head=temp.next;
                     temp.next=null;
                     this.insertAtEnd(temp);
                     return temp;
                }
                public void delete(int posicion){
                    if(posicion>=0 && posicion<size){
                        if(posicion == 0){
                            head = head.next;
                        }
                        else{
                            Article aux = head;
                            for (int i = 0; i < posicion-1; i++) {
                                aux = aux.next;
                            }
                            Article siguiente = aux.next;
                            aux.next=siguiente.next;
                        }
                        size--;
                    }
                }
                
                
                 
}
	
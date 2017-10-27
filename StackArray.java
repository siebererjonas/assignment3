package rainer_sieberer;

public class StackArray<E> implements LIFO{

   private E[] stack;
   int point;
   
   public StackArray(){
      stack = (E[]) new Object[10];      
      point = 0;
   }
   
   //---------------------------------------------------------
   public boolean empty(){
      return point == 0;
   }
   
   //---------------------------------------------------------
   public E peek(){
      
      E next;
      
      try{
         next = stack[point - 1];
      }
      catch(IndexOutOfBoundsException e){
         System.out.println("Stack is empty!");
         return null;
      }
      
      return next;
   }
   
   //----------------------------------------------------------   
   public E pop(){
      
      E next;
      
      try{
         next = stack[point - 1];
      }
      catch(IndexOutOfBoundsException e){
         System.out.println("Stack is empty!");
         return null;
      }
      
      point--;
      stack[point] = null;
      
      return next;
   }
   
   //---------------------------------------------------------
   public E push(Object o){
      
      E item = (E) o;
      
      if(point == stack.length){
         E[] help = (E[]) new Object[point * 2];
         for(int i = 0; i < stack.length; i++){
            help[i] = stack[i];
         }
         stack = help;
      }
      
      stack[point] = item;
      point++;
      return item;
   }

   //---------------------------------------------------------
   public int search(Object o){
      
      E item = (E) o;
      int count = 1;
      
      for(int i = point - 1; i >= 0; i--){
         if(stack[i] == item)
            return count;
         count++;
      }
      
      return -1;
   }
}
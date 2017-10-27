package rainer_sieberer;

import assignment3_int.Calculator;

public class RPN implements Calculator{
   
   private StackList<String> result = new StackList<String>();
   
   public RPN(){};
   
   //-------------------------------------------------------------
   public double calc(String[] input){
      
      if(input.length == 0){
         return stringToDouble(result.pop());
      }
      
      int count = 0;
      
      while(count < input.length && !isOp(input[count])){
         result.push(input[count]);
         count++;
      }
      
      String op = input[count];
      count++;
      
      String rechts = result.pop();
      String links = result.pop();
      
      String res = doOp(links, rechts, op);
      
      result.push(res);

      String[] newInput = new String[input.length - count];
      for(int i = count, j = 0; i <input.length; i++, j++){
         newInput[j] = input[i];
      }
         
      return calc(newInput);
   }
      
   //-----------------------------------------------------
   private boolean isOp(String s){
      return s == "+" || s == "-" || s == "*" || s == "/";
   }
   
   //-----------------------------------------------------
   private String doOp(String links, String rechts, String op){
      
      double x = stringToDouble(links);
      double y = stringToDouble(rechts);
      double res = 0;
      
      switch(op){
         case "+":
            res = x + y; break;
         case "-":
            res = x - y; break;
         case "*":
            res = x * y; break;
         case "/":
            if(y == 0)
               throw new IllegalArgumentException("Division by 0");
            else
               res = x / y;
            break;
         default:
            System.out.println("Wrong input");
            break;
      }
   
      return Double.toString(res);
   }
   
   //-----------------------------------------------------
   private double stringToDouble(String s){
      
      double res = 0;
      
      try {
         res = Double.parseDouble(s);
      } catch (NumberFormatException e) {
         System.out.println("Wrong input!");
      }
      
      return res;
   }
}
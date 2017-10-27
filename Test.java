package rainer_sieberer;

public class Test{
   
   public static void main(String[] args){
      
      RPN4 test = new RPN4();
      
      String[] sample ={"1.5", "2", "+", "3", "4", "-", "*"};
      
      System.out.println("Example:\ninput: {\"1.5\", \"2\", \"+\", \"3\", \"4\", \"-\", \"*\"}");
      System.out.println("output: " + test.calc(sample));
   }
  }
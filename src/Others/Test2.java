package Others;

public class Test2  {  
    public void run() {  
    	//......
    }
    
    public void f(String name) {  
        synchronized(this) {  
             for (int i = 0; i < 5; i++) {  
                  System.out.println(name + "f synchronized loop " + i);  
             }  
        }
   }
    
    /*public void g(String name) {  
        synchronized(this) {  
             for (int i = 0; i < 5; i++) {  
                  System.out.println(name + "g synchronized loop " + i);  
             }  
        }
   }*/
    
    public static void main(String[] args) {  
         Test2 t = new Test2();
  //       t.start();
         
         Test3 test31 = new Test3(t);
     	 Test3 test32 = new Test3(t);
     	 test31.start();
     	 test32.start();
         //Test2 t2 = new Test2();
         //ta.start();  
         //tb.start();  
    } 
}

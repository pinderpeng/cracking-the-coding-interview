package Others;

public class Test3 extends Thread{

	private Test2 t;
	public Test3(Test2 t){
		this.t = t;
	}
	
	public void run() {  
		t.f(Thread.currentThread().getName());
		//t.g(Thread.currentThread().getName());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

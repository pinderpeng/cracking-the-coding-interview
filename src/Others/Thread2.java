package Others;

public class Thread2 extends Thread{

	//public boolean start = false;
	
	@Override	
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			this.wait();
			System.out.println("i want to sleeping");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		this.notify();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread2 thread2 = new Thread2();
		Thread1 thread1_1 = new Thread1(thread2);
		//Thread1 thread1_2 = new Thread1(thread2);
		thread2.start();
		thread1_1.start();
		//thread1_2.start();
	}
     
}

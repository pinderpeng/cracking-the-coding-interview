package Others;

public class Thread1 extends Thread {

	public Thread2 thread2 = new Thread2();
	public Thread1(Thread2 thread2){
		this.thread2 = thread2;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			f(thread2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void f(Thread2 t) throws InterruptedException{
		//synchronized (t) {
			System.out.println("i am waiting...");
//			t.wait();
			t.resume();
			Thread.sleep(1000);
//			this.notify();
			System.out.println("stop waiting now!");
		//}		
	}
	
}

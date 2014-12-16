package test.jav;

class ThreadExtendsTest extends Thread {

	public static void main(String[] args) {
		ThreadExtendsTest t = new ThreadExtendsTest();
		t.start();
	}

	public void run() {
		System.out.println("Thread is running");
	}

}
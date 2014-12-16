package test.jav;

class ThreadRunnableTest implements Runnable

{

public static void main(String[] args)
{
    Thread t = new Thread( new ThreadRunnableTest());
    t.start();
}





public void run()
{
    System.out.println("Thread is running");   
}





}

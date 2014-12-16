package test.jav;

public class Fibonacci 
{
	public static void main(String[] args) {
		fibonacci(4);
	}

	public static  void fibonacci(int n)
	{
		int a1 =0, a2=1;
		System.out.println(a1);
		System.out.println(a2);
		for (int i = 2; i <=n ; i++)
		{
		int c= a1+a2;
		a1= a2;
		a2 = c;		
		System.out.println(c);
		}
	}
}
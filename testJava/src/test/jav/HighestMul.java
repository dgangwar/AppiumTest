package test.jav;

public class HighestMul {

	public static int highestMul(int[] data) {
		int fh = 0 , sh = 0, th = 0 ;

		for (int i = 0; i< data.length; i++ ) 
		{
			if (data[i] >= fh)
				{
				th = sh;
				sh = fh;
				fh = data[i];
				}
			else if (data[i] >= sh)
			{
				th = sh;
				sh = data[i];
			}
				
			else if (data[i] >= th)
			{
				th = data[i];

			}
			System.out.println(fh +" "+sh +" "+th + " - it "+i );
		}
			return fh*sh*th;
	}
	
	
	public static void main(String[] args) 
	{
		int[] data = {3,2,7,6,3,5};
		System.out.println(highestMul(data));
		
	}
}

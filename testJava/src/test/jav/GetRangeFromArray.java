package test.jav;

public class GetRangeFromArray 
{
	public static void main(String[] args) 
	{
		int[] a = {1,3,3,4,4,4};
		System.out.println(getRange(a,3));
		
		
		
	}
	
	static String getRange(int[] arr, int number)
	{
		return findLeftindex(arr, arr.length/2, number) +" "+findrightindex(arr, arr.length/2, number);
	}
	
	static int findLeftindex(int[] arr, int mid, int number)
	{
		if(arr[0] == number)
		{
			return 0;
			
		}
		if(arr[mid] == number && arr[mid-1] < number )
		{
			System.out.println("left " + mid);
			return mid;
		}
		else
		{
			return findLeftindex(arr,mid/2, number);	
		}
	}
	
	static int findrightindex(int[] arr, int mid, int number)
	{
		if(arr[arr.length-1] == number)
		{
			return arr.length-1;
			
		}
		if(arr[mid] == number && arr[mid+1] > number)
		{
			System.out.println("Right");
			return mid;
		}
		else
		{
			return findrightindex(arr,mid/2+mid, number);	
		}
	}
	
}

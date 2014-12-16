package test.jav;

public class EqualChek 
{
	public static void main(String[] args) {
		String str1 = new String();
		 String str2 =  new String();
		 String str3 = str2;

		 if(str3 == str2){
		 System.out.println("Objects are equal");
		 }else{
		 System.out.println("Objects are not equal");
		 }

		 if(str1.equals(str2)){
		 System.out.println("Objects are equal");
		 }else{
		 System.out.println("Objects are not equal");
		 Object obj = new Object();
		 
		 }
	}

		
	
}

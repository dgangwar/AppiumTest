package test.jav;

public class Palindrome
{

public static void main(String[] args)
{
    System.out.println(isPalindrome("ABAA"));
}

static boolean isPalindrome(String testString)
{
    char[] charArray = testString.toCharArray();
    int length = testString.length();
    boolean isPalin = true;
    for(int i = 0; i<=testString.length()/2; i++)
    {
        if(charArray[i] != charArray[length-1] )
        {
        	System.out.println(charArray[i] + " "+ i);
        	System.out.println(charArray[length-1]);
            isPalin = false;
            return isPalin;
        }
        length = length-1;
    }
    return isPalin;
}

}

package test.jav;

public class Factorial
{

public static void main(String[] args)
{

System.out.println(factorial(3));

}

static int factorial(int count)
{
    if(count==0)
    return 1;
    else
    return count*factorial(count-1);
}

}

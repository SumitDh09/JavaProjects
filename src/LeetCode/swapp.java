
package LeetcodeProblems;

public class swapp {
    public static void printhelloworld(){
        System.out.print("hello world");

    }
    public static int calculateSum(int a ,int b){
        //parameters or formal parameters
        int sum = a+b;
        return sum;

    }
    public static void swap(int a, int b){
        //Swap
        int temp= a;
         a = b;
         b =temp;
        System.out.println("a = "+a);
        System.out.println("b = "+b);

    }
    public static void main(String[] args) 
    {
        //swap -- vaalue exchanges
        int a=5;
        int b=10;
        swap(a, b);

        System.out.println("a = "+a);
        System.out.println("b = "+b);
    }

    
}

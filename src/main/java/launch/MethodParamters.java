package launch;

public class MethodParamters {
    //Passing variables to method paranthesis are called paramters
    void add(int a,int b){
        int c=a+b;
        System.out.println("The addition of "+a + " and " +b +" is "+c);
    }
    public static void main(String[] args) {

        //object creation syntax
        MethodParamters md=new MethodParamters();
        //Here 10,12 are aruguments to the method
        md.add(10,12);
    }
}

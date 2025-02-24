mport java.lang.reflect.*;
class Calculator{
    private int multiply(int a,int b){
        return a*b;
    }
}
public class ReflectionCal{
    public static void main(String[] args)
    {
        try{
        Class<?> cls=Calculator.class;
       
        Method mul=cls.getDeclaredMethod("multiply", int.class,int.class);
       
        mul.setAccessible(true);
        Calculator c=new Calculator();
        int result=(int) mul.invoke(c,5,4);
        System.out.println(result);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}



mport java.lang.reflect.*;
class Person{
    private int age=18;


    public void displayAge()
    {
        System.out.println("Age: "+age);
    }
}


public class Main{
    public static void main(String []args)
    {
        try{
            Person p=new Person();
            Class<?> cls=Person.class;
            Field agef=cls.getDeclaredField("age");
            agef.setAccessible(true);
            System.out.println("Original Age: "+agef.get(p));
            agef.set(p,49);
            System.out.println("Modified Age: " + agef.get(p));


           
            p.displayAge();
        }
        catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

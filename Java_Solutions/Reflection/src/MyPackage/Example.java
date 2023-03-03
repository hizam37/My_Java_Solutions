package MyPackage;

import java.lang.reflect.*;

public class Example {
    public static void main(String[] args) throws Exception{
        SomeClass someclass = new SomeClass();
        Class clss = someclass.getClass();
        System.out.println(clss.getName());
        System.out.println();
        System.out.println("Constructors:");
        Constructor[] constructors = clss.getDeclaredConstructors();
        for(Constructor constructor : constructors){
            System.out.println(constructor.getName());
            Parameter[] parameters = constructor.getParameters();
            for(Parameter parameter : parameters)
            {
                System.out.println(parameter.getName());
                System.out.println(parameter.getType().getName());
            }
        }

        System.out.println("");
        System.out.println("Methods:");
        Method[] methods = clss.getDeclaredMethods();
        for(Method method:methods)
        {
            System.out.println(method.getName());
            Parameter[] parameters = method.getParameters();
            for(Parameter parameter : parameters)
            {
                System.out.println(parameter.getName());
                System.out.println(parameter.getType().getName());
            }
            System.out.println(Modifier.toString(method.getModifiers()));
            System.out.println(method.getReturnType().getName());
            method.invoke(someclass,"test");
        }
        System.out.println();
        System.out.println("Fields:");
        Field[] fields = clss.getDeclaredFields();
        for(Field field:fields)
        {
            System.out.println(field.getName());
            System.out.println(field.getType().getName());
            System.out.println(Modifier.toString(field.getModifiers()));
            field.setAccessible(true);
            field.setInt(someclass,5);
            System.out.println(field.getInt(someclass));
        }


    }
}

class SomeClass {
   private int i;
//   String s;

   public SomeClass(){

   }
   SomeClass(String s){
//       this.s = s;
   }

   public synchronized String someMethod(String s)
   {
       System.out.println("This is " +s);
       return s;
   }

}

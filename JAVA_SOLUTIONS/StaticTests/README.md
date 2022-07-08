BE the compiler
The Java file on this page represents a
complete program. Your job is to play
compiler and determine whether this
file will compile. If it won't compile.
how would you fix it, and
if it does compile. what
would be the output?


class StaticSuper {
   static {System.out.println("super static block");
}
StaticSuper(){
    System.out.println("super constructor");
}
}


public class StaticTests extends StaticSuper{
    static int rand;
    static{
        rand = (int) (Math.random()*6);
        System.out.println("static block " + rand);
    }

StaticTests(){
    System.out.println("Constructor");

}


public static void main(String [] args)
{
    
    System.out.println("in main");
StaticTests st = new StaticTests();


}
}


1.possible output 
static block 3
in main
super static block
super constructor
Constructor

or

2.possible output 
super static block
static block 3
in main
super constructor
Constructor


Ответь 1 
Потому что потому что сначала запускается "static", а затем "Constructor"
BE the compiler
Each of the Java files on this page
represents a complete source file.
Your job is to play compiler and
determine whether these file
will compile. If it won't
compile, how would you
fix it?


class Hobbits {
String name;

public static void main(String[] args) {
Hobbits[] h = new Hobbits[3];
int z=0;

while (z<4){
z=z+1;
h[z]= new Hobbits();
h[z].name = "bilbo";
if(z==1){
h[z].name = "frodo";
}

if(z==2){
h[z].name = "same";
}
System.out.print(h[z].name + " is a ");
System.out.print("good Hobbit name");
}
}
}

Ответ B: Его можно скомпилировать, но он пропустит первый элемент массива, чтобы решить эту проблему, мы можем просто изменить значение "z" на -1 вместо 0 (cм программа Hobbits.java).

Результат 
bilbo is a good Hobbit name
frodo is a good Hobbit name
sam is a good Hobbit name




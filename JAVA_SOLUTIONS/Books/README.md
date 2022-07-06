BE the compiler
Each of the Java files on this page
represents a complete source file.
Your job is to play compiler and
determine whether these file
will compile. If it won't
compile, how would you
fix it?


A
class Books {
String title;
String author;
}

class BooksTestDrive {
public static void main(String[] args) {


Books [ ] MyBooks = new Books[3];
int x=0;
myBooks[0].title = "The Grapes of java";
myBooks[1].title = "The java Gatspy";
myBooks[2].title = "The java Cookbook";
myBooks[0].author = "bob;
myBooks[1].author = "sue;
myBooks[2].author = "ian;

while(x<3) {
System.out.print(myBooks[x].title);
System.out.print(" by ");
System.out.print(myBooks[x].author);
x=x+1;
}
}
}


Ответ A: не может быть скомпилирован, поскольку объекты в массиве размера 3 еще не созданы, поэтому давайте добавим отсутствующие объекты (см программа Books.java).

Результат 
The Grapes of Java by bob
The Java Gatsby by sue
The Java Cookbook by ian


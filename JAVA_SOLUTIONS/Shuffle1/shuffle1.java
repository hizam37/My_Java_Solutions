class shuffle1{
    public static void main(String[] arg) {
       int x =3;
       while(x>0)
       {
        if(x==1)
        {
            System.out.print("d");
            x=x-1;

        }
        if(x==2)
        {
            System.out.print("b c");
            System.out.print("~"); 
        }
        if(x>2)
        {
            System.out.print("a");
            System.out.print("~"); 
        }   
            x=x-1;
       }
     
    }
}

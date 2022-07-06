class Drumkit 
{
    boolean tophat =true ;
    boolean snare = true;
    void playsnare()
    {
        System.out.println("bang bang ba-bang");
    }
    void playtophat()
    {
        System.out.println("ding ding da-ding");
    }
} 

class Drumkittest{
    public static void main(String[] arg) {
      Drumkit d= new Drumkit();
      if(d.snare==true)
      {
        d.playsnare();
      }
    if(d.tophat==true)
    {
        d.playtophat();
    }
       }
}

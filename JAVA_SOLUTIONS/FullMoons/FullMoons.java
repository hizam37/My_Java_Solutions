import static java.lang.System.out;
import java.util.*;

public class FullMoons {
public static void main(String[] args) {
    Calendar c = Calendar.getInstance();
c.set(2004,1,7,15,40);
out.println("full moon on " + c.getTime());
c.set(2004,0,7,15,40);
out.println("full moon on " + c.getTime());
    long DAY_IM = 1000*60*60*24;
    long day1 = c.getTimeInMillis();
    day1 += (DAY_IM*29.52);
    c.setTimeInMillis(day1);
    out.println(String.format("full moon on %tc",c));


}
}


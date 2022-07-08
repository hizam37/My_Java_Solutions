This one might actually be usefull in addition to what you've learned in the last few
pages about manipulating dates, you'll need a little more information...First full
moons happen every 29.52 days or so.Second,there was a full moon on Jan.7th,
2004 .Your job is to reconstruct the code snippets to make a working Java program
that produces the output listed below (plus more full moon dates). (You might not
need all of the magnets, and add all the curly braces you need.) Oh, by the way,your
output will be different if you don't live in the mountain time zone.



long day1 = c.getTIMEInMillis();

c.set(2004,1,7,15,40);

import static java.lang.System.out;

static int DAY_IM = 60*60*24;

("full moon on %tc",c));

(c.format

Calendar c = new Calendar();

class FullMoons {

public static void main(String[] args) {

day1 += (DAY_IM*29.52);

for(int x=0;x<60;x++){

static int DAY_IM = 1000*60*60*24;

println

import java.io.*;

import java.util.*;

static import java.lang.System.out;

c.set(2004,0,7,15,40);

out.println;

c.setTimeInMillis(day1);

(String.format

Calendar c = Calendar.getInstance();


Результат 
full moon on Sat Feb 07 15:40:07 MSK 2004
full moon on Wed Jan 07 15:40:07 MSK 2004
full moon on Fri Feb 06 04:08:55 MSK 2004
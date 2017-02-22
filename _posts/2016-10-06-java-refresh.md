---
layout: post
title:  Java Refresh
categories: [blog ]
tags: [study,programing,merge,read,calendar, ]
description: These exercises are about the use of files, collections and dates/times in Java.
--- 

**Initialization in Java**  
`List<Node> nodes = null;`   
This is not an empty list, this is a list reference which is iniitalized to null;  
Use this instead:  
`List<Node> nodes = new LinkedList<Node>();`  
Everything in a valid Java program not explicitly set to something by the programmer, is initialized to a zero value.  

**Reverse**  
`String s = "sample";
String result = new StringBuffer(s).reverse().toString();`  

**Floor**   
The method floor gives the largest integer that is less than or equal to the argument.  
e.g.   
    public class Test { 
    
       public static void main(String args[]) {
          double d = -100.675;
          float f = -90;
    
          System.out.println(Math.floor(d));
          System.out.println(Math.floor(f)); 
    
          System.out.println(Math.ceil(d));
          System.out.println(Math.ceil(f));
       }
    }
output   
-101.0
-90.0
-100.0
-90.0

**Java Static Variables**

Java instance variables are given separate memory for storage. If there is a need for a variable to be common to all the   objects of a single java class, then the static modifier should be used in the variable declaration.  
Any java object that belongs to that class can modify its static variables.   
Also, an instance is not a must to modify the static variable and it can be accessed using the java class directly.   
Static variables can be accessed by java instance methods also.   
When the value of a constant is known at compile time it is declared ‘final’ using the ‘static’ keyword.   

**Java Static Methods**   

Similar to static variables, java static methods are also common to classes and not tied to a java instance.    
Good practice in java is that, static methods should be invoked with using the class name though it can be invoked using    an object. ClassName.methodName(arguments) or objectName.methodName(arguments)   
General use for java static methods is to access static fields.   
Static methods can be accessed by java instance methods.   


For references (anything that holds an object) that is null  .   
For int/short/byte/long that is a 0.   
For float/double that is a 0.0   
For booleans that is a false.   
For char that is the null character '\u0000' (whose decimal equivalent is 0).    


**Exercise 1**
Write a Java program that:
a) loads the rows of a text file called dictionary.txt, using a Collection (you are free to
choose the specific type to use) of String objects (one object per row);
b) reads the rows of a second text file, whose name is passed as argument on the command line, and
writes the rows of the second file that do not occur in the first one to standard output.

2016-10-06-programming-type.md
    /*
     * Date: 10/10/2016
     * Objective: loads the rows of a text file called dictionary.txt, using a Collection (you are free to
    choose the specific type to use) of String objects (one object per row);
     * Idea: BufferReader
     * */
    import java.io.*;
    import java.util.ArrayList;
    
    public class LoadFile1 {
    
    	private String fileName;
    	private String filePath;
    	ArrayList<String> strings;
    	
    	public LoadFile1(String fileName, ArrayList<String> strings){
    		this.fileName = fileName;
    		this.filePath = fileName;
    		this.strings = strings;
    	}
    	
    	public ArrayList<String> read() throws IOException{
    		strings = new ArrayList<String >();
    		FileInputStream fin = null;
    		int i = 0;
    		try {
    			fin = new FileInputStream(filePath);
    		} catch (IOException e) {
    			System.out.println(e.toString()+"!!!");
    			System.out.println("File " + fileName + " not found");
    		}
    		
    		DataInputStream in = new DataInputStream(fin);
    		BufferedReader br = new BufferedReader(new InputStreamReader(in));
    		String strLine = null;
    		
    		while ((strLine = br.readLine())!=null) {
    			strings.add(strLine);
    			System.out.println("line " + i + " is " + strLine);
    			i++;
    		}
    		
    		in.close();
    		
    		System.out.println("the size of the array is " + strings.size());
    		return strings;
    	} 
    }
    
    
**Exercise 2**
Write a Java program that reads a text file whose name is assigned to the system property
it.polito.dp2.file and whose rows are each made up of a series of six integers representing
a time instant in the local time zone (the integers are, respectively, hour, minute, second, day, month
and year). Such data must be loaded into objects of type GregorianCalendar. After loading,
the program must print the most recent date to standard output.
In order to read a system property you can use the System.getProperty() method like in the
following example:
// Get the "it.polito.dp2.file" system property
String dir = System.getProperty("it.polito.dp2.file");
A system property can be set or overridden by specifying the -D option to the java command when
running your program, as in the following example:
$ java -Dit.polito.dp2.file="filename" MyApp

    /* finish date 14/10/2016
     * idea: set system property using  System.setProperty("1", dir);(1st para:key, 2nd para:value, which is file name here)
     * or use command line to input like following
     * Z:\Documents\dp\JavaRefresh\src>java -D1="Z:\Documents\dp\JavaRefresh\it.polito.
    dp2.file.txt" Test
    * read the property which is like reading a file
    * add to the Calendar list then use compareTo method to compare to get most recent date
    */
    import java.io.IOException;
    import java.time.LocalDateTime;
    import java.util.ArrayList;
    import java.util.Calendar;
    import java.util.Collections;
    import java.util.Comparator;
    import java.util.Date;
    import java.util.GregorianCalendar;
    import java.util.TimeZone;
    import java.util.function.Function;
    import java.util.stream.Collectors;
    
    public class PrintDate {
    
    	private String fileName;
    	private String path;
    	private ArrayList<String> strings = new ArrayList<String >();
    	private LoadFile2 loadFile2;
    	
        public PrintDate(String fileName, String path) {
    		this.fileName = fileName;
    		this.path = path;
    		loadFile2 = new LoadFile2(fileName, path, strings);
    	} 
    	public void loadProperty() throws IOException {
    		// loadFile2.read();
    		
    		String dir ="it.polito.dp2.file.txt";// = System.getProperty("it.polito.dp2.file");
    		// System.out.println("sYSTEM PROPERTY IS :" + dir);
    		
    		String[] split;
    		int hour;
    		int year;
    		int day;
    		int month;
    		int minutes;
    		int second;
    	
    		// Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
    		Calendar calendar;
    		// GMT?
    		ArrayList<Calendar> cal = new ArrayList<Calendar >();
    		int i =0;
    		System.out.println("sYSTEM PROPERTY value IS :" + dir);
    		dir = System.getProperty("1");
    		LoadFile1 loadFile1 = new LoadFile1(dir,  strings);
    		System.out.println("hdad"+ strings.size());
    		loadFile1.read();
    		System.out.println("hdadsdasa"+ strings.size());
    		for (String item: strings) {
    			System.out.println("hdad");
    			item = item.replaceAll("\\s+", "");
    			split =item.split(",");
    			hour = Integer.parseInt(split[0]);
    			minutes = Integer.parseInt(split[1]);
    			second = Integer.parseInt(split[2]);
    			day = Integer.parseInt(split[4]);
    			month = Integer.parseInt(split[3]);
    			year = Integer.parseInt(split[5]);
    			calendar = new GregorianCalendar(year, month, day, hour, minutes, second);
    			System.out.println("hour is "+split[0]+" Calendar hour is "+calendar.HOUR_OF_DAY);
    		    cal.add(calendar);
    		    // System.out.println(cal.get(i));
    		    i++;
    		}
    		// ?how to get most recent one? what is exact value of cal array
    	
    		Calendar temp = cal.get(0);
    		for (Calendar c:cal) {
    			if (temp.compareTo(c) <= 0)
    				temp = c;
    		}
    		
    		System.out.println("the most recent date is:" + temp.get(Calendar.HOUR_OF_DAY) + ":" + temp.get(Calendar.MINUTE) + ":" +  
    				temp.get(Calendar.SECOND) + " " + temp.get(Calendar.DAY_OF_MONTH) + "_" + temp.get(Calendar.MONTH) + "_" 
    				+ temp.get(Calendar.YEAR)) ;
    	}
    }
    
**Exercise 3**
Write a Java program that reads two files, and merges them into a single third file with the lines
ordered in ascending alphabetic order.
The names of the files must be read from the command line.

    /*
     * idea: compareTo() compares two string with regard to their alphabetical order.
     * */
    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.Collections;
    
    public class Merge {
    
    	private String fileName1;
    	private String fileName2;
    	private ArrayList<String> strings1 = new ArrayList<String >(); 
    	private ArrayList<String> strings2 = new ArrayList<String >(); 
    	private LoadFile1 loadFile1;
    	private LoadFile1 loadFile2;
    	
    	public Merge(String fileName1, String fileName2) {
    		this.fileName1 = fileName1;
    		this.fileName2 = fileName2;
    		loadFile1 = new LoadFile1(fileName1, strings1);
    		loadFile2 = new LoadFile1(fileName2,  strings2);		
    	}
    	
    	public void sort() throws IOException {
    		strings1 = loadFile1.read(); //why must do in this way, then the strings will have value?
    		strings2 = loadFile2.read();
    		ArrayList<String> strings3 = new ArrayList<String>(strings1);
    		strings3.addAll(strings2);
    		
    		Collections.sort(strings3, String.CASE_INSENSITIVE_ORDER);
    		
    		for (String s : strings3) {
    			System.out.print(s + " ");
    		}
    	}
    }
  
**Terms**

-Interface cannot be instantiated but implement  
-Abstract classes cannot be instantiated directly. Declaring a class as abstract means that you do not want it  
to be instantiated and that the class can only be inherited.
It is meant to be used as the base class from which other classes are derived. The derived class is expected to  
provide implementations for the methods that are not implemented in the base class. A derived class that implement  
s all the missing functionality is called a concrete class

**The nested type NffgVerifierFactory cannot hide an enclosing type**
The problem is caused by the fact that I'm e naming my sketch the same thing as a class I'm using inside  
my sketch. My sketch can't be named MotorBike if I have a MotorBike class inside that sketch.

**Why doesn't java allow overriding of static methods**
Method overriding is made possible by dynamic dispatching, meaning that the declared type of an object doesn't determine  
its behavior, but rather its runtime type:

Animal lassie = new Dog();
lassie.speak(); // outputs "woof!"
Animal kermit = new Frog();
kermit.speak(); // outputs "ribbit!"
Even though both lassie and kermit are declared as objects of type Animal, their behavior (method .speak()) varies  
because dynamic dispatching will only bind the method call .speak() to an implementation at run time - not at compile time.

Now, here's where the static keyword starts to make sense: the word "static" is an antonym for "dynamic". So the reason  
why you can't override static methods is because there is no dynamic dispatching on static members - because static   
literally means "not dynamic". If they dispatched dynamically (and thus could be overriden) the static keyword just  
wouldn't make sense anymore.

**The static field MyNffgVerifierFactory.nffgs should be accessed in a static way**
In Java, when you declare something as static, you are saying that it is a member of the class, not the object  
(hence why there is only one). Therefore it doesn't make sense to access it on the object, because that particular  
data member is associated with the class.

Practicing reasoning about the code.

Parameters in java are always passed by value.


    public class SimpleLocation
    {
        public double lat;
        public double lon;
    
        public SimpleLocation(double latIn, double lonIn)
        {
            this.lat = latIn;
            this.lon = lonIn;
        }
    }
    public class LocationTester
    {
        public static void main(String[] args)
        {
            SimpleLocation loc1 = new SimpleLocation(39.9, 116.4);
            SimpleLocation loc2 = new SimpleLocation(55.8, 37.6);
            loc1 = loc2;
            loc1.lat = -8.3;
            System.out.println(loc2.lat + ", " + loc2.lon);
        }
    }
The result should be -8.3, 37.6. Because loc2's lat value changes via the change we make  
through loc1 because loc1 and loc2 now refer to the same object(the one that was created  
second)


**Variable Scope**  
local variables are declared inside a method, which can be used inside the method only.
[![local variable](http://imgur.com/0RKLG6i "local variable")](http://imgur.com/0RKLG6i "local variable")
Parameters behave like local variables, which can be used inside the method only  
[![parameters](http://imgur.com/eg8cIk2 "parameters")](http://imgur.com/eg8cIk2 "parameters")  
Member variables are declared outside any method, which means their scope is actually the entire  
class itself.
[![Member variables](http://imgur.com/0kIQzda "Member variables")](http://imgur.com/0kIQzda "Member variables")

An array is not a primitive type, but it's an object type
[![array object](http://imgur.com/BSHHZ6P "array object")](http://imgur.com/BSHHZ6P "array object")


[![Array_cons](http://imgur.com/COajr1E "Array_cons")](http://imgur.com/COajr1E "Array_cons")

When constructor done, all variables in this scope go away.
[![Constructor done](http://imgur.com/JWAlMJh "Constructor done")](http://imgur.com/JWAlMJh "Constructor done")
Can change the value in the main method:  
[![array_output](http://imgur.com/VZVwvZc "array_output")](http://imgur.com/VZVwvZc "array_output")

    public class MyClass
    {
      private int a;
      public double b;
      
      public MyClass(int first, double second)
      {
        this.a = first;
        this.b = second;
      }
      
      public static void incrementBoth(MyClass c1) {
        c1.a = c1.a + 1;
        c1.b = c1.b + 1.0;
      }
      
      // new method
      public static void incrementA(int first)
      {
        first = first + 1;
      }
      
      // new method
      public static void incrementB(double second)
      {
        second = second + 1.0;
      }
      
      public static void main(String[] args)
      {
        MyClass c1 = new MyClass(10, 20.5);
        MyClass c2 = new MyClass(10, 31.5);
        // different code below
        incrementA(c2.a);
        incrementB(c2.b);
        System.out.println(c2.a + ", "+ c2.b);
      }
    }   
 The result is 10, 31.5. Notice the scope of the variables. The functions  
 incrementA and incrementB only change parameter variables first and second
 which are in the method, it doesn't change the 2 object value

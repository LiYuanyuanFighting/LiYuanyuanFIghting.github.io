**Goal?**   
Have you ever wondered how map overlays for Google Maps are created? In the project 
for this course you will build your own interactive visualization of a large dataset 
tagged by geospatial information.  
Build large scale projects using existing libraries

Learning outcomes:

Build an interactive graphical program in Java
Design classes to make use of object-oriented programming paradigms
Explain inheritance and polymorphism and how each concept is applied in the creation of a Java GUI
Explain how event handling works in Java, and write event handlers to create an interactive program
Write and apply searching and sorting algorithms to manage large data sets
Find and fix errors (bugs) in code
Develop and use test cases to ensure correctness of a program

2 libraries used:  
[Unfolding is a library to create interactive maps and geovisualizations in Processing and Java](http://unfoldingmaps.org/ "Unfolding is a library to create interactive maps and geovisualizations in Processing and Java")
[SQLite JDBC Driver](https://bitbucket.org/xerial/sqlite-jdbc/ "SQLite JDBC Driver")### 主要特性

**Computer Science**  
Computer science is using and processing large amounts of information to automate useful tasks   
and learn about the world around us(using a computer)  

A class is a type of data.  
An object is one such piece of data.  

**Overloading**  
There are 2 different copies of the constructor that take different numbers and types of arguments.  
Can also overload methods.  
Have to have some difference when overload a method(Just change the return type is not enough)

UnfoldingMap

http://unfoldingmaps.org/javadoc/
public UnfoldingMap(processing.core.PApplet p,
                    java.lang.String id,
                    float x,
                    float y,
                    float width,
                    float height)
Creates a new map with specific position and dimension.
Parameters:
p - The main applet.
id - The ID of this map.
x - The x position of this map.
y - The y position of this map.
width - The width of this map.
height - The height of this map.   

**Constructor:**
Map<String, Float> lifeExpMap = new HashMap<String, Float>();   
Reference type                  Object type   
Abstract data type: List  
List<Feature> countries = new ArrayList<Feature> ();
List is abstract data type, i.e. java "interface" which specifies behaviors, not implementation.   
ArrayList implements all behaviors that specified by the list interface. This class can be instantiated.  

**ArrayLists** are like Arrays  
Array version:  
int len = countryArray.length;
ArrayList:   
int len = countries.size();  
Java will automatically resize the ArrayList for you.  

**Generics**  
List<Feature> countries;  
List<Marker> countryMarkers;  
What we put in the angle brackets is the type of object that we want java to store inside  
the container that we're creating.  


**Object creator**  
When constructing objects, in which order are instance variables initialized?  
They are initialized starting at Object and working their way down through the inheritance  
hierarchy to your subclass. The subclass constructor calls constructor up the hierarchy until  
it reaches Object, then initializes variables starting with Object all the way back down to  
your subclass.
Consider the following class definition:  
    public class Person {
        private String name;
     
        public Person( String n ) {
            super();
            this.name = n;
        }
        public void setName( String n ) {
            this.name = n;
        }
    }
  
     public class Student extends Person {
        public Student () {
            this.setName("Student"); 
        }
    }
    
    Suppose that in a main method you call  
    ``Student s = new Student()``  
    What will be the value of the name variable for this object?  
    There is a compile error:  
    It is because the Person class has no default(no-argument) constructor. Since the student  
    constructor doesn't explicitly call the super with an argument, java will attempt to call  
    the Person's non-existent no-argument constructor automatically(like add super() in student  
    constructor).
    
    
    
    
    
    
    




**Overloading vs. Overriding**  
Overloading: Same class has same method name with different parameters.  
Overriding: Subclass has same method name with the same parameters as the super class


**Abstract**  
Abstraction is a process of hiding the implementation details and showing only functionality to the user.

Another way, it shows only important things to the user and hides the internal details for example sending sms, you just type the text and send the message. You don't know the internal processing about the message delivery.

Abstraction lets you focus on what the object does instead of how it does it.

Ways to achieve Abstaction

There are two ways to achieve abstraction in java

Abstract class (0 to 100%)
Interface (100%)

e.g. Person - Campus Accounts
Add method "monthlyStatement"  
"Person" objects no longer make sense  
How do we:  
1. Force subclasses to have this method  
2. Stop having actual Person objects  
3. Keep having Person references  
4. Retain common Person code  
---Define abstract class(is - a)  which provides both inheritance of interface and inheritance of implementation  
[reference](http://www.javatpoint.com/abstract-class-in-java)

If have don't need to have 4  
---Use interface(like - a)

**Built-in sort**  
In java, the built in method sort uses merge sort which avoids programmers to implement the method. But for the object  
which includes attributes age, height, grade, to sort the object, what should be the criteria?  So we need to implemnt  
compareTo() method.  


**List to array**  
java.util.ArrayList.toArray(T[])  
If the list fits in the specified array with room to spare (i.e., the array has more elements than the list), the element in the array immediately following the end of the collection is set to null


**Autoboxing**  
[reference](http://docs.oracle.com/javase/7/docs/technotes/guides/language/autoboxing.html)  
As any Java programmer knows, you can't put an int (or other primitive value) into a collection. Collections can only hold object references, so you have to box primitive values into the appropriate wrapper class (which is Integer in the case of int). When you take the object out of the collection, you get the Integer that you put in; if you need an int, you must unbox the Integer using the intValue method. All of this boxing and unboxing is a pain, and clutters up your code. The autoboxing and unboxing feature automates the process, eliminating the pain and the clutter.

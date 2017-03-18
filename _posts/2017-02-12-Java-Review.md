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
    the Person's non-existent no-argument constructor automatically.
    
    
    
    
    
    
    




**Overloading vs. Overriding**  
Overloading: Same class has same method name with different parameters.  
Overriding: Subclass has same method name with the same parameters as the super class



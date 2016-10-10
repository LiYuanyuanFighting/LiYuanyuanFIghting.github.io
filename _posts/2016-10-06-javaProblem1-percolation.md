---
layout: post
title: Java Problem1---Percolation
categories: [blog ]
tags: [study,java,percolate, ]
description: 
---  
## Percolation
System percolates iff top and bottom are connected by open sites.
Q. How to check whether an N-by-N system percolates?
・Create an object for each site and name them 0 to N 2 – 1.
・Sites are in same component if connected by open sites.
・Percolates iff any site on bottom row is connected to site on top row.
But it needs N^2 calls to connected() 
so use a trick: 
Introduce 2 virtual sites (and connections to top and bottom).
・Percolates iff virtual top site is connected to virtual bottom site.
which is efficient algorithm: only 1 call to connected()

But it can cause a backwash problem because as long as one open block exists 
in the last row, then it is connected to the bottom node, which means, to check
percolate through top and bottom virtual nodes, it will be always percolate
(like in the following picture)
[![backwash ](http://3.bp.blogspot.com/-qt_McvcY4J0/UiKAIULvSTI/AAAAAAAAALM/C_0LHfFC4Yw/s320/percolation-backwash.png "backwash ")](http://3.bp.blogspot.com/-qt_McvcY4J0/UiKAIULvSTI/AAAAAAAAALM/C_0LHfFC4Yw/s320/percolation-backwash.png "backwash ")

### Avoid backwash issue

1. use 2  WQUUF, One(use 1 virtual top and 1 virtual bottom node) is for isFull().
the other(only use 1 virtual top node) is for percolate().
But it stores same information in 2 structures.

2. use 1 QQUUF, with additional information to keep track of each connected componet
[reference](reference http://www.sigmainfy.com/blog/avoid-backwash-in-percolation.html "reference")

- definition of API[[3]][1]
- define 2d array:
Try the following:

``int[][] multi = new int[5][10];``
... which is a short hand for something like this:

    int[][] multi = new int[5][];
    multi[0] = new int[10];
    multi[1] = new int[10];
    multi[2] = new int[10];
    multi[3] = new int[10];
    multi[4] = new int[10];
Note that every element will be initialized to the default value for int, 0, so the above are also equivalent to:

`int[][] multi = new int[][]{
  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
};`；

- how to use the command prompt:
java-algs4 edu.princeton.cs.algs4.StdDraw[[1]][1]
(if don't add -algs4, will have this error:Exception in thread "main" java.lang.NoClassDefFoundError: edu/princeton/cs/algs4/In)

- the other method is to run in DrJava(written in Interactions):
run ClassName parameters

- Array Length
When dealing with arrays, it is advantageous to know the number of elements contained within the array, or the array's "length".  This length can be obtained by using the array name followed by .length.  If an array named numbers contains 10 values, the code numbers.length will be 10.  ** You must remember that the length of an array is the number of elements in the array, which is one more than the largest subscript.
** value.length
is used to find the length of an array named value.
** value.length( )
is a method used to find the length of a String named value(not an array)

- array memory allocation:
in my program I put it outside the structure, 
use in this way:
    ...
    public int n;
    public int[][] site=new int[n+1][n+1];
    ...
    public Percolation(int n){
    // initialize array site using for loop
    ...
    
Then I got arrayIndexOutOfBound error,I guess it's due to the memory allocation problem, when it is outside the constructor, n is still uninitialized, so site doesn't get the ideal memory allocated. So I solved the problem like this:
    public int n;
    public int[][] site;
    public Percolation(int n){
    this.n = n;
    site = new int[n+1][n+1];
    //initialize the array
    }
- Write clear code:
reference [[2]][1]

- Instance variable
In object-oriented programming with classes, an instance variable is a variable defined in a class (i.e. a member variable), for which each instantiated object of the class has a separate copy, or instance. An instance variable is similar to a class variable

- xyto1D.java
transform (x,y) to 1D , which can save memory, cz don't need to initialize
a large array to store x,y

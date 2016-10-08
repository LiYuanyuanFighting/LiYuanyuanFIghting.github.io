---
layout: post
title: Java Problem1---Percolation
categories: [blog ]
tags: [study,java,percolate, ]
description: 
---  
### Percolation

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

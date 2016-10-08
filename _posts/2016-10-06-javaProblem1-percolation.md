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

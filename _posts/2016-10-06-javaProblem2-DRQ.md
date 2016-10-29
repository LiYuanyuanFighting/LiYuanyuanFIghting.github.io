---
layout: post
title: Java Problem1---Percolation
categories: [blog ]
tags: [study,java,queue,linkedlist,iterator ]
description: 
--- 

### Deques and Randomized Queues

***learning about generics and iterators*

- **raw types**
[reference](http://stackoverflow.com/questions/2770321/what-is-a-raw-type-and-why-shouldnt-we-use-it "reference")

### Assignment2
[requirement](http://coursera.cs.princeton.edu/algs4/assignments/queues.html "requirement")
**notes**
- Don't change the method name, type or parameters. If need to define a new method using keyword "private"
- for iterator, there should be methods hasNext(), remove(), next().
- For Deque:
-1. as it is a double-ended queue or deque, in my case, I used linked list which should have 2 links called next and prev, and 2 nodes called first and last.
-2. in method like addFirst(Item), take care to keep original node.
-3. for corner cases, what kind of exceptions should be throwed and when should do them.
for Randomized queues:
- 1. I used array so it will have size problem, so I implement resize method. 
- 2. don't forget to put the last item of the new array to be null to avoid loitering(Loitering: holding a reference to an object when it is no longer needed).
- 3. in iterator(): due to randomness and less space, time used, trick is to put last item to the item selected randomly every time. And in the same time we need to keep independent operation with every iterator created to same randomized queue,  creae a new array for every iterator!

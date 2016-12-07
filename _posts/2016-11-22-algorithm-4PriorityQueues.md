---
layout: post
title: Algorithm---Sorting
categories: [blog ]
tags: [study,java,sort,priorityQueue ]
description: Good algorithm is much more efficienet than spending more money and time
---  

[reference1](http://www.cs.dartmouth.edu/~gevorg/cs10/notes.php?num=14 "reference1")
[reference2](http://algs4.cs.princeton.edu/24pq/)

**Questions**
1. What is the expected number of array accesses and compares, respectively, to insert  
a random key into an ordered-array implementation of a priority queue?  
-linear and logarithmic 
-analysis: we can use binary search to find the insertion point using a logarithmic number   
of compares. On average, the key to be inserted must be placed in the middle of the array   
to keep the array in order, we must shift over all larger keys.  
**a priority queue** is an abstract data type which is like a regular queue or stack data   
structure, but where additionally each element has a "priority" associated with it. In a  
priority queue, an element with high priority is served before an element with low priority.  
If two elements have the same priority, they are served according to their order in the queue.  

**max-heap** satisfy a **max heap property**:
For every node i other than the root, the value in the parent of node i is greater than or equal  
to the value in node i.
**min-heap** satisfy a **min heap property**:
For every node i other than the root, the value in the parent of node i is less than or equal to  
the value in node i.

**Question?**
1.Suppose that an array a[] is a max-heap that contains the distinct integer keys 1,2,...,N with
N >= 7. The key N must be in a[1] and the key N-1 must be in either a[2] or a[3]. Where must be
the key N-2 be?
---2,3,4,5,6 or 7
analysis: a[1] is the root, so it's biggest, N-1 should be the children, N-2 will also be children,
no matter the position except not a[1]  
2.How many compares does bottom-up(sink-based) heap construction perform in the worst  
case when sorting an array of n keys?
not [linearithmic](https://en.wikipedia.org/wiki/Time_complexity#Linearithmic_time):  
Inserting n keys one-at-a-time into a binary heap would require a linearithmic  
number of compares. The bottom-up construction has a superior worst-case running time.  
Right answer:linear (As stated in lecture, the bottom-up version of heapsort makes ~2n  
compares in the worst case.)  [reference](http://algs4.cs.princeton.edu/24pq/index.php#Ex2.4.20)

**Heapsort**
Heapsort is optimal for both time and space, but may not use too much due to:     
(1)Inner loop longer than quicksort's, like mergesort, more things to do: compare  
children bigger... So there are 2 compares that get done at NlgN times, then there   
are some array index arithmetic.
(2)Makes poor use of cache memory. it doesn't have local memory reference, it goes down  
the tree.
(3)Not stable. It does long distance exchanges that might bring items that have equal keys
back out of order.

**Loitering Object**
As we know, Java has the advantage to create an environment that eliminated the memory management
problems(such as buffer overruns, de-referencing invalid pointers, and memory leaks). however, the  
responsibility of managing a finite memory resource has not been eliminated. Ill-designed Java  
applications can exhibit the same macro-level symptoms (that of a continually growing process size)  
as traditional memory leaks. This undesirable memory growth is a consequence of unintentionally  
retaining references to objects that have outlived their usefulness to the application.    
Object loitering: a form of memory leak. 
For example:    
Class that exhibits “object loitering”   
    // BAD CODE - DO NOT EMULATE
    public class LeakyChecksum {
        private byte[] byteArray;
        
        public synchronized int getFileChecksum(String fileName) {
            int len = getFileSize(fileName);
            if (byteArray == null || byteArray.length < len)
                byteArray = new byte[len];
            readFileContents(fileName, byteArray);
            // calculate checksum and return it
        }
    }
The decision to cache the buffer most likely followed from the assumption that it would be called  
many times within a program and that it would therefore be more efficient to reuse the buffer rather  
than reallocate it. But as a result, the buffer is never released because it is always reachable by  
the program (unless the LeakyChecksum object is garbage collected). Worse, while it can grow, it   
cannot shrink, so LeakyChecksum permanently retains a buffer as large as the largest file processed.  
At the very least, this puts pressure on the garbage collector and requires more frequent collections;  
keeping a large buffer around for the purpose of computing future checksums may not be the most efficient  
use of available memory.
The cause of the problem in LeakyChecksum is that the buffer is logically local to the getFileChecksum()  
operation, but its lifecycle has been artificially prolonged by promoting it to an instance field. As a   
result, the class has to manage the lifecycle of the buffer itself rather than letting the JVM do it.

[reference1](http://www.ibm.com/developerworks/library/j-jtp01246/ "reference1")
[reference2](https://adtmag.com/articles/2001/02/05/loitering-objects-and-java-framework-design.aspx)

Garbage collection is intended to remove the cause for classic memory leaks: unreachable-but-not-deleted   
objects in memory. However, this works only for memory leaks in the original sense. It’s possible to have  
unused objects that are still reachable by an application because the developer simply forgot to dereference  
them. Such objects cannot be garbage-collected. Even worse, such a logical memory leak cannot be detected by  
any software
[how does garbage collection work?](https://www.dynatrace.com/resources/ebooks/javabook/how-garbage-collection-works/)

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


---
layout: post
title: Algorithm---Sorting
categories: [blog ]
tags: [study,java,sort, ]
description: Good algorithm is much more efficienet than spending more money and time
---  

### MergeSort
**idea:** Taking 2 subhalves of an array using an auxilliary array, move them out and then
put them back in sorted order.
**prototype** Divide and Conquer: give a problem by dividing it into two halves, solving into 
two halves and then putting the solutions together to get the appropriate answer.

How many compares does mergesort-the pure version without any optimizations-make to sort an input
array that is already sorted?
-linearithmic (it makes (1/2)NlgN compares, which is the best case for mergesort. We note that
the optimized version that checks whether a[mid]<=a[mid+1] only requires ~N compares)
### Assertions
Try to use it:
-1. it detects the debug
-2. it documents what should do, 

### Quicksort with 3-way partition

Picture an array:

3, 5, 2, 7, 6, 4, 2, 8, 8, 9, 0
A two partition Quick Sort would pick a value, say 4, and put every element greater than 4 on one side of the array and every element less than 4 on the other side. Like so:

3, 2, 0, 2, 4, | 8, 7, 8, 9, 6, 5
A three partition Quick Sort would pick two values to partition on and split the array up that way. Lets choose 4 and 7:

3, 2, 0, 2, | 4, 6, 5, 7, | 8, 8, 9
It is just a slight variation on the regular quick sort.

You continue partitioning each partition until the array is sorted. The runtime is technically nlog3(n) which varies ever so slightly from regular quicksort's nlog2(n).

[Function Pointers in C](http://www.cprogramming.com/tutorial/function-pointers.html "Function Pointers in C")

**linearithmic**

(computer science, of a procedure) Taking up to time proportional to n log(n) to run on inputs of size n.

**logarithm**
In mathematics, the logarithm is the inverse operation to exponentiation. That means the logarithm of a number is the exponent to which another fixed number, the base, must be raised to produce that number. In simple cases the logarithm counts repeated multiplication. For example, the base 10 logarithm of 1000 is 3, as 10 to the power 3 is 1000 (1000 = 10 × 10 × 10 = 103);


**Shuffling a linkedlist** 
[reference](http://stackoverflow.com/questions/12167630/algorithm-for-shuffling-a-linked-list-in-n-log-n-time "reference")

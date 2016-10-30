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

---
layout: post
title: Algorithm---Sorting
categories: [blog ]
tags: [study,java,sort,priorityQueue ]
description: Good algorithm is much more efficienet than spending more money and time
---  

**Questions**
1. What is the expected number of array accesses and compares, respectively, to insert  
a random key into an ordered-array implementation of a priority queue?  
-linear and logarithmic 
-analysis: we can use binary search to find the insertion point using a logarithmic number   
of compares. On average, the key to be inserted must be placed in the middle of the array   
to keep the array in order, we must shift over all larger keys.  


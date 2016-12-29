---
layout: post
title: Algorithm---Balanced Search Tree
categories: [blog ]
tags: [study,java,search]
description: Good algorithm is much more efficienet than spending more money and time
---  

[reference](http://algs4.cs.princeton.edu/33balanced/)

**B-tree**  
B-tree is not binary tree, instead, it is a generalization of a binary search tree in that  
a node can have more than two children.    
It is optimized for systems to read and write large blocks of data, which is commonly used  
in databases and filesystems.   
![B-tree](https://upload.wikimedia.org/wikipedia/commons/6/65/B-tree.svg)  
**B+ tree**  
A general class variation of B-tree. In the B+ tree, copies of the keys are stored in the   
internal nodes; the keys and records are stored in leaves; in addition, a leaf node may  
include a pointer to the next leaf node to speed sequential access.   

**Hibbard Deletion**  
To delete a node that has 2 children:   
To delete a node x by replacing it with its successor. Because x has a right child, its  
successor is the node with the smallest key in its right subtree. The replacement preserves  
order in the tree because there are no keys between x.key and the successor's key.   
![Hibbard Deletion](https://qph.ec.quoracdn.net/main-qimg-7836b5ffbb3bb03596c95cd07ef6a6f1?convert_to_webp=true)

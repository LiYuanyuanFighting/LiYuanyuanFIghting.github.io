
---
layout: post
title: Java Problem3---Pattern Recognition
categories: [blog ]
tags: [study,java,sort,]
description: 
--- 

 **Double and double**
 Double is a wrapper class,
The Double class wraps a value of the primitive type double in an object. An object of type Double contains
a single field whose type is double.

In addition, this class provides several methods for converting a double to a String and a String to a double,
as well as other constants and methods useful when dealing with a double.
The double data type,

The double data type is a double-precision 64-bit IEEE 754 floating point. Its range of values is 
4.94065645841246544e-324d to 1.79769313486231570e+308d (positive or negative). For decimal values, this data
type is generally the default choice. As mentioned above, this data type should never be used for precise values,
such as currency

java.util.List is a raw type. References to generic type java.util.List<E> should be parameterized

**raw type**
[reference](http://stackoverflow.com/questions/2770321/what-is-a-raw-type-and-why-shouldnt-we-use-it)

**dynamic array**
To create dynamic array, should use ArrayList (or other array object who can handle any number of objects). A java array always has a fixed length since some memory will be reserved for the array.

**array length**
if I create an array like this: 
Object[] array = new Object[100];
then if I use array.length, the length will be 100 no matter the elements of the array are null or not...

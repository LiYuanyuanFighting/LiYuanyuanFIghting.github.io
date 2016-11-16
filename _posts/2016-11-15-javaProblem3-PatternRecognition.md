
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

**ICAST_IDIV_CAST_TO_DOUBLE**

Description

ICAST: integral division result cast to double or float 
This code casts the result of an integral division (e.g., int or long division) operation to double or float. Doing division on integers truncates the result to the integer value closest to zero. The fact that the result was cast to double suggests that this precision should have been retained. What was probably meant was to cast one or both of the operands to double before performing the division. 
兩個整數相除會使得結果先為整數再為double。以2/5而言，結果會變為0，5/2會為2。

Solution

將分母轉型為double或float。

Example

Before:

	public double div(int a, int b){
		return a / b;
	}
After:

	public double div(int a, int b){
		return a / (double)b;
	}

**Dead Code**
In computer programming, dead code is a section in the source code of a program which is executed but whose result is never used in any other computation.

**Chapter2  R and High-Performance Computing**  
Tasks done:
(1)install an add-on package [dplyr9](http://genomicsclass.github.io/book/pages/dplyr_tutorial.html)
(dplyr is a powerful R-package to transform and summarize tabular data with rows and columns.)  


**Tips**  
(1) To get help:  
help.start()  
Use browsable help index:  
help(package="dplyr") help(name) ?name e.g. ?group_by  
When you don't know an exact name, e.g: help.search("histogram")  
This command will search your local R installation for functions approximately matching the character string  
"histogram" in the (file) name, alias, title, concept, or keyword entries.  
Search engine used:  
RSiteSearch("group by factor") This reports all search results for the character string "group by factor"
(2) To load dataset:  
data(Cars93, package="MASS") e.g. load Cars93 dataset from package MASS  
(3) To list all objects with partial name e.g match of hist  
apropos("hist")

**Terms**  
(1)Workspace:  
The collection of all created objects  

**Commands**  
ls() getwd(): show the current working directoy  

**Data types**  
°numeric
°character  
°factor  
°logical  
data structures:  
°vector  
°list  
°array  
°data.frame  
°Special data types:missing values(NA), NULL-objects, NaN, -inf, +inf

**Vector**  
To subset vectors, the selection is made using the [] operator, which can be done in 3 d ways:  
° Positive: A vector of positive integers that specifies the position of the desired elements  
° Negative: A vector of nwgative integers indicating the position of the non-required elements  
° Logical: A logic vector in which the elements are to be the selected(TRUE), along with those that are not selected(FALSE)  
```python
> data(Cars93, package = "MASS")
> hp <- Cars93[1:10, "Horsepower"]
> hp
 [1] 140 200 172 172 208 110 170 180 170 200
> #positive indexing:
> hp[c(1, 6)]
[1] 140 110
> hp[-c(1, 6)]
[1] 200 172 172 208 170 180 170 200
> #logical indexing
> hp < 150
 [1]  TRUE FALSE FALSE FALSE FALSE  TRUE FALSE FALSE FALSE FALSE
> #a logical expression can be written directly in []
> hp[hp<150]
[1] 140 110
``` 
**Factors**  
They are used to represent nominal(unreordered factor) or ordinal(ordered factor) data.  
**list**  
ordered collection of objects whereas each object is part of the list and where the data types of the  
individual list elements can be different(vectors, matrices, data.frames, lists, and so on).  
**data.frame**  
Data fraomes are the most important data type. They correspond to the rectangle data format that is well-known from other software   
packages, with rows corresponding to observation units and columns to variables.  
```python
## extract cars with small number of cylinders and small power
> w <- Cars93$Cylinders %in% c("3", "4") & Cars93$Horsepower <80
> str(Cars93[w, ])
```
head(), the first(default 6) rows of a data frame, and colnames(), the columns/variable names  
**array**  
An array in R can have multiple dimensions. A vector is one-dimensional array, a matrix is a two-dimensional array,  
having rows and columns.  
```python
> library("vcd")
Loading required package: grid
> data(PreSex)
> PreSex
, , PremaritalSex = Yes, Gender = Women

             ExtramaritalSex
MaritalStatus Yes  No
     Divorced  17  54
     Married    4  25

, , PremaritalSex = No, Gender = Women

             ExtramaritalSex
MaritalStatus Yes  No
     Divorced  36 214
     Married    4 322

, , PremaritalSex = Yes, Gender = Men

             ExtramaritalSex
MaritalStatus Yes  No
     Divorced  28  60
     Married   11  42

, , PremaritalSex = No, Gender = Men

             ExtramaritalSex
MaritalStatus Yes  No
     Divorced  17  68
     Married    4 130

> 
```
We see that the 1st dimension is MaritalStatus, the second is ExtramaritalSex, the third is PremaritalSex,  
and the fourth is Gender.  
We can access the elements of the array by indexing using [].e.g, extract the data where PremaritalSex is Yes, Gender is Men:  
```python
> PreSex[, , 1, 2]
             ExtramaritalSex
MaritalStatus Yes No
     Divorced  28 60
     Married   11 42
## or by name:
> PreSex[, , "Yes", "Men"]
             ExtramaritalSex
MaritalStatus Yes No
     Divorced  28 60
     Married   11 42
```

**Missing values**  
To check if data values are missing: is.na  
it returns a logical vector or data.frame depending on whether the input is a vector or data.frame.  
To calculate the number of missing values, we could sum the TRUE's(interpreted as 1 while FALSE is interpreted as 0):   
```python
> sum(is.na(Cars93))
[1] 13  
```  
To analyze the structure of any missing values, the R package VIM can be used. matrixplot show all the values of the whole data  
frame. The darker the higher the values. Missing values are in red.  
```python  
> require("VIM")
> matrixplot(Cars93, sortby = "Weight", cex.axis=0.6)  

****

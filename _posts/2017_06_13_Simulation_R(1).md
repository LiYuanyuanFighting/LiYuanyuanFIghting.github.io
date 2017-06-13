**Chapter2-R and High-Performance Computing**  
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
'''  
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
'''  

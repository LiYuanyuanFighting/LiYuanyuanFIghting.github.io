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

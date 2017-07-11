**R and High-Performance Computing**  

**Data manipulation in R**  

**Apply**  
apply family can manipulate slices of data from matrices, arrays, lists and data frames in a repetitive manner.  
e.g. To apply a function over the second dimension of this data set. 
```r
> func <- function(x) {return (sum(is.na(x)))}
> na <- apply(X=Cars93, MARGIN=2, FUN=func)
> na
      Manufacturer              Model               Type          Min.Price 
                 0                  0                  0                  0 
             Price          Max.Price           MPG.city        MPG.highway 
                 0                  0                  0                  0 
           AirBags         DriveTrain          Cylinders         EngineSize 
                 0                  0                  0                  0 
        Horsepower                RPM       Rev.per.mile    Man.trans.avail 
                 0                  0                  0                  0 
Fuel.tank.capacity         Passengers             Length          Wheelbase 
                 0                  0                  0                  0 
             Width        Turn.circle     Rear.seat.room       Luggage.room 
                 0                  0                  2                 11 
            Weight             Origin               Make 
                 0                  0                  0 
> na[na>0]
Rear.seat.room   Luggage.room 
             2             11 
> 
```
The apply call is basically the same as the foor loop.  
> p <- ncol(Cars93)
> na_for <- numeric(p)
> for (i in 1:p){
+  na_for[i] <- func(Cars93[, i])
+ }
> identical(as.numeric(na), na_for)
[1] TRUE  

lapply accesses the length of each list element:  
> lapply(na[na>0], length)
$Rear.seat.room
[1] 1

$Luggage.room
[1] 1  


**dplyr**  
-Creating a local data frame tbl_df  
```r  
> library("dplyr")  
> Cars93<-tbl_df(Cars93)
> class(Cars93)
[1] "tbl_df"     "tbl"        "data.frame"
> print(Cars93)
```  

-Selecting lines slice() which can select rows according to their line number  
```r
> slice(Cars93, 1)
```  
c() creates a vector from input numbers, n() returns the number of observation. We will select the 1, 4, 10, 15  
and the last line of the data.  
```r
> slice(Cars93, c(1, 4, 10, 15, n()))
```  

-filter() can select rows that satisfy a condition  
```r
> filter(Cars93, Manufacturer=="Audi" & Min.Price>25)  
```  

Order
-arrange() can sort the data by one or more variables, by default, it is sorted in ascending order, with desc() descending:  
```r  
> Cars93 <- arrange(Cars93, Price)
```  
Sort by mutiple variables:  
```r  
> Cars93 <- arrange(Cars93, desc (MPG.city), Max.Price)
> head(Cars93, 7)
```   

Selecting columns  
-select() select variables from the data set:  
```r
> head (select (Cars93, Manufacturer:Price), 3)  
```  
For a sequence of variables, can use the operator :  
> head (select (Cars93, Manufacturer:Price), 3)  

Negative indexing is possible, while all variables with the letter prefix minus(-) are excluded:  
```r
> select (Cars93, -Min.Price, -Max.Price)  
```
starts_with  
```r
> head (select (Cars93, starts_with ("Man")), 3)  
```
contains  
```r
> head (select (Cars93, contains ("Price")), 3)  
```
rename  
```r
> head (select (Cars93, myPrize = Price, Min.Price))
# A tibble: 6 x 2
  myPrize Min.Price
    <dbl>     <dbl>
```  

Uniqueness  
distinct() can be used to keep only unique rows  
dim() function gets or sets the dimension of a matrix, array or data frame.  
e.g  
```r  
> dim( distinct(Cars93, Manufacturer) )
[1] 32  1
> dim( distinct(Cars93, Manufacturer, EngineSize) )
[1] 79  2
#second is rounded
> distinct(Cars93, Manufacturer, rr=round(EngineSize)) 
# A tibble: 57 x 2
   Manufacturer    rr
         <fctr> <dbl>
```  
Creating variables  
mutate() can add new variables and retains the old variables  
```r
> m <- mutate(Cars93, is_ford = Manufacturer == "Ford")
> m[1:3, c(1, 28)]
```  
Function transmute() retains only the listed variables  

Grouping and aggregates   
```r
> by_type <- group_by (Cars93, Type)
> summarize (by_type, count=n(), min_es = min(EngineSize), max_es = max(EngineSize))
``` 

Window functions  
> Cars93 %>%
+  group_by(Type) %>% 
+  arrange(Type) %>%
+  select (Manufacturer:Price) %>%
+  mutate(cmean=cummean(Price), csum=cumsum(Price))
#A tibble: 93 x 7
#Groups:   Type [6]
   Manufacturer    Model    Type Min.Price Price    cmean  csum
         <fctr>   <fctr>  <fctr>     <dbl> <dbl>    <dbl> <dbl>
 1        Mazda      626 Compact      14.3  16.5 16.50000  16.5
 2    Chevrolet  Corsica Compact      11.4  11.4 13.95000  27.9
 3    Chevrolet Cavalier Compact       8.5  13.4 13.76667  41.3
 4   Oldsmobile  Achieva Compact      13.0  13.5 13.70000  54.8
 5       Nissan   Altima Compact      13.0  15.7 14.10000  70.5
 6        Honda   Accord Compact      13.8  17.5 14.66667  88.0
 7      Pontiac  Sunbird Compact       9.4  11.1 14.15714  99.1
 8     Chrysler  LeBaron Compact      14.5  15.8 14.36250 114.9
 9       Subaru   Legacy Compact      16.3  19.5 14.93333 134.4
10         Ford    Tempo Compact      10.4  11.3 14.57000 145.7
#... with 83 more rows

**High performance computing**  
To measure which lines of code take the most computation time:  
system.time  
the user time is the CPU time for the call and evaluation of the code. The elabsed time  
is the sum of the user time and the system time.  
proc.time  

**Calculate groupwise**
After loading these packages:  
```r
library(microbenchmark); library(plyr); library(dplyr); library(data.table); library(Hmisc);
```  
The task is to calculate the groupwise(Type, Origin) means of Horsepower.
```r
> data(Cars93, package="MASS")
> Cars93 %>% group_by(Type, Origin) %>% summarise(mean = mean(Horsepower))
```

**Parallel Computing**  
makeCluster  
clusterCall(cl = NULL, fun, ...) calls a function fun with identical arguments ... on each node.  
clusterEvalQ evaluates a literal expression on each cluster node. It is a parallel version of evalq, and is a convenience function invoking clusterCall.  

**The graphics system in R**  
The graphics package  
High-level graphics functions: open a device and create a plot  
for example, plot()  
Low-level: Add output to existing graphics  
points()  
Interactive: Allow interaction with graphical output  
identify()  
```r
> x <- 1:20 / 2 
> x
 [1]  0.5  1.0  1.5  2.0  2.5  3.0  3.5  4.0  4.5  5.0  5.5  6.0  6.5  7.0  7.5
[16]  8.0  8.5  9.0  9.5 10.0
> y <- sin(x)
> y
 [1]  0.47942554  0.84147098  0.99749499  0.90929743  0.59847214  0.14112001
 [7] -0.35078323 -0.75680250 -0.97753012 -0.95892427 -0.70554033 -0.27941550
[13]  0.21511999  0.65698660  0.93799998  0.98935825  0.79848711  0.41211849
[19] -0.07515112 -0.54402111
> plot(x, y, pch=16, cex=10*abs(y), col= grey(x/14))
> text(x, y, 1:20, col="yellow")
> curve(sin, -2*pi, 4*pi, add=TRUE, col="red")
> abline(h=0, lty=2, col="grey")

```
[result](http://i.imgur.com/OifiTei.png)

**ggplot2**  
In ggplot2, the parts of a plot are defined independently. The anatomy of a plot consists of:  
(1)data, must be a data frame(objects of class data.frame);
(2)aesthetic mapping, which describes how variables in the data are mapped to visual propertities(aesthetics)  
of geometric objects.---> done within the function aes();
assignment, where values are mapped to visual propertities. It must also be done outside  
the function aes(). geometric objects(geom's, aesthetic will be mapped to geometric objects), e.g,  
geom_point() - statistical transformations, e.g, function stat_boxplot(), scales, coordinate system, position  
adjustments, and faceting, e.g, function facet_wrap.  

aes(): aesthetic mapping to geometric objects.  
```r
> library("ggplot2")
> ggplot(Cars93, aes(x=Horsepower, y=MPG.city)) + geom_point(aes(colour=Cylinders))
> gq <- ggplot(Cars93, aes(x=Horsepower, y=MPG.city))
> g2 <- gq+geom_point(aes(color=Weight))
> g2 + geom_smooth()
`geom_smooth()` using method = 'loess'

> g1 <- gq+geom_text(aes(label=substr(Manufacturer, 1, 3)), size=3.5)
> g1 + geom_smooth()
`geom_smooth()` using method = 'loess'

> gg <- ggplot(Cars93, aes(x=Horsepower, y=MPG.city))
> gg <- gg+geom_point(aes(shape=Origin, colour=Price))
> gg <- gg+facet_wrap(~ Cylinders) + theme_bw()
> gg
```


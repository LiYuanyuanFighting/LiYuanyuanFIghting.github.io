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

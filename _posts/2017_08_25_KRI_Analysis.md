1st preprocessing data on EXCEL:  
1. create a new column based on existing column: insert a function  
=IF(H2<=30, "insignificant", IF(H2<=60, "minor", IF(H2<=120, "Moderate", "Major")))  
2. split modes:  
Data-> Filter, then appear dropdown menu
3. Used rapidMiner:  
[Decision Tree Analysis](http://i.imgur.com/QrYPDLk.png)    
[Decision Tree Result](http://i.imgur.com/42tOnNy.png)  
Then realized, just doing feature selection is enough. Now check how to do it in R:  
Following the [article](https://www.analyticsvidhya.com/blog/2016/03/select-important-variables-boruta-package/)  




  
[FACTOR VARIABLES | R LEARNING MODULES](https://stats.idre.ucla.edu/r/modules/factor-variables/): There are a number  
of advantages to converting categorical variables to factor variables. For example,  
```r
ses <- c("low", "middle", "low", "low", "low", "low", "middle", "low", "middle",
    "middle", "middle", "middle", "middle", "high", "high", "low", "middle",
    "middle", "low", "high")    
levels(ses.f.bad.order)  
##[1] "high"   "low"    "middle"
```

The result is ordered in alphabetic order, so we should create a new factor variable called ses.f with the correct   
order of categories.  

```r
> convert <- c(2:6, 11:13)
> traindata[,convert] <- data.frame(apply(traindata[convert], 2, as.factor))
```
This should mean apply the 2 columns as factor  
```r
> dim(traindata)
[1] 36  7
traindata[1:36, 4:5] #the header is not taken into account  
> cols <- c("season", "class")
> traindata[,convert] <- data.frame(apply(traindata[cols], 2, as.factor))
Error in `[<-.data.frame`(`*tmp*`, , convert, value = list(season = c(1L,  : 
  duplicate subscripts for columns
```    
Problems met, needed to be solved  
https://machinelearningmastery.com/feature-selection-with-the-caret-r-package/

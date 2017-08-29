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

Solved  
> traindata[,cols] <- data.frame(apply(traindata[cols], 2, as.factor))
> class(traindata$season)
[1] "factor"  

Interesting website found:  
https://datahack.analyticsvidhya.com/contest/practice-problem-loan-prediction/#solution_checker     

[Meaning of ~.](https://stackoverflow.com/questions/14976331/use-of-tilde-in-r-programming-language)  

```r  
> boruta.train <- Boruta(class~., data=traindata, doTrace=2) #class~. here should mean class depends on all other attributes  
 1. run of importance source...
 2. run of importance source...
 3. run of importance source...
 4. run of importance source...
 5. run of importance source...
 6. run of importance source...
 7. run of importance source...
 8. run of importance source...
 9. run of importance source...
 10. run of importance source...
After 10 iterations, +0.33 secs: 
 rejected 3 attributes: agency, season, startHour;
 still have 3 attributes left.

 11. run of importance source...
 12. run of importance source...
 13. run of importance source...
 14. run of importance source...
After 14 iterations, +0.39 secs: 
 rejected 1 attribute: arrival;
 still have 2 attributes left.

 15. run of importance source...
 16. run of importance source...
 17. run of importance source...
 18. run of importance source...
 19. run of importance source...
 20. run of importance source...
After 20 iterations, +0.47 secs: 
 rejected 1 attribute: departure;
 still have 1 attribute left.

 21. run of importance source...
 22. run of importance source...
 23. run of importance source...
 24. run of importance source...
 25. run of importance source...
 26. run of importance source...
After 26 iterations, +0.55 secs: 
 rejected 1 attribute: endHour;
 no more attributes left.
 
 > print (boruta.train)
Boruta performed 57 iterations in 0.7313249 secs.
 No attributes deemed important.
 6 attributes confirmed unimportant: agency, arrival, departure, endHour, season and 1
more;
```
Then I modified the csv file, to make season relevant:    
```r
> getConfirmedFormula(boruta.train)
class ~ season
<environment: 0x000000000acff790>  
```  

After that, I test with more precise action(select data only for a certain leg):  
1.select data satisfied a certain condition from the full csv file:  
```r
> library(sqldf)
> traindataFull <- read.csv("D:/docs/database/historyTimeDeviationDetail.csv", header=T, stringsAsFactors=F)
> write.csv(traindataFull, "tempFull.csv", quote=FALSE, row.names=FALSE) #a temporary file will be created  
> traindataFull2 <- read.csv.sql("tempFull.csv", sql="select * from file where departure='Milan' and arrival='Bari'", eol="\n")
> traindataFull2
  departure arrival          agency mode startHour endHour season timeDeviation   class
1     Milan    Bari Demo Synchronet  BUS         0      11 Summer            49 minor\r
2     Milan    Bari Demo Synchronet  BUS        17       4 Summer            57 minor\r
3     Milan    Bari Demo Synchronet  BUS        21       8 Summer            45 minor\r
> 
```
2.do the feature selection  
```r
> traindataFull2[,cols] <- data.frame(apply(traindataFull2[cols], 2, as.factor))
> boruta.train <- Boruta(class~.-timeDeviation, data=traindataFull2, doTrace=2)
```
Repeate the full steps:  
```r
> traindataFull <- read.csv("D:/docs/database/historyTimeDeviationDetailFake.csv", header=T, stringsAsFactors=F)
> write.csv(traindataFull, "tempFull.csv", quote=FALSE, row.names=FALSE)
>  traindataFull <- read.csv.sql("tempFull.csv", sql="select * from file where departure='Milan' and arrival='Bari'")#, eol="\n")
> traindataFull[,cols] <- data.frame(apply(traindataFull[cols], 2, as.factor))
> boruta.train <- Boruta(class~.-timeDeviation, data=traindataFull, doTrace=2)
```
Because the method I used couldn't detect the most important feature for a link as I thought, I decide to  
try another method, i.e. traditional feature selection algorithm.  
[explanation of each parameter](https://www.rdocumentation.org/packages/caret/versions/6.0-76/topics/rfe)  
not working version:  
```r
> traindataFull <- read.csv("D:/docs/database/historyTimeDeviationDetailFake.csv", header=T, stringsAsFactors=F)
> write.csv(traindataFull, "tempFull.csv", quote=FALSE, row.names=FALSE)
> traindataFull2 <- read.csv.sql("tempFull.csv", sql="select * from file where departure='Paris' and arrival='Milan'")
> traindataFull2
> convert <- c(1:4, 7, 9)
> traindataFull2[,convert] <- data.frame(apply(traindataFull2[convert], 2, as.factor))
> rfe.train <- rfe(traindataFull2[,1:7], traindataFull2[,9], sizes=1:7, rfeControl=control)
Error in { : task 2 failed - "Can't have empty classes in y."
In addition: Warning messages:
1: In UseMethod("levels") : closing unused connection 8 (tempFull.csv)
2: In UseMethod("levels") : closing unused connection 7 (tempFull.csv)
3: In UseMethod("levels") : closing unused connection 6 (tempFull.csv)
4: In UseMethod("levels") : closing unused connection 5 (tempFull.csv)
5: In UseMethod("levels") : closing unused connection 4 (tempFull.csv)
6: In UseMethod("levels") : closing unused connection 3 (tempFull.csv)
> rfe.train <- rfe(traindataFull2[,3:7], traindataFull2[,9], sizes=1:7, rfeControl=control)
Error in { : task 2 failed - "Can't have empty classes in y."

```
Then added the last season: winter, test with Boruta again:  
```r
>  boruta.train <- Boruta(class~.-timeDeviation, data=traindataFull2, doTrace=1)
After 10 iterations, +0.12 secs: 
 rejected 5 attributes: agency, arrival, departure, mode, startHour;
 still have 2 attributes left.

After 14 iterations, +0.16 secs: 
 rejected 1 attribute: endHour;
 still have 1 attribute left.
 
 > final.boruta <- TentativeRoughFix(boruta.train)
> print(final.boruta)
Boruta performed 99 iterations in 1.160307 secs.
Tentatives roughfixed over the last 99 iterations.
 1 attributes confirmed important: season;
 6 attributes confirmed unimportant: agency, arrival, departure, endHour, mode and 1 more;
 
 > getSelectedAttributes(final.boruta, withTentative = T)
[1] "season"
```  


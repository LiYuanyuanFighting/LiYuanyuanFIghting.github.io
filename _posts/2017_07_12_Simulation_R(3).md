### The Discrepancy between Pencil-Driven Theory and Data-Driven Computation Solutions  

**Convergence**
We say that an iterative algorithm has been converged when the expected value is below a   
(samll and problem-dependent) threshold.
```r
> masch <- function(maxit=10000) {
+ summe <- 0
+ summeNeu <- n <- 1
+ ptm <- proc.time()
+ while(summe != summeNeu & n < maxit) {
+ summe <- summeNeu
+ summeNeu <- summe + 1/n
+ n <- n+1
+ }
+ time <- proc.time() - ptm
+ list(summe=summeNeu, time=time[3])
+ }
> masch(10000)$summe
[1] 10.78751
> masch(1000000)$summe
[1] 15.39273
> masch(10000000)$summe
[1] 17.69531
```
Thus, you may not be able to decide on a computer whether this series diverges. We can also see that  
the number calculated increases nonlinearly with the number of recursions.    
In R, one should be aware that printing a result does not mean that you see the exact number. It's just  
rounded off on given digits(default=7), but internally, the numbers are saved with more digits.

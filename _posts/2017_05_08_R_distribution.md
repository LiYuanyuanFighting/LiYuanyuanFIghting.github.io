**Simulate Bimodal Distribution in R**  
```r
mu1 <- log(1)   
mu2 <- log(50)
sig1 <- log(3)
sig2 <- log(3)
cpct <- 0.4   

bimodalDistFunc <- function (n,cpct, mu1, mu2, sig1, sig2) {
  y0 <- rlnorm(n,mean=mu1, sd = sig1)
  y1 <- rlnorm(n,mean=mu2, sd = sig2)

  flag <- rbinom(n,size=1,prob=cpct)
  y <- y0*(1 - flag) + y1*flag 
}

bimodalData <- bimodalDistFunc(n=100,cpct,mu1,mu2, sig1,sig2)
hist(log(bimodalData), breaks=100)
```

```r
> n = 100
> cpct = 0.6
> shape = 20
> scale = 1.2
> mu1 = 3
> sig1 = log(3)
> bimodalDistFunc <- function (n,cpct, mu1, shape, sig1, scale) {
+   y0 <- rnorm(n,mean=mu1, sd = sig1)
+   y1 <- rgamma(n,shape=mu2, scale = scale)
+ 
+   flag <- rbinom(n,size=1,prob=cpct)
+   y <- y0*(1 - flag) + y1*flag 
+ }
> bimodalData= bimodalDistFunc(n, cpct, mu1, shape, scale, sig1)
>

```

**To draw 2 density distributions in one figure**  
```r
> plot(density(rs$timeDeviation), ylim=c(0, 1))
> lines(density(bimodalData), col="red")
```

**Plot gamma distribution**  
```r
- seq(0,20, .1)
> plot(x, dgamma(x, scale=2, shape=1), type="l", ylim=c(0,.5), ylab="y")
> for(shape in 2:8){
+   lines(x, dgamma(x, scale=2, shape=shape), col=shape)
+ }
> plot(x, dgamma(x, scale=20, shape=1.2), type="l", ylim=c(0,.5), ylab="y")
> for(shape in 2:8){
+   lines(x, dgamma(x, scale=2, shape=shape), col=shape)
+ }
> x
  [1]  0.0  0.1  0.2  0.3  0.4  0.5  0.6  0.7  0.8  0.9  1.0  1.1  1.2  1.3  1.4
 [16]  1.5  1.6  1.7  1.8  1.9  2.0  2.1  2.2  2.3  2.4  2.5  2.6  2.7  2.8  2.9
 [31]  3.0  3.1  3.2  3.3  3.4  3.5  3.6  3.7  3.8  3.9  4.0  4.1  4.2  4.3  4.4
 [46]  4.5  4.6  4.7  4.8  4.9  5.0  5.1  5.2  5.3  5.4  5.5  5.6  5.7  5.8  5.9
 [61]  6.0  6.1  6.2  6.3  6.4  6.5  6.6  6.7  6.8  6.9  7.0  7.1  7.2  7.3  7.4
 [76]  7.5  7.6  7.7  7.8  7.9  8.0  8.1  8.2  8.3  8.4  8.5  8.6  8.7  8.8  8.9
 [91]  9.0  9.1  9.2  9.3  9.4  9.5  9.6  9.7  9.8  9.9 10.0 10.1 10.2 10.3 10.4
[106] 10.5 10.6 10.7 10.8 10.9 11.0 11.1 11.2 11.3 11.4 11.5 11.6 11.7 11.8 11.9
[121] 12.0 12.1 12.2 12.3 12.4 12.5 12.6 12.7 12.8 12.9 13.0 13.1 13.2 13.3 13.4
[136] 13.5 13.6 13.7 13.8 13.9 14.0 14.1 14.2 14.3 14.4 14.5 14.6 14.7 14.8 14.9
[151] 15.0 15.1 15.2 15.3 15.4 15.5 15.6 15.7 15.8 15.9 16.0 16.1 16.2 16.3 16.4
[166] 16.5 16.6 16.7 16.8 16.9 17.0 17.1 17.2 17.3 17.4 17.5 17.6 17.7 17.8 17.9
[181] 18.0 18.1 18.2 18.3 18.4 18.5 18.6 18.7 18.8 18.9 19.0 19.1 19.2 19.3 19.4
[196] 19.5 19.6 19.7 19.8 19.9 20.0
> 2:8
[1] 2 3 4 5 6 7 8   
```

**Plot pnorm**  
```r
> x <- seq(-100, 100, by=1)
> y <- pnorm(x, mean=20, sd=40)
> plot(x, y)
```

**Compare 2 distributions**  
[Kolmogorov-Smirnov test](http://bbs.bioguider.com/home-space-uid-2-do-blog-id-1079.html) 
KS test checks if two independent distributions are similar or different, by generating cumulative probability plots for two distributions and finding the distance along the y-axis for a given x values between the two curves. From all the distances calculated for each x value, the maximum distance is searched.  
[result parameter analysis](http://blog.sina.com.cn/s/blog_403aa80a01019ly5.html)

**pnorm**  
The function pnorm returns the integral from −∞−∞ to qq of the pdf of the normal distribution where qq is a Z-score. Try to guess the value of  pnorm(0). (pnorm has the same default mean and sd arguments as dnorm).  
It is comulative distribution function
[reference](http://seankross.com/notes/dpqr/)

**dnorm**  
probability distriution function

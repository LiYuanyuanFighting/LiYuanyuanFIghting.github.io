[How to calculate cumulative distribution in R?](https://stats.stackexchange.com/questions/30858/how-to-calculate-cumulative-distribution-in-r)  
The ecdf function applied to a data sample returns a function representing the empirical cumulative distribution function. For example:

> X = rnorm(100) # X is a sample of 100 normally distributed random variables
> P = ecdf(X)    # P is a function giving the empirical CDF of X
> P(0.0)         # This returns the empirical CDF at zero (should be close to 0.5)
[1] 0.52
> plot(P)        # Draws a plot of the empirical CDF (see below)

ecdf(x)  
Compute an empirical cumulative distribution function, with several methods for plotting, printing and computing
with such an “ecdf” object.

**density distribution**  
> d <- density(rs$timeDeviation)  
> plot(d)    
> max(d$x)   
[1] 32.66455  
> max(d$y)  
[1] 0.09265631    
[plot]((http://i.imgur.com/n55xe9L.png))   

note: rs is a result set returned by RMySQL, timeDeviation is a column name  
using max(d$x) can get the maximum value in x axis  

In probability theory, a [probability density function (PDF)](https://en.wikipedia.org/wiki/Probability_density_function), or density of a continuous random variable, is a function, whose value at any given sample (or point) in the sample space (the set of possible values taken by the random variable) can be interpreted as providing a relative likelihood that the value of the random variable would equal that sample 

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

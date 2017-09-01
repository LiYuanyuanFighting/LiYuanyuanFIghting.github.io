### Simulation of non-uniform distributed random variables**  
[runif](http://blog.csdn.net/lilanfeng1991/article/details/18505723)   

**The inversion method**  
Let Fv(x) be the distribution function of V. Through the plug-in of a uniform  
random number g~U(0, 1) into the inverse distribution function F-1v(g), we get  
a random number with the distribution V.  

Bernoulli distribution:  
The Bernoulli distribution is a special case of the binomial distribution where a   
single experiment/trial is conducted (n=1). It is also a special case of the two-point  
distribution, for which the outcome need not be a bit, i.e., the two possible outcomes  
need not be 0 and 1.  
```r
> u <- runif(100, 0, 1)
> ifelse(u<=0.2, 0, 1)
  [1] 1 1 1 0 1 1 1 1 1 0 1 1 1 1 1 1 1 1 1 1 1 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1
 [38] 1 1 1 1 1 1 1 1 1 1 1 1 1 0 1 1 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0
 [75] 1 1 0 1 1 1 1 1 1 0 1 1 1 1 1 0 1 1 0 1 1 1 1 1 0 1
```
  
From uniform U(0,1) to Bernouli B(pi=2) distributions. F-1(U) equals 0 for uniform  
random numbers smaller than 0.2, otherwise they are 1
[B(pi=2)](http://i.imgur.com/sTHr7of.png)
**A few words on Markov chains**  
A Markov chain {X(t)} is a sequence of dependent random variables, where the probability  
distribution of {X(t)} give X(0),...,X(t-1) only depends on the previous state X(t-1).  
```r 
#Simple random walk Markov chain:
n <- 10; set.seed(123)
x <- numeric(n)
for(i in 2:n){
  x[i] <- x[i-1] + rnorm(1)
}
```
The conditional probability is called the transition kernel or Markov kernel K:  
X(t+1)|X(0), X(1), X(2), ...,X(t) ~ K(X(t), X(t+1)).  
The Markov kernel K(X(t), X(t+1)) corresponds here to a N(X(t), 1) density, and thus  
the following code is equivalent to the previous one:  
```r
set.seed(123)
x <- numeric(n)
for(i in 2:n){
  x[i] <- rnorm(1, mean = x[i-1])
}
> x
 [1]  0.0000000 -0.5604756 -0.7906531  0.7680552  0.8385636  0.9678513
 [7]  2.6829163  3.1438325  1.8787713  1.1919184
```
We can see that the next state(value) only depends on the previous state(value).  
**Deterministic** means here: follow strict rules to achieve the maxima without any randomness  
included. While the numerical deterministic solution of the problem depends on the analytical  
properties of the objective function h(for example, convexity and smoothness), the stochastic  
approach is of more general use.  

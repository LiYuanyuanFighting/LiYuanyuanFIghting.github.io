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
'''r  
> u <- runif(100, 0, 1)
> ifelse(u<=0.2, 0, 1)
  [1] 1 1 1 0 1 1 1 1 1 0 1 1 1 1 1 1 1 1 1 1 1 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1
 [38] 1 1 1 1 1 1 1 1 1 1 1 1 1 0 1 1 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0
 [75] 1 1 0 1 1 1 1 1 1 0 1 1 1 1 1 0 1 1 0 1 1 1 1 1 0 1
'''   
From uniform U(0,1) to Bernouli B(pi=2) distributions. F-1(U) equals 0 for uniform  
random numbers smaller than 0.2, otherwise they are 1
[B(pi=2)](http://i.imgur.com/sTHr7of.png)

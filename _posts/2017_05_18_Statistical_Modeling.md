**Distribution fitting**  
https://www.spcforexcel.com/knowledge/basic-statistics/distribution-fitting


**mean and variance**  
http://staff.argyll.epsb.ca/jreed/math30p/statistics/standardDeviation.htm  
mean: the average obtained by dividing the sum of the data by the number of data in the set. Given a set of data, {x1, x2, x3, ..., xn}, you can find the mean, , using the following formula:See the link above  
standard deviation: the extent to which data differs from the mean. The standard deviation is a measure of how the data is clustered about the mean. For large sets of data, approximately 68.3% of the data lies within one standard deviation of the mean and approximately 95.4% of the data lies within two standard deviations of the mean.  

**Plot**  
**gamma distribution**  
The Gamma distribution is widely used in engineering, science, and business, to model continuous variables that are always positive and have skewed distributions. In Swedge, the Gamma distribution can be useful for any variable which is always positive, such as cohesion or shear strength for example.  
The scale parameter of a distribution determines how much spread there is in the distribution.  The larger the scale parameter, the more spread there is in the distribution.   
The shape parameter of a distribution allows the distribution to take different shapes.  
 The larger the shape parameter, the more the distribution tends to be skewed to the left.   
 
```r
library(ggplot2)
library(MASS)

#Generate gamma rvs

x <- rgamma(100000, shape = 2, rate = 0.2)

den <- density(x)

dat <- data.frame(x = den$x, y = den$y)

#Plot density as points

ggplot(data = dat, aes(x = x, y = y)) + 
  geom_point(size = 3) +
  theme_classic()
```
The y axis is the probability of the value x locates, totally 1, the random number generated should be from the x axis, most  
generated one should be the ones with the highest probability.  

**From experimental results to a prediction**  
```r
# Baseline run
test_scores(school = "public", acad_motivation = 0, relig_motivation = 0)

# Change school input, leaving others at baseline
test_scores(school = "private", acad_motivation = 0, relig_motivation = 0)

# Change acad_motivation input, leaving others at baseline
test_scores(school = "public", acad_motivation = 1, relig_motivation = 0)

# Change relig_motivation input, leaving others at baseline
test_scores(school = "public", acad_motivation = 0, relig_motivation = 1)

# Use results above to estimate output for new inputs
my_prediction <- 100 - 5 + 2 * 15 + 2 * 0
my_prediction

# Check prediction by using test_scores() directly
test_scores(school = "private", acad_motivation = 2, relig_motivation = 2)
```

**Model Definitions**
A model is a representation for a purpose.  
A mathematical model is built from mathematical stuff.  
A statistical model is trained on data, built on objects.  

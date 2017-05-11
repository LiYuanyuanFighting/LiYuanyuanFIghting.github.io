**K Means Clustering in R**  
[K means](https://en.wikipedia.org/wiki/K-means_clustering):k-means clustering aims to partition n observations  
into k clusters in which each observation belongs to the cluster with the nearest mean, serving as a prototype   
of the cluster. This results in a partitioning of the data space into Voronoi cells.  

[K Means Clustering in R](https://stat.ethz.ch/R-manual/R-devel/library/stats/html/kmeans.html):  
    kmeans(x, centers, iter.max = 10, nstart = 1,
         algorithm = c("Hartigan-Wong", "Lloyd", "Forgy",
                       "MacQueen"), trace=FALSE)  
 
x	
numeric matrix of data, or an object that can be coerced to such a matrix (such as a numeric vector or a data frame with all numeric columns).

centers	
either the number of clusters, say k, or a set of initial (distinct) cluster centres. If a number, a random set of (distinct) rows in x is chosen as the initial centres.

iter.max	
the maximum number of iterations allowed.

nstart	
if centers is a number, how many random sets should be chosen?

algorithm	
character: may be abbreviated. Note that "Lloyd" and "Forgy" are alternative names for one algorithm.

object	
an R object of class "kmeans", typically the result ob of ob <- kmeans(..).

method	
character: may be abbreviated. "centers" causes fitted to return cluster centers (one for each input point) and "classes" causes fitted to return a vector of class assignments.

trace	
logical or integer number, currently only used in the default method ("Hartigan-Wong"): if positive (or true), tracing information on the progress of the algorithm is produced. Higher values may produce more tracing information.

...	
not use

[Detailed Example](https://www.r-bloggers.com/k-means-clustering-in-r/)
(note the last command in the article is wrong, it should be:  
ggplot(iris, aes(Petal.Length, Petal.Width, color = irisCluster$cluster)) + geom_point())

Procedures to connect mySQL database with R  
```r
> library(RMySQL)   
>  mydb= dbConnect(MySQL(), user = 'root', password='root', dbname='synchronet', host = 'localhost')
> rs.table= dbSendQuery(mydb, 'select departure, arrival, transportMode from links')  
> rs.table= dbGetQuery(mydb, 'select departure from links')  
> rs.table2= dbGetQuery(mydb, 'select arrival from links')  
> rs.table1= dbGetQuery(mydb, 'select transportMode from links')  
> rs.c=cbind(rs.table, rs.table2, rs.table1)
> rs.d = dist(rs.c)  
> rs.d
> View(rs.c)
```
[reference](http://mizunolab.sist.ac.jp/2016/03/)

**Dealing with complex queries**  
```r
> library(RMySQL)  
>  mydb= dbConnect(MySQL(), user = 'root', password='root', dbname='synchronet', host = 'localhost')  
> query = 'select timeDeviation from history_time_deviations where PID in(select PID from planned_links where LID in (select LID from links where transportMode="FERRY" ))'   
> rs = dbGetQuery(mydb, query)
// calculate distribution 
> library(fitdistrplus)   
Loading required package: MASS  
Loading required package: survival     
> fit.norm <- fitdist(rs$timeDeviation, "norm")
> plot(fit.norm)    
```

**Compare Distributions**
```r
> data1 <- rs$timeDeviation
> data2 <- bimodalData
> ks.test(data1, data2)

        Two-sample Kolmogorov-Smirnov test

data:  data1 and data2
D = 0.54902, p-value = 2.873e-09
alternative hypothesis: two-sided

Warning message:
In ks.test(data1, data2) : cannot compute exact p-value with ties
> t.test(data1, data2)

        Welch Two Sample t-test

data:  data1 and data2
t = 6.4887, df = 51.494, p-value = 3.361e-08
alternative hypothesis: true difference in means is not equal to 0
95 percent confidence interval:
  7.470706 14.162296
sample estimates:
mean of x mean of y 
14.372549  3.556048 


```


in eclipse:  
		public static void testDBConnection() {
			final String host0 = "localhost";
			final String userName = "root";
			final String password0 = "root";
			final String dbName = "synchronet";
			
			engine.eval("host="+ host0);
			engine.eval("userName="+ userName);
			engine.eval("password="+ password0);
			engine.eval("dbName=" + dbName);
			
			org.rosuda.JRI.REXP x;
			// engine.eval("library(RMySQL)");
			System.out.println(x=engine.eval("library(\"RMySQL\")"));
			
			engine.eval("mydb= dbConnect(MySQL(), user = 'root', password='root', dbname='XXXX', host = 'localhost')" );
			System.out.println(x=engine.eval("dbListTables(mydb)"));
			engine.eval("rs= dbSendQuery(mydb, 'select LID from links')");
			
			// double[] result_a = engine.eval("dbGetQuery(mydb, 'select LID from links')").asList().at(1).asDoubleArray(); 
			 engine.eval("rs= dbSendQuery(mydb, 'select LID from links')");
			 System.out.println(x=engine.eval("data = fetch(rs, n=-1)"));
			 System.out.println(x.asList().at(0));
			 System.out.println(x.asIntArray());
			 
			// int[] result = engine.eval("data").asIntArray();
		///	x=engine.eval("data = fetch(rs, n=-1)");
		///	double[] result = x.asDoubleArray();
			/*for (int i = 0; i < result_a.length; i++) 
				System.out.println("Check " + result_a[i]);*/
				///	System.out.println(Arrays.asList(result));
				///System.out.println("Test db result is " + result.toString());
		}
    
    
he difference between dbGetQuery and dbSendQuery is that the former submits the query, fetches all output records, and clears the result set all in one step, but the latter does not extract any records; you need to use fetch to do that.

The first fetch statement below gets all records. The second requests only the first 10 rows (n=10).

** failed cluster methods**  
```r
> rail1.cluster <- ifelse(identical(rs.c$transportMode, "RAIL"), 2, 0)
> bus.cluster <- ifelse(identical(rs.c$transportMode, "BUS"), 2, 0)
> segmentCombined <- cbind(ship1.cluster, rail1.cluster, bus.cluster)
> View(segmentCombined)
```
It seems identical compare the whole set with the string.


Mostly follow the [article](https://eight2late.wordpress.com/2015/07/22/a-gentle-introduction-to-cluster-analysis-using-r/) 
1. install tm(text mining library)  
```r
install.packages("tm")
```
2. collect the document for text mining  
I choose to analysis the table, I decide to first export table to excel(there should  
be ways to analysis from tabl directly, but check later)  
(1)simulate the process with real data: add to time deviation table from the difference  
between planned and executed links  
```sql
INSERT INTO history_time_deviation(PID, timeDeviation)
 SELECT planned_link.PID, timestampdiff(minute, planned_link.ArrivalTime, executed_link.arrivalTime )
 FROM planned_link, executed_link
 WHERE planned_link.PID = executed_link.PID;
```
(2)export data from mysql to excel:  
```sql
 SHOW VARIABLES LIKE 'secure_file_priv'; # Your MySQL server has been started with --secure-file-priv option which basically limits from which directories you can load files using LOAD DATA INFILE. SO use this to check where is the directory then create the csv file in that directory
 
 SELECT link.departure, link.arrival, link.agency, timestampdiff(minute, planned_link.ArrivalTime, executed_link.arrivalTime )
 FROM planned_link, executed_link, link
 WHERE planned_link.PID = executed_link.PID and link.LID=planned_link.LID
 into outfile 'C:/ProgramData/MySQL/MySQL Server 5.7/Uploads/historyTimeDeviation.csv'
 fields terminated by ','
 enclosed by '"'
 lines terminated by '\n';
```

3. load documents into an object that can be manipulated by functions in the tm package.  
```r
docs <- Corpus(DirSource("D:/docs/thesis/dataFile"))
#check what is inside(the index starts from 1)
writeLines(as.character(docs[[1]]))
```
The next step is to clean up the corpus. This includes things such as transforming to a consistent   
case, removing non-standard symbols &  punctuation, and removing numbers (assuming that numbers do   
not contain useful information, which is the case here):  
```r
> docs <- tm_map(docs, content_transformer(tolower))
> docs <- tm_map(docs, removePunctuation)
#> docs <- tm_map(docs, stripWhitespace)
#check again
writeLines(as.character(docs[[1]]))
dtm <- DocumentTermMatrix(docs) # final processing:  create a document-term matrix (DTM) – a matrix that lists all occurrences of words in the corpus.
> dtm
```  
4. Hierarchical clustering  
```r
#convert dtm to matrix
m <- as.matrix(dtm)
#run hierarchical clustering using Ward’s method
groups <- hclust(d,method=”ward.D”) #failed here cz I only have one doc, only one cluster, so could not do it
```
A document-term matrix or term-document matrix is a mathematical matrix that describes the frequency of terms that occur   
in a collection of documents. In a document-term matrix, rows correspond to documents in the collection and columns   
correspond to terms. In my case, there's only one row.  

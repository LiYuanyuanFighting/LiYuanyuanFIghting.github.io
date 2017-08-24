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

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

1st preprocessing data on EXCEL:  
1. create a new column based on existing column: insert a function  
=IF(H2<=30, "insignificant", IF(H2<=60, "minor", IF(H2<=120, "Moderate", "Major")))  
2. split modes:  
Data-> Filter, then appear dropdown menu
3. Used rapidMiner:  
[Decision Tree Analysis](http://i.imgur.com/QrYPDLk.png)    
[Decision Tree Result](http://i.imgur.com/42tOnNy.png)  

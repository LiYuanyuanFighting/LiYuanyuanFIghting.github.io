1. create a new column based on existing column: insert a function  
=IF(H2<=30, "insignificant", IF(H2<=60, "minor", IF(H2<=120, "Moderate", "Major")))  

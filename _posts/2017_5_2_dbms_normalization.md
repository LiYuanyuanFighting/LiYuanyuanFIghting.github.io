**Normalization - 1NF, 2NF, 3NF and 4NF**  

[Imgur](http://i.imgur.com/5dd31H0.png)

**1st Normal Form**  
-Each cell to be single valued
-Entries in a column are same type  
-Rows uniquely identified. Add Unique ID, or Add more columns to make unique  
(Note: the order of the rows and the order of the columns are irrelevant)

[![1st Normal Form](http://i.imgur.com/0LeGgzw.png)

**2nd Normal Form**  
All attributes (Non key Columns) dependent on the key  

[![2nd Normal Form](http://i.imgur.com/0LeGgzw.png)

Problem? 
[![Problem](http://i.imgur.com/fFQiZIw.png)

[![2nd Normal ](http://i.imgur.com/A4sMDhc.png)

[![2nd Normal with junction table](http://i.imgur.com/FverJJT.png)

Problem? 
Supplier and Supplier phone  
they 2 can be repeated many times in the table. If one phone number is changed, need to change many places  
Lots of redundancy.

**3rd Normal Form**  
-All Fields{column} can be determined Only by the Key in the table and no other column  
[Imgur](http://i.imgur.com/TBm2Yc1.png)  

Problem?  
One customer with same shipping Address can have many newsletters

**4th Normal Form**  
-No muti-valued dependencies  (One column can have different values at different)   
[Imgur](http://i.imgur.com/4pFS1lP.png)

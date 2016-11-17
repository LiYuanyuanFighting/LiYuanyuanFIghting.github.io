---
layout: post
title: DBMG---Homework Problems
categories: [blog ]
tags: [study,DBMG, ]
description: 
---  

**Error1**
PLS-00103: Encountered the symbol "‘" when expecting one of the following: ( - + all case mod new null <an identifier>
<a double-quoted delimited-identifier> <a bind variable> continue any avg count current max min prior some sql stddev sum variance
execute forall merge time timestamp interval date <a string literal with character set specification> <a number> <a single-quoted SQL 
string> pipe <an alternatively-quoted string literal with character set specification> <an alternati

Analysis:  
in this case, should see which is the symbol has errors, here we can see it is "‘", then should realize it could be due to 
Chinese character and English character(For invalid characters it can also be due to this)

**Error2**
ORA-04091: table xxxx is mutating, trigger/function may not see it
[oracle@DB-Server ~]$ oerr ora 4091
04091, 00000, "table %s.%s is mutating, trigger/function may not see it"
// *Cause: A trigger (or a user defined plsql function that is referenced in 
//         this statement) attempted to look at (or modify) a table that was 
//         in the middle of being modified by the statement which fired it.
// *Action: Rewrite the trigger (or function) so it does not read that table.

 Analysis:  
  When have this error, it is due to in row level trigger, it can not refer to its own table which is locked.
     出现这个错误，是因为在行级触发器中，不能查询自身表。即在某表的行级触发器中不能读取当前表的问题。ORACLE行级触发器(FOR EACH ROW)，不能对本表做任何操作，甚至包括读取。

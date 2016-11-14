---
layout: post
title: DBMG---Homework Problems
categories: [blog ]
tags: [study,DBMG, ]
description: 
---  

**Error1**
Error(4,26): PLS-00103: Encountered the symbol "‘" when expecting one of the following: ( - + all case mod new null <an identifier>
<a double-quoted delimited-identifier> <a bind variable> continue any avg count current max min prior some sql stddev sum variance
execute forall merge time timestamp interval date <a string literal with character set specification> <a number> <a single-quoted SQL 
string> pipe <an alternatively-quoted string literal with character set specification> <an alternati
analysis: in this case, should see which is the symbol has errors, here we can see it is "‘", then should realize it could be due to 
Chinese character and English character

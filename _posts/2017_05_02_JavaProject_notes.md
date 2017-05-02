Due to R doesn't support multi-thread, there can be only one R instance created.   
So there are problems when I call 2 methods of R class.   
Then I moved engine outside method, inside the class, add static identifier, which  
says it is the member of the class, instead of the object. Then will only creat one  
R instance for the 2 methods.  
[reference]("http://stackoverflow.com/questions/5642834/why-should-the-static-field-be-accessed-in-a-static-way")  


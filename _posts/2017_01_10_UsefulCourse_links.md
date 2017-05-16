**distributed programming**  
 [xdr explanation](http://people.redhat.com/rjones/xdr_tests/)    
which talks about how some external data representation works, like some functions:  
xdr_stringlist, xdr_destroy and xdr_free.  

void xdr_destroy(XDR *xdrs);  
A macro that invokes the destroy routine associated with the XDR stream, xdrs. Destruction   
usually involves freeing private data structures associated with the stream. Using xdrs after  
invoking xdr_destroy() is undefined.   
void xdr_free(xdrproc_t proc, char *objp);   
Generic freeing routine. The first argument is the XDR routine for the object being freed.   
The second argument is a pointer to the object itself. Note: the pointer passed to this routine   
is not freed, but what it points to is freed (recursively).   

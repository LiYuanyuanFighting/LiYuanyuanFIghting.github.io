**What is AJAX?**
AJAX = Asynchronous JavaScript And XML.

AJAX is not a programming language.

AJAX just uses a combination of:

A browser built-in XMLHttpRequest object (to request data from a web server)
JavaScript and HTML DOM (to display or use the data)  

Asynchronous here means they can process in the background, without block the rest of the pages

callback:call them when gets response back.  

Ajax requests allow for content retrieval and display without reloading the webpage.  
Asynchronous refers to the fact that the request doesn't block other events from happening, instead  
the page gets on its thing and then then only acts on the data when it gets returned by the server.  

AJAX Response:  
*Data
  - XML <entry></entry>  
  - JSON {property:data}  
  - HTML <div></div>  
  
Facebook uses a lot of asynchronous requests so that the page almost never needs to refresh for users  
to see new content. For instance, when a user scrolls down in a business' page, new stories get inserted  
into the page which never needs to refresh to show new content.

Necessary components for AJAX request:  
url (type: String standing for the URL to which the request is sent   
settings are optional, which are a set of key/value pairs that configure the Ajax request.

**Practices**:
1.  
2. Loading Wikipedia Articles:  
   --1.Fire off JSON-P request to Wikipedia for articles about a city  
      --include dataType and success parameters
   --2.Iterate through response  
   --3.Present articles on the page inside <ul id="wikipedia-links"></ul>
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   

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
3. Error handling:  
   error handling isn't actually built into JSONP, but can use timeout like this:   
   
       var wikiRequestTimeout = setTimeout(function(){
    	$wikiElem.text("failed to get wikipedia resources");
    }, 8000);  // after 8s, change the text to it
    
    $.ajax({
    	url: wikiUrl,
    	dataType: "jsonp",
    	// jsonp: "callback",
    	success: function(response) {
    		var articleList = response[1];
    
    		for (var i = 0; i < articleList.length; i++) {
    			articleStr = articleList[i];
    			var url = 'http://en.wikipedia.org/wiki/' + articleStr;
    			$wikiElem.append('<li><a href="' + url + '">' + articleStr + '</a></li>');
            };
    	   clearTimeout(wikiRequestTimeout);
    }
    });

**CORS（Cross Origin Resource Sharing）**
CORS 采用同源策略。同源策略由 Web 浏览器实施，以防止来自不受信任域的恶意脚本在网站上运行。换句话说，它可确保一个网站的脚本无法自行插入另一个网站。
[reference](https://classroom.udacity.com/courses/ud110/lessons/3310298553/concepts/31914985390923)

**Render the page quickily*
 
常规 HTML：是指可用于任何用户的 HTML 和 CSS。例如，所有用户都会需要“最喜爱的谷物”、“最喜爱的意大利面食”的 HTML，以及描述如何设置用户图片样式的 CSS。

唯一 HTML：是指特定于某个用户的 HTML 内容。例如，“脆谷乐”、“通心粉”、“早餐”和我的图片就是唯一 HTML  
   
To get the page:  
1st, request the generic HTML, after getting the generic page, then request unique HTML,  
then render generic HTML, finally render unique HTML  
We can find this technique used in google search(https://classroom.udacity.com/courses/ud884/lessons/1464158642/concepts/15290985500923) and facebook

   
   
   
   
   
   
   
   
   
   
   
   
   

---
layout: post
title: Getting started with jQuery
categories: [blog ]
tags: [study,html,jquery, ]
description: 
--- 

# Making WebPages Interactive with Jquery

## Getting started with jQuery
#### Learn how to include the jQuery JavaScript library in your page using a script tag and how you can use jQuery  
to change parts of a page.

...
   ` <h1>Why should you learn jQuery?</h1>`
...
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
        
        <script>
            $("h1").text("jQuery is the GREATEST!!!");
        </script>
		<script>
        $("p").text("jQuery is the GREATEST!!!");//tag
        $("#main-heading").text("jQuery? More like YAY-QUERY!");//id
        $(".note").text("NOTE: jQuery has been known to cause EXTREME JOY!");//class name
        
    </script>
	//<p class="note">
	//<h1 id="main-heading"

## Getting info on elements with jQuery
#### Learn how to use jQuery methods to find the contents of an element.


    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="utf-8">
            <title>Getting info on elements with jQuery</title>
            <style>
                body {
                    font-family: Arial, sans-serif;
                    color: rgb(16, 10, 102);
                }
                
                p {
                    color: red;
                }
                
                #main-heading {
                    color: purple;
                }
                
                .note {
                    background: yellow;
                }
            </style>
        </head>
        <body>
    
        <h1 id="main-heading">What is jQuery?</h1>
    
        <p>jQuery is the most popular JavaScript library. It gives developers lots of useful functions so they can  
        make their webpage interactive across multiple browsers.</p>
        
        <p class="note">jQuery is an open source library with a big community of contributors.</p>
        
        <h1>Why should you learn jQuery?</h1>
    
        <p>If you learn jQuery, you'll be able to use it in your own webpages, understand other developer's webpages,  
        and have a better understanding generally about how to use libraries.</p>
        
        <p class="note">Note: jQuery functions use the DOM API (like <code>document.getElementById</code>). You should  
        learn that first, if you haven't yet.</p>
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
        
        <script>
            $("p").text("jQuery is the GREATEST!!!");
            //$("#main-heading").text("jQuery? More like YAY-QUERY!");
            var headingText = $("#main-heading").text();
            console.log(headingText);
            $("#main-heading").text("!!" + headingText + "!!");
            
            $(".note").text("NOTE: jQuery has been known to cause EXTREME JOY!");
            
        </script>
        </body>
    </html>

## Review: DOM access with jQuery
To find DOM elements with jQuery, pass a valid CSS selector into the jQuery function:
$("h1"); // selects all the h1s
$("#heading"); // selects the element with id of "heading"
$(".warning"); // selects all the elements with class name of "warning"  
Note that the jQuery function can be named $ or jQuery, so those are the same as:  
jQuery("h1");  
jQuery("#heading");  
jQuery(".warning");
Many people prefer $ because it's so short.  
  
The jQuery function will always return a jQuery collection of matching elements, even if there is only one matching  
element -- or none! You can read more about the jQuery function in their documentation.  

Once you've found DOM elements with jQuery, you can do things like set their inner contents with text():   
$("#temperature").text("89° Fahrenheit"); (See full example)
You can use the same method text() to get the inner content, by passing it 0 parameters:  

var heading = $("#heading").text();  

In the next tutorial, you'll learn many more methods to get and set properties of DOM elements.  

Behind the scenes, these jQuery functions all use the DOM API that we taught in the HTML/JS course. For example,  
the $ function uses methods like getElementById() and querySelectorAll(), and attr() uses the getAttribute() method.   
When you use the $ function, you get to use those functions in fewer lines of code, and also know that your code will work  
in all of jQuery's supported browsers, which is especially important when using the more recent DOM API functions.

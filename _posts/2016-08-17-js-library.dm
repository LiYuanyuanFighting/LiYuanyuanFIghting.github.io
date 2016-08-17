---
layout: post
title: Using JS library in your webpage
categories: [blog ]
tags: [study,html,js, ]
description: 
---  

#HTML/JS making webpages interactive
##Using JS libraries in your webpage
There are a billion webpages, and many of them are interactive in some way - in fact, many of them are interactive in the same ways.

Now, it's possible that every one of those web developers wrote their own JavaScript code to make a slideshow, but a lot of them probably re-used the same code. As programmers, we should re-use existing code when we can, so that we don't waste our time writing code that another programmer has already written.

In JavaScript, the way we do that is by using a library. A library is a JavaScript file that contains a bunch of functions, and those functions accomplish some useful task for your webpage.

How do we know what functions we can use? We could look at the JavaScript file, if it's short, or better, we could look at the documentation. Most libraries have documentation with a list of available functions or a real-world example.

When a programmer creates a JS library and puts it out into the world, they're purposefully deciding to share it with the world - so that often means they put in the effort to come up with great documentation and examples. Perhaps one day you will decide to create a library of some functionality that you find really useful and share it with the world.

##Using a JS Library: Slideshow libraryUsing a JS Library: Slideshow library



    <!DOCTYPE html>
    <html>
        <head>
            <title>Using a JS Library: Slideshow library</title>
        </head>
        <body>
            
        <div id="slideshow">
            <img src="https://www.kasandbox.org/programming-images/animals/birds_rainbow-lorakeets.png" alt="Rainbow lorakeets" />
            <img src="https://www.kasandbox.org/programming-images/animals/butterfly.png"alt="Butterfly" />
            <img src="https://www.kasandbox.org/programming-images/animals/cat.png" alt="Cat" />
            <img src="https://www.kasandbox.org/programming-images/animals/crocodiles.png" alt="Crocodiles" />
            <img src="https://www.kasandbox.org/programming-images/animals/fox.png" alt="Fox" />
            
        </div>
    
        <script src="https://cdn.rawgit.com/pamelafox/a8b77c43f56da1753348/raw/slideshow.js"></script>
        <script>
    slideShow(document.getElementById("slideshow"));
        </script>
        </body>
    </html>
in the script source link:


    /**
     * This function takes in a reference to a DOM element,
     * assumes each of its children are <img> tags,
     * and then makes a simple slideshow out of the images.
     * @param container A DOM element
     */
    var slideShow = function(container) {
        this.images = [];
        this.curImage = 0;
        for (i = 0; i < container.childElementCount; i++) {
            this.images.push(container.children[i]);
            this.images[i].style.display = "none";
        }
        
        // Handle going to to the next slide
        var nextSlide = function() {
            for (var i = 0; i < this.images.length; i++) {
                this.images[i].style.display = "none";
            }
            this.images[this.curImage].style.display = "block";
            this.curImage++;
            if (this.curImage >= this.images.length) {
                this.curImage = 0;
            }
            window.setTimeout(nextSlide.bind(this), 500);
        };
        
        nextSlide.call(this);
    };

##The world of JS libraries
[original webpage](https://www.khanacademy.org/computing/computer-programming/html-css-js/using-js-libraries-in-your-webpage/a/the-world-of-js-libraries "original webpage")
There are thousands of JavaScript libraries that you could bring into your webpage, and many aspects of your webpage that they can help you with:

DOM manipulation
DOM Events
AJAX / Data retrieval
Effects & animation
HTML templating
Page layout
UI widgets
Graphics & charts
Data modeling
Routing & navigation
Accessibility
Multi-browser support
Mobile support
Here's another way I like to think of it - a webpage is made up of the User Interface (HTML & CSS), Interactivity (JS + DOM), and Data (which we often bring in through JS). You can make your data-driven interactive UI without a library, or you can bring in different libraries to help out with different parts. Some libraries will do a lot, some will do just one part:
Web frameworks

There are some libraries that "do it all" - everything from data retrieval to DOM manipulation to fancy UI widgets. If you use one of these frameworks, you'll typically be bringing a lot of JavaScript into your page, so you'll want to make sure you really need most of what the framework is offering you. For some developers, these frameworks do too much, and they find it better to use smaller libraries with more focused tasks.

jQuery UI
jQueryMobile
Dojo
Sencha
QooxDoo
Closure
KendoUI
CSS frameworks

A CSS library is a collection of CSS style rules, and documentation that shows you what HTML tags and classes to use. There are many popular CSS libraries that will make it easier for you to make a beautifully styled website. They sometimes include optional JavaScript widgets, but developers often choose to use other JS libraries with a CSS library.

Twitter Bootstrap (See example on KA)
ZURB Foundation (See example on KA)
Pure CSS
Topcoat
Skeleton
JS browser libraries

These are libraries that will make it easier for you to use browser functionality - like the DOM API, the window methods - the topics we discussed in this course. They often make it possible to accomplish the same thing in less code, and they'll take care of cross-browser bugs.

jQuery (The most popular library, by far! - See example on KA)
ZeptoJS
MooTools
$dom
QuoJS
JS app architecture libraries

These libraries help you with your web apps as they grow larger. Your code might be manageable now, at a few hundred lines of code, but once you get to thousands of lines of code, your code might become "spaghetti code" - an unmanageable mess. These libraries help you separate your "model" (data) from your "view" (presentation), and often use object-oriented programming principles to organize your code.

Facebook React + Facebook Flux
Backbone
AngularJS
EmberJS
Mini libraries & microlibraries

You can also use small libraries that developers have written for a specific task - when they're really small, they're sometimes called "microlibraries". Here's a smattering:

DOM: tinyDOM
Events: Events.js
AJAX: MicroAjax
Animation: Morpheus, Viper
Data Modeling: Spine, Knockout
Templates: Handlebars, Mustache
Routing: PathJS
Object-Orientation: Classy, Klass
Graphics: Processing.JS (See example on KA), RaphaelJS (See example on KA), D3, Three.JS (See example on KA), Paper.js
Charts: gRaphael, High Charts
Date/time: moment.js
You can find more at microjs.com or just by searching the internet for "javascript library [functionality]" for whatever functionality you're looking for.


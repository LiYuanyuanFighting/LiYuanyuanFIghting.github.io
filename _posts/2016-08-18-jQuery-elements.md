---
layout: post
title: HTML/jQuery Elements 
categories: [blog ]
tags: [study,html,js,jquery ]
description: 
---  

# HTML/jQuery making webpages interactive
## Modifying elements with jQuery
#### Learn how you can use jQuery to modify elements of your webpage - to change their contents, class names, CSS styles, and attributes.
    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="utf-8">
            <title>Modifying elements with jQuery</title>
            <style>
                .crocodile {
                    color: green;
                    font-family: fantasy;
                }
            </style>
        </head>
        <body>
            
            <h2 id="cuteness">Cats are cute</h2>
    
            <p>Cats are widely known to be one of the cutest animals. It has long been rumored that they have put all of humanity under a hypnosis, so that they can achieve their goals of getting fed while also getting to do whatever they darn want around our houses.</p>
            
            <p>This cat is exhibiting what's known as the "so-cute-now-feed-me" face:</p>
            <a href="https://en.wikipedia.org/wiki/Cat_food">
                <img src="https://www.kasandbox.org/programming-images/animals/cat.png" width="200">
            </a>
            
            <h2 id="activities">Common cat activities (Cat-ivities)</h2>
            
            <p>Cats enjoy attacking innocent pieces of string, walking around your legs at the exact moment that you're trying to flip a pancake on the stove, sleeping for hours and hours and hours, and pouncing on unsuspecting laser dots.</p> 
            <img src="https://upload.wikimedia.org/wikipedia/commons/5/5c/2006-07-07_katze_mit_angel.jpg" width="200">
            
            <a href="https://en.wikipedia.org/wiki/Cat">Learn more</a>
            
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
            <script>
            $("h2").text("CROCODILE ATTACK!");
            $("p").html("The crocodiles are coming - <strong>oh noess</strong>!!");
            $("p").css("color", "green");
            $("h2").addClass("crocodile");
            $("a").attr("href", "https://en.wikipedia.org/wiki/Crocodile");
            $("img").attr("src", "https://www.kasandbox.org/programming-images/animals/crocodiles.png");
            </script>
        </body>
    </html>
    

## Creating elements with jQuery
#### Learn how to use jQuery to create elements from scratch and then insert them at different places in your webpage.
    <script>
    		var newP = $("<p>");
            newP.text("The crocodiles have eaten this ENTIRE PAGE!");
            newP.addClass("crocodile");
            // append prepend after
            $("body").append(newP);
            
     </script>

## Review: DOM modification with jQuery
Once you have found a collection of elements using the jQuery function,  
you can change them using various methods.  
Set their inner text with text():  
`$("h1").text("All about cats");`  
Set their inner html with html():  
`$("h1").html("I <strong>love</strong> cats");`  
Set attributes with attr():  
`$(".dog-pic").attr("src", "dog.jpg");`  
`$(".google-link").attr("href", "http://www.google.com");`  
Change CSS styles with css():  
`$("h1").css("font-family", "monospace");`  
`$("h1").css({"font-family": "monospace", color: "red"});`  
Add a class name with addClass():  
`$("h1").addClass("warning");`  
You can also create new elements from scratch by passing a string of HTML into the jQuery function:  
`var $p = $("<p>");`  
If you'd like, you can pass in the full HTML, including tag contents, attributes, and styles.  
`var $p = $('<p style="color:red;">I love people who love cats.</p>');`  
Once you create an element, you can modify it using any of the methods above:  
`$p.addClass("warning");`  
Then you can append it to an existing element using append(), :  
`$("#main-div").append($p);`  
You can also insert it into the page using prepend()  or appendTo()  


## jQuery Collections vs. DOM Nodes
#### Make sure you understand the difference between jQuery collections and DOM nodes, and learn how to convert your variables into collections and nodes.  
    // Let's discuss:
            var headingFromD = document.getElementById("cuteness"); // DOM node
            headingFromD.innerHTML = "Setting .innerHTML";
            var headingFromJ = $("#cuteness"); // jQuery collection
            headingFromJ.html("Using .html()");
            
            var $heading = $("#cuteness");
            $heading.html("Using jQuery again!");
            var headingD = $heading[0];
            
            var $headingJ = $(headingD);

```html
Given the line of code below, which of the next lines of code would result in changing the contents of the element?
var heading = $("#title");

This first line of code uses jQuery to select the element with the ID 'title' and store a jQuery collection representing that element.
Therefore, in order to change the contents of that element, we must call jQuery methods like text() and html() on it. We can't change it by changing the DOM property names like innerHTML and textContent because they don't exist on the jQuery collection object.
In order to use those DOM property names to change the element, we would need to get the original DOM element out of the collection, by using bracket notation:
heading[0].textContent = "Best heading ever";
heading[0].innerHTML = "Best heading <strong>ever</strong>";
Since those lines of code aren't given as options, only the text() and html() options are correct.
```

## Looping through jQuery collections
#### Learn several techniques for looping through jQuery collections, using both a for loop and a jQuery method.
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
            <script>
            // Modifying elements
            $("h2").text("CROCODILE ATTACK!");
            //$("p").html("The crocodiles are coming - <strong>oh noess</strong>!!");
            // for loop
            var $paragraphs = $('p');
            for (var i = 0; i < $paragraphs.length; i++) {
                var element = $paragraphs[i]; // DOM node
                var $paragraph = $(element);
                $paragraph.html( $paragraph.html() + "..huzzah!");
            }
            
            // each()
            $paragraphs.each(function(index, element) {
                var $paragraph = $(this);
//can also use element,in js "this" refers to the context of element  

                console.log(element === this);
                $paragraph.html( $paragraph.html() + "..wowee!");
            });
            
            
            $("p").css("color", "green");
            $("h2").addClass("crocodile");
            $("a").attr("href", "https://en.wikipedia.org/wiki/Crocodile");
            $("img").attr("src", "https://www.kasandbox.org/programming-images/animals/crocodiles.png");
            
            
            </script>

## Challenge: Loopy language
#### Translate the paragraphs

This webpage is about Pig Latin, a fun language. You'll use jQuery to translate each of the paragraphs to Pig Latin. Using either a for loop or the each() method, find each paragraph, send its text through the toPigLatin function, and set the paragraph to that text.  
original:
## All about Pig Latin

Pig Latin is a language game in which words in English are altered. The objective is to conceal the meaning of the words from others not familiar with the rules. The reference to Latin is a deliberate misnomer, as it is simply a form of jargon, used only for its English connotations as a strange and foreign-sounding language.

The origins of Pig Latin are unknown. A youthful Thomas Jefferson wrote letters to friends in Pig Latin.

For words that begin with consonant sounds, the initial consonant or consonant cluster is moved to the end of the word, and "ay" is added.

    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="utf-8">
            <title>Challenge: Loopy language</title>
        </head>
        <body>
            
            <h1>All about Pig Latin</h1>
            <p>Pig Latin is a language game in which words in English are altered. The objective is to conceal the meaning of the words from others not familiar with the rules. The reference to Latin is a deliberate misnomer, as it is simply a form of jargon, used only for its English connotations as a strange and foreign-sounding language.</p>
            <p>The origins of Pig Latin are unknown. A youthful Thomas Jefferson wrote letters to friends in Pig Latin.</p>
            <p>For words that begin with consonant sounds, the initial consonant or consonant cluster is moved to the end of the word, and "ay" is added.</p>
    
            
            <script src='https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js'></script>
            <script>
    // Takes a string and returns Pig Latin version of it
    var toPigLatin = function(str) {
        if (!str.replace) {
            return 'ERROR: Expected a string!';
        }
        return str.replace(/\b(\w)(\w+)\b/g, '$2-$1ay').toLowerCase();
    };
    
    // Iterate through each paragraph, call the toPigLatin function on it
    var $paragraphs = $("p");
    
    //each
    $paragraphs.each(function(index,element){
        var $paragraph = $(this);
        console.log(element === this);
        $paragraph.text( toPigLatin($paragraph.text()) );//change the text to pig latin
    })
            </script>
        </body>
    </html>
    

## All about Pig Latin

ig-pay atin-lay s-iay a anguage-lay ame-gay n-iay hich-way ords-way n-iay nglish-eay re-aay ltered-aay. he-tay bjective-oay s-iay o-tay onceal-cay he-tay eaning-may f-oay he-tay ords-way rom-fay thers-oay ot-nay amiliar-fay ith-way he-tay ules-ray. he-tay eference-ray o-tay atin-lay s-iay a eliberate-day isnomer-may, s-aay t-iay s-iay imply-say a orm-fay f-oay argon-jay, sed-uay nly-oay or-fay ts-iay nglish-eay onnotations-cay s-aay a trange-say nd-aay oreign-fay-ounding-say anguage-lay.

he-tay rigins-oay f-oay ig-pay atin-lay re-aay nknown-uay. a outhful-yay homas-tay efferson-jay rote-way etters-lay o-tay riends-fay n-iay ig-pay atin-lay.

or-fay ords-way hat-tay egin-bay ith-way onsonant-cay ounds-say, he-tay nitial-iay onsonant-cay r-oay onsonant-cay luster-cay s-iay oved-may o-tay he-tay nd-eay f-oay he-tay ord-way, nd-aay "y-aay" s-iay dded-aay.

## Review: jQuery collections & looping
### jQuery collections
When you use jQuery to find elements, jQuery returns back a jQuery collection object:  

`var $heading = $('h1');`  

It is common practice to start variable names like that with a $ sign to show that they're storing jQuery collection objects. That helps distinguish them from variables that store DOM nodes.  

If you'd like to retrieve the DOM node out of a jQuery object, then you can treat the jQuery object like an array and use bracket notation:  

`var heading = $heading[0];`  

If you'd like to turn a DOM node into a jQuery object, you can pass it into the jQuery function:  

`var $heading = $(heading);`  

### Looping through collections  
If you'd like to loop through multiple elements in a collection, you can use a normal for loop or jQuery's each():  

    $("p").each(function(index, element) { 
        $(elem).text( $(element).text() + "!!"); 
    );

When you call the each() function, you must pass a 'callback function' to it. jQuery will then call that callback function for each element in the collection, and it will pass the current index and element to the function.  

Query will also set the context of the function to the current element, which means you can reference the element with the this keyword:

    $("p").each(function() { 
        $(elem).text( $(this).text() + "!!"); 
    );

## Chaining jQuery methods
#### Learn how to use 'chaining', a common technique in jQuery for chaining a sequence of method calls together.
    // Creating elements
            var newP = $("<p>");
            newP.text("The crocodiles have eaten this ENTIRE PAGE!");
            newP.addClass("crocodile");
            $("body").append(newP);
            
            // chaining
            $("<p>")
                .text("The crocodiles have eaten this ENTIRE PAGE!")
                .addClass("crocodile")
                .appendTo("body");

#### challenge:to make daisy chains
     for ( var i = 0; i < 20; i++ ) {
            $("<img>")
            .attr("src","https://upload.wikimedia.org/wikipedia/commons/2/29/English_Daisy_(Bellis_Perennis).jpg")
                .attr("width","20")
                .attr("alt","daisy")
                .appendTo("body");}

[Behind the scenes: Browse the jQuery source code](https://www.khanacademy.org/computing/computer-programming/html-js-jquery/jquery-tools-techniques/a/bonus-dig-into-the-jquery-source-code "Behind the scenes: Browse the jQuery source code")

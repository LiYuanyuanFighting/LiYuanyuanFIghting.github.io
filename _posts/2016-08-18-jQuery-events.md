---
layout: post
title: Adding event listeners with jQuery
categories: [blog ]
tags: [study,html,js, ]
description: 
--- 

## Adding event listeners with jQuery
#### Learn how to add event listeners in jQuery so that your JavaScript can respond to events on the page, like when a user clicks a button or drags an image.  

    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="utf-8">
            <title>Adding event listeners with jQuery</title>
            <style>
                .crocodile {
                    color: green;
                    font-family: fantasy;
                }
            </style>
        </head>
        <body>
            <button id="croc-button">Crocodilize</button>
            
            <h2 id="cuteness">Cats are cute!</h2>
    
            <p>Cats are widely known to be one of the cutest animals. It has long been rumored that they have put all of humanity under a hypnosis, so that they can achieve their goals of getting fed while also getting to do whatever they darn want around our houses.</p>
            
            <p>This cat is exhibiting what's known as the "so-cute-now-feed-me" face:</p>
            <a href="https://en.wikipedia.org/wiki/Cat_food">
                <img src="https://www.kasandbox.org/programming-images/animals/cat.png" width="50">
            </a>
            
            <h2 id="activities">Common cat activities (Cat-ivities)</h2>
            
            <p>Cats enjoy attacking innocent pieces of string, walking around your legs at the exact moment that you're trying to flip a pancake on the stove, sleeping for hours and hours and hours, and pouncing on unsuspecting laser dots.</p> 
            <img src="https://upload.wikimedia.org/wikipedia/commons/5/5c/2006-07-07_katze_mit_angel.jpg" width="50">
            
            <a href="https://en.wikipedia.org/wiki/Cat">Learn more</a>
            
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
            <script>
            
            var crocodilize = function() {
                // Modifying elements
                $("h2").text("CROCODILE ATTACK!");
                $("p").html("The crocodiles are coming - <strong>oh noess</strong>!!");
                $("p").css("color", "green");
                $("h2").addClass("crocodile");
                $("a").attr("href", "https://en.wikipedia.org/wiki/Crocodile");
                $("img").attr("src", "https://www.kasandbox.org/programming-images/animals/crocodiles.png");  
            };
            
            $("#croc-button").on("click", function() {
                console.log("you clicked me!!");
                crocodilize();
            });
            
            </script>
        </body>
    </html>
    

## Using event properties in jQuery
#### to find the position of the mouse when the user clicks your webpage.
    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="utf-8">
            <title>Using event properties in jQuery</title>
            <style>
                .crocodile {
                    color: green;
                    font-family: fantasy;
                }
            </style>
        </head>
        <body>
            <h2 id="cuteness">Cats are cute!</h2>
    
            <p>Cats are widely known to be one of the cutest animals. It has long been rumored that they have put all of humanity under a hypnosis, so that they can achieve their goals of getting fed while also getting to do whatever they darn want around our houses.</p>
            
            <p>This cat is exhibiting what's known as the "so-cute-now-feed-me" face:</p>
            <a href="https://en.wikipedia.org/wiki/Cat_food">
                <img src="https://www.kasandbox.org/programming-images/animals/cat.png" width="50">
            </a>
            
            <h2 id="activities">Common cat activities (Cat-ivities)</h2>
            
            <p>Cats enjoy attacking innocent pieces of string, walking around your legs at the exact moment that you're trying to flip a pancake on the stove, sleeping for hours and hours and hours, and pouncing on unsuspecting laser dots.</p> 
            <img src="https://upload.wikimedia.org/wikipedia/commons/5/5c/2006-07-07_katze_mit_angel.jpg" width="50">
            
            <a href="https://en.wikipedia.org/wiki/Cat">Learn more</a>
            
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
            <script>
            
            var crocodilize = function() {
                $("h2").text("CROCODILE ATTACK!");
                $("p").html("The crocodiles are coming - <strong>oh noess</strong>!!");
                $("p").css("color", "green");
                $("h2").addClass("crocodile");
                $("a").attr("href", "https://en.wikipedia.org/wiki/Crocodile");
                $("img").attr("src", "https://www.kasandbox.org/programming-images/animals/crocodiles.png");  
            };
            
            crocodilize();
            
            // When the user clicks on the page:
            //   create a new image
            //   position it according to where click happened
            $("body").on("click", function(event) {
                console.log(event);
                var $img = $("<img>")
                    .attr("src", "https://www.kasandbox.org/programming-images/animals/crocodiles.png")
                    .width(100)
                    .css("position", "absolute")
                    .css("top", event.pageY + "px")
                    .css("left", event.pageX + "px")
                    .appendTo("body");
            });
            </script>
        </body>
    </html>
    

[What DOM events and properties are there?](https://www.khanacademy.org/computing/computer-programming/html-js-jquery/dom-events-with-jquery/a/dom-events-and-properties "What DOM events and properties are there?")

## Checking DOM readiness with jQuery
#### Learn how to use jQuery to check that the webpage is fully loaded before you try to access and modify the DOM.
    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="utf-8">
            <title>Checking DOM readiness with jQuery</title>
            <style>
                .crocodile {
                    color: green;
                    font-family: fantasy;
                }
            </style>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
            <script>
            
            var crocodilize = function() {
                $("h2").text("CROCODILE ATTACK!");
                $("p").html("The crocodiles are coming - <strong>oh noess</strong>!!");
                $("p").css("color", "green");
                $("h2").addClass("crocodile");
                $("a").attr("href", "https://en.wikipedia.org/wiki/Crocodile");
                $("img").attr("src", "https://www.kasandbox.org/programming-images/animals/crocodiles.png"); 
            };
    
            
            //use ready function to achieve:only after the document is ready then load the function
            $(document).ready(function() {
                crocodilize();
            });
            
            </script>
            
        </head>
        <body>
            
            <h2 id="cuteness">Cats are cute!</h2>
    
            <p>Cats are widely known to be one of the cutest animals. It has long been rumored that they have put all of humanity under a hypnosis, so that they can achieve their goals of getting fed while also getting to do whatever they darn want around our houses.</p>
            
            <p>This cat is exhibiting what's known as the "so-cute-now-feed-me" face:</p>
            <a href="https://en.wikipedia.org/wiki/Cat_food">
                <img src="https://www.kasandbox.org/programming-images/animals/cat.png" width="50">
            </a>
            
            <h2 id="activities">Common cat activities (Cat-ivities)</h2>
            
            <p>Cats enjoy attacking innocent pieces of string, walking around your legs at the exact moment that you're trying to flip a pancake on the stove, sleeping for hours and hours and hours, and pouncing on unsuspecting laser dots.</p> 
            <img src="https://upload.wikimedia.org/wikipedia/commons/5/5c/2006-07-07_katze_mit_angel.jpg" width="50">
            
            <a href="https://en.wikipedia.org/wiki/Cat">Learn more</a>
    
            
        </body>
    </html>
    

## Review: DOM events in jQuery
#### Adding an event listener
You can add an event using on():
    $("#save-button").on("click", function() {
       // handle click event
    });

If you need to access details about the event, you can find them in the[ jQuery event object](https://api.jquery.com/category/events/event-object/ " jQuery event object") that's passed into the callback function:  

    $("#face-pic").on("click", function(event) {
       var mouseX = event.pageX;
       var mouseY = event.pageY;
    });

#### Triggering events
You can manually trigger an event on an object from your JavaScript using trigger:
`$("#save-button").trigger("click");`
That can be useful when testing new functionality, or when you want some code to run both when the page loads and after some particular event.  
#### Checking DOM readiness
If you want to be sure that the browser does not run your JS code until the DOM is fully loaded and ready, then you can pass your code to ready()  
    $(document).ready(function() {
      $("h1").text("Y'all ready for this?");
    });

A shorter version of that is to pass your code to the jQuery function:

    $(function() {
      $("h1").text("Y'all ready for this?");
    });

That code is not as readable as the longer version, however, so we recommend using the ready() function.
Note that if you include your JS in a <script> tag at the bottom of the page, then your DOM should be fully ready by the time the browser runs your JS. However, if you want to be doubly sure, then you can choose to always check for DOM readinesss.  

#### More event techniques
For a longer summary and deeper dive into [jQuery events](https://learn.jquery.com/events/event-basics/#inside-the-event-handler-function "jQuery events"), read jQuery Event Basics in their documentation.

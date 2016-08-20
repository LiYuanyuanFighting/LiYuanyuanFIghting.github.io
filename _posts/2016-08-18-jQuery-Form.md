---
layout: post
title: Form processing with jQuery
categories: [blog ]
tags: [study,html,js,jquery ]
description: 
---  

# HTML/jQuery making webpages interactive
## Why process forms with jQuery?

We use forms on the web to get input from our users. Sometimes we send that input to a server to save it, and sometimes  
we just do something interesting with it in the browser. We often use jQuery to help us process that form, either before  
sending to a server, or replacing the need for a server entirely.  
We can use jQuery to do form "validation" - checking that inputs are the correct format, like the right phone number or   
length - and then send it off to a server. We do form validation in a few places on the  
[Khan Academy settings page](https://www.khanacademy.org/settings/account "Khan Academy settings page"):  
You'll use the same techniques for both of those sort of uses, and that's what we'll go through now. If you need a review  
of HTML forms first, go through [these slides](http://www.teaching-materials.org/htmlcss-1day/html-forms/slides.html#slide1 "these slides").  
## Processing a quiz with jQuery
#### Learn how to use jQuery to process a simple quiz, checking if the user entered the correct answer and messaging the result.

    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="utf-8">
            <title>Processing a quiz with jQuery</title>
        </head>
        <body>
    
        <h1>Reptile quiz</h1>
        
        <form id="quiz-form">
            <label>
                What is this? <br>
                <img src="https://ka-perseus-images.s3.amazonaws.com/325aab611b8b69b51bfeb16ade0af741da7dc3ff.jpg" alt="Reptile"> <br>
                <select id="quiz-answer">
                    <option value="crocodile">Crocodile</option>
                    <option value="alligator">Alligator</option>
                    <option value="caiman">Caiman</option>
                </select>
            </label> <br>
            <button type="submit">Check Answer</button>
        </form>
        <div id="result"></div>
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
        <script>
        
        // When the user submits the form,
        //   Check what answer they picked
        //   And tell them if they're correct
    
        // submit
        $("#quiz-form").on("submit", function(event) {
            event.preventDefault();
            var $answer = $("#quiz-answer"); 
            var answer = $answer.val();
            console.log(answer);
            if (answer === "crocodile") {
                $("#result").text("Woweeee! You got it! WOOO PARTY!");
            } else {
                $("#result").text("Try again!");
            }
            
        });
        </script>
        </body>
    </html>
    
## More form processing with jQuery
#### Learn more techniques for processing forms with jQuery, like scoping attribute selectors.
    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="utf-8">
            <title>More form processing with jQuery</title>
        </head>
        <body>
    
        <h1>Crocodile order form</h1>
        
        <form id="croc-form">
            <label>
                Species?
                <select name="species">
                    <option value="freshwater">Freshwater crocodile</option>
                    <option value="saltwater">Saltwater crocodile</option>
                    <option value="american">American crocodile</option>
                </select>
            </label>
            <button type="submit">Order</button>
        </form>
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
        <script>
        // Maps croc species to image URLs
        var crocImages = {
            "american": "https://upload.wikimedia.org/wikipedia/commons/f/f2/Crocodylus_acutus_mexico_02-edit1.jpg",
            "saltwater": "https://upload.wikimedia.org/wikipedia/commons/c/ca/Crocodylus_porosus_4.jpg",
            "freshwater": "https://upload.wikimedia.org/wikipedia/commons/c/ce/Australia_Cairns_18.jpg"
        };
        
        // When the user submits the form,
        //   Check what species they ordered
        //   and display an image of it
        
        $("#croc-form").on("submit", function(event) {
            event.preventDefault();
            var $crocSpecies = $(this).find("[name=species]"); // scoped
            var crocSpecies = $crocSpecies.val();
            var $img = $("<img>");
            $img.width(100);
            $img.attr("src", crocImages[crocSpecies]); 
            $img.appendTo("body");
            
        });
        </script>
        </body>
    </html>
    

## Review: Processing forms with jQuery
To process a form with jQuery, you should add an event listener to the form element for the 'submit' event:  
    $("form").on("submit", function() {
       // process form
    });
If you are processing the form entirely in jQuery, then you should call preventDefault() to prevent the page reloading:  
    $("form").on("submit", function(event) {
       event.preventDefault();
       // process form
    });
When you want to know what a user filled out for an input in a form, you typically use val():  
`var answer = $("#answer").val();`  
Inside the callback function, you can reference the form element using the this keyword. A common pattern is to call find() on the form element, to find only inputs inside the form element:  
    $("form").on("submit", function() {
      // store the value of the input with name='age' 
       var age = $(this).find('[name=age]').val();
    });  
[(See a full example here)](https://www.khanacademy.org/computer-programming/jquery-example-submit/4745335285612544 "(See a full example here)")  

## Project: Word game
###### We've started a webpage with a classic word game - the player sees a scrambled word, inputs what they think it is, and wins if they get it right. In this project, your goal is to add the jQuery needed for that game logic. Once you've got that working, add more words, style the win/lose message, and do anything else you think the game needs.  
    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="utf-8">
            <title>Project: Word game </title>
            <style>
                body {
                    font-family: Arial, sans-serif;
                }
                form {
                    font-size: 1.5em;
                }
                .scrambled, input, button {
                    font-family: monospace;
                    font-size: 2em;
                }
                
            </style>
        </head>
        <body>
        
        <h1>Word game!</h1>
        <form id="joke-form">
            <label>
                Unscramble these letters to form a word:<Br>
                <span class="scrambled">REYJUQ</span>
                <br>
                <input type="text" size="10">
            </label>
            <button type="submit">Check</button>
        </form>
    
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
        <script>
            // when the user submits the form,
            //   check that their answer is correct
            //   and show them appropriate message
            $("#joke-form").on("submit",function(event) {
                event.preventDefault();
                var $joke = $(this).find('input');
                var joke = $joke.val();
                console.log(joke);
                //create elements
                var p = $("<p>");
               
               
                if (joke === "jquery" || (joke.toLowerCase() === "jquery") ) {
                    p.text("You input: "+ joke + " is right!"); 
                }
                else {
                     p.text("You input: "+ joke + " is wrong!"); 
                } 
                p.addClass("scrambled");
                $("body").append(p);
            })
        </script>
        </body>
    </html>

 

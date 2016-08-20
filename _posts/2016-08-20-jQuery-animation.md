---
layout: post
title: Animating with jQuery
categories: [blog ]
tags: [study,html,js,jquery,animate, ]
description: 
---  

# HTML/jQuery making webpages interactive
## Animating visibility with jQuery
#### Learn how to use jQuery to show, hide, and toggle elements with animation effects.
    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="utf-8">
            <title>Animating visibility with jQuery</title>
            <style>
                #croc-pic {
                    border: 1px solid green;
                    width: 200px;
                }
            </style>
        </head>
        <body>
        
            <img id="croc-pic" src="https://upload.wikimedia.org/wikipedia/commons/f/f2/Crocodylus_acutus_mexico_02-edit1.jpg">
            <h1 id="croc-text">American Crocodile</h1>
            
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
            <script>
            $("#croc-pic").hide();
            $("#croc-text").hide();
            $("#croc-pic").slideDown(1000, function() {
                $("#croc-text").fadeIn();
            });
            
                
            </script>
            
        </body>
    </html>

## Animating numeric properties with jQuery
#### Learn how to use jQuery to animate elements in custom ways, like animating their sizes, borders, and spacing, to whatever values you specify.
    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="utf-8">
            <title>Animating numeric properties with jQuery</title>
            <style>
                #croc-pic {
                    border: 1px solid green;
                    width: 200px;
                }
            </style>
        </head>
        <body>
        
            <img id="croc-pic" src="https://upload.wikimedia.org/wikipedia/commons/f/f2/Crocodylus_acutus_mexico_02-edit1.jpg">
            <h1 id="croc-text">American Crocodile</h1>
            
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
            <script>
            $("#croc-pic").animate({
                width: "400px",
                marginLeft: "30px",
                borderWidth: "10px"
            }, 1500);
            
            $("#croc-text").animate({
               marginLeft: "30px",
               fontSize: "3em"
            });
                
            </script>
            
        </body>
    </html>

## Review: DOM animation in jQuery
jQuery provides a number of functions for animation and effects, which are listed in its [documentation](https://api.jquery.com/category/effects/ "documentation").  
#### Changing visibility  
For simple visibility changes, you can use hide() and show():  
`$("#pic").hide();
$("#pic").show();`  
[ (See example)](https://www.khanacademy.org/computer-programming/jquery-example-show-hide-toggle/5805110748381184 " (See example)")  
You can also use toggle(), which will decide whether to show or hide based on the current state: $("#pic").toggle(); ([See example](https://www.khanacademy.org/computer-programming/jquery-example-show-hide-toggle/5805110748381184 "See example"))  
You can also use slideDown(), slideUp() and slideToggle() for sliding effects (See example) or fadeIn(), fadeOut() and fadeToggle() for fading effects ([See example](https://www.khanacademy.org/computer-programming/jquery-example-fadein-fadeout-and-fadetoggle/5312653019447296 "See example")).  
You can pass a callback function as the second parameter to any of those functions, and jQuery will call that callback function when the animation is complete:  
    $("#pic").toggle(1000, function() {
        $("body").append("It's here!");
    });

You can also chain multiple effects together and call [delay()](https://api.jquery.com/delay/ "delay()") if you'd like a delay between them   
`$("#pic").slideUp(300).delay().fadeIn();`  

#### Custom animation  
If you'd like to animate specific CSS properties, you can use animate():  
    $("#pic").animate({
       width: "70%",
       opacity: 0.7,
       padding: 20
    }, 1000);
Note that you can only animate CSS properties that take numeric values - so you can't use this to animate properties like 'color'. ([See example](https://www.khanacademy.org/computer-programming/jquery-example-animate/6147702841278464 "See example"))   
You can also attach various callback functions in animate(), if you'd like to find out when the animation has progressed or is complete. Check [the documentation](https://api.jquery.com/animate/#animate-properties-options "the documentation") for more details.  

#### Animating responsibly  
Animations should always improve the user experience, not make it worse. Animations should help users understand something about the state of your web app or add a touch of fun - they should not slow down the experience unnecessarily and frustrate the user. You can ask users for feedback about your use of animations or work with a designer to decide how and where to animate.  
If you know your user is on a device that doesn't perform well with animations, you can set[ $.fx.off](https://api.jquery.com/jquery.fx.off/ " $.fx.off") to true.  

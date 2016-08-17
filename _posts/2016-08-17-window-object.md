---
layout: post
title: HTML/JS Window Object
categories: [blog ]
tags: [study,html,js, ]
description: 
---  

#HTML/JS making webpages interactive
##The window object
```
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>The window object</title>
    </head>
    <body>

        <h1>I'm all about that window...</h1>
        
        <div id="info"></div>
        
        <script>
        var infoDiv = document.getElementById("info");
        console.log(window);
        console.log(window.location);
        infoDiv.textContent += "The URL of this page is " + window.location.href;
        
        infoDiv.textContent += "The user agent is " + window.navigator.userAgent;
        
        infoDiv.textContent += " This webpage is " + outerWidth + " by " + outerHeight;
        // KA_
        
        
        </script>
    </body>
</html>
```

##Animating DOM with setInterval
```
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Animating DOM with setInterval</title>
    </head>
    <body>
    <div>
        <img id="ohnoes" src="https://www.kasandbox.org/programming-images/creatures/OhNoes.png">
        <h1>Oh noes, the world will end in
            <span id="countdown">5</span>
            seconds!
        </h1>
    </div>
    
  <script>
  // Step 1. What element do we want to animate?
  var countdown = document.getElementById("countdown");
  // Step 2. What function will change it each time?
  var countItDown = function() {
    var currentTime = parseFloat(countdown.textContent);
    if (currentTime > 0) {
       countdown.textContent = currentTime - 1;   
    } else {
        window.clearInterval(timer);
    }
    
  };
  // Step 3: Call that on an interval
  var timer = window.setInterval(countItDown, 1000);
  </script>

    </body>
</html>
```


##Animating styles with requestAnimationFrame

    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="utf-8">
            <title>Animating styles with requestAnimationFrame</title>
        </head>
        <body>
        <div>
            <img id="ohnoes" src="https://www.kasandbox.org/programming-images/creatures/OhNoes.png">
            <h1>Oh noes, the world will end in
                <span id="countdown">30</span>
                seconds!
            </h1>
            <div id="info"></div>
        </div>
        
      <script>
      var infoDiv = document.getElementById("info");
      
      var countdown = document.getElementById("countdown");
      var countItDown = function() {
        var currentTime = parseFloat(countdown.textContent);
        if (currentTime > 0) {
           countdown.textContent = currentTime - 1;   
        } else {
            window.clearInterval(timer);
        }
        
      };
      var timer = window.setInterval(countItDown, 1000);
      
      // Step 1. What element do we want to animate?
      var ohnoes = document.getElementById("ohnoes");
      ohnoes.style.width = "50px";
      
      // Step 2. What function will change it each time?
      var startTime = new Date().getTime();
      var makeItBigger = function() {
          var currTime = new Date().getTime();
          var newWidth = (50 + ((currTime - startTime)/1000) * 30);
           ohnoes.style.width = newWidth + "px"; 
           
           if (newWidth < 300) {
               window.requestAnimationFrame(makeItBigger);
           }
        
      };
      makeItBigger();
      </script>
    
        </body>
    </html>

##Animating styles with CSS animations



    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="utf-8">
            <title>Animating styles with CSS animations</title>
            <style>
                @keyframes getbigger {
                    from {
                        width: 50px;
                    }
                    
                    to {
                        width: 300px;
                    }
                }
                
                @-webkit-keyframes getbigger {
                    from {
                        width: 50px;
                    }
                    
                    to {
                        width: 300px;
                    }
                }
                
                #ohnoes {
                    animation-name: getbigger;
                    animation-duration: 3s;
                    /* vendor prefixes */
                    -webkit-animation-name: getbigger;
                    -webkit-animation-duration: 3s;
                }
                
                #countdown:hover {
                    font-size: 150px;
                    transition: font-size 1s linear;
                }
            </style>
        </head>
        <body>
        <div>
            <img id="ohnoes" src="https://www.kasandbox.org/programming-images/creatures/OhNoes.png">
            <h1>Oh noes, the world will end in
                <span id="countdown">30</span>
                seconds!
            </h1>
            <div id="info"></div>
        </div>
        
      <script>
      var infoDiv = document.getElementById("info");
      
      var countdown = document.getElementById("countdown");
      var countItDown = function() {
        var currentTime = parseFloat(countdown.textContent);
        if (currentTime > 0) {
           countdown.textContent = currentTime - 1;   
        } else {
            window.clearInterval(timer);
        }
        
      };
      var timer = window.setInterval(countItDown, 1000);
      
      /*
      // Step 1. What element do we want to animate?
      var ohnoes = document.getElementById("ohnoes");
      ohnoes.style.width = "50px";
      
      // Step 2. What function will change it each time?
      var startTime = new Date().getTime();
      var makeItBigger = function() {
          var currTime = new Date().getTime();
          var newWidth = (50 + ((currTime - startTime)/1000) * 30);
           ohnoes.style.width = newWidth + "px"; 
           
           if (newWidth < 300) {
               window.requestAnimationFrame(makeItBigger);
           }
        
      };
      makeItBigger();
      */
      </script>
    
        </body>
    </html>

##What DOM animation technique should you use?
You've now seen three techniques that let you animate parts of your webpage: window.setInterval/setTimeout, window.requestAnimationFrame, and CSS animations/transitions.

When you're considering what technique to use, you should consider these questions:

Can it actually do what I want to do?
How well does this technique perform? (Does it slow down the browser/computer?)
How accurate does my timing need to be?
Does it work in all the browsers that I want my webpage to work in?
When making webpages, we're very concerned about performance, so we like to consider that as the most important criteria. However, browser performance does change when new browsers come out, and mobile browsers can perform very differently from desktop browsers, so the technique that performs best today may not be the technique that performs best tomorrow. Currently, CSS animations/transitions are the most performant, then requestAnimationFrame, then setInterval.

However, CSS can't do everything. For example, to draw pixels and shapes in a <canvas> tag, you have to call functions like fillRect(), you can't use CSS. You would need to use requestAnimationFrame or setInterval to call those functions periodicially instead. In fact, that's what we do here on Khan Academy, in our ProcessingJS environment. ProcessingJS is a JS library that writes out to a <canvas> tag, and if you define a draw() function in your code, then ProcessingJS uses setInterval to call that draw() function repeatedly based on the frameRate.

Sometimes, you want to call JavaScript functions periodically, but not because you want to animate something on the page. You might be polling a server for updates, like Twitter does when it updates its realtime feed. In that case, you can just use setInterval, and it doesn't matter that the timing isn't accurate, because you're only calling it every minute or so. That's what we do on Khan Academy on the help requests page, to continuously check for new help requests every 2 minutes.

Of course, you should keep browser compatibility in mind. If you're writing code that needs to work in IE9, then you can't use requestAnimationFrame or CSS animations. You need to use a combination of techniques that work across the browsers, or find a library that does that for you, like Velocity.js.

There is a lot more to learn about all of these techniques. Follow these links to learn more:

CreativeJS: requestAnimationFrame
CSS Tricks: Using requestAnimationFrame
MDN: Guide to using CSS animations
TutsPlus: Beginners intro to CSS animation
The art of web: CSS animation
CSS Animation: An interactive guide
Bonus for Doctor Who fans: one of my favorite examples of the power of CSS3 animations is this animated TARDIS.

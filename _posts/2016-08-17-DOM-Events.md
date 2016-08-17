---
layout: post
title: HTML/JS DOM Events
categories: [blog ]
tags: [study,html,js, ]
description: 
---  
#HTML/JS making webpages interactive
##DOM Events
###Using event properties
```
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Using the event properties</title>
        <style>
        .beard {
              	background: black;
         		width: 5px;
         		height: 5px;
         		position: absolute;
         		border-radius: 2px;
         		top: 80px;
         		left: 15px;
         	}
        </style>
    </head>
    <body>
    
    <img id="face" src="https://www.kasandbox.org/programming-images/creatures/Winston.png">
    <div id="message"></div>
    
    <script>
    // 1. Find and store the element we want to listen to events on.
    var face = document.getElementById("face");
    // 2. Define the function that will respond to the event.
    var onMouseMove = function(event) {
        console.log(event);
        document.getElementById("message").textContent += "mooove ";         var beard = document.createElement("div");
        beard.className = "beard";
        document.body.appendChild(beard);
        beard.style.top = event.clientY + "px";
        beard.style.left = event.clientX + "px";
        
    };
    // 3. Add the event listener for the element and function
    face.addEventListener("mousemove", onMouseMove);
    </script>
    </body>
</html>
```

##Processing Forms With Elements

```
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Processing forms with events</title>
    </head>
    <body>
    <div>
        <label>What's your name?
        <input id="name" type="text">
        </label>
        <br>
        <label>What language do you speak?
        <select id="lang">
            <option value="en">English</option>
            <option value="es">Spanish</option>
            <option value="plt">Pig-latin</option>
        </select>
        </label>
        <br>
        <button id="button" type="button">Greet me, please!</button>
        <div id="message"></div>
    </div>
    
  <script>
  // Step 1: Find the element we want the event on
  var button = document.getElementById("button");
  // Step 2: Define the event listener function
     
  var onButtonClick = function() {
    var name = document.getElementById("name").value;
    var lang = document.getElementById("lang").value;
    var greeting;
    if (lang === "es") {
        greeting = "Hola, " + name;
    } else if (lang === "plt") {
        greeting = "Ello-hay, " + name;
    } else {
        greeting = "Heyaz, " + name;
    }
    document.getElementById("message").textContent += greeting;  
  };
  // Step 3: Attach event listener to element
  button.addEventListener("click", onButtonClick);
  </script>

    </body>
</html>

```
//when trying to insert the image into an input(which you can't cause its an empty //element). Just insert the image into the li.

//li.innerHTML = "<img src=\"" + imageReveal + "\">";

####example 2
```
<!DOCTYPE html>
<html>
 <head>
  <meta charset="utf-8" />
  <title>Challenge: Mad Libs</title>
 </head>
 <body>
 
    <h1>Mad Libs</h1>
     
    <ul>
      <li>Noun: <input type="text" id="noun"></li>
      <li>Adjective: <input type="text" id="adjective"></li>
      <li>Someone's Name: <input type="text" id="person"></li>
    </ul>
     
    <button id="lib-button">Lib it!</button>
      
    <p>Generated story: 
    <span id="story"></span>
    </p>
 
    <script>
        var libButton = document.getElementById('lib-button');
        var libIt = function() {
            var storyDiv = document.getElementById("story");
            var n = document.getElementById("noun").value;
            var a = document.getElementById("adjective").value;
            var p = document.getElementById("person").value;
            storyDiv.innerHTML = p + "is a/an " + a + " person or " + n;
            if(n==="person") {
                story.innerHTML += "<img src=\"https://cdn.kastatic.org/images/avatars/svg/cs-winston.svg" + "\">";
            }
        };
        libButton.addEventListener('click', libIt);
        
    </script>
  
 </body>
</html>

```

##Preventing Default Behavior of Events

```
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Preventing default behavior of events</title>
    </head>
    <body>
    
        <a id="ohnoes" href="https://www.kasandbox.org/programming-sounds/rpg/giant-no.mp3">What does Oh Noes say?</a>
    
      <script>
        // Step 1: Find the element we want the event on
        var ohnoesEl = document.getElementById("ohnoes");
        // Step 2: Define the event listener function
        var onOhNoesClick = function(e) {
//without using preventDefault,it will navigate to the link by default
            e.preventDefault();
            var audioEl = document.createElement("audio");
            audioEl.src = "https://www.kasandbox.org/programming-sounds/rpg/giant-no.mp3";
            audioEl.autoplay = "true";
            document.body.appendChild(audioEl);
        };
        // Step 3: Attach event listener to element
        ohnoesEl.addEventListener("click", onOhNoesClick);
        
      </script>
    </body>
</html>
```

##Summary DOM Events
###Adding event listeners

To make sure that the browser calls a particular function when an event happens on an element, you must use document.addEventListener:
```
var buttonEl = document.getElementById("clicker");
var onButtonClick = function() {
    console.log("Oh golly gosh, you clicked me");
};
buttonEl.addEventListener("click", onButtonClick);
```
You can pass many valid strings as the first argument, see the event types article.

If you want information about the event that happened, you can look at the event object that the browser passes to your callback function:
```
var faceEl = document.getElementById("face");
var onFaceClick = function(e) {
    console.log("You clicked " + e.clientX + " , " + e.clientY);
};
faceEl.addEventListener("click", onFaceClick);
```
There are many properties on the event object, you can see a full list here.

If you are overriding click behavior on a link or submit behavior on a form, you may want to call event.preventDefault() to prevent the browser's default behavior.

###Removing event listeners
If you no longer need a particular event listener, you can remove it using removeEventListener:

```
var faceEl = document.getElementById("face");
var onFaceClick = function(e) {
    console.log("You clicked " + e.clientX + " , " + e.clientY);
};
faceEl.addEventListener("click", onFaceClick);
// later...
faceEl.removeEventListener("click", onFaceClick);
```

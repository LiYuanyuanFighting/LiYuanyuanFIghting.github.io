articles talking about object oriented programming:  
http://www.webdeveasy.com/object-oriented-programming-with-javascript/  
[prototype](http://www.webdeveasy.com/javascript-prototype/)  
 In the prototype approach, all the instances will share one set of methods and therefore less memory.  
[scope in javascript](http://www.digital-web.com/articles/scope_in_javascript/)    
this: https://developer.mozilla.org/en/docs/Web/JavaScript/Reference/Operators/this  
A common trap with the function invocation is thinking that this is the same in an inner function as in the outer function. 
 Correctly the context of the inner function depends only on invocation, but not on the outer function's context.  
 https://rainsoft.io/gentle-explanation-of-this-in-javascript/  
 
 Object literal:  
functionName: function() {
    // some code
}
This is declaring an object property called functionName with a value that's an anonymous (unnamed) function. This would only occur within curly braces defining an object literal. It's different from the following, which declares a named function in the current scope, but isn't a property of any object:

function functionName() {
    // some code
}
You can learn more about object literals here: [MDN Grammar Reference](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Grammar_and_types#Object_literals)  

[Object Initializer](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Object_initializer)  


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

In the other [article](http://javascriptissexy.com/understand-javascripts-this-with-clarity-and-master-it/):   
It introduces 1. this is like a pronoun to use like a shortcut, a referent; it refers to an object, that is , the  
subject in context, or the subject of the executing code.  2. When a function executes, it gets the this property-  
a variable with the value of the object that invokes the function where this is used.his is used inside a function  
(let’s say function A) and it contains the value of the object that invokes function A. We need this to access methods  
and properties of the object that invokes function A, especially since we don’t always know the name of the invoking   
object, and sometimes there is no name to use to refer to the invoking object. Indeed, this is really just a shortcut  
reference for the “antecedent object”—the invoking object.  
`

    var person = {
        firstName   :"Penelope",
        lastName    :"Barrymore",
        // Since the "this" keyword is used inside the showFullName method below, and the showFullName method is defined on the person object,​
        // "this" will have the value of the person object because the person object will invoke showFullName ()​
        showFullName:function () {
        console.log (this.firstName + " " + this.lastName);
        }
    ​
        }
    ​
        person.showFullName (); // Penelope Barrymore`


3. In the global scope, when the code is executing in the browser, all global variables and functions are defined  
on the window object. Therefore, when we use this in a global function, it refers to (and has the value of) the   
global window object (not in strict mode though, as noted earlier) that is the main container of the entire JavaScript  
application or web page.  
`

    var firstName = "Peter",
        lastName = "Ally";
    ​
        function showFullName () {
        // "this" inside this function will have the value of the window object​
        // because the showFullName () function is defined in the global scope, just like the firstName and lastName​
        console.log (this.firstName + " " + this.lastName);
        }
    ​
        var person = {
        firstName   :"Penelope",
        lastName    :"Barrymore",
        showFullName:function () {
        // "this" on the line below refers to the person object, because the showFullName function will be invoked by person object.​
        console.log (this.firstName + " " + this.lastName);
        }
        }
    ​
        showFullName (); // Peter Ally​
    ​
        // window is the object that all global variables and functions are defined on, hence:​
        window.showFullName (); // Peter Ally​
    ​
        // "this" inside the showFullName () method that is defined inside the person object still refers to the person object, hence:​
        person.showFullName (); // Penelope Barrymore`


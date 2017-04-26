/*Note: learned from datacamp*/   

**Arithmetic with R**   
In its most basic form, R can be used as a simple calculator. Consider the following arithmetic operators:

Addition: +
Subtraction: -
Multiplication: *
Division: /
Exponentiation: ^
Modulo: %%  
The ^ operator raises the number to its left to the power of the number to its right: for example 3^2 is 9.
The modulo returns the remainder of the division of the number to the left by the number on its right, for example 5 modulo 3 or 5 %% 3 is 2.
example:
    # An addition
    5 + 5 
    
    # A subtraction
    5 - 5 
    
    # A multiplication
    3 * 5
    
     # A division
    (5 + 5) / 2 
    
    # Exponentiation
    5^2
    
    # Modulo
    
**To Assign Variable**  
my_var <- 4   

**Check the Data Type**  
my_numeric <- 42  
class(my_numeric)

**Create a vector**  
To create a vector, use the combine function c(), for example:  
numeric_vector <- c(1, 2, 3)  
character_vector <- c("a", "b", "c")

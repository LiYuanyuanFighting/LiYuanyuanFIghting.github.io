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

**Naming a vector**  
with the names() function:  
example:  
some_vector <- c("John Doe", "poker player")  
names(some_vector) <- c("Name", "Profession")  
Then have:  
    Name    Profession  
 "John Doe" "poker player"

**Calculate the sum of all elements of a vector**  
with the sum() function:  
example:  
total_poker <- sum(poker_vector)  

**Vector selection**  
c(2, 3, 4) can be abbreviated to 2:4  
e.g. poker_vector[2:4]
The first element in a vector has index 1, not 0  

for the average: mean()

**Sel**

**Rengine**  
Rengine class is the interface between an instance of R and the Java VM. Due to the fact that R has no threading support, you can run only one instance of R withing a multi-threaded application. There are two ways to use R from Java: individual call and full event loop. See the Rengine constructor for details.
eval(java.lang.String s)  Parses and evaluates an R expression and returns the result.

**What's a matrix?**  
In R, a matrix is a collection of elements of the same data type (numeric, character, or logical) arranged into a fixed number of rows and columns. Since you are only working with rows and columns, a matrix is called two-dimensional.

You can construct a matrix in R with the matrix() function. Consider the following example:

matrix(1:9, byrow = TRUE, nrow = 3)
In the matrix() function:

The first argument is the collection of elements that R will arrange into the rows and columns of the matrix. Here, we use 1:9 which is a shortcut for c(1, 2, 3, 4, 5, 6, 7, 8, 9).
The argument byrow indicates that the matrix is filled by the rows. If we want the matrix to be filled by the columns, we just place byrow = FALSE.
The third argument nrow indicates that the matrix should have three rows.

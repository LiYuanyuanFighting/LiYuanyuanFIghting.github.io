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
    // An addition
    5 + 5 
    
    // A subtraction
    5 - 5 
    
    // A multiplication
    3 * 5
    
     // A division
    (5 + 5) / 2 
    
    // Exponentiation
    5^2
    
    // Modulo
    
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

**Naming a matrix**  
# Box office Star Wars (in millions!)
new_hope <- c(460.998, 314.4)
empire_strikes <- c(290.475, 247.900)
return_jedi <- c(309.306, 165.8)

# Construct matrix
star_wars_matrix <- matrix(c(new_hope, empire_strikes, return_jedi), nrow = 3, byrow = TRUE)

# Vectors region and titles, used for naming
region <- c("US", "non-US")
titles <- c("A New Hope", "The Empire Strikes Back", "Return of the Jedi")

# Name the columns with region
colnames(star_wars_matrix) <- region

# Name the rows with titles
rownames(star_wars_matrix) <- titles

# Print out star_wars_matrix
star_wars_matrix

**To calculate the totals of rows**  
rowSums() conveniently calculates the totals for each row of a matrix. This function creates a new vector.  
rowSums(my_matrix)  

**Adding a column to a matrix**  
You can add a column or multiple columns to a matrix with the cbind() function, which merges matrices and/or  
vectors together by column. e.g.
big_matrix <- cbind(matrix1, matrix2, vector1 ...)

**Adding a row**  
Your R workspace, where all variables you defined 'live' ([check out what a workspace is](http://www.statmethods.net/interface/workspace.html) ), has already been initialized and contains two matrices:

star_wars_matrix that we have used all along, with data on the first trilogy,
star_wars_matrix2, with similar data for the second trilogy.
Type the name of these matrices in the console and hit Enter if you want to have a closer look. If you want to check out the contents of the workspace, you can type ls() in the console.

**Categorical Variable**  
There are two types of categorical variables: a nominal categorical variable and an ordinal categorical variable.  
A nominal variable is a categorical variable without an implied order. This means that it is impossible to say that 'one is worth more than the other'. For example, think of the categorical variable animals_vector with the categories "Elephant", "Giraffe", "Donkey" and "Horse". Here, it is impossible to say that one stands above or below the other.  
In contrast, ordinal variables do have a natural ordering. Consider for example the categorical variable temperature_vector with the categories: "Low", "Medium" and "High". Here it is obvious that "Medium" stands above "Low", and "High" stands above "Medium".  
      // Animals
      animals_vector <- c("Elephant", "Giraffe", "Donkey", "Horse")
      factor_animals_vector <- factor(animals_vector)
      factor_animals_vector

      // Temperature
      temperature_vector <- c("High", "Low", "High","Low", "Medium")
      factor_temperature_vector <- factor(temperature_vector, order = TRUE, levels = c("Low", "Medium", "High"))
      factor_temperature_vector

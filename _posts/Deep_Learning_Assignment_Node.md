### Python Basics with numpy
**Goal**  
 - Learn how to use numpy.

- Implement some basic core deep learning functions such as the softmax, sigmoid, dsigmoid, etc...

- Learn how to handle data by normalizing inputs and reshaping images.

- Recognize the importance of vectorization.

- Understand how python broadcasting works.   
Reminder: sigmoid(x)=1/(1+e−x) sigmoid(x)=11+e−x is sometimes also known as the logistic function.   
It is a non-linear function used not only in Machine Learning (Logistic Regression), but also   
in Deep Learning. In math, use math.exp()  
we use "numpy" instead of "math" in Deep Learning  
Exercise: Implement image2vector() that takes an input of shape (length, height, 3) and returns a vector of shape (length*height*3, 1). For example, if you would like to reshape an array v of shape (a, b, c) into a vector of shape (a*b,c) you would do:

v = v.reshape((v.shape[0]*v.shape[1], v.shape[2])) # v.shape[0] = a ; v.shape[1] = b ; v.shape[2] = c  
-  v = image.reshape((image.shape[0]*image.shape[1]*image.shape[2], 1))
- [normalize rows](https://docs.scipy.org/doc/numpy/reference/generated/numpy.linalg.norm.html)  
- [broadcasting](https://docs.scipy.org/doc/numpy/reference/generated/numpy.linalg.norm.html)  
 What you need to remember:

    np.exp(x) works for any np.array x and applies the exponential function to every coordinate
    the sigmoid function and its gradient
    image2vector is commonly used in deep learning
    np.reshape is widely used. In the future, you'll see that keeping your matrix/vector dimensions straight will go toward eliminating a lot of bugs.
    numpy has efficient built-in functions
    broadcasting is extremely useful

**Vectorization**  
Note that np.dot() performs a matrix-matrix or matrix-vector multiplication. This is different from np.multiply() and the * operator (which is equivalent to .* in Matlab/Octave), which performs an element-wise multiplication.  
2.1 Implement the L1 and L2 loss functions

Exercise: Implement the numpy vectorized version of the L1 loss. You may find the function abs(x) (absolute value of x) useful.
Reminder:

    The loss is used to evaluate the performance of your model. The bigger your loss is, the more different your predictions (ŷ y^) are from the true values (yy). In deep learning, you use optimization algorithms like Gradient Descent to train your model and to minimize the cost.
    L1 loss is defined as:
    L1(ŷ ,y)=∑i=0m|y(i)−ŷ (i)|  
    
    Exercise: Implement the numpy vectorized version of the L2 loss. There are several way of implementing the L2 loss but you may find the function np.dot() useful. As a reminder, if x=[x1,x2,...,xn]x=[x1,x2,...,xn], then np.dot(x,x) = ∑nj=0x2j∑j=0nxj2.

    L2 loss is defined as
    L2(ŷ ,y)=∑i=0m(y(i)−ŷ (i))2

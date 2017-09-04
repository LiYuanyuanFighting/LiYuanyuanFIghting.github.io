### Monte Carlo Methods for Optimization Problems  
**Gradient ascent/descent**  
Gradient descent is a first-order iterative optimization algorithm for finding the minimum of a function. To find a local minimum of a function using gradient descent, one takes steps proportional to the negative of the gradient (or of the approximate gradient) of the function at the current point. If instead one takes steps proportional to the positive of the gradient, one approaches a local maximum of that function; the procedure is then known as gradient ascent.

Gradient descent is also known as steepest descent. However, gradient descent should not be confused with the method of steepest descent for approximating integrals.  

[Steepest Ascent](https://i.imgur.com/sM5a0hy.png)  
Steepest descent would just be in the opposite direction to the steepest ascent.  
[Steepest Example](https://i.imgur.com/Hpou35y.png)  
Note: D means deriavative   
[Steepest Example2](https://i.imgur.com/e1ZzKoy.png)
The length of the gradient measures the maximum possible rate of change rate. So in  
the opposite direction you just get the opposite value negative root 6, we can't go  
down any faster than that and so we won't be able to do it.  
The steepest descent search is an extension that goes in the direction of the line of   
the gradient in each step, basically an optimum step is down, also referred to as a steepest  
step. The aim is to locate the maximum/minimum of a function.   
Successful Example:  
[SuccessfulGraph](https://i.imgur.com/cgWL2VS.png)
´´´r
library("animation")
grad.desc()
´´´  
Unsuccessful Example:  
[UnsuccessfulGraph](https://i.imgur.com/IsX91td.png)
´´´r
> ani.options(nmax = 70)
animation option 'nmax' changed: 50 --> 70
> par(mar = c(4, 4, 2, 0.1))
> f2 = function(x, y) sin(1/2 * x^2 - 1/4 * y^2 + 3) * cos(2 * x + 1 -
+  exp(y))
> grad.desc(f2, c(-2, -2, 2, 2), c(-1, 0.5), gamma = 0.3, tol = 1e-04)
Warning message:
In grad.desc(f2, c(-2, -2, 2, 2), c(-1, 0.5), gamma = 0.3, tol = 1e-04) :
  Maximum number of iterations reached!
´´´  



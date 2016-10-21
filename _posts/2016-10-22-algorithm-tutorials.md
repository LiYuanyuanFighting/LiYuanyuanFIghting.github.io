**What is the difference between Θ(n) and O(n)?**
O(n) represents upper bound. Θ(n) means tight bound. Ω(n) represents lower bound.

f(x) = Θ(g(x)) iff f(x) = O(g(x)) and f(x) = Ω(g(x))


down vote
There's a simple way (a trick, I guess) to remember which notation means what.

All of the Big-O notations can be considered to have a bar.

When looking at a Ω, the bar is at the bottom, so it is an (asymptotic) lower bound.

When looking at a Θ, the bar is obviously in the middle. So it is an (asymptotic) tight bound.
An algorithm is said to be constant time (also written as O(1) time) ..
 Why should I write O(2342.4534675767) when it can be easier expressed with O(1), which communicates
 the facts of the case unambiguously.

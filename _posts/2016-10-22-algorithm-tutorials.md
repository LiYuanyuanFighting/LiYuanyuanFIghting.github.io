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
 
Given an int array which might contain duplicates, find the largest subset of it which form a sequence. 
Eg. {1,6,10,4,7,9,5} 
then ans is 4,5,6,7 

Sorting is an obvious solution. Can this be done in O(n) time
def find(arr):
    table = {}
    first = 0
    last = 0
    for i in arr:
        beg = end = i
        if i in table:
            continue
        table[i] = 'EXISTED'
        if i - 1 in table:
            beg = table[i-1]
        if i + 1 in table:
            end = table[i+1]
        table[beg] = end
        table[end] = beg
        if end - beg > last - first:
            first = beg
            last = end
    return list(range(first, last + 1))

arr = [1,6,10,4,7,9,5, 5,8]
            
print(find(arr))
okay here is an explanation: 
Logic here is that each element in the hashtable keeps track of the sequence. So boundary elements of the sequence are important as the end element of the sequence points to beginning element of the sequence and beginning element of the sequence points to the end element. So whenever a new element is to be added to the sequence it picks up the boundary value and becomes the new boundary. Check how 8 is added to the table below:


Array a:      [1, 6, 10, 4, 7, 8]

i: 1 	 Table: {1=1}
i: 6 	 Table: {1=1, 6=6}
i: 10 	 Table: {1=1, 6=6, 10=10}
i: 4 	 Table: {1=1, 4=4, 6=6, 10=10}
i: 7 	 Table: {1=1, 4=4, 6=7, 7=6, 10=10}
i: 8 	 Table: {1=1, 4=4, 6=8, 7=6, 8=6, 10=10}

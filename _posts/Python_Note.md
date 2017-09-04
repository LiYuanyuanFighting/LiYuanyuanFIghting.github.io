**numpy.squeeze**
[numpy.squeeze](https://www.douban.com/note/614399507/)  
如果维度值为1，则降一维，不断迭代，直至去掉所有维度值是1的维，剩下既是结果。  
```
>>> import numpy as np
>>> x = np.array([[[0], [1], [2]]])
>>> x.shape
(1, 3, 1)
>>> x.squeeze()
array([0, 1, 2])
>>> y = np.array([[[0,1], [1], [2]]])
>>> y.shape
(1, 3)
>>> y.squeeze()
array([[0, 1], [1], [2]], dtype=object)
>>> y.squeeze().shape
(3,)
>>> y.ndim
2
>>> x.ndim
3
>>> 
```  
**numpy dimension**  
[numpy dimension](https://stackoverflow.com/questions/16018203/numpy-dimensions)  


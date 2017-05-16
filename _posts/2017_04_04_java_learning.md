**keyword transient**  

transient variables are never serialized in java.

It marks a member variable not to be serialized when it is persisted to streams of bytes. When an object is transferred 
through the network, the object needs to be 'serialized'. Serialization converts the object state to serial bytes. Those
bytes are sent over the network and the object is recreated from those bytes. Member variables marked by the java transient
keyword are not transferred, they are lost intentionally.

serialization  
In computer science, in the context of data storage, serialization is the process of translating 
data structures or object state into a format that can be stored (for example, in a file or memory
buffer, or transmitted across a network connection link) and reconstructed later in the same or 
another computer environment.[1] When the resulting series of bits is reread according to the 
serialization format, it can be used to create a semantically identical clone of the original 
object. For many complex objects, such as those that make extensive use of references, this process
is not straightforward. Serialization of object-oriented objects does not include any of their 
associated methods with which they were previously linked.  
Serialization breaks the opacity of an abstract data type by potentially exposing private implementation
details. Trivial implementations which serialize all data members may violate encapsulation.
[reference](https://en.wikipedia.org/wiki/Serialization)

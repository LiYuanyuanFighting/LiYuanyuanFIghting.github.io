For distributed process interaction, we were first introduced 3 architectures:  
Java RMI Architecture   
ORB-based Architecture   
SOA(service oriented architecture)  

Then we are concentrating on the last one. SOA consists of organizing software as a set of service  
How do services be provided? 2 ways: Published and Automatically discoverable; Machine readable.  
How to describe service? 1st, it is described by a contract, defined by one or more interfaces. 2nd,  
The service is implemented by a single instance, always available. It should be coarse grained and  
loosely coupled which means to reduce number of interactions.  

What is **Web Service**?  
They are distributed applications with SOA architecture which iis based on open internet protocols  
(in particular HTTP), modular, loosely couples and auto-descriptive.  
What are differences between web application and web service?  
![web services](http://imgur.com/FlmeStw "web services")
  
through the picture, we can find web application is for the interaction between browser and web  
server through http to transmit data using html represented; for web service, it is between client  
application(browser can be seen as a special case of client) and web server using http still to  
transmit data represented by XML or JSON.  
There are some interesting features of web services:  
1. pass through firewalls  
2. total platform independence  
3. simplicity  
4. universality(neutral w.r.t. choices such as Java EE vs .NET)  
5. low cost solution for legacy application integration(e.g.EAI)  

what is possible scenarios?
1.Software components, made available through the network as web services(SaaS)  
-A software vendor sells the **usage** of software components and manages internally as its maintenance   
2. whole applications(for example a whole information system process)  made available as web services  
3. Integration of services in order to create added-value new services(e.g.: a travel booking service based  
on hotel booking services, flight and train booking services, tec.)

![standard services](http://imgur.com/Vd3kj0n)

What is the use of SOAP?
SOAP(Simple Object Access Protocol) relies exclusively on XML to provide messaging services. Microft  
originally developed SOAP to take the place of older technologies that don't work well on the Internet  
such as the Distributed Component Object Model(DCOM) and Common Object Request Broker Architecture(CORBA).  
These technologies fail because they rely on binary messaging; the XML messaging that SOAP employs works  
better over the Internet.    
SOAP has built-in error handling. If there's a problem with your request, the response contains error  
information that you can use to fix the problem.   
With SOAP, you don't have to use HTTP, instead, you can use SMTP or FTP.   

![SOAP model](http://imgur.com/rnJp79b)

![Restful model](http://imgur.com/SL88YFe)

What is a REST Web Service 

The acronym REST stands for Representational State Transfer, this basically means that each unique URL is a representation of some object. You can get the contents of that object using an HTTP GET, to delete it, you then might use a POST, PUT, or DELETE to modify the object (in practice most of the services use a POST for this).  

Who's using REST?

All of Yahoo's web services use REST, including Flickr, del.icio.us API uses it, pubsub, bloglines, technorati, and both eBay, and Amazon have web services for both REST and SOAP.

Who's using SOAP?

Google seams to be consistent in implementing their web services to use SOAP, with the exception of Blogger, which uses XML-RPC. You will find SOAP web services in lots of enterprise software as well.

REST vs SOAP  

As you may have noticed the companies I mentioned that are using REST api's haven't been around for very long, and their apis came out this year mostly. So REST is definitely the trendy way to create a web service, if creating web services could ever be trendy (lets face it you use soap to wash, and you rest when your tired). The main advantages of REST web services are:

Lightweight - not a lot of extra xml markup Human Readable Results Easy to build - no toolkits required SOAP also has some advantages:

Easy to consume - sometimes Rigid - type checking, adheres to a contract Development tools For consuming web services, its sometimes a toss up between which is easier. For instance Google's AdWords web service is really hard to consume (in CF anyways), it uses SOAP headers, and a number of other things that make it kind of difficult. On the converse, Amazon's REST web service can sometimes be tricky to parse because it can be highly nested, and the result schema can vary quite a bit based on what you search for.

Which ever architecture you choose make sure its easy for developers to access it, and well documented.  

[reference1](http://blog.smartbear.com/apis/understanding-soap-and-rest-basics/ "reference1")  
[reference2](http://stackoverflow.com/questions/2131965/main-differences-between-soap-and-restful-web-services-in-java)

What is java servlet?  
A java servlet is a java program that extends the capabilities of a server. Although servlets can respond   
to any types of requests, they most commonly implement applications hosted on web servers.
Servlets are most often used to process or store a java class in Java EE that conforms to the java  
Servlet API, a standard for implementing java classes that respond to requests.

To deploy and run a servlet, a web container must be used. A web container (also known as a servlet container) is essentially the component of a web server that interacts with the servlets. The web container is responsible for managing the lifecycle of servlets, mapping a URL to a particular servlet and ensuring that the URL requester has the correct access rights.  
A Servlet is an object that receives a request and generates a response based on that request.  

What is Java EE?  
It is a widely used computing platform for enterprise software which provides an API and runtime environment  
for developing and running enterprise software, including network and web services, and other large-scale, multi-tired,  
scalable, reliable, and secure netwoek applications.


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







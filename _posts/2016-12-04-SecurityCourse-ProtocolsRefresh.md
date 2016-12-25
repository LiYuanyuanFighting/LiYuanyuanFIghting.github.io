---
layout: post
title: SecurityCourse Protocol Refresh
categories: [blog ]
tags: [study,security,protocols ]
description: Refresh some protocols used in Computer security
---  

These two week in Computer security course, the professor talked about security of IP networks.  
Then I realized I had forgotten some protocols, now to refresh as following:

**Point-to-Point Protocol (PPP):**  
a data link (layer 2) protocol used to establish a direct connection between 
two nodes. It can provide connection authentication, transmission encryption
(using ECP, RFC 1968), and compression.

PPP is a layered protocol that has three components:   
An encapsulation component that is used to transmit datagrams over the specified   
physical layer.  
A Link Control Protocol (LCP) to establish, configure, and test the link as well  
as negotiate capabilities.One or more Network Control Protocols (NCP) used to   
negotiate optional configuration parameters and facilities for the network layer.  
There is one NCP for each higher-layer protocol supported by PPP.  

**重放攻击(Replay attack)**  
[reference](https://cnodejs.org/topic/557c354d16839d2d539362b6 "reference")

**Accounting**
measures the resources a user consumes during access. This can include the amount of system  
time or the amount of data a user has sent and/or received during a session. Accounting is  
carried out by logging of session statistics and usage information and is used for authorization  
control, billing, trend analysis, resource utilization, and capacity planning activities.

**Protection against SYN flooding**  
Firewalls and Proxies: A firewall or proxy machine inside the network can buffer end hosts from  
SYN flooding attacks through two methods, by either spoofing SYN-ACKs to the initiators or   
spoofing ACKs to the listener     
The Transmission Control Block (TCB) is a transport protocol data structure (actually a set of  
structures in many operations systems) that holds all the information about a connection. The  
memory footprint of a single TCB depends on what TCP options and other features an implementation  
provides and has enabled for a connection. Usually, each TCB exceeds at least 280 bytes, and  
in some operating systems currently takes more than 1300 bytes. The TCP SYN-RECEIVED state is  
used to indicate that the connection is only half open, and that the legitimacy of the request  
is still in question. The important aspect to note is that the TCB is allocated based on   
reception of the SYN packetâ€” before the connection is fully established or the initiator's   
return reachability has been verified.  
Figure 6 shows the basic operation of a firewall/proxy that spoofs SYN-ACKs to the initiator.  
If the initiator is legitimate, the firewall/ proxy sees an ACK and then sets up a connection  
between itself and the listener, spoofing the initiator's address. The firewall/proxy splits  
the end-to-end connection into two connections to and from itself. This splitting works as a  
defense against SYN flooding attacks, because the listener never sees SYNs from an attacker.   
As long as the firewall/proxy implements some TCP-based defense mechanism such as SYN cookies  
or a SYN cache, it can protect all the servers on the network behind it from SYN flooding attacks.

[![SYN interceptor](http://imgur.com/BRw6nFv "SYN interceptor")](http://imgur.com/BRw6nFv "SYN interceptor")

Figure 7 illustrates the packet exchanges through a firewall/proxy that spoofs ACKs to the listener  
in response to observed SYN-ACKs. This spoofing prevents the listeners TCBs from staying in the   
SYN-RECEIVED state, and thus maintains free space in the backlog. The firewall/proxy then waits   
for some time, and if a legitimate ACK from the initiator is not observed, then it can signal the  
listener to free the TCB using a spoofed TCP RST segment. For legitimate connections, packet flow  
can continue, with no interference from the firewall/ proxy. This solution is more desirable than  
the mode of operation in Figure 5, where the firewall/proxy spoofs SYN-ACKs, because it does not   
require the firewall/proxy to actively participate in legitimate connections after they are   
established.  

[![SYN monitor](http://imgur.com/Ggjugtj "SYN monitor")](http://imgur.com/Ggjugtj "SYN monitor")

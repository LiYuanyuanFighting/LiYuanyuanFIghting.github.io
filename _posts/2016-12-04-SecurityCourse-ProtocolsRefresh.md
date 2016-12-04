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

****

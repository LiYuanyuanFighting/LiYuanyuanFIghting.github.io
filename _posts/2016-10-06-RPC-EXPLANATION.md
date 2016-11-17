---
layout: post
title:  what is RPC
categories: [blog ]
tags: [study,programing,RPC,socket,xdr ]
description: 
--- 

## RPC explanation
 
 in wiki, it is defined as follows:
 In [distributed computing] a remote procedure call (RPC) is when a computer program causes a procedure 
 (subroutine) to execute in another address space (commonly on another computer on a shared network),
 which is coded as if it were a normal (local) procedure call, without the programmer explicitly coding
 the details for the remote interaction. That is, the programmer writes essentially the same code whether
 the subroutine is local to the executing program, or remote.[1] This is a form of client–server interaction
 (caller is client, executer is server), typically implemented via a request–response message-passing system.
 
 This reminds me the subject of distributed programming. In that subject, I wrote lots of examples to implement
 the communication between clients and servers, which can locate in different network nodes using TCP or UDP.
 In website called zhihu, I found funny and detailed explanation as follows:
 作者：肖继潮
链接：https://www.zhihu.com/question/25536695/answer/31046384
来源：知乎

早期单机时代，一台电脑上运行多个进程，大家各干各的，老死不相往来。假如A进程需要一个画图的功能，B进程也需要一个画图的功能，
程序员就必须为两个进程都写一个画图的功能。这不是整人么？于是就出现了IPC（Inter-process communication，单机中运行的进程
之间的相互通信）。OK，现在A既然有了画图的功能，B就调用A进程上的画图功能好了，程序员终于可以偷下懒了。


到了网络时代，大家的电脑都连起来了。以前程序只能调用自己电脑上的进程，能不能调用其他机器上的进程呢？于是就程序员就把IPC
扩展到网络上，这就是RPC（远程过程调用）了。现在不仅单机上的进程可以相互通信，多机器中的进程也可以相互通信了。

要知道实现RPC很麻烦呀，什么多线程、什么Socket、什么I/O，都是让咱们普通程序员很头疼的事情。于是就有牛人开发出RPC框架
（比如，CORBA、RMI、Web Services、RESTful Web Services等等）。

OK，现在可以定义RPC框架的概念了。简单点讲，RPC框架就是可以让程序员来调用远程进程上的代码一套工具。有了RPC框架，咱程序员
就轻松很多了，终于可以逃离多线程、Socket、I/O的苦海了。

至于最近Java中流行的Netty，没玩过。但是大致了解过，Netty、Mina是游戏行业做服务器开发的Java程序员用的比较多的PRC框架
（我们学生主要是Java方向的，有不少人毕业后从事游戏开发）。据说互联网公司用的也比较多。这两行业都有高并发量的、长连接、
分布式、异步通讯、大数据量等特点。Netty这种RPC框架封装和优化了Java NIO和异步网络编程的一些繁琐的细节，一方面可以让开
发者专注于业务逻辑的实现，一方面只需要调用Netty封装的API就可以很快编写出高性能的服务器。

I also found a good article talking both about RPC and XDR:
http://www.cprogramming.com/tutorial/rpc/remote_procedure_call_start.html

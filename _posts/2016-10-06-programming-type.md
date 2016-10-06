---
layout: post
title:  Different Programming Types
categories: [blog ]
tags: [study,programing,declarative,type ]
description: 
---  

### Different Programming Types

- Declarative
 is where you say what you want without having to say how to do it.
Describe a result and get it via a black box. Examples:

yacc
Treetop
SQL(SQL is more declarative than procedural, because the queries don't specify
steps to produce the result.)
Regular Expressions
lex
XSLT
markup, troff, CSS, VHDL

- Procedure
you have to specify exact steps to get the result.
Describe the algorithm and process steps, at various degrees of abstraction.

C, most legacy languages
PHP, mostly
in some sense all major languages

- Object Oriented
Tends to be in the procedural category, typically refers to languages that
exhibit a hierarchy of types that inherit both methods and state from base 
types to derived types, but also kind of includesprototype-based languages 
like JavaScript. Somewhat a separate dimension from the other categories here.

- Functional
The opposite of imperative programming, it emphasizes the application of 
functions without side effects and without mutable state. The declarative 
systems above exhibit certain aspects of functional programming.
Scheme
Erlang
OCaml
Haskell
Lisp, depending. (Lisp perhaps deserves its own unique category)
Clojure, somewhat
Ruby, somewhat less
F#
Actually, programming that describes algorithm and process steps is called 
imperative programming, which is a supertype of procedural programming which 
achieves that based on "procedure calls" or other similar concept.


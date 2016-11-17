---
layout: post
title: Animating with jQuery
categories: [blog ]
tags: [study,html,js,jquery,animate, ]
description: 
--- 

# To adjust table

  I have a table which contains two tables and needs to lay in parallel.
  After updating the table,new problems come out: the caption could not
  be in the same line(it should be due to automatic center align configured
  in the external css sheet.) 
  
  Inside td, I have div, my last problem is only to make div fill in the td
  label, but div is a block label which changes size according to the content
  so I solved using a hidden attribute,which adds a new line with the caption
  content, but hides it, then solved!
  
  in php:
  `echo "<tr id='visible'><th>quantity_to_buy</th><th>price_for_buying</th></tr>";`
  in css:
 ` #visible {visibility: hidden;}`

===================================================================
Quovolver v1.0: A simple jQuery plugin for revolving quotes
-
By Sebastian Nitu
-
Plugin URI:	http://sandbox.sebnitu.com/jquery/quovolver/
Author URI:	http://sebnitu.com/
===================================================================

Why use quovolver?
-
Quovolver is a great way to display quotes, testimonials or comments
on your site. I can't count how many times clients ask for something
like this on their site. This just makes it easy to implement.
-

How do I use it?
-
1: Simply link to the file in the header of your (X)HTML page:
   <script type="text/javascript" src="jquery.quovolver.js"></script>

2: Call the quovolver function in your .doc.ready file:
   $(document).ready(function() {
	   $('blockquote').quovolver();
   });

3: Make sure you link to jQuery too: http://jquery.com

4: In your CSS, give the quote elements a fixed width. This prevents
   the quotes from displaying funny when elements are below them.
   
4: That's it, watch the quotes fly!
-

Can I adjust the speed they display?
-
You sure can! Quovolver can takes two parameters:
1: The speed of the animation
2: The duration before they revolve

Format the script like so:

$('blockquote').quovolver($speed, $duration);

The defaults are 500 and 6000, respectively.
-

===================================================================
Copyright 2009 Sebastian Nitu. All rights reserved.
===================================================================

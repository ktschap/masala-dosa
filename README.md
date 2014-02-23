masala-dosa
===========

masala-dosa is an after school enrichment program enrollment web site. It currently provides a simple form to allow enrollment for a list of classes, along with the ability to to view pdf file info about the class. No user authentication or verification has been implemented. It also has extensive web forms for administrators to configure the classes on the main page, upload class flyers, and run enrollment reports.

It is written in java, with spring core/mvc and jdo. Standard jsp/jstl technology is used with basic jquery/css. It has only ever run on the Google App Engine - but it is independent of google appengine libraries. The one exception to this is in package pepparkmead / google. The main form has also been subject to my early experimentation with responsive design.

Currently, you can see it running at http://pepparkmead.appspot.com.

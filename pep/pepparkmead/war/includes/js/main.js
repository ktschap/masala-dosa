// Filename: main.js

// Require.js allows us to configure shortcut alias
// There usage will become more apparent further along in the tutorial.
require.config({
  paths: {
    jquery: 'http://ajax.aspnetcdn.com/ajax/jquery/jquery-1.8.3.min',
    jqueryvalidate: 'http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min',
    jquerymaskedinput: 'jquery.maskedinput-1.3.min',
    jqueryyitihit: 'jquery.yitihit',
    pepwiz: 'pepwizard'
  },
  shim: {
    'jqueryvalidate': ['jquery'],
    'jquerymaskedinput': ['jquery'],
    'jqueryyitihit': ['jquery']
  }
});

require(['pepwiz'], 
	function(pepwiz) 
	{ 
		pepwiz.initialize(); 
	}
);

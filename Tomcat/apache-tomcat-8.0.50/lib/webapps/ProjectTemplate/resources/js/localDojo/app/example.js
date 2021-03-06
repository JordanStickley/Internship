/*// ---------------------------------------------------------
// file example.js
// ---------------------------------------------------------

define([ 'dojo/ready',
	     'dojo/query', 
	     'dojo/dom',
	     'dojo/domReady!',
	     'dojo/dom-construct',
	     'dojo/NodeList-manipulate',
	     'dojo/dom-prop',
	     'dojo/dom-attr',
	     'dojo/on',
	     'dojo/_base/window',
         'local/app/Intern'
        ], 
function (ready, query, dom, domReady, domConstruct, NodeListManipulate, domProp, domAttr, on, win, Intern) {
	
    const internsApp = {
        interns: [],
        nameRegEx: /^[a-zA-Z]+$/,
        sortDirection: "ascending",
        
        sayHello: function () {
			return new Promise((resolve, reject) => {
				console.log('Hello World from the example module!');
	        	resolve('Good To Go!');
			});
        },
        
        sayGoodBye: function () {
			return new Promise((resolve, reject) => {
				console.log('Goodbye from the example module!');
	        	resolve('Good To Go!');
			});
        }
    
    };
    
    return internsApp;
});*/
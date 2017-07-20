var URI = 'http://localhost:8588/ContactApp/api/';



// -----------------------REGISTERING THE APPLICATION AND DEPENDENCIES-----------------------

var contact = angular.module("Application", ['ngRoute']);

contact.config(function($httpProvider) {
	$httpProvider.defaults.headers.post['Content-Type'] = "application/json; charset=UTF-8";
	$httpProvider.defaults.headers.post['Data-Type'] = "json";
});


// ----------------------CONFIGURING THE APPLICATION------------------------

contact.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/Contacts', {
		templateUrl : 'partials/contacts.html',
		controller : 'Controller'
	}).when('/Messages', {
		templateUrl : 'partials/messages.html',
		controller :'Controller'
	}).when('/Details/:value', {
		templateUrl : 'partials/details.html',
		controller :'Controller'
	}).when('/Send/:value', {
		templateUrl : 'partials/sendMessage.html',
		controller :'Controller'
	}).when('/Facts', {
		templateUrl : 'partials/facts.html',
		controller :'Controller'
	}).otherwise({
		redirectTo : '/Contacts'
	});
} ]);


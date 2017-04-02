contact.controller("Controller", function($scope,$route,$http,$routeParams,$rootScope) {
	
		$scope.contactForm = {};
		$scope.contactForm.contactList = null;
		$scope.contactForm.contactList1 = null;
		$scope.contactForm.cId = null;
		$scope.contactForm.otp=null;
		$scope.otp=null;
		$scope.contactForm.msgList = null;
		$scope.contactForm.names = [];		
		
		$scope.init = function(){	
			$scope.contactForm.getAllContacts(); 
			$scope.contactForm.getAllMessages(); 
		};
	
	$scope.contactForm.getAllContacts = function() {		
		var responsePromise = $http.get(URI + "ContactAPI" + "/allContacts");
		responsePromise.then(function(response) {
			$scope.contactForm.contactList = response.data;
		}, function(response) {
			$scope.contactForm.contactList = null;
		});
	};
	
	$scope.contactForm.getContactById= function() {	
		$scope.contactForm.cId=$routeParams.value;
		var responsePromise = $http.get(URI + "ContactAPI" + "/contact/"+$routeParams.value);
		responsePromise.then(function(response) {
			$scope.contactForm.contactList1 = response.data;
		}, function(response) {
			$scope.contactForm.contactList1 = null;
		});

	};

	$scope.contactForm.getOTP=function(){
		var x=Math.floor(Math.random()*900000) + 100000;
		$scope.otp=x;
		document.getElementById("d").innerHTML = "  Hi. Your OTP is: " + x;	
	}
	
	$scope.Send= function() {
		var z=$routeParams.value;
		var y=$scope.otp;
		console.log(z);
		console.log(y);
		var responsePromise = $http.post(URI + "MessageAPI" + "/addMessages/"+z+"/"+y);
		responsePromise.then(function(response) {
			$scope.msg = response.data;
		}, function(response) {
			$scope.msg = null;
		});
	   };
	
	
	$scope.contactForm.getAllMessages = function() {		
		var responsePromise = $http.get(URI + "MessageAPI" + "/allMessages");
		responsePromise.then(function(response) {
			$scope.contactForm.msgList = response.data;
			$scope.list1=$scope.contactForm.msgList;
			return $scope.list1;
		}, function(response) {
			$scope.contactForm.msgList = null;
		});

	};
	
	$scope.init();

});
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
	$scope.randomColor=function(){
	    var colorList=['a','b','c','d','e','f','g','h']
	    var random=Math.floor(Math.random()*10);
		if(random>=8)
		return colorList[10-random-1];
		return colorList[random];
	}
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
	
	
	
	$scope.Send= function() {
		var z=$routeParams.value;
		var y=$scope.otp;
		var responsePromise = $http.post(URI + "MessageAPI" + "/addMessages/"+z+"/"+y);
		responsePromise.then(function(response) {
			$scope.msg = response.data;
			setTimeout(function() {
				$scope.stoppingSignal();
				setTimeout(function() {
					document.getElementById('msg').style.display = 'block';
				}, 0)
			}, 0);
			
		}, function(response) {
			$scope.msg = null;
		});
	   };
	
	   
	   $scope.AddContacts= function() {
			$scope.addUser={};
			$scope.addUser.firstName=$scope.firstName;
			$scope.addUser.lastName=$scope.lastName;
			$scope.addUser.phoneNo=$scope.phoneNo;
			$scope.addUser.location=$scope.location;
			
		   var data=angular.toJson($scope.addUser);
		   console.log(data);
			var responsePromise = $http.post(URI + "ContactAPI/addContacts",data);
			responsePromise.then(function(response) {
				$scope.msg = response.data;				
				document.getElementById('msg').style.display = 'block';
				document.getElementById('addContacts').style.display = 'none';
			}, function(response) {
				$scope.msg = null;
			});
		   };
	
	
		   $scope.setUrl=function(conId){
				window.location.href="#/Details/"+conId;
			}
			
			$scope.goIndex=function(){
				window.location.href="#/Contacts";
			}
			
			$scope.refreshPage=function(){
				document.getElementById('msg').style.display = 'none';
				$route.reload();
			}
	
	$scope.waitingSignal=function(){
	    $scope.flagSignal=true;
	    setTimeout(function() {$scope.Send();},3000);
	    
	}
	$scope.stoppingSignal=function(){
		$scope.flagSignal=false;
	}
	
	
	$scope.init();
/*});
contact.controller("FactsController", function($scope,$route,$http) {*/
	$scope.factList=null;
	$scope.Randomlist=null;
	$scope.flag=null;
	
	$scope.getFacts=function(){
		
		var response=$http.get(URI+"FactAPI/allFacts");
		response.then(function(res){
			$scope.factList=res.data;
			s=$scope.factList.length;
			 var x = Math.floor((Math.random() *(s-1)) + 0);
			$scope.Randomlist=$scope.factList[x];
			$scope.flag=true;
		},function(res){
			$scope.factList=null;
		});
	};
	
});

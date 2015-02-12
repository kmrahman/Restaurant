"use strict";

(function(){
	
	angular.module("kitchen").controller("ContactCtrl",ContactController);
	
	function ContactController(){
		
		this.cCtrl = this;
	}
	
	  angular.module('kitchen').controller('HomeCtrl', HomeCtrl);
	  angular.module('kitchen').controller('ProfileCtrl', ProfileCtrl);
	  angular.module('kitchen').controller('LoginCtrl', LoginCtrl);

	  function HomeCtrl($routeParams) {

	    var hCtrl = this;
	    hCtrl.params = $routeParams;
	    console.log('HomeCtrl');
	  }




	  function ProfileCtrl($routeParams, user) {

	    var pCtrl = this;

	    console.log('ProfileCtrl');
	    console.log(user.data);
	    console.log($routeParams);
	    pCtrl.user = user.data.headers;
	  }
	  
	  
	  
	  

	  function LoginCtrl() {

	    var lCtrl = this;

	    console.log('LoginCtrl');
	  }


})();
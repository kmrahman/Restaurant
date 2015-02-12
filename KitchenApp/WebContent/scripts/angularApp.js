(function() {

  angular.module('kitchen', ['ngRoute']);

  angular.module('kitchen').config(['$routeProvider', moduleConfig]);

  function moduleConfig($routeProvider) {
    $routeProvider
      .when('/reservation', {
        templateUrl: 'templates/reservation.html', //url of the template
        controller: 'LoginCtrl', //name of the controller
        controllerAs: 'lCtrl' //how it should be referred in the template
      })
      .when('/cancel', {
        templateUrl: 'templates/cancel.html', //url of the template
        controller: 'LoginCtrl', //name of the controller
        controllerAs: 'lCtrl' //how it should be referred in the template
      })
      .when('/ownerReservation', {
        templateUrl: 'templates/ownerReservation.html', //url of the template
        controller: 'LoginCtrl', //name of the controller
        controllerAs: 'lCtrl' //how it should be referred in the template
      })
      .when('/ownerSeating', {
        templateUrl: 'templates/ownerSeating.html', //url of the template
        controller: 'LoginCtrl', //name of the controller
        controllerAs: 'lCtrl' //how it should be referred in the template
      })
      .when('/ownerProfile', {
        templateUrl: 'templates/ownerProfile.html', //url of the template
        controller: 'LoginCtrl', //name of the controller
        controllerAs: 'lCtrl' //how it should be referred in the template
      })
      .when('/ownerAppSettings', {
        templateUrl: 'templates/ownerAppSettings.html', //url of the template
        controller: 'LoginCtrl', //name of the controller
        controllerAs: 'lCtrl' //how it should be referred in the template
      })
     .when('/ownerContactList', {
        templateUrl: 'templates/ownerContactList.html', //url of the template
        controller: 'LoginCtrl', //name of the controller
        controllerAs: 'lCtrl' //how it should be referred in the template
      })
      .when('/menu', {
        templateUrl: 'templates/menu.html', //url of the template
        controller: 'LoginCtrl', //name of the controller
        controllerAs: 'lCtrl' //how it should be referred in the template
      })
   
      .when('/login', {
        templateUrl: 'templates/login.html', //url of the template
        controller: 'LoginCtrl', //name of the controller
        controllerAs: 'lCtrl' //how it should be referred in the template
      })
      .when('/contactUs', {
        templateUrl: 'templates/contactUs.html', //url of the template
        controller: 'LoginCtrl', //name of the controller
        controllerAs: 'lCtrl' //how it should be referred in the template
      })
     .when('/home', {
        templateUrl: 'templates/home.html', //url of the template
        controller: 'HomeCtrl', //name of the controller
        controllerAs: 'hCtrl' //how it should be referred in the template
      })
      .when('/profile', {
        templateUrl: 'profile.html', //url of the template
        controller: 'ProfileCtrl', //name of the controller
        controllerAs: 'pCtrl', //how it should be referred in the template
        resolve: {
          user: ['$http', userLoader]
        }
      })
 
      .otherwise({
        redirectTo: '/reservation'
      });
  }
  
  function userLoader ($http) {
    return $http({
      url: 'http://httpbin.org/get',
      method: 'GET'
    });
  }



})();
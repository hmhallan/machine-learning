(function(){

    angular.module('jwt.controllers', []);
    angular.module('jwt.services', []);

    var app = angular.module('jwt-exemplo', [ 'jwt.controllers', 'jwt.services', 'ngRoute', 'ngStorage']);



    app.config(['$routeProvider', '$httpProvider', '$sessionStorageProvider', '$localStorageProvider', function($routeProvider, $httpProvider, $sessionStorageProvider, $localStorageProvider){


        $sessionStorageProvider.setKeyPrefix('jwtexemplo-');
        $localStorageProvider.setKeyPrefix('jwtexemplo-');


        $routeProvider
            .when('/home', { templateUrl: 'modules/home/home.html', controller: 'HomeController'})
            .when('/weka', { templateUrl: 'modules/weka/form.html', controller: 'WekaFormController'})

            .otherwise ({ redirectTo: '/home' });

    }]);


    app.run(function($rootScope, $localStorage, $location) {

    });


}).call(this);
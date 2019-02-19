(function(){

    angular.module('experimento.controllers', []);
    angular.module('experimento.services', []);

    var app = angular.module('ml-experimento', [ 'experimento.controllers', 'experimento.services', 'ngRoute', 'ngStorage']);



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
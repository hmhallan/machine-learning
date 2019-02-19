(function(){
    angular.module('experimento.controllers').controller('MenuController', ['$rootScope','$scope', '$location',
        function($rootScope, $scope, $location){

        $scope.location = $location;

}]);
}).call(this);
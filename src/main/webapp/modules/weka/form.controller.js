
(function(){

    angular.module('experimento.controllers').controller('WekaFormController', ['$scope', '$http',
        function($scope, $http){

        $scope.model = {};

        $scope.classificar = function(){
            if ( $scope.form.$valid ){

                $http.post("./api/weka/classificar", $scope.model)
                    .then(function(response){
                       console.info(response.data);
                       $scope.tipo = response.data;
                    });

            }
            else{
                console.info("not ok");
            }
        }

        }]);

}).call(this);
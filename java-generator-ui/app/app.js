'use strict';

var module = angular.module('test', []);

module.controller('IndexCtrl', ['$scope', '$http', function($scope, $http){

    $scope.showList = false;

    $scope.loadData = function() {
        $http.get('http://127.0.0.1:8081/api/generator', null).then(function(data){
            $scope.showList = true;
            $scope.list = data.data;
        });
    };

}]);
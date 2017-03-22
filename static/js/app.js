
//
var app = angular.module('app',[]);
app.config(['$interpolateProvider', function($interpolateProvider) {
  $interpolateProvider.startSymbol('{a');
  $interpolateProvider.endSymbol('a}');
}]);

app.controller('ctrl',
    function($scope, $http)
    {
        $http.get('http://localhost:5000/operations').
            success(function(data) {
                console.log(data);
                $scope.operations = data;
            });
    }); 
    

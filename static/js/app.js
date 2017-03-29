
//
var app = angular.module('app',[]);
app.config(['$interpolateProvider', function($interpolateProvider) {
  $interpolateProvider.startSymbol('{a');
  $interpolateProvider.endSymbol('a}');
}]);

app.controller('ctrl',
    function($scope, $http)
    {
        $scope.detailedOperation=null;
        $http.get('http://localhost:5000/operations').
            success(function(data) {
                console.log(data);
                $scope.operations = data;
            });
        $scope.detailedInfoId=function(id){
            var i=0;
            for(i=0;i<$scope.operations.length;i++){
                if($scope.operations[i]['id']==id){
                    $scope.detailedOperation=$scope.operations[i];
                }
            }
            console.log($scope.detailedOperation);
        };
        $scope.parseHist=function(id){            
            var config = {
                headers : {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                }
            }
            $http.post("http://localhost:5000/getID", {"id": id}).success(function (data, status, headers, config) {
                $scope.PostDataResponse = data;
            })
            .error(function (data, status, header, config) {
                $scope.ResponseDetails = "Data: " + data +
                    "<hr />status: " + status +
                    "<hr />headers: " + header +
                    "<hr />config: " + config;
            });
        };
        $scope.deleteHist=function(id){
            var config = {
                headers : {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                }
            }
            $http.post("http://localhost:5000/delID", {"id": id}).success(function (data, status, headers, config) {
                $scope.PostDataResponse = data;
            })
            .error(function (data, status, header, config) {
                $scope.ResponseDetails = "Data: " + data +
                    "<hr />status: " + status +
                    "<hr />headers: " + header +
                    "<hr />config: " + config;
            });
        };
    }); 
    

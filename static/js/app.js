
var ip = location.host;
console.log(ip);

var app = angular.module('app',[]);
app.config(['$interpolateProvider', function($interpolateProvider) {
  $interpolateProvider.startSymbol('{a');
  $interpolateProvider.endSymbol('a}');
}]);

app.controller('ctrl',
    function($scope, $http)
    {
        $scope.detailedOperation=null;
        $http.get(ip + '/operations').
            success(function(data) {
                console.log("OPERATIONS");
                console.log(data);
                $scope.operations = data;
            });
        $http.get(ip + '/profiles').
            success(function(data) {
                console.log("PROFILES");
                console.log(data);
                $scope.profiles = data;
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
            $http.post(ip + "/getID", {"id": id}).success(function (data, status, headers, config) {
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
            $http.post(ip + "/delID", {"id": id}).success(function (data, status, headers, config) {
                $scope.PostDataResponse = data;
            })
            .error(function (data, status, header, config) {
                $scope.ResponseDetails = "Data: " + data +
                    "<hr />status: " + status +
                    "<hr />headers: " + header +
                    "<hr />config: " + config;
            });
        };
        $scope.prof_act=function(id, action){
            var config = {
                headers : {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                }
            }
            $http.post(ip + "/"+action, {"id": id}).success(function (data, status, headers, config) {
                $scope.PostDataResponse = data;
            })
            .error(function (data, status, header, config) {
                $scope.ResponseDetails = "Data: " + data +
                    "<hr />status: "  + status +
                    "<hr />headers: " + header +
                    "<hr />config: "  + config;
            });
        };
        
    }); 
    

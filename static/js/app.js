
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
        /*$http.get('http://localhost:5000/operations').
            success(function(data) {
                console.log("OPERATIONS");
                console.log(data);
                $scope.operations = data;
            });*/
        $scope.profiles = ["anonimo_filename","profile2"]
        /*$http.get('http://localhost:5000/profiles').
            success(function(data) {
                console.log("PROFILES");
                console.log(data);
                $scope.profiles = data;
            });*/
        $scope.operations = [{"autor": "anonimo", "output": "examplesXML/filename.xml", "date": "2018-05-02 15:03:13.946074", "input": "examplesXML/default2.xml", "id": "5ae9b711c13367135f6c13be", "diagrams": [{"entities": [{"name": "WorkProduct"}, {"name": "StructuralWP"}, {"name": "BehaviourWP"}, {"name": "DPDFSMMel"}, {"name": "DPDFSMMat"}, {"name": "FreeWP"}, {"name": "CompositeWP"}, {"name": "StructuredWP"}, {"name": "DPDFS"}, {"name": "DPDFSMMop"}], "name": "WorkProductDiagram", "relations": [{"sources": [{"name": "CompositeWP"}], "name": "WPContains", "targets": [{"name": "FreeWP"}, {"name": "StructuralWP"}, {"name": "StructuredWP"}, {"name": "BehaviourWP"}]}, {"sources": [{"name": "StructuralWP"}], "name": "none", "targets": [{"name": "FreeWP"}, {"name": "DPDFS"}]}, {"sources": [{"name": "DPDFS"}], "name": "QQ", "targets": [{"name": "DPDFS"}]}, {"sources": [{"name": "FreeWP"}, {"name": "DPDFS"}], "name": "relates", "targets": [{"name": "DPDFS"}]}, {"sources": [{"name": "DPDFS"}], "name": "QR", "targets": [{"name": "DPDFS"}]}, {"sources": [{"name": "DPDFSMMel"}], "name": "QD", "targets": [{"name": "DPDFSMMat"}, {"name": "DPDFSMMop"}]}, {"sources": [{"name": "FreeWP"}, {"name": "DPDFS"}], "name": "defines", "targets": [{"name": "DPDFS"}]}, {"sources": [{"name": "FreeWP"}, {"name": "DPDFS"}], "name": "quotes", "targets": [{"name": "DPDFS"}]}]}, {"entities": [{"name": "Node"}, {"name": "DecisionNode"}, {"name": "Process"}, {"name": "Phase"}, {"name": "Activity"}, {"name": "InitialNode"}, {"name": "iPhase"}, {"name": "ForkNode"}, {"name": "EndNode"}, {"name": "JoinNode"}], "name": "PhaseDiagram", "relations": [{"sources": [{"name": "DecisionNode"}], "name": "FollowsGuarded", "targets": [{"name": "Node"}]}, {"sources": [{"name": "Node"}, {"name": "Activity"}], "name": "Follows", "targets": [{"name": "Node"}, {"name": "Activity"}]}]}, {"entities": [{"name": "AgentWS"}, {"name": "CompositeWP"}, {"name": "FreeWP"}, {"name": "TaskWS"}, {"name": "StructuredWP"}, {"name": "Activity"}, {"name": "StructuralWP"}, {"name": "WorkProduct"}, {"name": "RoleWS"}, {"name": "BehaviourWP"}], "name": "ActivityWPDiagram", "relations": [{"sources": [{"name": "FreeWP"}, {"name": "CompositeWP"}, {"name": "StructuralWP"}, {"name": "BehaviourWP"}, {"name": "StructuredWP"}], "name": "none", "targets": [{"name": "WorkProduct"}]}, {"sources": [{"name": "Activity"}], "name": "ActivityPrecedes", "targets": [{"name": "Activity"}]}, {"sources": [{"name": "WorkProduct"}], "name": "WFConsumes", "targets": [{"name": "TaskWS"}]}, {"sources": [{"name": "WorkProduct"}], "name": "WFProduces", "targets": [{"name": "TaskWS"}]}, {"sources": [{"name": "AgentWS"}, {"name": "RoleWS"}], "name": "WFResponsable", "targets": [{"name": "TaskWS"}]}, {"sources": [{"name": "Activity"}], "name": "WFContains", "targets": [{"name": "Activity"}, {"name": "TaskWS"}, {"name": "RoleWS"}]}]}]}, {"autor": "anonimo", "output": "examplesXML/filename.xml", "date": "2018-05-02 15:03:59.846336", "input": "examplesXML/default2.xml", "id": "5ae9b73fc13367138e509927", "diagrams": [{"entities": [{"name": "WorkProduct"}, {"name": "StructuralWP"}, {"name": "BehaviourWP"}, {"name": "DPDFSMMel"}, {"name": "DPDFSMMat"}, {"name": "FreeWP"}, {"name": "CompositeWP"}, {"name": "StructuredWP"}, {"name": "DPDFS"}, {"name": "DPDFSMMop"}], "name": "WorkProductDiagram", "relations": [{"sources": [{"name": "CompositeWP"}], "name": "WPContains", "targets": [{"name": "FreeWP"}, {"name": "StructuralWP"}, {"name": "StructuredWP"}, {"name": "BehaviourWP"}]}, {"sources": [{"name": "StructuralWP"}], "name": "none", "targets": [{"name": "FreeWP"}, {"name": "DPDFS"}]}, {"sources": [{"name": "DPDFS"}], "name": "QQ", "targets": [{"name": "DPDFS"}]}, {"sources": [{"name": "FreeWP"}, {"name": "DPDFS"}], "name": "relates", "targets": [{"name": "DPDFS"}]}, {"sources": [{"name": "DPDFS"}], "name": "QR", "targets": [{"name": "DPDFS"}]}, {"sources": [{"name": "DPDFSMMel"}], "name": "QD", "targets": [{"name": "DPDFSMMat"}, {"name": "DPDFSMMop"}]}, {"sources": [{"name": "FreeWP"}, {"name": "DPDFS"}], "name": "defines", "targets": [{"name": "DPDFS"}]}, {"sources": [{"name": "FreeWP"}, {"name": "DPDFS"}], "name": "quotes", "targets": [{"name": "DPDFS"}]}]}, {"entities": [{"name": "Node"}, {"name": "DecisionNode"}, {"name": "Process"}, {"name": "Phase"}, {"name": "Activity"}, {"name": "InitialNode"}, {"name": "iPhase"}, {"name": "ForkNode"}, {"name": "EndNode"}, {"name": "JoinNode"}], "name": "PhaseDiagram", "relations": [{"sources": [{"name": "DecisionNode"}], "name": "FollowsGuarded", "targets": [{"name": "Node"}]}, {"sources": [{"name": "Node"}, {"name": "Activity"}], "name": "Follows", "targets": [{"name": "Node"}, {"name": "Activity"}]}]}, {"entities": [{"name": "AgentWS"}, {"name": "CompositeWP"}, {"name": "FreeWP"}, {"name": "TaskWS"}, {"name": "StructuredWP"}, {"name": "Activity"}, {"name": "StructuralWP"}, {"name": "WorkProduct"}, {"name": "RoleWS"}, {"name": "BehaviourWP"}], "name": "ActivityWPDiagram", "relations": [{"sources": [{"name": "FreeWP"}, {"name": "CompositeWP"}, {"name": "StructuralWP"}, {"name": "BehaviourWP"}, {"name": "StructuredWP"}], "name": "none", "targets": [{"name": "WorkProduct"}]}, {"sources": [{"name": "Activity"}], "name": "ActivityPrecedes", "targets": [{"name": "Activity"}]}, {"sources": [{"name": "WorkProduct"}], "name": "WFConsumes", "targets": [{"name": "TaskWS"}]}, {"sources": [{"name": "WorkProduct"}], "name": "WFProduces", "targets": [{"name": "TaskWS"}]}, {"sources": [{"name": "AgentWS"}, {"name": "RoleWS"}], "name": "WFResponsable", "targets": [{"name": "TaskWS"}]}, {"sources": [{"name": "Activity"}], "name": "WFContains", "targets": [{"name": "Activity"}, {"name": "TaskWS"}, {"name": "RoleWS"}]}]}]}]
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
        $scope.prof_act=function(id, action){
            var config = {
                headers : {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                }
            }
            $http.post("http://localhost:5000/"+action, {"id": id}).success(function (data, status, headers, config) {
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
    

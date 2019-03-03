alert('foi')

//create principal module
var appCliente = angular.module("appCliente", [])

//create controllers
appCliente.controller("indexController", function($scope){
	$scope.testeRic = "Teste Ricardo"
});
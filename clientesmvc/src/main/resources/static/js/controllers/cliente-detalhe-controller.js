appCliente.controller("clienteDetalheController", function($scope, $http, $routeParams){
	
	
	var load=()=>{
		$http
			.get('/private/clientes/'+$routeParams.id)
			.then(function(response) {
				console.log(response.data + response.status)
				$scope.cliente = response.data
			}, function(response) {
				console.error(response)
			});
	};
	
	load();
});
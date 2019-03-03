appCliente.controller("clienteController", function($scope, $http) {
	$scope.clientes = [];
	$scope.estados = [];
	$scope.cliente = {};
	$scope.estado = {};

	$scope.salvarCliente = function() {
		if ($scope.frmCliente.$invalid) {
			window.alert('Dados inválidos')
			return;
		}
		$http({
			method : 'POST',
			url : '/private/clientes',
			data : $scope.cliente
		}).then(function(response) {
			carregarClientes();
			
			$scope.cancelarAlteracaoCliente();
			$scope.frmCliente.$setPristine(true);
		})
	};

	$scope.removeCliente = function(cliente) {
		$http({
			method : 'DELETE',
			url : '/private/clientes/' + cliente.id
		}).then(function(response) {
			alert("Removido com sucesso!")
			pos = $scope.clientes.indexOf(cliente);
			$scope.clientes.splice(pos, 1);
			console.log(response.data + response.status)
		})
	};

	var carregarClientes = function() {
		$http({
			method : 'GET',
			url : '/private/clientes'			
		}).then(function(response) {
			console.log(response.data + response.status)
			$scope.clientes = response.data
		})
	};

	function load() {
		carregarClientes();

		// load estados
		$http.get('/private/estados').then(function(response) {
			$scope.estados = response.data
		});
	}
	$scope.alterarCliente = function(cliente) {
		$scope.cliente = angular.copy(cliente);
	};

	$scope.cancelarAlteracaoCliente = function() {
		$scope.cliente = {}
	}

	load();

});
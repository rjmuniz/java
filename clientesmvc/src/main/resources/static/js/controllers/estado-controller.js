appCliente.controller("estadoController", function($scope, $http){
	$scope.estados = [];
	$scope.estado = {}
	
	
	
	function load(){
		$http.get("/private/estados")
			.then(function(response){ 
				$scope.estados = response.data;
			})
	}
	$scope.salvarEstado = function(){
		
		if($scope.frmEstado.$invalid){
			window.alert('Dados inválidos')
			return;
		}
		$http.post('/private/estados', $scope.estado)
		.then(function(response) {
			load();		
			$scope.frmEstado.$setPristine(true);
			$scope.cancelarAlteracaoEstado();
		})
		
	}
	
	$scope.cancelarAlteracaoEstado=	function (){
		$scope.cliente = {}
	}
	
	$scope.removeEstado=function (estado){
		$http.delete('/private/estados/'+estado.id)
		  .then(function(response) {
			alert("Removido com sucesso!")
			pos = $scope.estados.indexOf(estado);
			$scope.estados.splice(pos,1);
		})
	}
	load();
})
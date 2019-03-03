appCliente.controller("loginController", function($scope, $http){
	$scope.usuario = {};
	$scope.token="";
	
	$scope.autenticar= function(){
		console.log("autenticar")
		$http
			.post('/public/login', $scope.usuario)
			.then(function(response){
					console.log(response);
					$scope.token = response.data.token;
					sessionStorage.setItem('token', $scope.token);
					
				  },
				  function(response){
					console.error(response)
				  });
	}
	
})
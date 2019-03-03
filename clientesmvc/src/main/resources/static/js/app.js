//create principal module
var appCliente = angular.module("appCliente", [ 'ngRoute' ])

appCliente.config(function($routeProvider, $locationProvider) {
	
	$routeProvider
		.when('/clientes', { templateUrl : 'views/cliente.html', controller : 'clienteController' })
		.when('/clie', { templateUrl : 'views/cliente.html', controller : 'clienteController' })
		.when('/cidades', { templateUrl : 'views/cidade.html', controller : 'cidadeController' })
		.when('/estados', { templateUrl : 'views/estado.html', controller : 'estadoController' })
		.when('/clientes/:id', { templateUrl : 'views/cliente-detalhe.html', controller : 'clienteDetalheController' })
		.when('/login', { templateUrl : 'views/login.html', controller : 'loginController' })
		.otherwise({ redirectTo: '/'});
	
	$locationProvider.html5Mode(true)
})

appCliente.config(function($httpProvider){
	$httpProvider.interceptors.push("tokenInterceptor");
})
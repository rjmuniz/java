appCliente.factory("tokenInterceptor", function($q, $location) {
	return {
		"request" : function(config) {
			config.headers.Authorization = 'Bearer '
					+ sessionStorage.getItem('token')
			return config;
		},
		'response' : function(response) {
			if (response.status == 401) {
				$location.path("/login");
			}
			return response;
		},
		'responseError' : function(rejection) {
			
			console.warn(rejection.data.message)
			
			if (rejection.status == 401) {
				$location.path("/login");
			}
			
			
			return $q.reject(rejection);

		}
	};
})
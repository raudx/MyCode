angular.module('app',['ngRoute'])
	.constant('pageTitle', 'Incident Details')
	.run(['pageTitle', '$rootScope', function(pageTitle, $rootScope)
		{
			$rootScope.pageTitle = pageTitle;
		}])

	.controller('showIncident',['$scope','$http','$location', function($scope,$http,$location)
		{
			
		$http.get('http://localhost:8081/rest/incident/readFile').success(function(data)
				{
			console.log(data.incident);
			console.log("executed");
			$scope.incidents = data.incident;
				});
	}]);
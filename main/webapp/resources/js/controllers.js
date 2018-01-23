var cartApp = angular.module('cartApp', []);
 
cartApp.controller('cartCtrl',  function ($scope, $http) {
	
	$scope.refreshCart = function(cartId) {
		  						$http.get('/gamestore/rest/cart/'+$scope.cartId)
		  						 	 .success(function(data) {
		  						 		 		$scope.cart = data;
		  						 	 		});
		  					};
		  					
	$scope.clearCart = function() {
		  						$http.delete('/gamestore/rest/cart/'+$scope.cartId)
		  							 .success($scope.refreshCart($scope.cartId));
		  						
	  					  };
	  					  
	$scope.initCartId = function(cartId) {
		  					$scope.cartId=cartId;
		  					$scope.refreshCart($scope.cartId);
	  						};
	  						
	  $scope.addToCart = function(gameId) {
		  						$http.put('/gamestore/rest/cart/add/'+gameId)
		  						 	 .success(function(data) {
		  						 		 		$scope.refreshCart($http.get('/gamestore/rest/cart/get/cartId'));
		  						 		 		alert("Gra pomyślnie dodana do koszyka!");
		  						 	 		});
		  					};
	  $scope.removeFromCart = function(gameId) {
			  						$http.put('/gamestore/rest/cart/remove/'+gameId)
			  						 	 .success(function(data) {
			  						 		 	$scope.refreshCart($http.get('/gamestore/rest/cart/get/cartId'));
			  						 	 		});
			  					};
	  });

var productManagement = angular.module('productManagement', ["ngRoute"]);

productManagement.controller('ProductManagementController', function ProductManagementController($scope, $routeParams, $http) {
    $scope.categoryName = $routeParams.categoryName;
    $http.get('http://localhost:3000/products').then(function (response) {
        $scope.products = response.data;
    });
    $http.get('http://localhost:3000/categories').then(function (response) {
        $scope.categories = response.data;
    });
    $http.get('http://localhost:3000/total').then(function (response) {
        $scope.totalItems = response.data.items;
    });
    $scope.addItem = function (product) {

        $http.get(('http://localhost:3000/products/') + product.id).then(function successCallback(response) {
            response.data.quantity++;
            $http({
                method: 'PUT',
                url: 'http://localhost:3000/products/' + product.id,
                data: response.data,
                dataType: 'json'
            });
        });

        $http.get(('http://localhost:3000/cart/') + product.id).then(function successCallback(response) {
            response.data.quantity++;
            $http({
                method: 'PUT',
                url: 'http://localhost:3000/cart/' + product.id,
                data: response.data,
                dataType: 'json'
            });

        }, function errorCallback(response) {
            cartItem = {
                "id": product.id,
                "quantity": 1,
                "image": product.image,
                "price": product.price,
                "title": product.title
            };
            $http({
                method: 'POST',
                url: 'http://localhost:3000/cart',
                data: cartItem,
                dataType: 'json'
            });
        });
        $scope.totalItems++;
        $http.get('http://localhost:3000/total').then(function (response) {
            response.data.items++;
            response.data.amount += product.price;
            $http({
                method: 'PUT',
                url: 'http://localhost:3000/total',
                data: response.data,
                dataType: 'json'
            });

        });
        $window.location.reload();
    }
});

productManagement.controller('CartController', function CartController($scope, $rootScope, $routeParams, $http) {
    $scope.categoryName = $routeParams.categoryName;
    $http.get('http://localhost:3000/cart').then(function (response) {
        $scope.cartItems = response.data;
    });
    $http.get('http://localhost:3000/total').then(function (response) {
        $scope.total = response.data;
        $scope.totalItems = $scope.total.items;
    });
    $scope.increaseQuantity = function (cartItem) {

        $http.get(('http://localhost:3000/products/') + cartItem.id).then(function (response) {
            response.data.quantity++;
            $http({
                method: 'PUT',
                url: 'http://localhost:3000/products/' + cartItem.id,
                data: response.data,
                dataType: 'json'
            });
        });

        $http.get(('http://localhost:3000/cart/') + cartItem.id).then(function (response) {
            response.data.quantity++;
            $http({
                method: 'PUT',
                url: 'http://localhost:3000/cart/' + cartItem.id,
                data: response.data,
                dataType: 'json'
            });

        });
        $scope.totalItems++;
        $http.get('http://localhost:3000/total').then(function (response) {
            response.data.items++;
            response.data.amount += cartItem.price;
            $http({
                method: 'PUT',
                url: 'http://localhost:3000/total',
                data: response.data,
                dataType: 'json'
            });

        });
        $window.location.reload();
    }
    
    $scope.decreaseQuantity = function (cartItem) {

        $http.get(('http://localhost:3000/products/') + cartItem.id).then(function (response) {
            response.data.quantity--;
            $http({
                method: 'PUT',
                url: 'http://localhost:3000/products/' + cartItem.id,
                data: response.data,
                dataType: 'json'
            });
        });

        $http.get(('http://localhost:3000/cart/') + cartItem.id).then(function (response) {
            response.data.quantity--;
            $http({
                method: 'PUT',
                url: 'http://localhost:3000/cart/' + cartItem.id,
                data: response.data,
                dataType: 'json'
            });

        });
        $scope.totalItems--;
        $http.get('http://localhost:3000/total').then(function (response) {
            response.data.items--;
            response.data.amount -= cartItem.price;
            $http({
                method: 'PUT',
                url: 'http://localhost:3000/total',
                data: response.data,
                dataType: 'json'
            });

        });
        $window.location.reload();
    }

});


productManagement.config(function config($locationProvider, $routeProvider) {
    $locationProvider.hashPrefix('!');

    $routeProvider.
    when('/', {
        templateUrl: 'views/home.html',
        controller: 'ProductManagementController'
    }).
    when('/category/:categoryName', {
        templateUrl: 'views/home.html',
        controller: 'ProductManagementController'
    }).
    when('/cart', {
        templateUrl: 'views/cart.html',
        controller: 'CartController'
    })
});

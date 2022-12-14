angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8190';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                console.log("test")
                $scope.ProductList = response.data;
            });
    };

    $scope.changeQuantity = function (productID, delta) {
        $http({
            url: contextPath + '/products/change_quantity',
            method: 'GET',
            params: {
                id: productID,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    };

    $scope.deleteProduct = function (productID) {
        $http({
            url: contextPath + '/products/delete',
            method: 'GET',
            params: {
                id: productID
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    };

    $scope.loadProducts();

});
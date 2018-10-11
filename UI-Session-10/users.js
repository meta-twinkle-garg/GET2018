var userManagement = angular.module('userManagement', []);

userManagement.controller('UserManagementController', function UserManagementController($scope, $http) {
    $scope.getData = function () {
        $http.get('userDetails.json').then(function (response) {
            $scope.users = response.data;
        });
    }
    $scope.submit = function () {
        user = {
            name: $scope.name,
            phone: $scope.phone,
            location: $scope.location

        };
        $scope.users.push(user);
//        $http.post('userDetails.json', $scope.users);
    };
    $scope.editUser = function (userId) {
        $scope.users.forEach(function(user){
            if (userId == user.id) {
                $scope.id= user.id;

                $scope.name= user.name;
                $scope.phone= user.phone;
                $scope.location= user.location;
            }
        }); 

    };
});

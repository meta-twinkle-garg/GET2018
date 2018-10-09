var userManagement = angular.module('userManagement', []);

// Define the `PhoneListController` controller on the `phonecatApp` module
userManagement.controller('UserManagementController', function UserManagementController($scope) {
  $scope.users = [
    {
      name: 'Akshat',
      phone: '1234567890',
      location: 'Jaipur'
    }, {
      name: 'Akshat',
      phone: '1234567890',
      location: 'Jaipur'
    }, {
      name: 'Rahul',
      phone: '1234567890',
      location: 'Delhi'
    }
  ];
});
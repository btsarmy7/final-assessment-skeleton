import flightMap from './map/map.module'
import apiUrl from './api.url'
import appComponent from './app.component.js'

// login stuff
import loginTitle from './login/title/title.module.js'
import loginUserlogin from './login/userlogin/userlogin.module.js'
import loginNewuser from './login/newuser/newuser.module.js'

import userDataService from './userData/userDataService.js'

export default
  angular
    .module('flight', [
      'ngAria',
      'ngAnimate',
      'ngMaterial',
      'ngMessages',
      'ui.router',

      flightMap,
     
      loginTitle,
      loginUserlogin,
      loginNewuser,
    ])
    .config(['$stateProvider', '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {

      const titleState = {
        abstract: true,
        name: 'title',
        url: '/title',
        component: 'titleComponent'
      }

      const userloginState = {
        name: 'login.userlogin',
        url: '/userlogin',
        component: 'userLoginComponent'
      }

      const newuserState = {
        name: 'login.newuser',
        url: '/newuser',
        component: 'newuserComponent'
      }
    
      $stateProvider.state(titleState)
      //.state(titleState)
      .state(userloginState)
      .state(newuserState)

      $urlRouterProvider.otherwise('/title')
    }
  ])
    .constant('apiUrl', apiUrl)
    .component('flightApp', appComponent)
    .component('appComponent', appComponent)
    //.controller('appController', appController)
    .service('userDataService', userDataService)
   

    .name

    
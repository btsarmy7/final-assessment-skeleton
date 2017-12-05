import flightMap from './map/map.module'
import apiUrl from './api.url'
import appComponent from './app.component.js'

// login stuff
import title from './title/title.module.js'
import titleLogin from './login/login.module.js'
import titleNewuser from './newuser/newuser.module.js'

export default
  angular
    .module('flight', [
      'ngAria',
      'ngAnimate',
      'ngMaterial',
      'ngMessages',
      'ui.router',

      flightMap,
      title,
      titleLogin,
      titleNewuser
    ])
    .config(['$stateProvider', '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {

      const titleState = {
        abstract: true,
        name: 'title',
        url: '/title',
        component: 'titleComponent'
      }

      const loginState = {
        name: 'title.login',
        url: '/login',
        component: 'loginComponent'
      }

      const newuserState = {
        name: 'title.newuser',
        url: '/newuser',
        component: 'newuserComponent'
      }
    
      $stateProvider.state(titleState)
      .state(loginState)
      .state(newuserState)

      $urlRouterProvider.otherwise('/title/login')
    }
  ])
    .constant('apiUrl', apiUrl)
    .component('flightApp', appComponent)

   

    .name

    
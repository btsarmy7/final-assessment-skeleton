import title from './title/title.module.js'
import titleLogin from './title/login/login.module.js'
import titleNewuser from './title/newuser/newuser.module.js'

import member from './member/member.module.js'
import memberBook from './member/book/book.module.js'
import memberHistory from './member/history/history.module.js'

import appComponent from './app.component.js'
import appController from './app.controller.js'
import apiUrl from './api.url.js'
import userDataService from './userData/userDataService.js'

export default
angular
  .module('flight', [
    'ngAria',
    'ngAnimate',
    'ngMaterial',
    'ngMessages',
    'ui.router',

    title,
    titleLogin,
    titleNewuser,
    member,
    memberBook,
    memberHistory
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

      const memberState = {
        abstract: true,
        name: 'member',
        url: '/member',
        component: 'memberComponent'
      }

      const bookState = {
        name: 'member.book',
        url: '/book',
        component: 'bookComponent'
      }

      const historyState = {
        name: 'member.history',
        url: '/history',
        component: 'historyComponent'
      }

      $stateProvider.state(titleState)
        .state(loginState)
        .state(newuserState)
        .state(memberState)
        .state(bookState)
        .state(historyState)

      $urlRouterProvider.otherwise('/title/login')
    }
  ])
  .constant('apiUrl', apiUrl)
  .component('appComponent', appComponent)
  .controller('appController', appController)
  .service('userDataService', userDataService)
  .name
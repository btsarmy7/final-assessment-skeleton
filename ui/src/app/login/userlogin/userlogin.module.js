import userLoginComponent from './userlogin.component.js'
import userLoginController from './userlogin.controller.js'
import userLoginService from './userlogin.service.js'

export default
  angular
    .module('userlogin', [])
    .component('userLoginComponent', userLoginComponent)
    .controller('userLoginController', userLoginController)
    .service('userLoginService', userLoginService)
    .name
import { loginComponent } from './login.component.js'
import { LoginService } from './login.service.js'

export default
  angular
    .module('login', [])
    .component('loginComponent', loginComponent)
    .service('loginService', LoginService)
    .name
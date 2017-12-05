import { newuserComponent } from './newuser.component.js'
import { NewuserService } from './newuser.service.js'

export default
  angular
    .module('newuser', [])
    .component('newuserComponent', newuserComponent)
    .service('newuserService', NewuserService)
    .name

import memberComponent from './member.component.js'
import memberController from './member.controller.js'

export default
  angular
    .module('member', [])
    .component('memberComponent', memberComponent)
    .controller('memberController', memberController)
    .name

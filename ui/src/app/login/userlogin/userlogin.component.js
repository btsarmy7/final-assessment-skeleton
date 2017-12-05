import templateUrl from './userlogin.template.html'

export default {
  templateUrl,
  controller: 'userLoginController',
  controllerAs: '$loginCtrl',
  bindings: {
    submission: '='
  }
}
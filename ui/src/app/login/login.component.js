import templateUrl from './login.template.html'


const controller = class LoginController {
   constructor(loginService, userDataService, $state) { 
      'ngInject'
          this.userInfo = {
              username: '',
              password: ''
          }
          this.loginService = loginService
          this.userDataService = userDataService
          this.$state = $state

          usernameErrorCss = "black"
          passwordErrorCss = "black"
      }

  
      login() {
          this.loginService.login(this.userInfo).then((successResponse) => {
              this.userDataService.setUserCredentials(this.userInfo.username, this.userInfo.password)
              this.usernameErrorCss = "black"
              this.passwordErrorCss = "black"
  
              this.$state.go('session.book')
          }, (errorResponse) => {
              if (errorResponse.status === 404) {
                  // Username not found, shows error on username field
                  this.userInfo.username = ''
                  this.userInfo.password = ''
                  this.usernameErrorCss = "red"
                  this.passwordErrorCss = "black"
              }
  
              if (errorResponse.status === 401) {
                  // Password not found, shows error on password field
                  this.userInfo.password = ''
                  this.passwordErrorCss = "red"
                  this.usernameErrorCss = "black"
              }
  
          })
      }
  }
   
export const loginComponent = {
  controller,
  templateUrl,
  controllerAs: 'loginController',
  bindings: {
    userInfo: '='
  }
}
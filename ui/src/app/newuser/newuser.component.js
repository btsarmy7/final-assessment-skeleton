import templateUrl from './newuser.template.html'

const controller = class NewuserController {
    constructor(newuserService, $state) {
            '@ngInject'
            this.newuserService = newuserService
            this.$state = $state
            userInfo = {
                username: '',
                password: ''
            }
        
            usernameErrorCss = "black"
            passwordErrorCss = "black"

        }
    
        createNewUser() {
            let user = {
                credentials: this.userInfo
            }
    
            this.newuserService.createNewUser(user).then((succeessResponse) => {
                this.$state.go('title.login')
            }, (errorResponse) => {
                if (errorResponse.status === 409) {
                    // Username taken
                    this.submission.username = ''
                    this.usernameErrorCss = "red"
                    this.passwordErrorCss = "black"
                }
    
                if (errorResponse.status === 406) {
                    // Required field missing
                    this.usernameErrorCss = "red"
                    this.passwordErrorCss = "red"
                }
            })
        }
    }

export const newuserComponent = {
  templateUrl,
  controller,
  controllerAs: 'newuserController'
}
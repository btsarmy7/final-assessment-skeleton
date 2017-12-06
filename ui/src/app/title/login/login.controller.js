/* @ngInject */
class LoginController {

    constructor(loginService, userDataService, $state) {
        this.submission = {
            username: '',
            password: ''
        }
        this.loginService = loginService
        this.userDataService = userDataService
        this.$state = $state
    }

    submission = {
        username: '',
        password: ''
    }

    usernameErrorCss = "black"
    passwordErrorCss = "black"

    login() {
        this.loginService.login(this.submission).then((successResponse) => {
            this.userDataService.setUserCredentials(this.submission.username, this.submission.password)
            window.alert("Sucessfully Logged in!")
            this.$state.go('member.book')
        }, (errorResponse) => {
            if (errorResponse.status === 404) {
                // Username not found, shows error on username field
                this.submission.username = ''
                this.submission.password = ''
                window.alert("Invalid Username")
            }

            if (errorResponse.status === 401) {
                // Password not found, shows error on password field
                this.submission.password = ''
                window.alert("Invalid Password")
            }

        })
    }
}

export default LoginController
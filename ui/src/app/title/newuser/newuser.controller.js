/* @ngInject */
class NewuserController {

    constructor(newuserService, $state) {
        this.newuserService = newuserService
        this.$state = $state
    }

    submission = {
        username: '',
        password: ''
    }

    usernameErrorCss = "black"
    passwordErrorCss = "black"

    createNewUser() {
        let user = {
            credentials: this.submission
        }

        this.newuserService.createNewUser(user).then((successResponse) => {
            window.alert("Successfully Signed Up! Please procceed to login.")
            this.$state.go('title.login')
        }, (errorResponse) => {
            if (errorResponse.status === 409) {
                // Username taken
                this.submission.username = ''
                //this.usernameErrorCss = "red"
                //this.passwordErrorCss = "black"
                window.alert("Username Unavailable")
            }

            if (errorResponse.status === 406) {
                // Required field missing
                //this.usernameErrorCss = "red"
                //this.passwordErrorCss = "red"
                window.alert("Username or Password is unavailable")
            }
        })
    }
}

export default NewuserController
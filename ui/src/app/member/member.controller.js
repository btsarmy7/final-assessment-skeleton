/* @ngInject */
class memberController {
    
    constructor(userDataService, $state) {
        if(!userDataService.loggedIn()) {
            $state.go('title.login')
        }
    }

}

export default memberController
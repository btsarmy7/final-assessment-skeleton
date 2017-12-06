/* @ngInject */
class ListService {

    backupItinerary = []

    constructor($http, apiUrl, userDataService) {
        this.$http = $http
        this.apiUrl = apiUrl
        this.userDataService = userDataService
    }

	/*
	 * get previously booked trips by this user
	 */
    getItinerary() {
        return this.$http.get(`${this.apiUrl}/flights/trips/${this.userDataService.credentials.username}`)
    }

}

export default ListService
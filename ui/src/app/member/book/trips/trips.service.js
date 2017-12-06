/* @ngInject */
class TripsService {

    constructor($http, apiUrl, userDataService) {
        this.$http = $http
        this.apiUrl = apiUrl
        this.userDataService = userDataService
    }

    getTrips(origin, destination) {
        return this.$http.get(`${this.apiUrl}/flights/trips/`, {
            params: {
                origin,
                destination
            }
        })
    }

	/*
	 * insert the selected flight trip to backend database
	 */
    bookTrip(trip) {
        window.alert("Trip Booked! Go to My Trips to see itinerary.")
        return this.$http.post(`${this.apiUrl}/flights/trips/${this.userDataService.credentials.username}`, trip)
    }

}

export default TripsService
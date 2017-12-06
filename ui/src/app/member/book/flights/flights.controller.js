/* @ngInject */
class FlightsController {
    constructor(flightsService, $interval, $state, userDataService) {
        this.flightsService = flightsService

        if (!userDataService.loggedIn()) {
            $state.go('title.login')
        } else {
            this.getFlights()
            $interval(() => this.getFlights(), 20000)
        }
    }

    flightList = []

    getFlights() {
        this.flightsService.getFlights().then((successResponse) => {
            if (successResponse.data.length === 5) {
                successResponse.data.forEach((flight) => {
                    flight.output = `From ${flight.origin} to ${flight.destination} at ${flight.offset}:00 AM, duration ${flight.flightTime} hour(s)`
                })
                this.flightList = successResponse.data
            }
        })
    }

}

export default FlightsController
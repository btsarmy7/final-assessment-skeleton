/* @ngInject */
class TripsController {

    constructor(tripsService, $interval, $state, userDataService, $log) {
        this.tripsService = tripsService
        this.logger = $log
        if (!userDataService.loggedIn()) {
            $state.go('title.login')
        }
        else {
            this.getTrips()
            $interval(() => this.getTrips(), 10000)
        }
    }

    originSelection = 'Memphis'
    destinationSelection = 'Nashville'

    tripList = []

    getTrips() {
        this.tripsService.getTrips(this.originSelection, this.destinationSelection).then((successResponse) => {
            successResponse.data.forEach((trip) => {
                //this.logger.log(this.originSelection)
                //this.logger.log(this.destinationSelection)
                //this.logger.log(trip)
                trip.flightOutput = []
                for (let i = 0; i < trip.length; i++) {
                    trip.flightOutput.push(trip[i])
                    trip.flightOutput[i].to = 'to'
                    trip.flightOutput[i].hours = 'hour(s)'
                    if ((i + 1) < trip.length) {
                        trip.flightOutput[i].layovers = []
                        trip.flightOutput[i].layovers.push(trip[i + 1].offset - trip[i].offset)
                    }
                }
            })

            if (successResponse.data.length !== 0 &&
                this.originSelection !== this.destinationSelection) {
                this.tripList = successResponse.data
            } else {
                let defaultTrip = []
                let flight = []
                flight.origin = 'No flight'
                flight.destination = 'available'
                defaultTrip.flightOutput = [flight]
                this.tripList = [defaultTrip]
            }
    
        })
    }

    bookTrip(trip) {
        if (trip.length > 0) {
            const outputTrip = {
                origins: [],
                destinations: [],
                flightTimes: [],
                layoverTimes: []
            }

            for (let i = 0; i < trip.length; i++) {
                outputTrip.origins.push(trip[i].origin)
                outputTrip.destinations.push(trip[i].destination)
                outputTrip.flightTimes.push(trip[i].flightTime)

                if ((i + 1) < trip.length) {
                    outputTrip.layoverTimes.push(trip[i + 1].offset - trip[i].offset)
                }
            }

            this.tripsService.bookTrip(outputTrip).then((successResponse) => {})
        }
    }
}

export default TripsController
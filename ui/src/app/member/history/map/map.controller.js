/* @ngInject */
class MapController {
    zoom = 7
    center = [35.5175, -86.5804]
    paths = []

    constructor(mapService, mapLocations, historyService, $state, userDataService) {
        this.mapService = mapService
        this.historyService = historyService

        if (!userDataService.loggedIn()) {
            $state.go('title.login')
        } else {
            this.drawTrip()
        }
    }

    addPath(origin, destination) {
        let pathColor = ''
        let cityPair = origin.city + '_' + destination.city
        switch (cityPair) {
            case 'Memphis_Chattanooga':
            case 'Chattanooga_Memphis':
                pathColor = 'dodgerblue'
                break;
            case 'Memphis_Knoxville':
            case 'Knoxville_Memphis':
                pathColor = 'hotpink'
                break;
            case 'Memphis_Nashville':
            case 'Nashville-Memphis':
                pathColor = 'limegreen'
                break;
            case 'Chattanooga_Knoxville':
            case 'Knoxville_Chattanooga':
                pathColor = 'dimgray'
                break;
            case 'Chattanooga_Nashville':
            case 'Nashville_Chattanooga':
                pathColor = 'coral'
                break;
            case 'Knoxville_Nashville':
            case 'Nashville_Knoxville':
                pathColor = 'red'
                break;
            default:
                console.dir("Error in city icon display")
        }

        this.paths.push({
            path: `[[${origin.latitude}, ${origin.longitude}], [${destination.latitude}, ${destination.longitude}]]`,
            strokeColor: pathColor,
            strokeOpacity: 1.0,
            strokeWeight: 3,
            geodesic: true
        })
    }

    drawTrip() {
        if (this.historyService.trip && this.historyService.trip.origins) {
            for (let i = 0; i < this.historyService.trip.origins.length; i++) {
                this.mapService.getMarkerByCityName(this.historyService.trip.origins[i]).then((originResponse) => {
                    this.mapService.getMarkerByCityName(this.historyService.trip.destinations[i]).then((destinationResponse) => {
                        let flightOrigin = {
                            latitude: originResponse.data.latitude,
                            longitude: originResponse.data.longitude,
                            city: originResponse.data.city
                        }

                        let flightDestination = {
                            latitude: destinationResponse.data.latitude,
                            longitude: destinationResponse.data.longitude,
                            city: destinationResponse.data.city
                        }

                        /*
                         * add the trip path to the map
                         */
                        this.addPath(flightOrigin, flightDestination)
                    })
                })
            }
        } else {
            this.historyService.trip = {
                destinationInfo: 'Select a Flight'
            }
        }
    }

}

export default MapController
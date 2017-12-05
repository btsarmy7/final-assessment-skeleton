export class LoginService {
  
      constructor($http, apiUrl) {
          this.$http = $http
          this.apiUrl = apiUrl
      }
  
      login(credentials) {
          return this.$http.post(`${this.apiUrl}/users/login/`, credentials) // check if the user is in database
      }
  
  }
  
  
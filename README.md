# Agora Data Bug Tracker

Live Application: [Agora Bug Tracker](https://fierce-savannah-21475.herokuapp.com/)

I implemented the applicaiton using Java 8 and Spring Boot on the backend with a basic H2 in-memory database for the purpose of this application.
The table sorting is handled with JavaScript so the table remains dynamic.

# API Documentation
I also implemented a basic RESTful API for getting a JSON payload of all the active bugs. The default payload is sorted by ID.
[https://fierce-savannah-21475.herokuapp.com/api/bugs](https://fierce-savannah-21475.herokuapp.com/api/bugs)
or
[https://fierce-savannah-21475.herokuapp.com/api/bugs?sortBy=id](https://fierce-savannah-21475.herokuapp.com/api/bugs?sortBy=id)

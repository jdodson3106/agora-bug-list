# Agora Data Bug Tracker

Live Application: [Agora Bug Tracker](https://fierce-savannah-21475.herokuapp.com/)

I implemented the applicaiton using Java 8 and Spring Boot on the backend with a basic H2 in-memory database for the purpose of this application.
The table sorting is handled with JavaScript so the table remains dynamic.
<hr/>

# API Documentation
I also implemented a basic RESTful API for getting a JSON payload of all the active bugs.<br/>
**The default payload is sorted by ID.**<br/>
[https://fierce-savannah-21475.herokuapp.com/api/bugs](https://fierce-savannah-21475.herokuapp.com/api/bugs)<br/>
or<br/>
[https://fierce-savannah-21475.herokuapp.com/api/bugs?sortBy=id](https://fierce-savannah-21475.herokuapp.com/api/bugs?sortBy=id)
<br/>
To sort by each column when requesting the JSON payload simply put in the column name you wish to sort by in the request parameter.

<br/>
### Sort By ID

[https://fierce-savannah-21475.herokuapp.com/api/bugs?sortBy=id](https://fierce-savannah-21475.herokuapp.com/api/bugs?sortBy=id)
<br/>
### Sort By Title

[https://fierce-savannah-21475.herokuapp.com/api/bugs?sortBy=title](https://fierce-savannah-21475.herokuapp.com/api/bugs?sortBy=title)

<br/>
### Sort By Date

[https://fierce-savannah-21475.herokuapp.com/api/bugs?sortBy=date](https://fierce-savannah-21475.herokuapp.com/api/bugs?sortBy=date)

<br/>
### Sort By Severity

[https://fierce-savannah-21475.herokuapp.com/api/bugs?sortBy=severity](https://fierce-savannah-21475.herokuapp.com/api/bugs?sortBy=severity)

<br/>
### Sort By Priority

[https://fierce-savannah-21475.herokuapp.com/api/bugs?sortBy=priority](https://fierce-savannah-21475.herokuapp.com/api/bugs?sortBy=priority)

<hr/>
# API Considerations
If the request parameter is not valid the result will return an empty JSON object. <br/>
The sorting of the JSON payload matches the table sorting scheme direct. For example, the severity will sort 1 -> 5 as 1 is the most severe as with the table.

<hr/>
# Notes
I did not implement much validation with the exception of trying to submit an empty file. Aside from this the field will only accept .csv files. The basic operation of the application is matched with the basic requirements given and makes all the same assumptions that the data is properly formatted and the file uploaded will be an accurate file. In the event a non-vavlid or formatted file is uploaded the application may produce an error.

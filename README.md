# Airport
### ABOUT APPLICATION
This application was designed to process airport passengers data and certain of their requests. This application can register a passenger, purchase a passenger’s ticket, 
search a flight between certain dates, delete a passenger, ticket, flight, route from the database.

### TECHNOLOGIES
Java 11, Hibernate, Spring, Spring Security, MySQL.

### ENDPOINTS
#### /passenger - get all passengers from database(GET), register passenger(POST), delete passenger from database(DELETE)
#### /ticket - get all tickets from database(GET), buy ticket(POST), delete ticket database(DELETE)
#### /route - delete route from database(DELETE)
#### /flight - delete flight from database(DELETE)
#### /flight/search/borders?datefrom=2022-04-11 00:00:00&dateTo=2022-04-20 00:00:00 - search flight between certain dates

### PASSWORDS
###### "3487" for passengers with USER role
###### "1234" for passengers with ADMIN role (now only passenger with name "Gonchar Sergij"

### HOW TO INSTALL
Download repository -> download IntelliJ IDEA -> open this repository by IntelliJ IDEA -> run SpringApp

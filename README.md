Voting system
===========
This is a REST API using Spring-Boot without frontend.
It can be used to decide where to have lunch.

May be 2 types of users: admin and regular users. 
Admin can input a restaurant and it's lunch menu of the day (a dish name and price). 
Menu changes each day (admins do the updates). 
Users can vote on which restaurant they want to have lunch at. Only one vote counted per user. 
If user votes again the same day: If it is before 11:00 we asume that he changed his mind. If it is after 11:00 thenvote can't be changed. 
Each restaurant provides new menu each day.

## **API documentation and curl commands**

### URL for Admin

create new restaurant, JSON, example `{"name": "Кафе"}` :
`http://localhost:8080/rest/admin/restaurant/new`

create menu for restaurant, JSON, example 
``` 
{"meals":
[
{"name":"суп","price":100},
{"name":"плов","price":90},
{"name":"вода","price":50}
],
"date":"2020-01-14"}
``` 

`http://localhost:8080/rest/admin//restaurant/{restaurantId}/menu/new`

delete restaurant by id
`http://localhost:8080/rest/admin/{restaurantId}/delete`

### URL for User

get all restaurants 
`http://localhost:8080/rest/restaurant/`

vote (by restaurant id)
`http://localhost:8080/rest/restaurant/{restaurantId}/vote`

get menu (by restaurant id)
`http://localhost:8080/rest/restaurant/{restaurantId}/menu"`

get rating
`http://localhost:8080/rest/restaurant/rating`
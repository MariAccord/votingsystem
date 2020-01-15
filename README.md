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

create new restaurant
 
 POST `http://localhost:8080/rest/admin/restaurant/new`

Request Body, template

`{"name": [restaurantName]}` 

example JSON

 `{"name": "Кафе"}` 
 
create menu for restaurant

POST `http://localhost:8080/rest/admin//restaurant/{restaurantId}/menu/new`

Request Body, template

``` 
{"meals":
[
{"name":[itemName1],"price": [itemPrice1]}, 
{"name":[itemName2],"price": [itemPrice2]}, 
.....
{"name":[itemNameN],"price": [itemPriceN]}
],
"date":[yyyy-MM-dd]}
``` 

example JSON

``` 
{"meals":
[
{"name":"суп","price":100},
{"name":"плов","price":90},
{"name":"вода","price":50}
],
"date":"2020-01-14"}
``` 

delete restaurant by id

POST `http://localhost:8080/rest/admin/{restaurantId}/delete`

### URL for User

get all restaurants 

GET `http://localhost:8080/rest/restaurant/`

get menu (by restaurant id)

GET `http://localhost:8080/rest/restaurant/{restaurantId}/menu"`

get rating (by date)

GET `http://localhost:8080/rest/restaurant/rating[date]`

Request Parameter "date" is optional and it points what date the rating will be show for.
If "date" is not present, date will be "today" by default.

example `http://localhost:8080/rest/restaurant/rating?date=2020-01-16`

example `http://localhost:8080/rest/restaurant/rating`


vote (by restaurant id)

POST `http://localhost:8080/rest/restaurant/{restaurantId}/vote`
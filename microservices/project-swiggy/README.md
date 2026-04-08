
## Register a user

```
POSTMAN --request POST 'http://localhost:8080/auth/register' 

--data-raw '{
    "name":"sunil",
    "password":"12345",
    "email":"sunil@gmail.com"
}'

```

## Generate token

```
POSTMAN--request POST 'http://localhost:9898/auth/token'    http://localhost:8080/auth/token

--data-raw '{
    "username":"sunil",
    "password":"12345"
}'
```
## Access Swiggy-app

```
POSTMAN --request GET 'http://localhost:8080/swiggy/35fds631'   -----> 35fds631 OrderID - refer DAO class in Restaurants MS
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJCYXNhbnQiLCJpYXQiOjE2NzkwNTU4MDIsImV4cCI6MTY3OTA1NzYwMn0.Q0bwS5_16q1Z8K-p_flpmyRoJNFCyOhU2AMKSNYh66o' \
```

## Access Restaurant-service

```
curl --location --request GET 'http://localhost:8080/restaurant/orders/status/37jbd832' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJCYXNhbnQiLCJpYXQiOjE2NzkwNTU1MDcsImV4cCI6MTY3OTA1NzMwN30.9nNAW1rx8RoTIrhn5Abtzg7RplvT9_d-U5EOwUcJZq8' \
--header 'Cookie: JSESSIONID=7CE91EE75A65277C0DCB6C5736C5DF5D'
```




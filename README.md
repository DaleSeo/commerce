# Commerce

## Run
```
$ ./gradlew bootRun
```

## Heroku
- https://dale-commerce.herokuapp.com/

## Repository
- Github : https://github.com/DaleSeo/commerce.git
- Heroku : https://git.heroku.com/dale-commerce.git

## API
### Record
```
$ curl http://localhost:5000/record
```
### Member
```
$ curl -X POST http://localhost:8080/member -H 'Content-type: application/json' -d '{"username": "dale0713", "password": "12345678", "email": "dale.seo@gmail.com"}'
```
```
$ curl -X GET http://localhost:8080/member/1
```
```
$ curl -X GET http://localhost:8080/member
```
```
$ curl -X PUT http://localhost:8080/member/1 -H 'Content-type: application/json' -d '{"username": "dale_seo", "password": "87654321", "email": "dale.seo@daum.net"}'
```
```
$ curl -X DELETE http://localhost:8080/member/1
```
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
$ curl http://localhost:8080/api/record
```

### Auth
```
$ curl http://localhost:8080/api/auth/signIn
```
```
$ curl http://localhost:8080/api/auth/signOut
```

### Member
```
$ curl -X POST http://localhost:8080/api/member -u user:password -H 'Content-type: application/json' -d '{"username": "dale0713", "password": "12345678", "email": "dale.seo@gmail.com"}'
```
```
$ curl -X GET http://localhost:8080/api/member/1 -u user:password
```
```
$ curl -X GET http://localhost:8080/api/member -u user:password
```
```
$ curl -X PUT http://localhost:8080/api/member/1 -u user:password -H 'Content-type: application/json' -d '{"username": "dale_seo", "password": "87654321", "email": "dale.seo@daum.net"}'
```
```
$ curl -X DELETE http://localhost:8080/api/member/1 -u user:password
```
## API

### Record
```
$ curl http://localhost:8080/api/record
```

### Auth
```
$ curl "http://localhost:8080/api/auth/signIn?username=guest&password=1234"
```
```
$ curl http://localhost:8080/api/auth/signOut -H 'x-auth-token: <x-auth-token>'
```

### Member
```
$ curl -X POST http://localhost:8080/api/member -H 'x-auth-token: <x-auth-token>' -H 'Content-type: application/json' -d '{"username": "dale0713", "password": "12345678", "email": "dale.seo@gmail.com"}'
```
```
$ curl -X GET http://localhost:8080/api/member/1 -H 'x-auth-token: <x-auth-token>'
```
```
$ curl -X GET http://localhost:8080/api/member -H 'x-auth-token: <x-auth-token>'
```
```
$ curl -X PUT http://localhost:8080/api/member/1 -H 'x-auth-token: <x-auth-token>' -H 'Content-type: application/json' -d '{"username": "dale_seo", "password": "87654321", "email": "dale.seo@daum.net"}'
```
```
$ curl -X DELETE http://localhost:8080/api/member/1 -H 'x-auth-token: <x-auth-token>'
```

### Product
```
$ curl -X POST http://localhost:8080/api/product -H 'x-auth-token: c1df482e-c428-4482-b549-090f5308b27e' -H 'Content-type: application/json' -d '{"username": "dale0713", "password": "12345678", "email": "dale.seo@gmail.com"}'
```
```
$ curl -X PUT http://localhost:8080/api/product/1 -u -H 'x-auth-token: c1df482e-c428-4482-b549-090f5308b27e' -H 'Content-type: application/json' -d '{"username": "dale_seo", "password": "87654321", "email": "dale.seo@daum.net"}'
```
```
$ curl -X DELETE http://localhost:8080/api/product/1 -H 'x-auth-token: c1df482e-c428-4482-b549-090f5308b27e'
```
```
$ curl -X GET http://localhost:8080/api/product/1 -H 'x-auth-token: c1df482e-c428-4482-b549-090f5308b27e'
```
```
$ curl -X GET http://localhost:8080/api/product -H 'x-auth-token: c1df482e-c428-4482-b549-090f5308b27e'
```

### Order
```
$ curl -X GET http://localhost:8080/api/orders/1

```
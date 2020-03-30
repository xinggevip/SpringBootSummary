# SpringBoot集成学习总结

## 一、项目访问

- Druid

  ```
  url:http://127.0.0.1:8080/druid/index.html
  username:root
  password:123456
  ```

- Swagger

  - springfox-swagger-ui

    ```
    url:http://127.0.0.1:8080/swagger-ui.html
    ```

  - swagger-bootstrap-ui

    ```
    url:http://127.0.0.1:8080/doc.html
    ```

  - RabbitMQ

    ```
    url:http://192.168.163.128:15672
    username:guest
    password:guest
    ```

    

## 二、Docker

### Docker安装redis

```
docker run -d -p 6379:6379 redis:5.0.8
```

### Docker安装RabbitMQ

```
docker run -d -p 5672:5672 -p 15672:15672 rabbitmq:3.8.2-management
```


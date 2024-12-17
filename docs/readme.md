## To compile
```
mvn compile
```

# Iniciar container rabbitMQ
docker run -d --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4.0-management

# Listar
docker exec rabbitmq rabbitmqctl list_queues
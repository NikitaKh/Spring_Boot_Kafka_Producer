# Spring Boot Kafka Producer

Продюсер кафки на спринге.  

### Инструкция:
1. В файле src/main/resources/application.properties прописываем адрес кафки и топик, куда будем писать.  
2. В файле src/main/java/ru/sbt/mock_http_to_kafka/controller/KafkaProducerController.java  
   можно добавить запросы или изменить текущий post запрос.  
3. Для запуска надо перейти в корень проекта и ввести <b>mvn clean spring-boot:run</b>.  
4. Обращаться по POST http://127.0.0.1:8080/kafka/post?message=text  

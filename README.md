
# ***REST API(GET) Current Time***

## Описание проекта

*Приложение предоставляет текущее время с точностью до секунд с указанием Timezone.

Реализован обработчик(GET),
+ /api/time

## Запуск

Сборка .jar и запуск .jar file 
```
./gradlew clean build
```
Запуск .jar file
```
java -jar .\build\libs\currenttimemvc-0.0.1-SNAPSHOT.jar
```
Запуск без .jar
```
./gradlew clean run
```

## Пример использования в Postman 

![image](https://github.com/gazzsha/Rest-API-Current-Time/assets/90255037/256c32fd-4311-40cf-bed8-c6a0e5b3ba3e)


## Web MVC vs WebFlux
**MVC** представляет собой способ разработки с использованием контейнеров сервлетов(ex. Tomcat). 
Каждому входному запросу будет назначен поток, который будет обработывать весь жизенный цикл запроса.
Приложение сможет обрабатывать кол-во запросов, равное размеру пола потока. Так же при каждом вызове/ответе службы потоки блокируются. 

![image](https://github.com/gazzsha/Rest-API-Current-Time/assets/90255037/5a0dada0-cd63-4347-b500-e575d2aeea7d)


**Реактивное программирование** - это неблокирующие приложения, которые являются асинхронными и управляемыми событиями и требуют небольшого количества потоков для масштабирования

![image](https://github.com/gazzsha/Rest-API-Current-Time/assets/90255037/aadfc1c8-e044-4a8f-bb38-522a7a5ce4a6)


Одно из преимуществ реактивных веб-сервисов наблюдается при большом количестве обрабатываемых запросов. Наибольший эффект реактивное программирование дает при вертикальном масштабировании.

![image](https://github.com/gazzsha/Rest-API-Current-Time/assets/90255037/e408e542-263c-44c1-961c-1ef27a89dfca)

Задание не подразумевает обработку большего количества запросов, тогда мы можем не вольноваться насчет просадок при нагрузке. Наш контроллер обращается к одному метода Service - getCurrentDate(),
у нас нет сложной логической цепочки обработки запроса, что также говорит о быстром отклике контроллера. Поэтому выбор был сделал в пользу традиционного MVC, ввиду несложной логики работы контроллера, 
простой реализации и не подразумевает большую нагрузку.

Теория взята отсюда:

[https://docs.spring.io/spring-framework/reference/web/webflux.html](https://docs.spring.io/spring-framework/reference/web/webflux/new-framework.html)

https://habr.com/ru/articles/565752/

https://habr.com/ru/articles/565004/

https://habr.com/ru/articles/565698/




package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // Исходники: https://github.com/IlyaLisov/data-generator-microservice
        //Описание: у нас это приложение которое будет отправлять данные с датчика в кафку, а другое приложение будет читать данные с кафки и обрабатывать их

        // 1. Прием данных по REST с датчика(фронт/постман) и отправка данных в кафку - https://www.youtube.com/watch?v=A3ed6nayNcw&list=PL3Ur78l82EFBhKojbSO26BVqQ7n4AthHC&index=3

        //папки:
            //web - тут принимаем данные с датчика, тоесть как будто нам данные присылает датчик(фронт или postman) и
                    //после приема данных мы их будем отправлять в кафку, а данные будут анализироваться другим сервисом.
                    //папки:
                            //controller -
                            //dto - для понимания отправки данных
                            //mapper - для приема данных
            //config -
            //model -
            //service -

        SpringApplication.run(Main.class, args);
        //App   start on: http://localhost:8081
        //Kafka start on: http://localhost:9092
    }
}

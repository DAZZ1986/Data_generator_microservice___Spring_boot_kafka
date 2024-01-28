    // Исходники: https://github.com/IlyaLisov/data-generator-microservice
    
    //Описание: у нас это приложение которое будет отправлять данные с датчика в кафку, 
    //а другое приложение будет читать данные с кафки и обрабатывать их.

    //1. Прием данных по REST с датчика(фронт/постман) и отправка данных в кафку - https://www.youtube.com/watch?v=A3ed6nayNcw&list=PL3Ur78l82EFBhKojbSO26BVqQ7n4AthHC&index=3

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

    //App   start on: http://localhost:8081
    //Kafka start on: http://localhost:9092



https://kafka.apache.org/quickstart
1. запуск zookeeper
папку с кафкой вытаскиваем максимально в корень, тк терминал в intelij idea нихрена не может принимать длинные пути!
мой путь до кафки - C:\PC\CODE\kafka_2.13-3.6.1    -    
bin/windows/zookeeper-server-start.bat config/zookeeper.properties
bin/windows/zookeeper-server-stop.bat config/zookeeper.properties


2. запуск kafka-server
в новом терменале запускаем также из папки с кафкой C:\PC\CODE\kafka_2.13-3.6.1> - 
bin/windows/kafka-server-start.bat config/server.properties
bin/windows/kafka-server-stop.bat config/server.properties


заметка по п.1 и п.2 - если не запускается зуукипер или кафка то решение проблемы:
https://stackoverflow.com/questions/45599625/kafka-unable-to-start-kafka-process-can-not-access-file-00000000000000000000
	а) I had the same issue. The only way I could figure it out that was just delete the C:\tmp\kafka-logs directory. After that i was able to start up the kafka server.
	б) All answers give you a same solution by remove data, not how to prevent the problem. Which actually, you just need to stop Kafka and Zookeepter properly. You just have run these two commands in order:
			bin/windows/zookeeper-server-stop.bat config/zookeeper.properties
			bin/windows/kafka-server-stop.bat config/server.properties


3. запуск чтения kafka message
в новом терменале запускаем также из папки с кафкой C:\PC\CODE\kafka_2.13-3.6.1> - bin/windows/kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic data-temperature test --from-beginning

топики:
TopicBuilder.name("data-temperature")
TopicBuilder.name("data-voltage")
TopicBuilder.name("data-power")



тут не будет сообщений так как их в ней просто нет, далее отправляем сообщение в наше приложение и проверяем кафку
POST 
http://localhost:8081/api/v1/data/send
{
  "sensorId": 1,
  "timestamp": "2023-09-12T12:10:05",
  "measurement": 15.5,
  "measurementType": "TEMPERATURE"
}


{
  "delayInSeconds": 3,
  "measurementTypes": [
    "POWER",
    "VOLTAGE",
    "TEMPERATURE"
  ]
}

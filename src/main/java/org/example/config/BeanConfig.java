package org.example.config;

import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class BeanConfig {

    @SneakyThrows   //тут мы обрабатываем исключение чтобы оно пробрасывалось выше
    @Bean
    public XML producerXML() {  //тут ловим исключение которое пробрасываем выше аннотацией @SneakyThrows
        return new XMLDocument(
                new File("src/main/resources/kafka/producer.xml")
        );
    }


}

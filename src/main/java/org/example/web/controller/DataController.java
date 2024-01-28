package org.example.web.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Data;
import org.example.model.test.DataTestOptions;
import org.example.service.KafkaDateService;
import org.example.service.TestDataService;
import org.example.web.dto.DataDto;
import org.example.web.dto.DataTestOptionsDto;
import org.example.web.mapper.DataMapper;
import org.example.web.mapper.DataTestOptionsMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/data")
@RequiredArgsConstructor
public class DataController {
    private final KafkaDateService kafkaDateService;
    private final TestDataService testDataService;
    private final DataMapper dataMapper;
    private final DataTestOptionsMapper dataTestOptionsMapper;

    @PostMapping("/send")
    public void send(@RequestBody DataDto dto) {    //как тут мы разложили наш json из постмана в переменные класса DataDto ???
        Data data = dataMapper.toEntity(dto);   //приняли данные с датчика(фронт или постман), кладем в ДТО и далее
                                                //сохраняем в сущность/объект класса Data, сериализуем в байти и
        kafkaDateService.send(data);            //отправляем в кафку
    }

    @PostMapping("/test/send")
    public void testSend(@RequestBody DataTestOptionsDto testOptionsDto) {
        DataTestOptions testOptions = dataTestOptionsMapper.toEntity(testOptionsDto);
        testDataService.sendMessages(testOptions);
    }


}

package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class Data {
    //У нас должны быть два одинаковых объекта/класса. Тут мы объект сериализуем.
    //Сериализация — это преобразование объекта в строку (в последовательность байтов).

    private Long sensorId;
    private LocalDateTime timestamp;
    private double measurement;
    private MeasurementType measurementType;

    public enum MeasurementType {
        TEMPERATURE,
        VOLTAGE,
        POWER
    }


}

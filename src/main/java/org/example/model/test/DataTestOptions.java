package org.example.model.test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.Data;

@NoArgsConstructor
@Getter
@Setter
public class DataTestOptions {

    private int delayInSeconds;
    private Data.MeasurementType[] measurementTypes;

}

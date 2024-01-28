package org.example.web.mapper;

import java.util.Arrays;
import javax.annotation.processing.Generated;
import org.example.model.Data;
import org.example.model.test.DataTestOptions;
import org.example.web.dto.DataTestOptionsDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-03T21:12:22+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class DataTestOptionsMapperImpl implements DataTestOptionsMapper {

    @Override
    public DataTestOptions toEntity(DataTestOptionsDto dto) {
        if ( dto == null ) {
            return null;
        }

        DataTestOptions dataTestOptions = new DataTestOptions();

        dataTestOptions.setDelayInSeconds( dto.getDelayInSeconds() );
        Data.MeasurementType[] measurementTypes = dto.getMeasurementTypes();
        if ( measurementTypes != null ) {
            dataTestOptions.setMeasurementTypes( Arrays.copyOf( measurementTypes, measurementTypes.length ) );
        }

        return dataTestOptions;
    }

    @Override
    public DataTestOptionsDto toDto(DataTestOptions entity) {
        if ( entity == null ) {
            return null;
        }

        DataTestOptionsDto dataTestOptionsDto = new DataTestOptionsDto();

        dataTestOptionsDto.setDelayInSeconds( entity.getDelayInSeconds() );
        Data.MeasurementType[] measurementTypes = entity.getMeasurementTypes();
        if ( measurementTypes != null ) {
            dataTestOptionsDto.setMeasurementTypes( Arrays.copyOf( measurementTypes, measurementTypes.length ) );
        }

        return dataTestOptionsDto;
    }
}

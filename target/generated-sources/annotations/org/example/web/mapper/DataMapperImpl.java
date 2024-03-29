package org.example.web.mapper;

import javax.annotation.processing.Generated;
import org.example.model.Data;
import org.example.web.dto.DataDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-03T21:12:22+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class DataMapperImpl implements DataMapper {

    @Override
    public Data toEntity(DataDto dto) {
        if ( dto == null ) {
            return null;
        }

        Data data = new Data();

        data.setSensorId( dto.getSensorId() );
        data.setTimestamp( dto.getTimestamp() );
        data.setMeasurement( dto.getMeasurement() );
        data.setMeasurementType( dto.getMeasurementType() );

        return data;
    }

    @Override
    public DataDto toDto(Data entity) {
        if ( entity == null ) {
            return null;
        }

        DataDto dataDto = new DataDto();

        dataDto.setSensorId( entity.getSensorId() );
        dataDto.setTimestamp( entity.getTimestamp() );
        dataDto.setMeasurement( entity.getMeasurement() );
        dataDto.setMeasurementType( entity.getMeasurementType() );

        return dataDto;
    }
}

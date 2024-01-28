package org.example.web.mapper;

import org.example.model.test.DataTestOptions;
import org.example.web.dto.DataTestOptionsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataTestOptionsMapper extends Mappable<DataTestOptions, DataTestOptionsDto> {
}

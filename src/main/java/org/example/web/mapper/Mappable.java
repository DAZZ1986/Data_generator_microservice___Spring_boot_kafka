package org.example.web.mapper;

public interface Mappable<E, D> {
    //маппер для двух классов Data, DataDto - чтобы принимать данные

    E toEntity(D dto);  //из дто в сущность для приема данных с фронта или с кафки

    D toDto(E entity);  //из сущности в дто для отправки данных на фронт или в кафку

}

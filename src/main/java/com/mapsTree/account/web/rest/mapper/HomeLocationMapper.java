package com.mapsTree.account.web.rest.mapper;

import com.mapsTree.model.HomeLocation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
@Mapper(componentModel = "spring")
public interface HomeLocationMapper {
    @Mapping(target="latitude",ignore = true)
    @Mapping(target="longitude",ignore = true)
    com.mapsTree.account.domain.HomeLocation map(HomeLocation homeLocation);
    @Mapping(target="latitude",ignore = true)
    @Mapping(target="longitude",ignore = true)
    HomeLocation map(com.mapsTree.account.domain.HomeLocation homeLocation);
}

package com.mapsTree.account.web.rest.mapper;

import com.mapsTree.account.domain.User;
import com.mapsTree.model.UserCreate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {HomeLocationMapper.class}
)
public interface UserMapper {
    @Mapping(target="id",ignore = true)
    @Mapping(target="username",source="username")
    @Mapping(target="password",source="password")
    @Mapping(target="age",source="age")
    @Mapping(target="phoneNumber",source="phoneNumber")
    @Mapping(target="homeLocation.latitude",source="homeLocation.latitude")
    @Mapping(target="homeLocation.longitude",source="homeLocation.longitude")
    @Mapping(target = "country",source = "country")
    @Mapping(target = "timeOfCreation",source="timeOfCreation")
    User map(UserCreate userCreate);
    @Mapping(target="userId",source = "userId")
    @Mapping(target="username",source="username")
    @Mapping(target="age",source="age")
    @Mapping(target="phoneNumber",source="phoneNumber")
    @Mapping(target="homeLocation.latitude",source="homeLocation.latitude")
    @Mapping(target="homeLocation.longitude",source="homeLocation.longitude")
    @Mapping(target = "country",source = "country")
    @Mapping(target = "timeOfCreation",source="timeOfCreation")
    com.mapsTree.model.User map(User user);
    @Mapping(target="userId",source = "userId")
    User map(com.mapsTree.model.User user);

}

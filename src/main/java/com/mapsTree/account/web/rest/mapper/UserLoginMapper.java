package com.mapsTree.account.web.rest.mapper;

import com.mapsTree.model.User;
import com.mapsTree.model.UserLogin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {HomeLocationMapper.class}
)
public interface UserLoginMapper {
    @Mapping(target="username",source="username")
    @Mapping(target="password",source="password")
    com.mapsTree.account.domain.User map(UserLogin userLogin);
    @Mapping(target="userId",source = "userId")
    @Mapping(target="username",source="username")
    @Mapping(target="age",source="age")
    @Mapping(target="phoneNumber",source="phoneNumber")
    @Mapping(target="homeLocation.latitude",source="homeLocation.latitude")
    @Mapping(target="homeLocation.longitude",source="homeLocation.longitude")
    @Mapping(target = "country",source = "country")
    @Mapping(target = "timeOfCreation",source="timeOfCreation")
    User map(com.mapsTree.account.domain.User user);
}

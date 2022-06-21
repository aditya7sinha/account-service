package com.mapsTree.account.repository;

import com.mapsTree.account.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepostitory extends JpaRepository<User,Long> {
    @Query(value = "Select * from user_data where username= ?1 and password = ?2",nativeQuery = true)
    User findUserByUserNameandPassword(String username,String password);

}

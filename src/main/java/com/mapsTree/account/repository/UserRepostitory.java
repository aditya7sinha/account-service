package com.mapsTree.account.repository;

import com.mapsTree.account.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepostitory extends JpaRepository<User,Long> {
    @Query(value = "Select * from user_data where username= ?1 and password = ?2",nativeQuery = true)
    User findUserByUserNameandPassword(String username,String password);
    @Query(value="Select * from user_data where user_id=?1",nativeQuery = true)
    User findUserById(String id);
    @Query(value = "Select * from user_data where username= ?1",nativeQuery = true)
    User findUserByUsername(String username);
    @Query(value="SELECT CASE WHEN COUNT(u)>0 THEN TRUE ELSE FALSE END FROM user_data u WHERE u.username=?1", nativeQuery = true)
    Boolean userExists(String username);


}

package perscholascs.mylibrary.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import perscholascs.mylibrary.database.entity.User;
import perscholascs.mylibrary.database.entity.UserRole;

import java.util.List;


public interface UserRoleDAO extends JpaRepository<UserRole, Long> {
    @Query("select ur from UserRole ur where ur.user.id = :userId")
    List<UserRole> getUserRoles(@Param("userId") Integer userId);
    public UserRole findByUser(@Param("userId") Integer userId);


}

package perscholascs.mylibrary.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import perscholascs.mylibrary.database.entity.User;
import perscholascs.mylibrary.database.entity.UserRole;

import java.util.List;

public interface UserDAO extends JpaRepository<User,Long> {

    public User findById(@Param("id") Integer id);
    public User findByEmail(@Param("email") String email);
    public User findByUserName(@Param("userName") String userName);
//    @Query("select ur from UserRole ur where ur.user.id = :userId")
//    List<UserRole> getUserRoles(@Param("userId") Integer userId);
}

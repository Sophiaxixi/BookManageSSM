package book.manage.mapper;

import book.manage.entity.AuthUser;
import org.apache.ibatis.annotations.*;

/**
 * @Author: shlin
 * @Date: 2022/12/15 - 12 - 15 - 0:27
 * @Description: book.manage.mapper
 * @Version: 1.0
 */
@Mapper
public interface UserMapper {

    @Select("select * from users where name = #{name}")
    AuthUser getPasswordByUsername(String name);

    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")//将id回写到实体类中
    @Insert("insert into users(name,role,password) values(#{name},#{role},#{password})")
    int registerUser(AuthUser user);

    @Insert("insert into student(uid,name,sex,grade) values(#{uid},#{name},#{sex},#{grade})")
    int addStudentInfo(@Param("uid") int uid,@Param("name") String name,@Param("sex") String sex,@Param("grade") String grade);

    @Select("select sid from student where uid=#{uid}")
    Integer getSidByUserId(int uid);

    @Select("select count(*) from student")
    int studentCount();

}

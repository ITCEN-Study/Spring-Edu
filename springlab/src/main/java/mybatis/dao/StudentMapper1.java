package mybatis.dao;

import com.example.springlab.domain.StudentDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper1 {
    @Select("SELECT name, score FROM student")
    List<StudentDTO> listAll();

    @Select("SELECT name, score FROM student ORDER BY score DESC")
    List<StudentDTO> listOrderByScoreDesc();

    @Select("SELECT name, score FROM student WHERE score >= 70")
    List<StudentDTO> listByScoreGreaterEqualThan70();

    @Select("SELECT name, score FROM student WHERE name LIKE '%짱%'")
    List<StudentDTO> listByContainName();

    @Select("SELECT score FROM student WHERE name = #{name}")
    Integer getScore(String name);

    @Select("SELECT AVG(score) FROM student")
    Double getScoreAvg();

    @Insert("INSERT INTO student (name, score) VALUES (#{name}, #{score})")
    int insertStudent(StudentDTO dto);

    @Delete("DELETE FROM student WHERE name = #{name}")
    int deleteStudent(String name);
}

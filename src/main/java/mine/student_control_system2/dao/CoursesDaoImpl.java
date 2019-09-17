package mine.student_control_system2.dao;

import mine.student_control_system2.domain.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "coursesDao")
public class CoursesDaoImpl implements CoursesDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createCourse(Courses c) {
        jdbcTemplate.update("insert into courses (cname, name , dname)  value (?,?,?)"
                ,new Object[]{c.getCname(),c.getName(),c.getDname()});
    }

    @Override
    public List<Courses> getAllCourses() {
        return jdbcTemplate.query("select cname from courses where name ='null' or name ='course' or name ='name';",
                new BeanPropertyRowMapper<>(Courses.class)
        );
    }

    @Override
    public Courses getCoursesByCname(String cname) {
        return jdbcTemplate.query("select * from courses where cname="+cname+";",
                new BeanPropertyRowMapper<>(Courses.class)
        ).get(0);
    }

    @Override
    public List<Courses> getCoursesById(String id) {
        String sql="select * from courses where name ="+id+";";
        return jdbcTemplate.query("select * from courses where name ="+id+";",
                new BeanPropertyRowMapper<>(Courses.class)
        );
    }
}

package mine.student_control_system2.dao;

import mine.student_control_system2.domain.Departments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "departmentsDao")
public class DepartmentsDaoImpl implements DepartmentsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Departments> getAllDepartments() {
        return jdbcTemplate.query("select dname from departments;",
                new BeanPropertyRowMapper<>(Departments.class));
    }

    @Override
    public Departments getMineDepartments(String id) {
        return jdbcTemplate.query("select * from departments where name=" + id + ";",
                new BeanPropertyRowMapper<>(Departments.class)).get(0);
    }

    @Override
    public void createDepartment(Departments departments) {
        jdbcTemplate.update("insert into departments (dname,name,job) values('"+departments.getDname()+"',"+departments.getName()+",'"+ departments.getJob()+"');"
                );
    }

    @Override
    public void createPeople(Departments name) {
        jdbcTemplate.update("insert into departments (dname,name,job) values('"+name.getDname()+"','"+name.getName()+"','"+name.getJob()+"');"
        );
    }
}

package mine.student_control_system2.dao;


import mine.student_control_system2.domain.Departments;

import java.util.List;

public interface DepartmentsDao {
    List<Departments>getAllDepartments();
    Departments getMineDepartments(String id);
    void createDepartment(Departments dname);
    void createPeople(Departments name);
}

package mine.student_control_system2.service;


import mine.student_control_system2.domain.Departments;
import mine.student_control_system2.moudel.DepartmentModel;

import java.util.List;

public interface DepartmentsService {

    List<Departments> getAllDepartment();
    Departments  getMineDepartment(String id);
    void createDepartment(Departments d);
    void createPoeple(Departments d);
}

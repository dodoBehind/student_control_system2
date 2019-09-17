package mine.student_control_system2.service;

import mine.student_control_system2.dao.DepartmentsDao;
import mine.student_control_system2.domain.Departments;
import mine.student_control_system2.moudel.DepartmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "departmentsService")
public class DepartmentsServiceImpl implements DepartmentsService {

    @Autowired
    @Qualifier(value = "departmentsDao")
    private DepartmentsDao departmentsDao;


    @Override
    public void createDepartment(Departments d) {
        departmentsDao.createDepartment(d);
    }

    @Override
    public Departments getMineDepartment(String id) {
        return departmentsDao.getMineDepartments(id);
    }

    void setDepartments(DepartmentModel dm){
        Departments d=new Departments();
        d.setDname((String) dm.getValueAt(0,0));
        d.setName((String) dm.getValueAt(0,1));
        d.setJob((String) dm.getValueAt(0,2));
    }

    @Override
    public List<Departments> getAllDepartment() {
        return departmentsDao.getAllDepartments();
    }

    @Override
    public void createPoeple(Departments d) {
        departmentsDao.createPeople(d);
    }
}

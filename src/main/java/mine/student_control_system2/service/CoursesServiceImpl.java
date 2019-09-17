package mine.student_control_system2.service;

import mine.student_control_system2.dao.CoursesDao;
import mine.student_control_system2.domain.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "coursesService")
public class CoursesServiceImpl implements CoursesService {

    @Autowired
    @Qualifier(value = "coursesDao")
    CoursesDao coursesDao;

    @Override
    public void createCourse(Courses c) {
        coursesDao.createCourse(c);
    }

    @Override
    public List<Courses> getAllCourse() {
        List<Courses> l=coursesDao.getAllCourses();
        return coursesDao.getAllCourses();
    }

    @Override
    public List<Courses> getMineCourse(String id) {
        List<Courses> l=coursesDao.getCoursesById(id);
        return coursesDao.getCoursesById(id);
    }

}

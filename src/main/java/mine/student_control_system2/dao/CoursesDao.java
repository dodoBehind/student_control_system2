package mine.student_control_system2.dao;

import mine.student_control_system2.domain.Courses;

import java.util.List;

public interface CoursesDao {
    List<Courses> getAllCourses();
    Courses getCoursesByCname(String cid);
    List<Courses> getCoursesById(String id);
    void createCourse(Courses c);
}

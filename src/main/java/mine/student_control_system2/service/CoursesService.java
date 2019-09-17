package mine.student_control_system2.service;

import mine.student_control_system2.domain.Courses;

import java.util.List;

public interface CoursesService {
    List<Courses> getAllCourse();
    List<Courses> getMineCourse(String id);
    void createCourse(Courses c);
}

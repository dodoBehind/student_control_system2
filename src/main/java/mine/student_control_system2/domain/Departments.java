package mine.student_control_system2.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Departments implements Serializable {
    private String dname;
    private String name;
    private String job;
}

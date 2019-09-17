package mine.student_control_system2.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Courses implements Serializable {
    private String cname;
    private String name;
    private String dname;
}

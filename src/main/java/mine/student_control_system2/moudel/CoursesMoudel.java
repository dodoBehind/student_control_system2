package mine.student_control_system2.moudel;

import mine.student_control_system2.domain.Courses;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CoursesMoudel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private List<Courses> courses;

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
        fireTableDataChanged();

    }

    public void setCourses(Courses c) {
        courses = new ArrayList<>();
        courses.add(c);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return courses.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Courses c = courses.get(rowIndex);
        if (columnIndex == 0) return c.getCname();
        else if (columnIndex==1)return c.getName();
        else if (columnIndex==2)return c.getDname();
        else return c.getCname();
    }
}

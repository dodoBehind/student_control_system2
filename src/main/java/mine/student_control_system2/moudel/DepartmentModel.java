package mine.student_control_system2.moudel;

import mine.student_control_system2.domain.Departments;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public
class DepartmentModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;

    private List<Departments> departments;

    public void setDepartments(List<Departments> departments) {
        this.departments = departments;
        fireTableDataChanged();
    }

    public void setDepartments(Departments d) {
        departments = new ArrayList<>();
        departments.add(d);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return departments.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Departments d = departments.get(rowIndex);
        if (rowIndex == 0) return d.getDname();
        if (rowIndex == 1) return d.getName();
        if (rowIndex == 2) return d.getJob();
        return d.getJob();
    }
}

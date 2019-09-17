package mine.student_control_system2.ui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;

public class MyTable extends JTable{
    public MyTable(TableModel dm) {
        super(dm);
        setOpaque(false);
    }
    @Override
    public Component prepareRenderer(TableCellRenderer renderer,
                                     int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);
        if (c instanceof JComponent) {
            ((JComponent) c).setOpaque(false);
        }
        return c;
    }
}
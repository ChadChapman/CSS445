import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import java.awt.BorderLayout;
        import java.awt.GridLayout;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.sql.SQLException;
        import java.util.List;

        import javax.swing.JButton;
        import javax.swing.JFrame;
        import javax.swing.JLabel;
        import javax.swing.JOptionPane;
        import javax.swing.JPanel;
        import javax.swing.JScrollPane;
        import javax.swing.JTable;
        import javax.swing.JTextField;
        import javax.swing.event.TableModelEvent;
        import javax.swing.event.TableModelListener;
        import javax.swing.table.TableModel;

/*
 * TCSS 445 - Autumn 2017 Group Project.
 */


/**
 * @author Chad Chapman, Hui Ting Cai, Keegan J Kell and mmuppa
 * @version 30 November 2017
 *
 */
public class ReviewGUI extends JFrame implements ActionListener, TableModelListener {

    /** A generated serial version UID for object Serialization.*/
    private static final long serialVersionUID = -2827451253287095287L;

    private JButton btnList, btnDelete, btnAdd;
    private JPanel pnlButtons, pnlContent;
    private ReviewDB db;
    private List<InternshipReview> list;
    private String[] columnNames = {"StudentID",
            "ReviewID",
            "ReviewText"};

    private Object[][] data;
    private JTable table;
    private JScrollPane scrollPane;
    private JPanel pnlDelete;
    private JLabel lblTitle;;
    private JTextField txfTitle;
    private JButton btnTitleDelete;

    private JPanel pnlAdd;
    private JLabel[] txfLabel = new JLabel[5];
    private JTextField[] txfField = new JTextField[5];
    private JButton btnAddStudent;

    /**
     * Creates the frame and components and launches the GUI.
     * Initializes all of fields.
     */
    public ReviewGUI(){
        // The JFrame's overloaded constructor can set the title.
        super("Internship Reviews");
        db = new ReviewDB();
        try
        {
            list = db.getReview();

            data = new Object[list.size()][columnNames.length];
            for (int i=0; i<list.size(); i++) {
                data[i][0] = list.get(i).getStudentID();
                data[i][1] = list.get(i).getReviewID();
                data[i][2] = list.get(i).getReviewText();
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        createComponents();
        setVisible(true);
        setSize(500, 500);

    }
    /**
     * Creates panels for Student list, delete, and adds the corresponding
     * components to each panel.
     */
    private void createComponents() {
        pnlButtons = new JPanel();
        btnList = new JButton("Review List");
        btnList.addActionListener(this);

        btnDelete = new JButton("    Delete    ");
        btnDelete.addActionListener(this);

        btnAdd = new JButton("Add Review");
        btnAdd.addActionListener(this);

        pnlButtons.add(btnList);
        pnlButtons.add(btnDelete);
        pnlButtons.add(btnAdd);
        add(pnlButtons, BorderLayout.NORTH);

        // List Panel
        pnlContent = new JPanel();
        table = new JTable(data, columnNames);
        scrollPane = new JScrollPane(table);
        pnlContent.add(scrollPane);
        table.getModel().addTableModelListener(this);

        // Delete Panel
        pnlDelete = new JPanel();
        lblTitle = new JLabel("Enter ReviewID: ");
        txfTitle = new JTextField(15);
        btnTitleDelete = new JButton("Delete");
        btnTitleDelete.addActionListener(this);
        pnlDelete.add(lblTitle);
        pnlDelete.add(txfTitle);
        pnlDelete.add(btnTitleDelete);

        // Add Panel
        pnlAdd = new JPanel();
        pnlAdd.setLayout(new GridLayout(6, 0));
        String labelNames[] = { "Enter StudentID: ", "Enter ReviewID: ", "Enter ReviewText: "};
        for (int i = 0; i < labelNames.length; i++) {
            JPanel panel = new JPanel();
            txfLabel[i] = new JLabel(labelNames[i]);
            txfField[i] = new JTextField(25);
            panel.add(txfLabel[i]);
            panel.add(txfField[i]);
            pnlAdd.add(panel);
        }
        JPanel panel = new JPanel();
        btnAddStudent = new JButton("Add");
        btnAddStudent.addActionListener(this);
        panel.add(btnAddStudent);
        pnlAdd.add(panel);

        add(pnlContent, BorderLayout.CENTER);

    }

    /**
     * Event handling to change the panels when different tabs are clicked, add
     * and search buttons are clicked on the corresponding add and search
     * panels.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnList) {
            try {
                list = db.getReview();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            data = new Object[list.size()][columnNames.length];
            for (int i = 0; i < list.size(); i++) {
                data[i][0] = list.get(i).getStudentID();
                data[i][1] = list.get(i).getReviewID();
                data[i][2] = list.get(i).getReviewText();

            }
            pnlContent.removeAll();
            table = new JTable(data, columnNames);
            table.getModel().addTableModelListener(this);
            scrollPane = new JScrollPane(table);
            pnlContent.add(scrollPane);
            pnlContent.revalidate();
            this.repaint();

        } else if (e.getSource() == btnDelete) {
            pnlContent.removeAll();
            pnlContent.add(pnlDelete);
            pnlContent.revalidate();
            this.repaint();

        } else if (e.getSource() == btnAdd) {
            pnlContent.removeAll();
            pnlContent.add(pnlAdd);
            pnlContent.revalidate();
            this.repaint();

        } else if (e.getSource() == btnTitleDelete) {
            // Get the text from the text file.
            String reviewID = txfTitle.getText();
            // If the text file is not empty
            if (reviewID.length() == 7) {
                db.removeReview(reviewID); // remover this student form DB
                txfTitle.setText("");
            }else {
                JOptionPane.showMessageDialog(null, "ReviewID is 7 digits");
            }
        } else if (e.getSource() == btnAddStudent) {
            InternshipReview review = new InternshipReview(txfField[0].getText(),
                    txfField[1].getText(), txfField[2].getText());
            db.addReview(review);

            for (int i=0; i<txfField.length; i++) {
                txfField[i].setText("");
            }
        }
    }

    /**
     * Event handling for any cell being changed in the table.
     */
    @Override
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);

        db.updateReview(row, columnName, data);

    }

}

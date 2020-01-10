package student_management.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import student_management.dto.Student;
import student_management.ui.panel.AbsItemPanel;
import student_management.ui.panel.StudentPanel;

@SuppressWarnings("serial")
public class StudentManagementFrame extends JFrame implements ActionListener {
	public static final int STUDENT_TYPE = 1;
	public static final int DEPARTMENT_TYPE = 2;
	public static final int TITLE_TYPE = 3;
	
	private JPanel contentPane;
	private AbsItemPanel<Student> pCenter;
	private JPanel pSouth;
	private JButton btnAdd;
	private JButton btnCancel;

	public StudentManagementFrame() {
		initialize();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pCenter = new StudentPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		
		pSouth = new JPanel();
		contentPane.add(pSouth, BorderLayout.SOUTH);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pSouth.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pSouth.add(btnCancel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
	}
	protected void btnAddActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, getItem());
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		pCenter.clearTf();
	}
	
	private Student getItem() {
		return pCenter.getItem();
	}
}

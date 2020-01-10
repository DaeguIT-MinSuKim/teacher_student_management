package student_management.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import student_management.dto.Department;
import student_management.dto.Student;
import student_management.dto.Title;
import student_management.ui.panel.AbsItemPanel;
import student_management.ui.panel.DepartmentPanel;
import student_management.ui.panel.StudentPanel;
import student_management.ui.panel.TitlePanel;

@SuppressWarnings("serial")
public class ManagementFrame<T> extends JFrame implements ActionListener {
	public static final int STUDENT_TYPE = 1;
	public static final int DEPARTMENT_TYPE = 2;
	public static final int TITLE_TYPE = 3;
	
	private JPanel contentPane;
	private AbsItemPanel<T> pCenter;
	private JPanel pSouth;
	private JButton btnAdd;
	private JButton btnCancel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//1 : 학생 관리 2 : 학과관리
					ManagementFrame<Student> frame = new ManagementFrame<>(ManagementFrame.STUDENT_TYPE);
					frame.setVisible(true);
					
					ManagementFrame<Department> deptFrame = new ManagementFrame<>(ManagementFrame.DEPARTMENT_TYPE);
					deptFrame.setVisible(true);
					
					ManagementFrame<Title> titleFrame = new ManagementFrame<>(ManagementFrame.TITLE_TYPE);
					titleFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ManagementFrame(int type) {
		initialize(type);
	}
	
	private void initialize(int type) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pCenter = getCenterPanel(type);
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

	@SuppressWarnings("unchecked")
	private AbsItemPanel<T> getCenterPanel(int type) {
		if (type == 1) {
			return (AbsItemPanel<T>) new StudentPanel();
		}
		if (type==2) {
			return (AbsItemPanel<T>) new DepartmentPanel();
		}
		if (type==3) {
			return (AbsItemPanel<T>) new TitlePanel();
		}
		return null;
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
	
	private T getItem() {
		return pCenter.getItem();
	}
}

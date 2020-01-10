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
import student_management.ui.panel.DepartmentPanel;

@SuppressWarnings("serial")
public class DepartmentManagementFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private DepartmentPanel pCenter;
	private JPanel pSouth;
	private JButton btnAdd;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentManagementFrame frame = new DepartmentManagementFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DepartmentManagementFrame() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pCenter = new DepartmentPanel();
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
		Department newDept = pCenter.getDepartment();
		JOptionPane.showMessageDialog(null, newDept);
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		pCenter.clearTf();
	}
}

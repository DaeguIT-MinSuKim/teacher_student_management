package student_management.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ManagementFrame extends JFrame {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//1 : 학생 관리 2 : 학과관리
					StudentManagementFrame frame = new StudentManagementFrame();
					frame.setVisible(true);
					
					DepartmentManagementFrame deptFrame = new DepartmentManagementFrame();
					deptFrame.setVisible(true);
					
					TitleManagementFrame titleFrame = new TitleManagementFrame();
					titleFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

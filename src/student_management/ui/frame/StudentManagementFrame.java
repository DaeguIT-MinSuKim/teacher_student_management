package student_management.ui.frame;

import student_management.dto.Student;
import student_management.ui.panel.AbsItemPanel;
import student_management.ui.panel.StudentPanel;

@SuppressWarnings("serial")
public class StudentManagementFrame extends AbsManagementFrame<Student> {
	private StudentPanel studentPanel;
	@Override
	protected AbsItemPanel<Student> createItemPanel() {
		studentPanel = new StudentPanel();
		return studentPanel;
	}

	@Override
	protected Student getItem() {
		return studentPanel.getItem();
	}
	
}

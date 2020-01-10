package student_management.ui.frame;

import student_management.dto.Title;
import student_management.ui.panel.AbsItemPanel;
import student_management.ui.panel.TitlePanel;

@SuppressWarnings("serial")
public class TitleManagementFrame extends AbsManagementFrame<Title> {
	private TitlePanel titlePanel;
	
	@Override
	protected AbsItemPanel<Title> createItemPanel() {
		titlePanel = new TitlePanel();
		return titlePanel;
	}

	@Override
	protected Title getItem() {
		return titlePanel.getItem();
	}
	
}

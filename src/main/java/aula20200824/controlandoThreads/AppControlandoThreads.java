package aula20200824.controlandoThreads;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class AppControlandoThreads extends JDialog {
	private JPanel jPanel = new JPanel();

	public static void main(String[] args) {
		AppControlandoThreads dialog = new AppControlandoThreads();
		dialog.setSize(300, 250);
		dialog.setVisible(true);
	}

	public AppControlandoThreads() {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JButton btnAddPanel = new JButton("Mew Thread Panel");
		btnAddPanel.addActionListener(event -> addPanel());
		BoxLayout boxLayout = new BoxLayout(jPanel, BoxLayout.PAGE_AXIS);
		jPanel.setLayout(boxLayout);
		jPanel.add(btnAddPanel);
		this.add(jPanel);
	}

	private void addPanel() {
		ThreadControlPanel panel = new ThreadControlPanel();
		this.jPanel.add(panel);
		this.revalidate();
	}

}

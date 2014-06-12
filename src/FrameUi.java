import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;


public class FrameUi implements ActionListener{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameUi window = new FrameUi();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameUi() {
		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialize();
		}
		

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u8D85\u5E02\u7BA1\u7406\u7CFB\u7EDF");
		frame.setBounds(100, 100, 789, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u9009\u62E9\u529F\u80FD");
		menu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		menuBar.add(menu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5E93\u5B58\u4FE1\u606F");
		menu.add(mntmNewMenuItem);
		
		JMenuItem menuItem = new JMenuItem("\u51FA\u5E93\u4FE1\u606F");
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5165\u5E93\u4FE1\u606F");
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u5546\u54C1\u4FE1\u606F");
		menu.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u9500\u552E\u4FE1\u606F");
		menu.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u7528\u6237\u4FE1\u606F");
		menu.add(menuItem_4);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class MainFrame extends JFrame implements ActionListener{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox1,comboBox;
	private JButton button,button_1;
	PreparedStatement pree;
	private DataBaseUtil dbu;
	private JTextField textField_3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public MainFrame() {
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
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("商品销售信息");
		frame.setTitle("\u9500\u552E\u4FE1\u606F");
		frame.setBounds(800, 400, 222, 290);  //后两个分别是宽和高,前两个是距离左面X像素，距离上面X像素
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		label.setBounds(23, 75, 79, 21);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(99, 75, 78, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(99, 106, 78, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("\u552E\u51FA\u60C5\u51B5\uFF1A");
		label_1.setBounds(23, 106, 79, 21);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u552E\u4EF7\uFF1A");
		label_2.setBounds(23, 137, 79, 21);
		frame.getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(99, 137, 78, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		button = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		button.setBounds(10, 177, 92, 23);
		frame.getContentPane().add(button);
		
		button_1 = new JButton("\u5220\u9664");
		button_1.setEnabled(false);
		button_1.setBounds(115, 177, 62, 23);
		frame.getContentPane().add(button_1);
		
		 comboBox = new JComboBox(new Object[]{});
		comboBox.setBounds(108, 10, 84, 21);
		frame.getContentPane().add(comboBox);
		additem();
	}
	public void additem(){
		dbu=new DataBaseUtil();
		dbu.getConnectionAndStatement();
		ResultSet rs=dbu.executeQuery("SELECT * from 销售信息 where id in (select min(id)from 销售信息 group by 商品类型)");
		try {
			rs.last();
			int i;
			i = rs.getRow();
			rs.beforeFirst();
			String type[]=new String[i];
			int m=0;
			while(rs.next()){
				type[m]=rs.getString(2);
				m++;
			}
			comboBox1 = new JComboBox(type);
			 comboBox1.addActionListener(this);
			comboBox1.setBounds(10, 10, 84, 21);
			frame.getContentPane().add(comboBox1);
			
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(99, 44, 78, 21);
			frame.getContentPane().add(textField_3);
			
			JLabel label = new JLabel("\u5546\u54C1\u7C7B\u578B\uFF1A");
			label.setBounds(23, 44, 79, 21);
			frame.getContentPane().add(label);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setcombobox();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==comboBox1)
			setcombobox();
	}

public void setcombobox(){
	comboBox.removeAllItems();
	String typename=comboBox1.getSelectedItem().toString();
	try {
		pree=DataBaseUtil.getCon().prepareStatement("select 商品名称 from 销售信息 where 商品类型=?");
		pree.setString(1, typename);
		ResultSet rs =pree.executeQuery();
		rs.last();
		int i;
		i = rs.getRow();
		rs.beforeFirst();
		String type[]=new String[i];
		int m=0;
		while(rs.next()){
			type[m]=rs.getString(1);
			m++;
		}
		//comboBox=new JComboBox(type);
		for(i=0;i<m;i++){
			comboBox.addItem(type[i]);
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
}
}
	


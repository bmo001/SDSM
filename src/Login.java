import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login implements ActionListener{

	private JFrame frame;
	private JTextField textField;
	private JLabel label_1;
	private JPasswordField passwordField;
	DataBaseUtil dbu;
	PreparedStatement preparedStatement;
	private JButton button,button_1;
	MainFrame mainFrame;
	Register reg;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
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
		frame.setTitle("\u767B\u9646");
		frame.setBounds(750, 400, 412, 268);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8D26\u53F7\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(67, 37, 87, 32);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(148, 39, 179, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		label_1 = new JLabel("\u8BF7\u8F93\u5165\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(67, 93, 87, 32);
		frame.getContentPane().add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(148, 95, 179, 29);
		frame.getContentPane().add(passwordField);
		
		button = new JButton("\u767B\u9646");
		button.addActionListener(this);
		button.setBounds(67, 146, 116, 39);
		frame.getContentPane().add(button);
		
		button_1 = new JButton("\u6CE8\u518C");
		button_1.addActionListener(this);
		button_1.setBounds(211, 146, 116, 39);
		frame.getContentPane().add(button_1);
		condb();
	}
	public void condb(){
		dbu=new DataBaseUtil();
		dbu.getConnectionAndStatement();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource()==button) {
			if(yzmm()==1)
				mainFrame=new MainFrame();
		}
		if(arg0.getSource()==button_1)
			reg=new Register();
	}
	public int yzmm(){
		try {
			preparedStatement=dbu.getCon().prepareStatement("SELECT * from 用户信息 ");
			ResultSet rs=preparedStatement.executeQuery();
			String name = null,type=null;
			String key;
			String inputkey=new String(passwordField.getPassword());
			int k=0;
			while(rs.next()){
				name=rs.getString(1);
				key=rs.getString(2);
				type=rs.getString(4);
				if(name.equals(textField.getText().toString())){
					if(key.equals(inputkey)){
						k=1;
						break;
					}
					else k=0;
				}
				else k=0;
				}
			if (k==1) {
				System.out.print("OK");
				JOptionPane.showMessageDialog(frame.getContentPane(),
					       "欢迎登陆！"+type+"："+name, "登陆成功！", JOptionPane.INFORMATION_MESSAGE);
				return 1;
			}
			else {
				System.out.print("error");
				JOptionPane.showMessageDialog(frame.getContentPane(),
					       "账号或密码错误！", "信息错误", JOptionPane.ERROR_MESSAGE);
				return 0;
			}
	}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return 0;
		
	}
}

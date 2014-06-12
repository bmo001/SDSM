import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddItem {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private SQLQuery sqlQuery;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItem window = new AddItem();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddItem() {
		sqlQuery=new SQLQuery();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u6DFB\u52A0\u5546\u54C1");
		frame.setBounds(800, 400, 324, 289);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(149, 45, 107, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u7C7B\u578B");
		lblNewLabel.setBounds(55, 45, 54, 21);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(149, 76, 107, 21);
		frame.getContentPane().add(textField_1);
		
		JLabel label = new JLabel("\u5546\u54C1\u540D\u79F0");
		label.setBounds(55, 76, 54, 21);
		frame.getContentPane().add(label);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(149, 107, 107, 21);
		frame.getContentPane().add(textField_2);
		
		JLabel label_1 = new JLabel("\u9500\u552E\u6570\u91CF");
		label_1.setBounds(55, 107, 54, 21);
		frame.getContentPane().add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(149, 138, 107, 21);
		frame.getContentPane().add(textField_3);
		
		JLabel label_2 = new JLabel("\u5546\u54C1\u4EF7\u683C");
		label_2.setBounds(55, 138, 54, 21);
		frame.getContentPane().add(label_2);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String 商品类型,商品名称,销售数量,商品价格;
				商品类型=textField.getText().toString();
				商品名称=textField_1.getText().toString();
				销售数量=textField_2.getText().toString();
				商品价格=textField_3.getText().toString();
				sqlQuery.executeUpdate("insert into 销售信息(商品类型,商品名称,销售数量,商品价格) values('"+商品类型+"','"+商品名称+"','"+销售数量+"','"+商品价格+"')");
			}
		});
		btnNewButton.setBounds(55, 198, 201, 31);
		frame.getContentPane().add(btnNewButton);
	}
}

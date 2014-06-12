import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class MainFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = (long) 1.0;
	private JFrame frame;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JComboBox comboBox1,comboBox;
	private JButton button,delete;
	private SQLQuery sqlQuery;
	private JTextField textField_1;
	private String[] type;
	private int i;
	private JButton button_2;
	private String nameString;
	AddItem addItem;

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
		sqlQuery=new SQLQuery();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("��Ʒ������Ϣ");
		frame.setTitle("\u9500\u552E\u4FE1\u606F");
		frame.setBounds(800, 400, 298, 290);  //�������ֱ��ǿ�͸�,ǰ�����Ǿ�������X���أ���������X����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		label.setBounds(54, 84, 79, 21);
		frame.getContentPane().add(label);
		
		textField_2 = new JTextField();
		textField_2.setBounds(130, 84, 93, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(130, 115, 93, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_1 = new JLabel("\u9500\u552E\u6570\u91CF\uFF1A");
		label_1.setBounds(54, 115, 79, 21);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u552E\u4EF7\uFF1A");
		label_2.setBounds(54, 146, 79, 21);
		frame.getContentPane().add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(130, 146, 93, 21);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		
		button = new JButton("\u786E\u8BA4\u66F4\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sqlQuery.executeUpdate("UPDATE ������Ϣ SET ��Ʒ���� ='"+textField_1.getText().toString()+"',��Ʒ����='"+textField_2.getText().toString()+"',��������='"+textField_3.getText().toString()+"',��Ʒ�۸�='"+textField_4.getText().toString()+"'where ��Ʒ����='"+nameString+"'");
			}
		});
		button.setBounds(10, 189, 92, 23);
		frame.getContentPane().add(button);
		
		delete = new JButton("\u5220\u9664");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sqlQuery.executeUpdate("delete from ������Ϣ where ��Ʒ����='"+comboBox.getSelectedItem().toString()+"'");
				setcombobox();
			}
		});
		delete.setEnabled(false);
		delete.setBounds(115, 189, 62, 23);
		frame.getContentPane().add(delete);
		
		 comboBox = new JComboBox(new Object[]{});
		comboBox.setBounds(108, 10, 84, 21);
		frame.getContentPane().add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(130, 53, 93, 21);
		frame.getContentPane().add(textField_1);
		
		JLabel label1 = new JLabel("\u5546\u54C1\u7C7B\u578B\uFF1A");
		label1.setBounds(54, 53, 79, 21);
		frame.getContentPane().add(label1);
		
		JButton btnNewButton = new JButton("\u8BFB\u53D6");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				delete.setEnabled(true);
				String itemname=comboBox.getSelectedItem().toString();
				sqlQuery.getQueryReturnY("SELECT * from ������Ϣ where ��Ʒ����='"+itemname+"'", 2,3,4,5);
				String[] allinfo=new String[sqlQuery.getY()];
				allinfo=sqlQuery.getData()[0];
				textField_1.setText(allinfo[0]);
				textField_2.setText(allinfo[1]);
				nameString=allinfo[1];
				textField_3.setText(allinfo[2]);
				textField_4.setText(allinfo[3]);
			}
		});
		btnNewButton.setBounds(203, 9, 69, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		
		button_2 = new JButton("\u6DFB\u52A0");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addItem=new AddItem();
			}
		});
		button_2.setBounds(203, 189, 69, 23);
		frame.getContentPane().add(button_2);
		
		
		additem();
	}
	public void additem(){
		int i=sqlQuery.getQueryReturnY("SELECT * from ������Ϣ where id in (select min(id)from ������Ϣ group by ��Ʒ����)", 2);
			type=new String[i];
			type=sqlQuery.getData()[0];
			comboBox1 = new JComboBox(type);
			 comboBox1.addActionListener(this);
			comboBox1.setBounds(10, 10, 84, 21);
			frame.getContentPane().add(comboBox1);
			setcombobox();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==comboBox1)
			{setcombobox();
			return;
			}
	}

public void setcombobox(){
	int num;
	comboBox.removeAllItems();
	String typename=comboBox1.getSelectedItem().toString();
	num=sqlQuery.getQueryReturnY("SELECT ��Ʒ���� FROM ������Ϣ WHERE ��Ʒ����='"+typename+"'",1);
	type=new String[num];
	type=sqlQuery.getData()[0];
	for(int i=0;i<num;i++){
		comboBox.addItem(type[i]);
	}
}
public void showInfo(){
	
//	for(i=0;i<num;i++)
//	{
//		jTextFields[i].setText(type[i].toString());
//	}
}
}


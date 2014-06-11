
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
 
public class Register extends JFrame implements ActionListener{
 JLabel lInform,lLogin,lKey,lage;
 JButton bEnter,bCancel;
 JTextField textLogin,textage;
 JPasswordField textKey;
 JComboBox type;
 ButtonGroup bg;
 JRadioButton boy,girl;
 PreparedStatement preparedStatement;
 DataBaseUtil dbu;
 public Register(){
  	super("�û�ע��");
  	setLayout(null);
  	lInform=new JLabel("�������û���Ϣ");
  	lLogin=new JLabel("�ʺ�");
  	lKey=new JLabel("����");
  	textLogin=new JTextField("",8);
  	textKey=new JPasswordField("",8);
  	lage=new JLabel("����");
  	textage=new JTextField("",2);
  	bEnter=new JButton("ȷ��");
  	bEnter.addActionListener(this);
  	bCancel=new JButton("�˳�");
  	bCancel.addActionListener(this);
  	
  	
  	
  	type=new JComboBox();
  	type.addItem("����Ա");
  	type.addItem("�û�");
  	
   	
  	
  	bg=new ButtonGroup();
  	boy=new JRadioButton("��");
  	
  	girl=new JRadioButton("Ů");
  	girl.addActionListener(this);
  	
  	
  	bg.add(boy);
  	bg.add(girl);
  	
  	lInform.setBounds(20, 20,150, 30);  //X����㣬Y�����,���,�߶�
  	lLogin.setBounds(10, 60, 40, 30);
  	textLogin.setBounds(60,60,80,30);
  	lKey.setBounds(10, 100, 40, 30);
  	textKey.setBounds(60,100,80, 30);
  	lage.setBounds(10,140,40,30);
  	textage.setBounds(60,140,50,30);
  	boy.setBounds(10, 180, 40, 30);
  	girl.setBounds(60, 180,40, 30);
  	 type.setBounds(10, 220, 80, 30);
  	 bEnter.setBounds(10, 260, 60, 30);
  	 
  	bCancel.setBounds(90, 260,60, 30);
  	
  	
  	this.add(lInform);
  	this.add(lLogin);
  	this.add(textLogin);
  	this.add(lKey);
  	this.add(textKey);
  	this.add(lage);
  	this.add(textage);
  	this.add(type);
  	
  	this.add(boy);
  	this.add(girl);
  	
  	
  	
  	this.add(bEnter);
  	this.add(bCancel);
  	
  	
  	
    this.setSize(250,400);
    this.setLocation(800, 400);
    this.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e){
	 dbu=new DataBaseUtil();
	 dbu.getConnectionAndStatement();
  	if(e.getSource()==bEnter){
  		
  		String URL;
        Connection con;
        Statement sql; 
        ResultSet rs;
        String sqlAddUser;
      
        
  		String key=new String(textKey.getPassword());
  	  	 String login=textLogin.getText();
  	  	 String sex;
  	  	 String typeofuser;
  	  	 String age=textage.getText();
  	  	
  	  	 
  	  	 if(boy.isSelected()) sex="��";
  	  	 else sex="Ů";
  	  	 typeofuser=type.getSelectedItem().toString();
  	  	 
  	  	
       try { 
             preparedStatement=dbu.getCon().prepareStatement("insert into �û���Ϣ (�û���,����,�Ա�,����,����) values(?,?,?,?,?)");
             preparedStatement.setString(1, login);
     	   	 preparedStatement.setString(2, key);
     	   	 preparedStatement.setString(3, sex);
     	   	 preparedStatement.setString(4, typeofuser);
     	   	 preparedStatement.setString(5, age);
     	     System.out.println("Connect Succeed!");
            int number=preparedStatement.executeUpdate();
            if(number>0) System.out.println("��ӳɹ�");
            
             
  	} 
       catch(SQLException e1) { 
           System.out.println(e1);
        }
     	     
   if(e.getSource()==bCancel){
  	  System.exit(0);
  	}  
  	
  	
  }
  }
  public static void main(String args[]){
    new Register();
  }



}

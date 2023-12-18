package nkz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JToolBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class nkz {

	private JFrame frame;
	private static JTable tableData;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nkz window = new nkz();
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
	public nkz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 845, 431);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("NKZ DevOps");
		
		// Menu Bar ..................
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu setting = new JMenu("Settings");
		menuBar.add(setting);
		
		JMenu about = new JMenu("About");
		menuBar.add(about);
		
		JMenu refresh = new JMenu("Refresh");
		menuBar.add(refresh);
		
		JMenu register = new JMenu("Register");
		menuBar.add(register);
		
		JMenu help = new JMenu("Help");
		menuBar.add(help);
		
		JMenuItem help1 = new JMenuItem("Help1");
		help.add(help1);
		frame.getContentPane().setLayout(null);
		
		// Gui Table ....................
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(164, 0, 665, 276);
		frame.getContentPane().add(scrollPane);
		
		tableData = new JTable();
		scrollPane.setViewportView(tableData);
		tableData.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		
		// Exit Button.......... 
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(699, 316, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		// Filter Buttons ............
		
		textField = new JTextField();
		textField.setBounds(217, 317, 117, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("From Date");
		lblNewLabel.setBounds(150, 316, 70, 23);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(392, 317, 117, 21);
		frame.getContentPane().add(textField_1);
		
		JLabel lblToDate = new JLabel("To Date");
		lblToDate.setBounds(344, 316, 62, 23);
		frame.getContentPane().add(lblToDate);
		
		JButton filter = new JButton("Filter");
		filter.setBounds(519, 316, 89, 23);
		frame.getContentPane().add(filter);
		
		
		//MsSql server button ..............,,,
		
		JButton mysqlButton = new JButton("MsSQL Server");
		mysqlButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				try  {
			     	Class.forName("oracle.jdbc.driver.OracleDriver");
			     	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "amjad");

			     	
			         java.sql.Statement smt =  con.createStatement();
			         ResultSet rs =smt.executeQuery("select SESSION_KEY, INPUT_TYPE, STATUS, START_TIME, END_TIME from V$RMAN_BACKUP_JOB_DETAILS");
			         ResultSetMetaData rsmd =rs.getMetaData();
			         DefaultTableModel model=(DefaultTableModel) tableData.getModel();
			         model.setRowCount(0);
			         
			         int cols=rsmd.getColumnCount();
			         String[] colName=new String[cols];
			         for(int i=0;i<cols;i++)
			        	 colName[i]=rsmd.getColumnName(i+1);
			         model.setColumnIdentifiers(colName);
			         
			         String SLNO,NAME, STATUS, START, END;
			         while(rs.next()) {
			        	 
			        	 SLNO=rs.getString(1);
			        	 NAME=rs.getString(2);
			        	 STATUS=rs.getString(3);
			        	 START=rs.getString(4);
			        	 END=rs.getString(5);
			        	 String[] row= {SLNO,NAME,STATUS,START,END};
			        	 model.addRow(row);
			        	 
			         }
			         smt.close();
			         con.close();
			         
			          
				 }
				

				catch (SQLException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mysqlButton.setBounds(10, 11, 144, 47);
		frame.getContentPane().add(mysqlButton);
		
		
		//Oracle button.....................// 
		
		JButton btnOracle = new JButton("Oracle");
		
		btnOracle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try  {
			     	Class.forName("oracle.jdbc.driver.OracleDriver");
			     	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "amjad");

			     	
			         java.sql.Statement smt =  con.createStatement();
			         ResultSet rs =smt.executeQuery("select SESSION_KEY, INPUT_TYPE, STATUS, START_TIME, END_TIME from V$RMAN_BACKUP_JOB_DETAILS");
			         ResultSetMetaData rsmd =rs.getMetaData();
			         DefaultTableModel model=(DefaultTableModel) tableData.getModel();
			         model.setRowCount(0);
			         
			         int cols=rsmd.getColumnCount();
			         String[] colName=new String[cols];
			         for(int i=0;i<cols;i++)
			        	 colName[i]=rsmd.getColumnName(i+1);
			         model.setColumnIdentifiers(colName);
			         
			         String SLNO,NAME, STATUS, START, END;
			         while(rs.next()) {
			        	 
			        	 SLNO=rs.getString(1);
			        	 NAME=rs.getString(2);
			        	 STATUS=rs.getString(3);
			        	 START=rs.getString(4);
			        	 END=rs.getString(5);
			        	 String[] row= {SLNO,NAME,STATUS,START,END};
			        	 model.addRow(row);
			        	 
			         }
			         smt.close();
			         con.close();
			         
			       
				 }
				

				catch (SQLException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnOracle.setBounds(10, 69, 144, 47);
		frame.getContentPane().add(btnOracle);
		
		//MySQL ........Button...........
		
		JButton btnMysqlCommnity = new JButton("MySQL");
		
		btnMysqlCommnity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try  {
			     	Class.forName("oracle.jdbc.driver.OracleDriver");
			     	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "amjad");

			     	
			         java.sql.Statement smt =  con.createStatement();
			         ResultSet rs =smt.executeQuery("select * from V$BACKUP");
			         ResultSetMetaData rsmd =rs.getMetaData();
			         DefaultTableModel model=(DefaultTableModel) tableData.getModel();
			         model.setRowCount(0);
			         
			         int cols=rsmd.getColumnCount();
			         String[] colName=new String[cols];
			         for(int i=0;i<cols;i++)
			        	 colName[i]=rsmd.getColumnName(i+1);
			         model.setColumnIdentifiers(colName);
			         
			         String SLNO,NAME;
			         while(rs.next()) {
			        	 
			        	 SLNO=rs.getString(1);
			        	 NAME=rs.getString(2);
			        	 String[] row= {SLNO,NAME};
			        	 model.addRow(row);
			        	 
			         }
			         smt.close();
			         con.close();
			       
				 }
				

				catch (SQLException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnMysqlCommnity.setBounds(10, 126, 144, 47);
		frame.getContentPane().add(btnMysqlCommnity);
		
		
		//MySQL Community Button........
		
		JButton mysqlButton_3 = new JButton("MySQL Community");
		
		mysqlButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try  {
			     	Class.forName("oracle.jdbc.driver.OracleDriver");
			     	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "amjad");

			     	
			         java.sql.Statement smt =  con.createStatement();
			         ResultSet rs =smt.executeQuery("select * from V$BACKUP");
			         ResultSetMetaData rsmd =rs.getMetaData();
			         DefaultTableModel model=(DefaultTableModel) tableData.getModel();
			         model.setRowCount(0);
			         
			         int cols=rsmd.getColumnCount();
			         String[] colName=new String[cols];
			         for(int i=0;i<cols;i++)
			        	 colName[i]=rsmd.getColumnName(i+1);
			         model.setColumnIdentifiers(colName);
			         
			         String SLNO,NAME;
			         while(rs.next()) {
			        	 
			        	 SLNO=rs.getString(1);
			        	 NAME=rs.getString(2);
			        	 String[] row= {SLNO,NAME};
			        	 model.addRow(row);
			        	 
			         }
			         smt.close();
			         con.close();
			         
			  }
			
				catch (SQLException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		mysqlButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mysqlButton_3.setBounds(10, 184, 144, 47);
		frame.getContentPane().add(mysqlButton_3);
		
		// Postgre Button .....................................
		
		JButton mysqlButton_4 = new JButton("Postgre");
		
		mysqlButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try  {
			     	Class.forName("oracle.jdbc.driver.OracleDriver");
			     	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "amjad");

			     	
			         java.sql.Statement smt =  con.createStatement();
			         ResultSet rs =smt.executeQuery("select * from V$BACKUP");
			         ResultSetMetaData rsmd =rs.getMetaData();
			         DefaultTableModel model=(DefaultTableModel) tableData.getModel();
			         model.setRowCount(0);
			         
			         int cols=rsmd.getColumnCount();
			         String[] colName=new String[cols];
			         for(int i=0;i<cols;i++)
			        	 colName[i]=rsmd.getColumnName(i+1);
			         model.setColumnIdentifiers(colName);
			         
			         String SLNO,NAME;
			         while(rs.next()) {
			        	 
			        	 SLNO=rs.getString(1);
			        	 NAME=rs.getString(2);
			        	 String[] row= {SLNO,NAME};
			        	 model.addRow(row);
			        	 
			         }
			         smt.close();
			         con.close();
			         
			         
			         
			         
			         
				 }
				

				catch (SQLException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		mysqlButton_4.setBounds(10, 242, 144, 47);
		frame.getContentPane().add(mysqlButton_4);
	}
}

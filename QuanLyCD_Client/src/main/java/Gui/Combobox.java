//package Gui;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JComboBox;
//import java.awt.BorderLayout;
//import javax.swing.DefaultComboBoxModel;
//import java.awt.Font;
//import javax.swing.JLabel;
//import java.awt.event.ActionListener;
//import java.rmi.Naming;
//import java.awt.event.ActionEvent;
//import javax.swing.JButton;
//import javax.swing.JTextArea;
//
//import facade.MayTinh_Interface;
//
//public class Combobox {
//
//	private JFrame frame;
//	private JComboBox comboBox;
//	private JLabel lblCombo;
//	private JTextArea txtA;
//	private JTextArea txtB;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Combobox window = new Combobox();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public Combobox() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 747, 535);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//		
//		 comboBox = new JComboBox();
//		
//		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 19));
//		comboBox.setModel(new DefaultComboBoxModel(new String[] {"c\u1ED9ng", "tr\u1EEB", "nh\u00E2n", "chia"}));
//		comboBox.setBounds(0, 0, 193, 496);
//		frame.getContentPane().add(comboBox);
//		
//		 lblCombo = new JLabel("");
//		lblCombo.setBounds(403, 202, 206, 65);
//		frame.getContentPane().add(lblCombo);
//		
//		JButton btnNewButton = new JButton("Check");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				int ketqua,b,a;
//				SecurityManager securityManager = System.getSecurityManager();
//				
//				if(securityManager ==null) {
//					System.setProperty("java.security.policy", "policy/policy.policy");
//					System.setSecurityManager(new SecurityManager());
//				}
//				
//				try {
//					MayTinh_Interface maytinhIMPL=(MayTinh_Interface) Naming.lookup("rmi://192.168.1.31:1098/maytinhIMPL");
//					
//				
//					 a=Integer.parseInt(txtA.getText());
//					 b=Integer.parseInt(txtB.getText());
//					int c=comboBox.getSelectedIndex();
////					int c=COMBOBOX.getSelectedIndex();
//					ketqua=maytinhIMPL.PhepCong(a, b, c);
//					lblCombo.setText("Kết quả là :"+ketqua);
//					
////					textArea.setText(String.valueOf(c));
//					
//					
//
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//				
//				
//			}
//		});
//		btnNewButton.setBounds(388, 324, 221, 65);
//		frame.getContentPane().add(btnNewButton);
//		
//		 txtA = new JTextArea();
//		txtA.setBounds(403, 27, 172, 44);
//		frame.getContentPane().add(txtA);
//		
//		 txtB = new JTextArea();
//		txtB.setBounds(403, 106, 172, 44);
//		frame.getContentPane().add(txtB);
//	}
//}

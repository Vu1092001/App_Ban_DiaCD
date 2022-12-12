//package Gui;
//
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//import javax.swing.JPanel;
//import javax.swing.border.TitledBorder;
//
//import facade.MayTinh_Interface;
//
//import java.awt.Color;
//import javax.swing.border.EtchedBorder;
//import java.awt.Font;
//import javax.swing.JTextArea;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.DefaultComboBoxModel;
//import java.awt.event.ActionListener;
//import java.rmi.Naming;
//import java.rmi.registry.LocateRegistry;
//import java.rmi.registry.Registry;
//import java.awt.event.ActionEvent;
//
//public class Test extends JFrame {
//	private JTextField txtA;
//	private JTextField txtB;
//	private JComboBox COMBOBOX;
//	private JTextArea textArea;
//	
//	public Test() {
//		
//		getContentPane().setLayout(null);
//		
//		JPanel panel_Input = new JPanel();
//		panel_Input.setFont(new Font("Tahoma", Font.BOLD, 23));
//		panel_Input.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(160, 160, 160)), "Client Input", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(255, 0, 0)));
//		panel_Input.setBounds(10, 38, 391, 406);
//		getContentPane().add(panel_Input);
//		panel_Input.setLayout(null);
//		
//		txtA = new JTextField();
//		txtA.setBounds(10, 76, 188, 46);
//		panel_Input.add(txtA);
//		txtA.setColumns(10);
//		
//		txtB = new JTextField();
//		txtB.setColumns(10);
//		txtB.setBounds(10, 161, 188, 52);
//		panel_Input.add(txtB);
//		
//		JButton btnNewButton = new JButton("T\u00EDnh");
//	
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
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
////					a=Integer.parseInt(txtA.getText());
////					b=Integer.parseInt(txtB.getText());
////					int c=COMBOBOX.getSelectedIndex();
//					ketqua=maytinhIMPL.PhepCong(2, 2, 4);
////					
//					textArea.setText( "\n Kết quả:"+ketqua);
////					textArea.setText(String.valueOf(c));
//					
//					
//
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
//		});
//		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
//		btnNewButton.setBounds(240, 161, 141, 62);
//		panel_Input.add(btnNewButton);
//		
//		JComboBox COMBOBOX = new JComboBox();
//		COMBOBOX.setFont(new Font("Tahoma", Font.BOLD, 24));
//		COMBOBOX.setModel(new DefaultComboBoxModel(new String[] {"+", "x", "/"}));
//		COMBOBOX.setSelectedIndex(0);
//		COMBOBOX.setBounds(248, 65, 133, 62);
//		panel_Input.add(COMBOBOX);
//		
//		JLabel lblNewLabel = new JLabel("Nh\u1EADp a");
//		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		lblNewLabel.setBounds(10, 49, 72, 26);
//		panel_Input.add(lblNewLabel);
//		
//		JLabel lblNhpB = new JLabel("Nh\u1EADp b");
//		lblNhpB.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		lblNhpB.setBounds(10, 135, 72, 26);
//		panel_Input.add(lblNhpB);
//		
//		JPanel panel_outPut = new JPanel();
//		panel_outPut.setBorder(new TitledBorder(null, "K\u1EBFt qu\u1EA3 Server tr\u1EA3 v\u1EC1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
//		panel_outPut.setBounds(411, 48, 473, 394);
//		getContentPane().add(panel_outPut);
//		panel_outPut.setLayout(null);
//		
//		textArea = new JTextArea();
//		textArea.setEditable(false);
//		textArea.setBounds(32, 35, 431, 324);
//		panel_outPut.add(textArea);
//		setSize(900, 600);
//		setLocationRelativeTo(null);
//	
//		
//		
//		
//		
//		
//	}
//	public static void main(String[] args) {
//		new Test().setVisible(true);
//		
//		
//	}
//}

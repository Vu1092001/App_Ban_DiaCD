package component;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import event.EventMenuSelected;
import form.FrmDiaCD;
import form.FrmGioiThieu1;
import form.FrmNhanVien;
import form.FrmPhieuMuon;
import form.FrmPhieuTra;
import form.FrmThanhVien;
import form.FrmThongKe;
import model.ModelMenu;
import net.miginfocom.swing.MigLayout;

public class Main_QuanLy extends javax.swing.JFrame {

    private Menu menu = new Menu();
    private JPanel main = new JPanel();
    private MigLayout layout;
    private Animator animator;
    private boolean menuShow;

    public Main_QuanLy() {
        initComponents();
        init();
    }

    private void init() {
    	setResizable(false);
//    	setLocationRelativeTo(null);
    	setSize(new Dimension(1600, 875));
        layout = new MigLayout("fill", "0[]0[]0", "0[fill]0");
        body.setLayout(layout);
        main.setOpaque(false);
        main.setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        menu.addEventMenu(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
            }
        });
        //Event Selected Index Item
        menu.setEvent(new EventMenuSelected() {
			
			@Override
			public void selected(int index) throws RemoteException {
//				System.out.println("Selected index "+index);
				try {
					if(index==0) {
						HienThiJpanel(new FrmGioiThieu1());
					}
					else if(index==1) {
						HienThiJpanel(new FrmNhanVien());
						
}
					else if(index==2) {
						HienThiJpanel(new FrmThanhVien());
						
}
					else if(index==3) {
						HienThiJpanel(new FrmPhieuMuon());
						
}
					else if(index==4) {
						HienThiJpanel(new FrmPhieuTra());
						
}
					else if(index==5) {
						HienThiJpanel(new FrmDiaCD());
						
}
					else if(index==6) {
						HienThiJpanel(new FrmThongKe());
				
}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
							
			}
		});
        //
        menu.addEventDangXuat(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new GuiFormDangNhap().setVisible(true);
				dispose();
				
			}
		});
        menu.addMenu(new ModelMenu("Giới Thiệu", new ImageIcon(getClass().getResource("/icon_trangchu/icons8_home_32px.png"))));
        menu.addMenu(new ModelMenu("Quản lý nhân viên", new ImageIcon(getClass().getResource("/icon_trangchu/icons8_profile_100px.png"))));
        menu.addMenu(new ModelMenu("Quản lý thành viên", new ImageIcon(getClass().getResource("/icon_trangchu/icons8_team_30px.png"))));
        menu.addMenu(new ModelMenu("Quản lý phiếu mượn", new ImageIcon(getClass().getResource("/icon_trangchu/icons8_purchase_order_32px.png"))));
        menu.addMenu(new ModelMenu("Quản lý phiếu trả", new ImageIcon(getClass().getResource("/icon_trangchu/icons8_remittance_slip_48px.png"))));
        menu.addMenu(new ModelMenu("Quản lý CD", new ImageIcon(getClass().getResource("/icon_trangchu/icons8_software_48px.png"))));
        menu.addMenu(new ModelMenu("Thống kê ", new ImageIcon(getClass().getResource("/icon_trangchu/icons8_statistics_40px.png"))));
       
        body.add(menu, "w 50!");
        body.add(main, "w 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menuShow) {
                    width = 50+ (150 * (1f - fraction));//ấn để Menu bung vô lại
                    menu.setAlpha(1f -fraction);
                } else {
                    width = 50 + (150 * fraction);//chiều rộng menu bung ra
                    menu.setAlpha(fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!");
                body.revalidate();
            }

            @Override
            public void end() {
                menuShow = !menuShow;
            }
        };
        //hiệu ứng menu bung
        animator = new Animator(600, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
       
    }
    private void HienThiJpanel(Component com) {
		main.removeAll();
		main.add(com);
		main.repaint();
		main.revalidate();
	}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	setTitle("Trang chủ");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Main_QuanLy.class.getResource("/icon_trangchu/icondestop.png")));
        body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        setUndecorated(true);

        body.setBackground(new java.awt.Color(245, 245, 245));//màu của background bên phải menu

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// 

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       

        //Hàm Main
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_QuanLy().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    // End of variables declaration//GEN-END:variables
}

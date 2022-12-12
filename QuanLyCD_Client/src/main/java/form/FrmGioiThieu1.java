package form;
/*
 * Author:Nguyễn Lâm Nhật Minh
 * Date:16/11/2021
 */
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.DropMode;

public class FrmGioiThieu1 extends JPanel {
private MauNenPanel panel;
	
	public FrmGioiThieu1() {
		setPreferredSize(new Dimension(1162, 728));
		setOpaque(false);
		setLayout(null);
		
		panel=new MauNenPanel();
		panel.kStartColor = Color.CYAN;
		panel.setkStartColor(Color.YELLOW);
		panel.kEndColor = Color.CYAN;
		panel.setBounds(0, 0, 1593, 915);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblGiiThiuV = new JLabel("GIỚI THIỆU VỀ THÀNH VIÊN NHÓM");
		lblGiiThiuV.setForeground(new Color(255, 0, 0));
		lblGiiThiuV.setBounds(251, 11, 851, 59);
		lblGiiThiuV.setHorizontalAlignment(SwingConstants.CENTER);
		lblGiiThiuV.setFont(new Font("Arial", Font.BOLD, 42));
		panel.add(lblGiiThiuV);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\game\\word_space_eclipse_2020\\QuanLyLuong_Final\\image\\pngtree-recruitment-looking-for-talent-recruitment-season-banner-image_171916-removebg-preview.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(584, 81, 547, 585);
		panel.add(lblNewLabel);
		
		JLabel lbltrnThnhNamreporter = new JLabel("1)Trần Thành Nam");
		lbltrnThnhNamreporter.setHorizontalAlignment(SwingConstants.CENTER);
		lbltrnThnhNamreporter.setForeground(Color.BLACK);
		lbltrnThnhNamreporter.setFont(new Font("Arial", Font.BOLD, 36));
		lbltrnThnhNamreporter.setBounds(-112, 81, 547, 53);
		panel.add(lbltrnThnhNamreporter);
		
		JLabel lblnguynLmNht = new JLabel("2)Nguyễn Lâm Nhật Minh");
		lblnguynLmNht.setHorizontalAlignment(SwingConstants.CENTER);
		lblnguynLmNht.setForeground(Color.BLACK);
		lblnguynLmNht.setFont(new Font("Arial", Font.BOLD, 36));
		lblnguynLmNht.setBounds(-112, 145, 666, 60);
		panel.add(lblnguynLmNht);
		
		JLabel lblhongHuyVtime = new JLabel("3)Hoàng Huy Vũ");
		lblhongHuyVtime.setHorizontalAlignment(SwingConstants.CENTER);
		lblhongHuyVtime.setForeground(Color.BLACK);
		lblhongHuyVtime.setFont(new Font("Arial", Font.BOLD, 36));
		lblhongHuyVtime.setBounds(-163, 215, 610, 62);
		panel.add(lblhongHuyVtime);
		
		JLabel lblGingVinHng = new JLabel("Giảng viên hướng dẫn : Nguyễn Thị Hoàng Khánh");
		lblGingVinHng.setHorizontalAlignment(SwingConstants.CENTER);
		lblGingVinHng.setForeground(Color.RED);
		lblGingVinHng.setFont(new Font("Arial", Font.BOLD, 36));
		lblGingVinHng.setBounds(115, 317, 963, 65);
		panel.add(lblGingVinHng);
		
		
	}
}

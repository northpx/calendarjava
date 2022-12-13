package PBL4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.*;

public class Client extends JFrame implements ActionListener{
	public static JTextField txtYear;
	public TextArea txtmonth1;
	public TextArea txtmonth2;
	public TextArea txtmonth3;
	public TextArea txtmonth4;
	public TextArea txtmonth5;
	public TextArea txtmonth6;
	public TextArea txtmonth7;
	public TextArea txtmonth8;
	public TextArea txtmonth9;
	public TextArea txtmonth10;
	public TextArea txtmonth11;
	public TextArea txtmonth12;
	public JFrame frame;
	public Socket soc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Client() {
		this.frame = new JFrame("Chuong trinh in lich the ky");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(400, 100, 1000, 600);
		frame.setBackground(Color.DARK_GRAY);
		this.frame.setLayout(null);

		txtYear = new JTextField();
		txtYear.setFont(new Font("Arial", Font.BOLD, 14));
		txtYear.setForeground(new Color(0, 0, 0));
		txtYear.setBounds(634, 10, 160, 30);
		frame.add(txtYear);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(Color.GRAY);
		btnSearch.setForeground(Color.RED);
		btnSearch.setFont(new Font("Arial", Font.BOLD, 14));
		btnSearch.setBounds(815, 9, 126, 30);
		btnSearch.addActionListener(this);
		frame.add(btnSearch);
		
		txtmonth1 = new TextArea("");
		txtmonth1.setBounds(81, 58, 170, 120);
		txtmonth1.setBackground(Color.lightGray);
		txtmonth1.setForeground(Color.BLACK);
        txtmonth1.setFont(new Font("Segoe Script", Font.BOLD, 12));
		frame.add(txtmonth1);
                
        txtmonth2 = new TextArea("");
		txtmonth2.setBounds(342, 58, 170, 120);
		txtmonth2.setBackground(Color.lightGray);
		txtmonth2.setForeground(Color.BLACK);
        txtmonth2.setFont(new Font("Segoe Script", Font.BOLD, 12));
		frame.add(txtmonth2);
                
        txtmonth3 = new TextArea("");
		txtmonth3.setBounds(598, 58, 170, 120);
		txtmonth3.setBackground(Color.lightGray);
		txtmonth3.setForeground(Color.BLACK);
        txtmonth3.setFont(new Font("Segoe Script", Font.BOLD, 12));
		frame.add(txtmonth3);
                
        txtmonth4 = new TextArea("");
		txtmonth4.setBounds(840, 58, 170, 120);
		txtmonth4.setBackground(Color.lightGray);
		txtmonth4.setForeground(Color.BLACK);
        txtmonth4.setFont(new Font("Segoe Script", Font.BOLD, 12));
		frame.add(txtmonth4);
                
        txtmonth5 = new TextArea("");
		txtmonth5.setBounds(81, 222, 170, 120);
		txtmonth5.setBackground(Color.lightGray);
		txtmonth5.setForeground(Color.BLACK);
        txtmonth5.setFont(new Font("Segoe Script", Font.BOLD, 12));
		frame.add(txtmonth5);
                
        txtmonth6 = new TextArea("");
		txtmonth6.setBounds(342, 222, 170, 120);
		txtmonth6.setBackground(Color.lightGray);
		txtmonth6.setForeground(Color.BLACK);
        txtmonth6.setFont(new Font("Segoe Script", Font.BOLD, 12));
		frame.add(txtmonth6);
               
        txtmonth7 = new TextArea("");
		txtmonth7.setBounds(598, 222, 170, 120);
		txtmonth7.setBackground(Color.lightGray);
		txtmonth7.setForeground(Color.BLACK);
        txtmonth7.setFont(new Font("Segoe Script", Font.BOLD, 12));
		frame.add(txtmonth7);
                
        txtmonth8 = new TextArea("");
		txtmonth8.setBounds(840, 222, 170, 120);
		txtmonth8.setBackground(Color.lightGray);
		txtmonth8.setForeground(Color.BLACK);
        txtmonth8.setFont(new Font("Segoe Script", Font.BOLD, 12));
		frame.add(txtmonth8);
                
        txtmonth9 = new TextArea("");
		txtmonth9.setBounds(81, 380, 170, 120);
		txtmonth9.setBackground(Color.lightGray);
		txtmonth9.setForeground(Color.BLACK);
        txtmonth9.setFont(new Font("Segoe Script", Font.BOLD, 12));
		frame.add(txtmonth9);
                
        txtmonth10 = new TextArea("");
		txtmonth10.setBounds(342, 380, 170, 120);
		txtmonth10.setBackground(Color.lightGray);
		txtmonth10.setForeground(Color.BLACK);
        txtmonth10.setFont(new Font("Segoe Script", Font.BOLD, 12));
		frame.add(txtmonth10);
                
        txtmonth11 = new TextArea("");
		txtmonth11.setBounds(598, 380, 170, 120);
		txtmonth11.setBackground(Color.lightGray);
		txtmonth11.setForeground(Color.BLACK);
        txtmonth11.setFont(new Font("Segoe Script", Font.BOLD, 12));
		frame.add(txtmonth11);
                
        txtmonth12 = new TextArea("");
		txtmonth12.setBounds(840, 380, 170, 120);
		txtmonth12.setBackground(Color.lightGray);
		txtmonth12.setForeground(Color.BLACK);
        txtmonth12.setFont(new Font("Segoe Script", Font.BOLD, 12));
		frame.add(txtmonth12);

		JLabel lbYear = new JLabel("Year");
		lbYear.setFont(new Font("Arial", Font.BOLD, 14));
		lbYear.setBounds(575, 10, 84, 30);
		frame.add(lbYear);
		frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			soc = new Socket("localhost", 9999);
			DataInputStream is= new DataInputStream(soc.getInputStream());
			DataOutputStream os= new DataOutputStream(soc.getOutputStream());
			String year = txtYear.getText();
			System.out.print(year);
			os.writeUTF(year);
			os.flush();
			if(txtYear.getText().equals("")) {
				txtmonth1.setText("");
				txtmonth2.setText("");
				txtmonth3.setText("");
				txtmonth4.setText("");
				txtmonth5.setText("");
				txtmonth6.setText("");
				txtmonth7.setText("");
				txtmonth8.setText("");
				txtmonth9.setText("");
				txtmonth10.setText("");
				txtmonth11.setText("");
				txtmonth12.setText("");
			}else {
				//doc du lieu tu server luu vao bien rs
				String rs = is.readUTF();
				
				//cat chuoi rs thanh 12 thang
				String[] arrOfMonth = rs.split("---------------------------\n",13);
				
				//hien thi lich len 12 textarea
				for(String a : arrOfMonth)
					System.out.println(a);
					//gan moi arrOfMonth[i] cho moi txtArea hoac gan thu cong txtArea1.setText(arr[1])
					txtmonth1.setText(arrOfMonth[0]);
					txtmonth2.setText(arrOfMonth[1]);
					txtmonth3.setText(arrOfMonth[2]);
					txtmonth4.setText(arrOfMonth[3]);
					txtmonth5.setText(arrOfMonth[4]);
					txtmonth6.setText(arrOfMonth[5]);
					txtmonth7.setText(arrOfMonth[6]);
					txtmonth8.setText(arrOfMonth[7]);
					txtmonth9.setText(arrOfMonth[8]);
					txtmonth10.setText(arrOfMonth[9]);
					txtmonth11.setText(arrOfMonth[10]);
					txtmonth12.setText(arrOfMonth[11]);
			}
			
		} catch (Exception e1) {
			System.out.print(e1);
		}
	}
}


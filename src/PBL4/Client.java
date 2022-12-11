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
	public JTextArea txtArea;
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

		txtArea = new JTextArea("");
		txtArea.setBounds(40, 50, 900, 500);
		txtArea.setBackground(Color.lightGray);
		txtArea.setForeground(Color.CYAN);
		frame.add(txtArea);

		JLabel lbYear = new JLabel("Year");
		lbYear.setFont(new Font("Arial", Font.BOLD, 14));
		lbYear.setBounds(575, 10, 84, 30);
		frame.add(lbYear);
		frame.setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 1000, 500);
//		JPanel contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		txtYear = new JTextField();
//		txtYear.setFont(new Font("Arial", Font.BOLD, 14));
//		txtYear.setForeground(new Color(0, 0, 0));
//		txtYear.setBounds(634, 10, 147, 30);
//		contentPane.add(txtYear);
//		txtYear.setColumns(100);
//		
//		JButton btnSearch = new JButton("Search");
//		btnSearch.setBackground(new Color(240, 240, 240));
//		btnSearch.setForeground(new Color(255, 0, 0));
//		btnSearch.setFont(new Font("Arial", Font.BOLD, 14));
//		btnSearch.setBounds(828, 9, 126, 30);
//		btnSearch.addActionListener(this);
//		contentPane.add(btnSearch);
//		
//		txtArea = new JTextArea("");
//		txtArea.setBounds(55, 150, 764, 32384);
//		contentPane.add(txtArea);
//		
//		JLabel lbYear = new JLabel("Year");
//		lbYear.setFont(new Font("Arial", Font.BOLD, 14));
//		lbYear.setHorizontalAlignment(SwingConstants.CENTER);
//		lbYear.setBounds(540, 10, 84, 30);
//		contentPane.add(lbYear);
		
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
			//doc du lieu tu server luu vao bien rs
			String rs = is.readUTF();
			
			//cat chuoi rs thanh 12 thang
			String[] arrOfMonth = rs.split("---------------------------\n",13);
			
			//hien thi lich len 12 textarea
			for(String a : arrOfMonth)
				System.out.println(a);
				//gan moi arrOfMonth[i] cho moi txtArea hoac gan thu cong txtArea1.setText(arr[1])
			
		} catch (Exception e1) {
			System.out.print(e1);
		}
	}
}


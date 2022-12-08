package PBL4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;


public class Server {
	final static int port = 9999;
	
	public static void main(String[] args) {
		new Server();
	}
	
	public Server()
	{
		ServerSocket serversocket;
		Socket Connection;
		try {
			serversocket = new ServerSocket(port);
			while(true)
			{
				Connection = serversocket.accept();
				System.out.println("New client connected: "
                         + Connection.getInetAddress()
                               .getHostAddress());
				new XuLyClient1(Connection).start();
			}
		} catch (Exception e) {
			System.err.println(e);
			System.out.println("error o server");
		}     
	}


}
class XuLyClient1 extends Thread{
	Socket socket;

	public XuLyClient1(Socket socket) {
		this.socket = socket;
	}
	public static String printMonth(int numberOfDays, int startDay) {
		String s = "";
		int weekdayIndex = 0;
//		System.out.println("Su  Mo  Tu  We  Th  Fr  Sa");
		s += "Su  Mo  Tu  We  Th  Fr  Sa\n";

		for (int day = 1; day < startDay; day++) {
//			System.out.print("    ");
			s+="    ";
			weekdayIndex++;
		}

		for (int day = 1; day <= numberOfDays; day++) {
//			System.out.printf("%1$2d", day);
			s = s+String.format("%1$2d", day);
			weekdayIndex++;
			if (weekdayIndex == 7) {
				weekdayIndex = 0;
//				System.out.println();
				s+="\n";
			} else {
//				System.out.print("  ");
				s+="  ";
			}
		}
//		System.out.println();
		s+="\n";
		return s;
	}
	
	public static String printYear(int year) {
		String s = "";
		Calendar cal = new GregorianCalendar();
		int startDay;
		int numberOfDays;
		for (int i = 0; i < 12; i++) {
			cal.set(year, i, 1);
			startDay = cal.get(Calendar.DAY_OF_WEEK);
			numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
//			System.out.print(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US));
			s+=cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
//			System.out.println(" " + year);
			s+=" "+ year + "\n";
			s+=printMonth(numberOfDays, startDay);
//			System.out.println();
			s+="\n";
		}
		return s;
	}	
	public void run() {
		try {
			DataInputStream is = new DataInputStream(socket.getInputStream());
			DataOutputStream os = new DataOutputStream(socket.getOutputStream());
			while (true) {
				String year = is.readUTF();
				int yearTmp = Integer.parseInt(year);
				String s1 = printYear(yearTmp);
				os.writeUTF(s1);
				os.flush();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

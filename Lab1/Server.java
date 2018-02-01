import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Server {

	static int ClientCounter = 0;
	public static void main(String[] args) {
		
		try(ServerSocket ss = new ServerSocket(5000)) {
			Socket clientSocket = ss.accept();
			System.out.println("SERVER: Client is Connected");
			ClientCounter++;
			
			BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
			
			while(true) {
				String userInput = input.readLine();
				if (!userInput.isEmpty() && !userInput.contains(" ")) {	
					if (userInput.equals("COUNT")) {
						output.println("SERVER ITMD466K - Clients Connected: " +ClientCounter);
					} else if (userInput.equals("exit")) {
						break;
					}
	
					int result;
					for (int i = 0; i < userInput.length(); i++) {
						try {
							if (userInput.charAt(i) == '+') {
								result = Integer.parseInt(userInput.substring(0,  i)) + Integer.parseInt(userInput.substring(i+1, userInput.length()));
								output.println("SERVER ITMD466K: " +result);
							} else if (userInput.charAt(i) == '-') {
								result = Integer.parseInt(userInput.substring(0,  i)) - Integer.parseInt(userInput.substring(i+1, userInput.length()));
								output.println("SERVER ITMD466K: " +result);
							} else if (userInput.charAt(i) == '*') {
								result = Integer.parseInt(userInput.substring(0,  i)) * Integer.parseInt(userInput.substring(i+1, userInput.length()));
								output.println("SERVER ITMD466K: " +result);
							} else if (userInput.charAt(i) == '/') {
								result = Integer.parseInt(userInput.substring(0,  i)) / Integer.parseInt(userInput.substring(i+1, userInput.length()));
								output.println("SERVER ITMD466K: " +result);
							} else if (userInput.charAt(i) == '%') {
								result = Integer.parseInt(userInput.substring(0,  i)) % Integer.parseInt(userInput.substring(i+1, userInput.length()));
								output.println("SERVER ITMD466K: " +result);
							} 
						} catch (NumberFormatException e) {
							
						}
					}
					} else {
						output.println("SERVER ITMD466K - Please Enter Something");
					}
				}
		} catch (IOException e) {
			System.out.println("Error in Server: " +e.getMessage());
		}
	} 
}

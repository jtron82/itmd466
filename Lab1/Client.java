import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		try (Socket clientSocket = new Socket("localhost", 5000)) {
			BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
			Scanner scanner = new Scanner(System.in);
			
			String userInput;
			String response;
			
			do {
				System.out.println("Enter Message");
				userInput = scanner.nextLine();
				
				output.println(userInput);
				if(!userInput.equals("exit")) {
					response = input.readLine();
					System.out.println(response);
				}
 			} while(!userInput.equals("exit"));
		} catch (IOException e) {
			System.out.println("Error in Client: " +e.getMessage());
		}
	}
}

package RpcPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

//Code on Client
public class CalculatorClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		int result = 0;
		Socket socket = new Socket("localhost",8080);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		
		int num1 =6, num2 =2;
		out.println("substract," +num1 + "," + num2);
		//receive result from server
		result = Integer.parseInt(in.readLine());
		//print result on client terminal
		System.out.println(num1 + "-" + num2 + "="+ result);
		
		
		out.println("substract,5,3");
		//receive result from server
		result = Integer.parseInt(in.readLine());
		//print result on client terminal
		System.out.println("5-3="+ result);
		out.println("multiply,7,2");
		//receive result from server
		result = Integer.parseInt(in.readLine());
		//print result on client terminal
		System.out.println("7*2="+ result);
		out.println("add,5,9");
		//receive result from server
		result = Integer.parseInt(in.readLine());
		//print result on client terminal
		System.out.println("5+9="+ result);
		out.println("divide,7,3");
		//receive result from server
		result = Integer.parseInt(in.readLine());
		//print result on client terminal
		System.out.println("7/3="+ result);
		
		socket.close();
	}

}

package RpcPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
//Code on Server

public class RpcServer implements Runnable{

	private CalculatorService service;
	private int port;
	private ServerSocket server;
	
	public RpcServer(CalculatorService service,int port) {
		this.service = service;
		this.port = port;
	}
	
	public void start() throws Exception{
		server = new ServerSocket(port);
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Socket client = server.accept();
				new Thread(new RpcHandler(client,service)).start();	
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
class RpcHandler implements Runnable{

	private Socket client;
	private CalculatorService service;
	
	public RpcHandler(Socket client, CalculatorService service) {
		this.client = client;
		this.service = service;
	}
	
	
	
	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream(),true);
			while(true) {
				//read the client request
				String request = in.readLine();
				if(request == null) {
					break;
				}
				String[] args = request.split(",");
				String methodName = args[0];
				int a = Integer.parseInt(args[1]);
				int b = Integer.parseInt(args[2]);
				int result = 0;
				switch(methodName) {
					case "add":
						result = service.add(a, b);
						break;
					case "substract":
						result = service.substract(a, b);
						break;
					case "multiply":
						result = service.multiply(a, b);
						break;
					case "divide":
						result = service.divide(a, b);
						break;
				}
				//send result to client
				out.println(result);
			}
			client.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

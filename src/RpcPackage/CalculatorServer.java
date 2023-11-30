package RpcPackage;
//Code on Server
public class CalculatorServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CalculatorService service = new CalculatorServiceImpl();
		RpcServer server = new RpcServer(service,8080);
		server.start();
	}

}

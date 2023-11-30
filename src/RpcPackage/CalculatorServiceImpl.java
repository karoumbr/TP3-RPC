package RpcPackage;

//Code on Server
public class CalculatorServiceImpl implements CalculatorService{

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public int substract(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	@Override
	public int multiply(int a, int b) {
		// TODO Auto-generated method stub
		return a * b;
	}

	@Override
	public int divide(int a, int b) {
		// TODO Auto-generated method stub
		return a / b;
	}

}

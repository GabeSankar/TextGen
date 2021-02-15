import java.util.*; 

public class App{

	LinkedList<Vector<Double>> buffer = new LinkedList<Vector<Double>>();
	public static void main(String[] args) {
		
	}
	//write code for the sigmoid function
	public double sigmoid(double x){
		return x;
	}
	public Vector<Double> vectormaker(int size){

		Vector<Double> vec = new Vector<Double>(size);
		Random random = new Random(); 

		for(int i = 0; i < size; i++){
		
			vec.add(random.nextDouble());

		}
		return vec;

	}
	public vector

	
}
import java.util.*; 

public class App{

	public LinkedList<Vector<Double>> bufferhidden = new LinkedList<Vector<Double>>();
	public LinkedList<Vector<Double>> bufferout = new LinkedList<Vector<Double>>();
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
	public Vector<Double> vecmult(Vector<Double> vec1, Vector<Double> vec2){

		Vector<Double> funcvec = new Vector<Double>(vec1.size());
		
		if(vec1.size() == vec2.size()){

			for(int i = 0; i < vec1.size(); i++){
				
				funcvec.add(sumvec(vec1, vec2.get(i)));

			}

		}else{

			System.out.println("error vector size not equal");
			System.exit(0);

		}

		return funcvec;
	}
	private double sumvec(Vector<Double> vectorinit,double currentElement){

		double outputElement = 0;

		for(int j = 0; j < vectorinit.size(); j++){

			outputElement = outputElement + (currentElement * vectorinit.get(j));

		}

		return outputElement;
	}
	public Vector<Double> vectoraddition(Vector<Double> vector1, Vector<Double> vector2){

		Vector<Double> finalvec = new Vector<Double>(vector1.size());

		if(vector1.size() == vector2.size()){

		for(int k = 0; k < vector1.size(); k++){

			finalvec.add(vector1.get(k)+vector2.get(k));

		}

		}else{

		System.out.println("error vector size not equal");
		System.exit(0);

		}

		return finalvec;

	}


	
}
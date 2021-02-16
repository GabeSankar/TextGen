import java.util.*; 



public class App{

	//Important this is the itteration/epoch
	public int GlobalItteration = 0;

	public LinkedList<Vector<Double>> bufferhidden = new LinkedList<Vector<Double>>();
	public LinkedList<Vector<Double>> bufferout = new LinkedList<Vector<Double>>();
	public LinkedList<Vector<Double>> trainvec = new LinkedList<Vector<Double>>();

	public static void main(String[] args) {
		
	}
	public Vector<Double> sigmoid(Vector<Double> x){
		
		Vector<Double> endvec = new Vector<Double>(x.size());

		for(int m = 0; m < x.size(); m++){

			endvec.add((1/( 1 + Math.pow(Math.E,(-1*x.get(m))))));

		}

		return endvec;
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
	public Vector<Double> forwardpassequation(Vector<Double> hprev,Vector<Double> xin,
											  Vector<Double> xwvec,Vector<Double> ywvec,Vector<Double> hwvec){

		Vector<Double> h1notactivated = vectoraddition(vecmult(hwvec, hprev),vecmult(xwvec, xin));

		return vecmult(ywvec, sigmoid(h1notactivated));

	}
	public double dotproduct(Vector<Double> vect1,Vector<Double> vect2){

		double finalvectordot = 0;

		if(vect1.size() == vect2.size()){

			for(int d = 0; d < vect1.size(); d++){

			finalvectordot = finalvectordot + (vect1.get(d)*vect2.get(d));

			}

		}else{

			System.out.println("error vector size not equal");

		}

		return finalvectordot;

	}
	public double Loss(LinkedList<Vector<Double>> out ,int itteration,LinkedList<Vector<Double>> trainbuffer){

		return dotproduct(vectoraddition(out.get(itteration), trainbuffer.get(itteration))
						 ,vectoraddition(out.get(itteration), trainbuffer.get(itteration)));

	}


	
}
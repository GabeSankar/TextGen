import java.util.*;



public class NeuralNetwork {

    

	public Vector<Double> sigmoid(Vector<Double> x){
		
		Vector<Double> endvec = new Vector<Double>(x.size());

		for(int m = 0; m < x.size(); m++){

			endvec.add((1/( 1 + Math.pow(Math.E,(-1*x.get(m))))));

		}

		return endvec;
	}
	public double scalarsigmoid(double x){

		return (1/( 1 + Math.pow(Math.E,(-1*x))));

	}
	public Vector<Double> tanh(Vector<Double> y){

		Vector<Double> retvec = new Vector<Double>(y.size());
		for(int g = 0; g < y.size(); g++){

			retvec.set(g, Math.tanh(y.get(g)));

		}

		return retvec;

	}
	public double scalartanh(double y){

		return Math.tanh(y);

	}
    public Vector<Double> vectormaker(int size){

		Vector<Double> vec = new Vector<Double>(size);
		Random random = new Random(); 

		for(int i = 0; i < size; i++){
		
			vec.add(random.nextDouble());

		}
		return vec;

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
	public Vector<Double> scalarproduct(double scalar, Vector<Double> vect){

		Vector<Double> returnvector = new Vector<Double>(vect.size());

		for(int h = 0; h < vect.size(); h++){

			returnvector.set(h,(vect.get(h) * scalar));

		}

		return returnvector;

	}
	public Vector<Double> forwardpassequation(Vector<Double> hprev,Vector<Double> xin,
											  Vector<Double> xwvec,Vector<Double> ywvec,Vector<Double> hwvec){

		double h1notactivated = dotproduct(hwvec, hprev) + dotproduct(xwvec, xin);

		return scalarproduct(scalarsigmoid(h1notactivated),ywvec);

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

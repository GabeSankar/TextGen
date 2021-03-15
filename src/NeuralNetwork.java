import java.util.*;



public class NeuralNetwork {

	
	public VectorMath v = new VectorMath();
	public Gradient backprop = new Gradient();



	private Vector<Double> forwardpassequation(double hprev,Vector<Double> xin,
											  Vector<Double> xwvec,Vector<Double> ywvec,Vector<Double> hwvec,
											  LinkedList<Double> h1outputs, LinkedList<Vector<Double>> outputlist,
											  int globalItter){

		double h1notactivated = v.scalarvectoscalar(hwvec, hprev) + v.dotproduct(xwvec, xin);
		h1outputs.add(globalItter, v.scalarsigmoid(h1notactivated));

		outputlist.add(globalItter,(v.scalarproduct(v.scalarsigmoid(h1notactivated),ywvec)));
		return v.scalarproduct(v.scalarsigmoid(h1notactivated),ywvec);

	}
	private double Loss(LinkedList<Vector<Double>> out ,int itteration,LinkedList<Vector<Double>> trainbuffer){

		return v.dotproduct(v.vectoraddition(out.get(itteration), trainbuffer.get(itteration))
						 ,v.vectoraddition(out.get(itteration), trainbuffer.get(itteration)));

	}
	//Full process for the epoch during training
	public void epoch(Vector<Double> hiddenweights,Vector<Double> outputweights,Vector<Double> inputweights,
					  LinkedList<Double> hiddenbuffer,LinkedList<Vector<Double>> bufferoutput,
					  LinkedList<Vector<Double>> trainingvectors, int GlobalItter, Vector<Double> input){

		forwardpassequation(hiddenbuffer.get(GlobalItter - 1), input, inputweights, outputweights, 
							hiddenweights,hiddenbuffer, bufferoutput, GlobalItter);

		System.out.println(Loss(bufferoutput, GlobalItter, trainingvectors));

		

	}
    
}

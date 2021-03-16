import java.util.*; 



public class App{

	//Important this is the itteration/epoch
	public int GlobalItteration = 0;
	
	int vectorsize;

	public Vector<Double> Hiddenweights = new Vector<Double>(vectorsize);
	public Vector<Double> Inputweights = new Vector<Double>(vectorsize);
	public Vector<Double> Outputweights = new Vector<Double>(vectorsize);

	public LinkedList<Double> bufferhidden = new LinkedList<Double>();
	public LinkedList<Vector<Double>> bufferout = new LinkedList<Vector<Double>>();
	public LinkedList<Vector<Double>> trainvec = new LinkedList<Vector<Double>>();

	public static void main(String[] args) {
		
	}

}
import java.util.*;


public class Gradient {

    VectorMath vec = new VectorMath();
 
    private double sigmoiderivative(double input){

        double sigmoidDEnding = (1 - vec.scalarsigmoid(input));
        return vec.scalarsigmoid(input)*sigmoidDEnding;

    }
    private double partialSummationDerivativeH(double hprev){

        return hprev;

    }
    private double partialSummationDerivativeX(Vector<Double> inputvec,Vector<Double> xweight,int index){

        return inputvec.get(index);

    }
    private double  partialDerivativeYSig(double hlayerActive){
    
        return hlayerActive;

    }
    private double partialLY(Vector<Double> Correctvec,int index){

        return Correctvec.get(index);

    }
    public double finalpartialDerivativeX(int index,double bufferhidden,double h1notactivated,double hlayeractivated,
                                        Vector<Double> CorrectVec,Vector<Double> invec,Vector<Double> xweight){

        return partialSummationDerivativeH(bufferhidden)*
        sigmoiderivative(h1notactivated)*partialDerivativeYSig(hlayeractivated)*partialLY(CorrectVec, index);

    }
    public double finalpartialDerivativeH(Vector<Double> invec,Vector<Double> xweight,int index,double h1notactivated,
                                         double hlayeractivated,Vector<Double> CorrectVec){

        return partialSummationDerivativeX(invec,xweight,index)*
        sigmoiderivative(h1notactivated)*partialDerivativeYSig(hlayeractivated)*partialLY(CorrectVec, index);

    }
    public double finalpartialDerivativeYweight(Vector<Double> Correctvec,int index,double hlayerActive){

        return partialLY(Correctvec, index)*partialDerivativeYSig(hlayerActive);

    }


}

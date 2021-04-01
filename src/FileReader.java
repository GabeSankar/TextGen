import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {
    
    public HashMap<Vector<Double>,Character> encodingKey = new HashMap<Vector<Double>,Character>();

    private ArrayList<Character> charCounter(String filename) throws IOException{

        ArrayList<Character> allcharsinfile = new ArrayList<Character>();

        try {
            
            File traintestFile = new File(filename);
            Scanner input = new Scanner(traintestFile);

            while (input.hasNextByte()) {

                byte b = input.nextByte();
                char currentIn = (char)b;

            if (!allcharsinfile.contains(currentIn)) {
                
                allcharsinfile.add(currentIn);
            
            }
            }   
            input.close();
            

        } catch (IOException e) {
            e.printStackTrace();
        }
        return allcharsinfile;

    }
    private void encodingKeyCreate(String file)throws IOException{

        ArrayList<Character> baseArraylist = charCounter(file);

        int vectorsize = baseArraylist.size();

        for(int j = 0; j < vectorsize;j++){

            encodingKey.put(nullvectormaker(vectorsize, j), baseArraylist.get(j));

        }


    }
    private Vector<Double> nullvectormaker(int size,int itter){

		Vector<Double> vec = new Vector<Double>(size);
	 

		for(int i = 0; i < size; i++){
		
			vec.add(0.0);

		}
        vec.set(itter, 1.0);
		return vec;

	}

    //Take care of the file reading later.

    public LinkedList<Vector<Double>> Vectorencoderfinal(String file) throws IOException{

        encodingKeyCreate(file);
        LinkedList<Vector<Double>> returnvectorlist = new LinkedList<Vector<Double>>();

        return returnvectorlist;

    }

}

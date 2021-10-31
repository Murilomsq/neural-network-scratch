import java.util.ArrayList;
import java.util.Random;

public class NNElement{
    public double value;
    public ArrayList<Double> weight;

    public NNElement(int numOfWeights){

        weight = new ArrayList<Double>(numOfWeights);
        Random r  =  new Random();
        for (int i = 0; i < numOfWeights; i++) {
            weight.add(i, r.nextDouble(10) - 5.0);
        }
    }
    public NNElement(){}
}

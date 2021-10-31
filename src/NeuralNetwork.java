import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class NeuralNetwork {

    //Class attributes
    private ArrayList<NNElement>[] layerValues;

    //Methods
    public NeuralNetwork(int[] numOfElements){
        // This basically instantiate the smaller pieces of a NN to a bigger one with all weights connected
        layerValues = new ArrayList[numOfElements.length];
        for (int i = 0; i < numOfElements.length; i++ ) {
            layerValues[i] = new ArrayList<NNElement>();
            for(int j = 0; j < numOfElements[i]; j++){
                if(i < numOfElements.length - 1){
                    layerValues[i].add(new NNElement(numOfElements[i+1]));
                }
                else{
                    layerValues[i].add(new NNElement());
                }
            }
        }
    }

    public void RandomizingEntryLayer(){

        Random r  =  new Random();
        for(int i = 0; i < layerValues[0].size(); i++){
            layerValues[0].get(i).value = r.nextDouble(1);
        }
    }

    public ArrayList<NNElement> FeedForward() {
        // The element value will be defined by the sigmoid of the sum of (value*weight)
        // We start the Feeding with the second layer

        //Iterating through layers
        for(int i = 1; i < layerValues.length; i++){
            //Iterating through NNElements
            for(int j = 0; j < layerValues[i].size() ; j++){
                double sum = 0.0;
                //Iterating through last NNElements to calc the feedforward
                for(int k = 0; k < layerValues[i-1].size(); k++){
                    NNElement elem = layerValues[i-1].get(k);
                    sum += (elem.value * elem.weight.get(j));
                    //System.out.println(sum);
                }

                layerValues[i].get(j).value = Sigmoid(sum);
            }
        }
        return layerValues[layerValues.length - 1];
    }

    public double Sigmoid(double x) {
        return (1/( 1 + Math.pow(Math.E,(-1*x))));
    }
}

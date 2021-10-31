public class Main {
    public static void main(String args[]){
        int arr[] = {4,3,1};

        NeuralNetwork net = new NeuralNetwork(arr);

        net.RandomizingEntryLayer();

        System.out.println(net.FeedForward().get(0).value);

        System.out.println("asd");
    }
}

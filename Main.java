
public class Main {
    public static void main(String[] args) {
        

        double[] inputs = {1,0};
        double[] weights = {1,1};
        double[] outputs = new double[2];
        
        double finalOutput;
        

        System.out.println("Para el problema XOR con 3 neuronas");
        System.out.println("Si el input 1 es: " + (inputs[0] != 0) + " y el input 2 es " + (inputs[1] != 0) );
        
        // Layer 1
        Layer layer1 = new Layer(2, ActivationFunctionsEnum.Step);
        layer1.getNeuron(0).setBias(-0.5);
        layer1.getNeuron(1).setBias(-1.5);

        // Le ponemos los mismos pesos a ambas neuronas
        layer1.setNeuronWeight(0, weights);
        layer1.setNeuronWeight(1, weights);


        outputs = layer1.runLayer(inputs);

        
        // Layer 2
        // re set the weights

        weights[0] = 1 ;
        weights[1] = -2;
        
        Layer layer2 = new Layer(1, ActivationFunctionsEnum.Step);
        layer2.getNeuron(0).setBias(-0.5);

        // Le ponemos los mismos pesos a ambas neuronas
        layer2.setNeuronWeight(0, weights);

        finalOutput = layer2.runLayer(outputs)[0];
        

        System.out.println("El resultado es: " + (finalOutput != 0));



    }
}
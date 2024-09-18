
public class Main {
    public static void main(String[] args) {
        

        double[] inputs = {1,0};
        double[] weights = {1,1};
        double[] outputs = new double[2];
        
        double finalOutput;
        

        System.out.println("Para el problema XOR con 3 neuronas");
        System.out.println("Si el input 1 es: " + (inputs[0] != 0) + " y el input 2 es " + (inputs[1] != 0) );
        
        // Layer 1
        Neuron neuron1 = new Neuron(-0.5, ActivationFunctionsEnum.Step);
        outputs[0] = neuron1.RunNeuron(inputs, weights);
        Neuron neuron2 = new Neuron(-1.5, ActivationFunctionsEnum.Step);
        outputs[1] = neuron2.RunNeuron(inputs, weights);
        
        
        // Layer 2
        weights[0] = 1 ;
        weights[1] = -2;
        inputs[0] = outputs[0];
        inputs[1] = outputs[1];
        Neuron neuron3 = new Neuron(-0.5, ActivationFunctionsEnum.Step);
        
        finalOutput = neuron3.RunNeuron(inputs, weights);

        System.out.println("El resultado es: " + (finalOutput != 0));



    }
}
import java.util.Random;

public class Layer {
    
    private Neuron[] LayerNeurons;
    private Neuron ActiveNeuron;
    private double[][] weights; 

    // This must be changed later becouse of some network has no linear layers
    // See https://miro.medium.com/v2/resize:fit:2000/1*cuTSPlTq0a_327iTPJyD-Q.png  

    public Layer(int numberOfNeurons , ActivationFunctionsEnum ActivationFunctionName){

        this.weights = new double[numberOfNeurons][numberOfNeurons];
        // Definir a this.LayerNeurons pero con numberOfNeurons como tamaño
        this.LayerNeurons = new Neuron[numberOfNeurons]; 
        for(int i = 0; i < numberOfNeurons; i++){
            Random random = new Random();
            double randomDouble = random.nextDouble(); // Esto genera cualquier número entero posible

            this.LayerNeurons[i] = new Neuron(randomDouble, ActivationFunctionName);
        }
        
    }

    public int getCantidadNeuronas(){
        return this.LayerNeurons.length;
    }


    public Neuron getNeuron(int index){
        return this.LayerNeurons[index];
    }


    public Neuron getActiveNeuron(){
        return this.ActiveNeuron;
    }
    public void setActiveNeuron( int index  ){

        this.ActiveNeuron  = this.LayerNeurons[index];
    }

    public void setWeights(double[][] weights) {
        this.weights = weights;
    }

    public void setNeuronWeight(int index, double[] weights) {
        this.weights[index] = weights;
    }

    public double[] runLayer(double[] inputs){
        double[] neuronsOutputs = new double[this.getCantidadNeuronas()]; 

        for (int i = 0; i < this.getCantidadNeuronas(); i++) {
            neuronsOutputs[i] = this.getNeuron(i).RunNeuron(inputs, this.weights[i]);
        }
        return neuronsOutputs;
    }
}

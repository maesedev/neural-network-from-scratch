public class Neuron {
   
    protected double[] inputs;
    protected double[] weights;
    protected double output;
    protected double bias;
    protected ActivationFunctionsEnum ActivationFunctionName;


    public Neuron( double bias, ActivationFunctionsEnum ActivationFunctionName){
        this.bias = bias;
        this.ActivationFunctionName = ActivationFunctionName;
    }
    
    
    public double RunNeuron(double[] inputs, double[] weights ){
        this.inputs = inputs;
        this.weights = weights;
        
        return PassThoughtActivationFunction();
    }

    private double sumWeights(){
        
        if(this.inputs.length != this.weights.length){
            try {
                throw new Exception("Dimension Error: The weights and inputs have diferent sizes.");
            } catch (Exception e) {
                System.exit(2);
            }
        }
        
        double sum = 0;
        for(int i = 0; i < this.inputs.length ; i++){
            sum += inputs[i] * weights[i];
        }

        sum += this.bias;

        return sum;
    }


    public double PassThoughtActivationFunction () {
        
        double x = 0;
        x = this.sumWeights();
        ActivationFunction af = new ActivationFunction();

        return af.ExecuteFunction(this.ActivationFunctionName, x);

    }



}   

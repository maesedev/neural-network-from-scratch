public class ActivationFunction {
    

    public ActivationFunction(){

        
    }

    public double ExecuteFunction(ActivationFunctionsEnum name, double x){
        double value = 0;
        switch (name) {
            case Relu:
                value = ReluFunction(x);
            break;
            
            case LeakyRelu:
                value = LeakyReluFunction(x);
            break;
            
            case Sigmoid:
                value = SigmoidFunction(x);
            break;

            case Tanh:
                value = TanhFunction(x);
            break;
            case Step:
                value = StepFuncion(x);
            break;
            default:
            try{
                throw new Error("Error: No such activation function name '" + name + "'");
            }
            catch( Exception e ){
                System.exit(2);
            }
        }
        return value;
    }


    public double ReluFunction(double x){
        return Math.max(0, x);

    }

    public double StepFuncion(double x){
        
        return (x >= 0) ? 1 : 0;  

    }
    public double LeakyReluFunction(double x){
        return 0;
    }
    public double SigmoidFunction(double x){
        return 1 / (1 + (double)Math.exp(-x));

    }
    public double TanhFunction(double x){
        return (double)Math.tanh(x);
    }

    // Commonly used in the output of the neural netweor
    public double[] SoftMaxFunction(double[] inputs ){
        double sum = 0.0;
        double[] output = new double[inputs.length];
        
        // Calcular el sumatorio de e^x
        for (double input : inputs) {
            sum += Math.exp(input);
        }
        
        // Calcular softmax
        for (int i = 0; i < inputs.length; i++) {
            output[i] = (double)Math.exp(inputs[i]) / sum;
        }
        
        return output;
    }


   
}

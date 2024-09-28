
public class Vector {
    
    //Atributs
    private double[] values;
    private Integer dimension;

    //Constructor
    public Vector(int d){
        dimension = d;
        values = new double[d];
        set_zeros();
    }

    //Mètodes
    public void setVec(int i, double val){
        values[i] = val;
    }

    public Double getVec(int i){
        if (i>values.length){
            System.out.println("Position doesn't exist");
            return -1.0; 
        } else{
            return values[i];
        }
    }

    public Integer getDim(){
        return dimension;
    }

    public void multiplyVec(double s){
        for(int i = 0; i<dimension; i++){
            values[i] = values[i] * s;
        }
    }

    public void printVec(){
        System.out.print("[");
        System.out.print(values[0]);
        for(int i=1; i<dimension; i++){
              System.out.print(", " + values[i]);
        }
        System.out.print("]");
        System.out.print("\n");
    }

    public void set_zeros(){    //Sinó no la veiem al main.
        for (int i=0; i<dimension; i++){
            values[i] = 0.0;
        }
    }

    public void set3DVec(double i, double j, double k){ //matriu
        values[0] = i;
        values[1] = j;
        values[2] = k;
    }

    public void multiplyMat(Matrix m){
        if(values.length != m.getrows()){
            System.out.println("ERROR!: incompatible dimensions");
        }else{
            Vector multiply_vector = new Vector(3);
            multiply_vector.set3DVec(values[0], values[1], values[2]);
            for(int i=0; i<m.getrows(); i++){
                double value = 0;
                for (int j=0; j<m.getcols(); j++){
                    value += multiply_vector.getVec(j)*m.get(i,j);
                }
                values[i] = value;
            }
        }
    }

}

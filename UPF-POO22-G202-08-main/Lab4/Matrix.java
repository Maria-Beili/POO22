
public class Matrix {
    
    //Atributs
    private Vector[] values;
    private Integer rows;
    private Integer cols;

    //Constructor
    public Matrix(int n, int m){
        rows = n;
        cols = m;
        values = new Vector[n];
        for (int i=0; i<rows; i++){
            values[i] = new Vector(m);
        }
    }

    //Mètodes
    public void set(int i, int j, double val){
        values[i].setVec(j,val);
    }

    public double get(int i, int j){
        return values[i].getVec(j);
    }

    public double getcols(){
        return cols;
    }

    public double getrows(){
        return rows;
    }

    public void multiplyMat(double s){
        for (int i=0; i<rows; i++){
            values[i].multiplyVec(s);
        }
    }

    public void printMatrix(){
        System.out.println("Matrix:");
        for (int i=0; i<rows; i++){
            values[i].printVec();
        }
        System.out.print("\n");
    }

    
    public void set_zeros_matrix(){
        for (int i=0; i<rows; i++){
            values[i].set_zeros();
        }
    }

    public void create3DRotationMat(double alpha){
        if (alpha == 90){
            alpha = 90*180/Math.PI;
        }

        double cosAlpha = Math.cos(alpha);
        double sinAlpha = Math.sin(alpha);

        values[0].set3DVec(cosAlpha, -sinAlpha, 0);
        values[1].set3DVec(sinAlpha, cosAlpha, 0);
        values[2].set3DVec(0, 0, 1);
    }
    
}

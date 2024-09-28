public class Main {
    
    public static void main(String[] args) {
       
        Vector v = new Vector(3) ;
        v.setVec(0, 1);
        v.setVec(1 , 2);
        v.setVec(2 , 3);
        v.printVec(); 
        v.set_zeros();
        v.printVec();
        System.out.print("\n");

        Matrix m = new Matrix(2,2) ;
        m.set(0,0,1);
        m.set(0,1,0);
        m.set(1,0,0);
        m.set(1,1,1);
        m.printMatrix();
        m.set_zeros_matrix();
        m.printMatrix();


        Vector vec = new Vector(3);
        vec.set3DVec(1, 0, 0);
        vec.printVec();

        Matrix m2 = new Matrix(3,3);
        m2.create3DRotationMat(Math.PI/2);
        vec.multiplyMat(m2); 
        vec.printVec();   

        Vector vec2 = new Vector(2);
        Matrix m3 = new Matrix(3, 3);
        m3.create3DRotationMat(Math.PI/2);
        vec2.multiplyMat(m3);
    }
}


public class BWFrame extends Frame{
    
    //Constructor
    public BWFrame(int n, int m){
        super(n,m);
    }

    //Mètodes
    public void setBW(int i, int j, double val){
        super.set(i, j, val);
    }

    public double getBW(int i, int j){
        return super.get(i, j);
    }

    @Override
    public void changeBrightness(double delta){
        super.multiplyMat(delta);
    }
}

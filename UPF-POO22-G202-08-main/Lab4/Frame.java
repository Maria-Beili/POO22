public abstract class Frame extends Matrix {

    //Constructor
    public Frame(int n, int m) {
        super(n, m);
    }

    //Mètodes
    public abstract void changeBrightness(double delta);
}

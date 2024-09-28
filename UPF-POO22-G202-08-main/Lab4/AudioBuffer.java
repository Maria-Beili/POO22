public class AudioBuffer extends Vector {

    //Constructor
    public AudioBuffer(int d) {
        super(d);
    }

    //Mètodes
    public void ChangeVolume(double delta){
        super.multiplyVec(delta);
    }
    
}

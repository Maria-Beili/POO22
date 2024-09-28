import java.awt.*;

public class World {
    //atributs
    private int width;
    private int height;
    private Agent[] agents;
    private int marge;

    //Constructor
    public World(int w, int h){
        width  = w;
        height = h;
        marge = 30;
        agents = new Agent[10];
        for(int i = 0; i<agents.length; i++){
            agents[i] = new Agent(randomPos(), randomRadius());
            agents[i].setSpeed(1);
            agents[i].setTarget(randomPos());            
        }
    }

    //Mètodes
    private Vec2D randomPos() {
        double x = marge + Math.random() * (width - 2* marge);
        double y = marge + Math.random() * (height - 2 * marge);
        return new Vec2D(x,y);
    }

    private double randomRadius() {
        return 5 + Math.random() * (marge - 5);
    }

    public void simulationStep(){
        for (int i = 0; i<agents.length; i++){
            if(agents[i].targetReached() == true){
                agents[i].setTarget(randomPos());
            }else{
                agents[i].updatePosition();
            }
        }
    }

    public void paint(Graphics g){
        for (int i = 0; i < agents.length; i++){
            agents[i].paint(g);
        }
    }

   //funció manage collisions:
   
    /* 
    public void manageCollisions() {
        for (int i=0 ; i<10; i++ ){
            for (int j=i+1; j<10; j++){
                if ((agents[i]!=agents[j]) & (agents[i].isColliding(agents[j]) == true)) {
                    agents[i].updatePosition();
                    agents[j].updatePosition();
                }
            }
        }
    }
    */ 
}

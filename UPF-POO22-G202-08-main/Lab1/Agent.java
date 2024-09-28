import java.awt.*;

public class Agent {

    // Atributs
    private Vec2D pos;
    private double radius;
    private Vec2D dir;
    private Vec2D target;
    private double speed;

    // Constructor
    public Agent(Vec2D position, double r) {
        radius = r;
        pos = position;
    }

    // Mètodes
    public void setTarget(Vec2D tar) {
        target = tar;
        dir = new Vec2D(target); // estem creant una instància
        dir.subtract(pos);
        dir.normalize();
    }

    public void setSpeed(double velocity) {
        speed = velocity;
    }

    public void updatePosition() {
        Vec2D multiplication = new Vec2D(dir.getX()*speed, dir.getY()*speed);
        pos = new Vec2D(pos);       //creem instància
        pos.add(multiplication);
    }

    public boolean targetReached(){
        target = new Vec2D(target);
        target.subtract(pos);
        if (target.getX()<radius | target.getY()<radius ) {
            return true;
        } else {
            return false;
        }
    }
     
    public boolean isColliding(Agent a){
        pos = new Vec2D(pos);
        pos.subtract(a.pos);

        double sum = radius + a.radius;
        if (pos.length() < sum){
            return true;
        }
        else{
            return false;
        }
    }

    public void paint(Graphics g) {
        int x = (int) (pos.getX() - radius);
        int y = (int) (pos.getY() - radius) ;
        int d = (int) (2*radius) ;
        g.setColor(Color.RED);
        g.fillOval(x,y,d,d);
    }
}

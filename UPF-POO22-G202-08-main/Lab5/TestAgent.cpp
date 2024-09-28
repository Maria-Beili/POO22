
#include <iostream>
#include "Agent.hpp"
#include "Entity.hpp"

int main() {
	// create instances directly
	Vec2D pos(2,2);
    Agent a(&pos, "Jorge", 100, 1.70);
    Agent a2(&pos, "Martin", 70, 0.80);
	
    
    Vec2D * target = new Vec2D(40,40);
    a.setTarget(target);
    a.setSpeed(25.00);
    std::cout << a.getSpeed() << "\n"; //Prints 25
    std::cout << a2.getName() << "\n"; //Prints Martin
    
    bool t = a.isColliding(&a2);
    std::cout << t << "\n";  //Prints 1 because they are colliding 

	a.update();
    bool reached = a.targetReached();
    std::cout << reached << "\n";   //Prints 0 because target not reached 
	
	// create instances using pointers
	Agent * a3 = new Agent(a2);
    std::cout << a3->getEnergy() << "\n";   //Prints 70
	std::cout << a3->getPos()->length() << "\n";    //Prints 25

    Entity * e1 = new Agent(a);  //fem upcast per a poder crear una entitat 

    bool f = a3->compareTo(e1);
    std::cout << f << "\n";  //Prints 0 because they don't have the same energy.
	
	// instances created using "new" have to be deleted
	delete a3;
    delete e1;
	
}


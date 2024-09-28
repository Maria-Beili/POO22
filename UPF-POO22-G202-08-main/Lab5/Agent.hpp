#ifndef _AGENT_
#define _AGENT_

#include "Entity.hpp"
#include "Vec2D.hpp"
#include <iostream>

class Agent: public Entity{
    private:
        double radius;
        Vec2D * dir;
        Vec2D * target;
        double speed;

    public:
        //Constructors 
        Agent(Vec2D *p, std::string n, int e, double r): Entity(p,n,e), radius(r) {}

        void setTarget(Vec2D * v){
            target = v;
            dir = new Vec2D(target);
            dir->subtract(Entity::getPos());
            dir->normalize();

        }

        void setSpeed(double s){
            speed = s;
        }

        double getSpeed(){
            return speed;
        }

        bool targetReached(){
            target = new Vec2D(target);
            target->subtract(Entity::getPos());
            if (target->getX()<radius | target->getY()<radius){
                return true;
            } else{
                return false;
            }
        }

        bool isColliding(Agent * a){
            Vec2D * pos = Entity::getPos();
            Vec2D * a_pos = a->getPos();
            pos->subtract(a_pos);

            double sum = radius + a->radius;
            if (pos->length() < sum){
                return true;
            } else{
                return false;
            }
        }

        void update(){
            Vec2D * multiplication = new Vec2D(dir->getX()*speed, dir->getY()*speed);
            Vec2D * pos = Entity::getPos();
            pos->add(multiplication);
        }   
};

#endif
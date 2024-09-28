#ifndef _ENTITY_
#define _ENTITY_

#include "Vec2D.hpp"
#include "Nameable.hpp"
#include "Comparable.hpp"
#include <iostream>

class Entity: public Nameable, Comparable<Entity>{
    
    private:
        Vec2D * pos;
        std::string name;
        int energy;

    public:
        Entity(Vec2D *p, std::string n, int e): pos(p), name(n), energy(e) {}
        Entity(Entity * e): pos(e->getPos()), name(e->getName()), energy(e->getEnergy()) {}

        Vec2D * getPos(){
            return pos;
        }
        
        std::string getName(){
            return name;
        }

        void setName(std::string n){
            name = n;
        }
        
        int getEnergy(){
            return energy;
        }

        int compareTo(Entity * e){
            int element = e->energy;
            if (element == this->energy){
                return 1; 
            }else if ((element < this->energy) || (element > this->energy)){
                return 0;
            }
        }


        virtual void update() = 0;
};

#endif
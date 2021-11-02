package com.mygdx.colony;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import java.util.ArrayList;

public abstract class Humanoid extends Actor {

    public Location currentLocation;
    //public Location destination;
    public Sprite humanoidSpr;
    public Texture humanoidTxr;
    public char status;
    //public boolean moving;
    public ColonyResources allResources;
    public ArrayList<Location> route  = new ArrayList<>();


    public void update() {
        //Could swap this over to a boolean if speed is a problem
        if (route.size()>0) {
            if (route.get(0).getY() != humanoidSpr.getY()) {
                climb();
            } else {
                walk();
            }
        }
    }


    private void walk() {
        if (route.get(0).getX() > humanoidSpr.getX()) {
            humanoidSpr.setX(humanoidSpr.getX() + 1);
        } else {
            humanoidSpr.setX(humanoidSpr.getX() -1);
        }
    }


    private void climb() {
        if (route.get(0).getY() > humanoidSpr.getY()) {
            humanoidSpr.setY(humanoidSpr.getY() + 1);
        } else {
            humanoidSpr.setY(humanoidSpr.getY() -1);
        }
    }


    public void move(Location destination) {
        //route = new ArrayList<>();
        ArrayList<Location> nodes = currentLocation.getConnections();
        boolean finished = false;
        //Uses breadth-first search to find the route
        while (!finished) {
            //Proceeds on to the next node
            //!! Not removing elements from nodes. So nothing else ever gets checked, and it loops infinitely
            route.add(nodes.get(0));
            if (route.get(route.size()-1) == destination) {
                finished = true;
                //A valid route from the current location to the destination has been found
            } else {
                //Backs up to the previous node
                route.remove(route.size()-1);
                //Adds connections to the list of nodes to explore, ensuring there are no cycles
                //!! Refactor this, I'm just getting it working for now
                for (Location each_node: route/*.get(route.size()-1).getConnections()*/) {
                    if (!route.contains(each_node)) {
                        nodes.add(each_node);
                    }
                }
            }
        }
    }
}
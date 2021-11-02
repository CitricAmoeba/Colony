package com.mygdx.colony;

import java.util.ArrayList;

public class Location {

    private final int id;
    private int x;
    private int y;
    private ArrayList<Location> connections;
    private                                                                                                                                                        ArrayList<Boolean> climbs;


    public Location(int locId, int locX, int locY) {
        this.id = locId;
        this.x = locX;
        this.y = locY;
    }


    public void setConnections(ArrayList<Location> nodes, ArrayList<Boolean> climbing) {
        if (nodes.size() == climbing.size()) {
            this.connections = nodes;
            this.climbs = climbing;
        } else {
            System.out.println("Arrays passed in are not of the same length");
        }
    }


    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getId() { return this.id; }

    public ArrayList<Location> getConnections() { return connections; }
}

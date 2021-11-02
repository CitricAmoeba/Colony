package com.mygdx.colony;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Human extends Humanoid {

    public Human(Location origin, String appearance, ColonyResources resources) {
        currentLocation = origin;
        humanoidTxr = new Texture(Gdx.files.internal(appearance));
        humanoidSpr = new Sprite(humanoidTxr);
        humanoidSpr.setX(currentLocation.getX());
        humanoidSpr.setY(currentLocation.getY());
        //moving = true;
        allResources = resources;
    }

}
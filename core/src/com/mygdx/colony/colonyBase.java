package com.mygdx.colony;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import java.util.ArrayList;

public class colonyBase extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Location loc1;
	Location loc2;
	Location loc3;
	Location loc4;
	Location loc5;
	Location loc6;
	Location loc7;

	ArrayList<Location> otherLocs;
	ArrayList<Boolean> climbingRequired;
	Human[] farmers;
	ColonyResources clanResources;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		img = new Texture("badlogic.jpg");

		loc1 = new Location(1, 500, 350);
		loc2 = new Location(2, 1200, 350);
		loc3 = new Location(3, 500, 250);
		loc4 = new Location(4, 200, 250);
		loc5 = new Location(5, 800, 250);
		loc6 = new Location(6, 200, 100);
		loc7 = new Location(7, 800, 100);

		setupGraph();

		clanResources = new ColonyResources();
		farmers = new Human[2];
		farmers[0] = new Human(loc2, "human.jpg", clanResources);
		farmers[0].move(loc7);
		//farmers[1] = new Human(loc1, "human.jpg", clanResources);
		//farmers[0].destination = loc2;
		//farmers[1].destination = loc3;

	}

	public void setupGraph() {
		otherLocs = new ArrayList<Location>();
		climbingRequired = new ArrayList<Boolean>();
		otherLocs.add(loc2);
		otherLocs.add(loc3);
		climbingRequired.add(false);
		climbingRequired.add(true);
		loc1.setConnections(otherLocs, climbingRequired);

		otherLocs.clear();
		climbingRequired.clear();
		otherLocs.add(loc1);
		climbingRequired.add(false);
		loc2.setConnections(otherLocs, climbingRequired);

		otherLocs.clear();
		climbingRequired.clear();
		otherLocs.add(loc1);
		otherLocs.add(loc4);
		otherLocs.add(loc5);
		climbingRequired.add(true);
		climbingRequired.add(false);
		climbingRequired.add(false);
		loc3.setConnections(otherLocs, climbingRequired);

		otherLocs.clear();
		climbingRequired.clear();
		otherLocs.add(loc3);
		otherLocs.add(loc6);
		climbingRequired.add(false);
		climbingRequired.add(true);
		loc4.setConnections(otherLocs, climbingRequired);

		otherLocs.clear();
		climbingRequired.clear();
		otherLocs.add(loc3);
		otherLocs.add(loc7);
		climbingRequired.add(false);
		climbingRequired.add(true);
		loc5.setConnections(otherLocs, climbingRequired);

		otherLocs.clear();
		climbingRequired.clear();
		otherLocs.add(loc6);
		climbingRequired.add(true);
		loc6.setConnections(otherLocs, climbingRequired);

		otherLocs.clear();
		climbingRequired.clear();
		otherLocs.add(loc5);
		climbingRequired.add(true);
		loc7.setConnections(otherLocs, climbingRequired);
	}


	@Override
	public void render () {

		ScreenUtils.clear(0.46f, 0.23f, 0, 0);
		batch.begin();

			//Updates each farmer in the simulation
			for (Human each_farmer : farmers) {
				each_farmer.update();
				each_farmer.humanoidSpr.draw(batch);
			}

			//draws in the points of the graph for reference
			batch.draw(img, 475, 350,50,50);
			batch.draw(img, 1200, 350,50,50);
			batch.draw(img, 475, 250,50,50);
			batch.draw(img, 175, 250,50,50);
			batch.draw(img, 775, 250,50,50);
			batch.draw(img, 175, 100,50,50);
			batch.draw(img, 775, 100,50,50);

		batch.end();

	}


	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
package com.mygdx.colony;

public class Dwarf extends Humanoid {

    private int miningSkill;
    private int craftingSkill;
    private int gatheringSkill;

    @Override
    public void update() {
        super.update();

        switch (status) {
            case 'm':
                allResources.ores += miningSkill;
            case 'g':
                allResources.food += gatheringSkill;
            case 'c':
                for (int allTreasure = 0; allTreasure < craftingSkill; allTreasure++) {
                    if (allResources.ores > 1) {
                        allResources.treasure++;
                    }
                }
            case 's':
                //Sleeping case, nothing actually happens, this is just here in case I need
                //to add to it
        }
    }
}

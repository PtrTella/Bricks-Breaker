package brickbreaker.model.factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import brickbreaker.common.Difficulty;
import brickbreaker.common.P2d;
import brickbreaker.model.GameMap;
import brickbreaker.model.World;
import brickbreaker.model.WorldImpl;
import brickbreaker.model.gameObjects.Brick;
import brickbreaker.model.gameObjects.bounding.RectBoundingBox;
import brickbreaker.model.gameObjects.power.TypePower;

public class WorldFactory {

    private static final Double WORLD_WIDTH = 8.0;
    private static final Double WORLD_HEIGHT = 6.0;

    private static WorldFactory instance;

    private WorldFactory() {

    }

    public static WorldFactory getInstance() {
        if (instance == null) {
            instance = new WorldFactory();
        }

        return instance;
    }
    
    public World getBasicWorld(final String name) {

        GameMap map = new GameMap();
        GameFactory f = new GameFactory();
        RectBoundingBox boundary = new RectBoundingBox(new P2d(WORLD_WIDTH/2, WORLD_HEIGHT/2), WORLD_WIDTH, WORLD_HEIGHT);
        World w = new WorldImpl(boundary);

        //TODO: Add actual parameters.
        w.setBar(f.createBar(null));
        w.addBall(f.createBall(null, null));
        w.addBricks(f.createBricks(map.LoadMap(name), map.getMapColumns(), map.getMapLines()));

        return w;
    }

    public World getWorld(final String name, final Integer bonusPercentage) {

        World w = this.getBasicWorld(name);
        Integer bonusQuantity = (w.getBricks().size() / 100) * bonusPercentage;

        if (bonusQuantity < w.getBricks().size()) {
            Integer malusQuantity = (w.getBricks().size() - bonusQuantity) / 2;

            List<TypePower> typePowerList = getWorldPowerUp(bonusQuantity, true);
            typePowerList.addAll(getWorldPowerUp((malusQuantity)/2, false));
            
            randomPowerUpAssignament(w.getBricks(), getWorldPowerUp(bonusQuantity, true));
        }

        return w;
    }

    public World getScalableDifficultyWorld(final String name, final World current, final boolean easier) {
        
        World w = this.getBasicWorld(name);
        Integer bonusQuantity = (int) current.getBricks().stream()
        .filter(item -> item.getPowerUp().type == "POSITIVE").count();

        if (easier) {
            bonusQuantity++;
            bonusQuantity = bonusQuantity > w.getBricks().size() ? w.getBricks().size() : bonusQuantity;
        } else {
            bonusQuantity--;
            bonusQuantity = bonusQuantity < 0 ? 0 : bonusQuantity;
        }

        List<TypePower> p = getWorldPowerUp(bonusQuantity, true);
        p.addAll(getWorldPowerUp(w.getBricks().size() - bonusQuantity, false));
        randomPowerUpAssignament(w.getBricks(), p);

        return w;
    }

    public World getDifficultyClassWorld(final String name, final Difficulty diff) {
        return this.getWorld(name, diff.getBonusPercentage());
    }

    private void randomPowerUpAssignament(final List<Brick> b, final List<TypePower> p){
        Integer diff = b.size() - p.size();
        Random random = new Random();
        if(diff > 0){
            p.addAll(Collections.nCopies(diff, TypePower.NULL));
        }
        for(Brick brick : b){
            brick.setPowerUp(p.remove(random.nextInt(p.size())));
        }
    }

    /**
     * This method returns a list of TypePower which are the power up types that are
     * present in the current World.
     * @param pQuantity is the power up quantity value.
     * @param bonus is true if the powerup to fill 
     * @return
     */
    private List<TypePower> getWorldPowerUp(final Integer pQuantity, final boolean bonus) {
        List<TypePower> p = new ArrayList<>();
        Random r = new Random();
        List<TypePower> types = TypePower.getElement(bonus ? "POSITIVE" : "NEGATIVE");

        for (int i = 0; i < pQuantity; i++) {
            Integer randomChoice = r.nextInt(types.size());
            p.add(types.get(randomChoice));
        }

        return p;
    }
}

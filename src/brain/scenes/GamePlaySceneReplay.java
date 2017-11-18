package brain.scenes;

import bases.GameObject;
import bases.Scene;
import brain.FallingObjects.SpawnerManagerReplay;
import brain.background.*;
import brain.playershape.PlayerLeftShape;
import brain.playershape.PlayerRightShape;

public class GamePlaySceneReplay implements Scene {
    @Override
    public void init() {
        GameObject.add(new BackGround());

        GameObject.add(new Score());

        GameObject.add(new LightEffect1());

        GameObject.add(new LightEffect2());

        GameObject.add(new LightEffect3());

        GameObject.add(new LightEffect4());

        GameObject.add(new LightEffect5());

        GameObject.add(new LightEffect_Am2());

        GameObject.add(new LightEffect_Am3());

        GameObject.add(new PlayerRightShape());

        GameObject.add(new PlayerLeftShape());

        GameObject.add(new SpawnerManagerReplay());

        GameObject.add(new LifesOfPlayer());

    }

    @Override
    public void deinit() {
GameObject.clearAll();
    }
}

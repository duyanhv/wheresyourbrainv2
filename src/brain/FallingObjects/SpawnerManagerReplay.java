package brain.FallingObjects;

import bases.GameObject;
import bases.Vector2D;
import bases.actions.Action;
import bases.actions.ActionSequence;
import bases.actions.ActionWait;
import brain.traps.TrapSpawner;

public class SpawnerManagerReplay extends GameObject {
    Spawner leftSpawner;
    Spawner rightSpawner;

    public SpawnerManagerReplay(){
//        Action waitAction = new ActionWait(1200);
//        Action waitAction2 = new ActionWait(1200);
        Action waitAction3 = new ActionWait(1200);
    //    Action waitAction0 = new ActionWait(500);







        Action fallingBothAction = new Action() {
            @Override
            public boolean run(GameObject owner) {

                leftSpawner = new Spawner(new Vector2D(105,-20));
                rightSpawner = new Spawner(new Vector2D(300,-20));
                GameObject.add(leftSpawner);
                GameObject.add(rightSpawner);
                return true;
            }

            @Override
            public void reset() {

            }
        };

        Action trapAction = new Action() {
            @Override
            public boolean run(GameObject owner) {
                GameObject.add(new TrapSpawner());
                return true;
            }

            @Override
            public void reset() {

            }
        };


        Action actionSequence = new ActionSequence(fallingBothAction, waitAction3, trapAction);
        this.addAction(actionSequence);






    }

}

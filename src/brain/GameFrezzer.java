package brain;

import bases.FrameCounter;
import brain.input.InputManager;

/**
 * Created by duyanh on 11/5/17.
 */
public class GameFrezzer {
    int frezzeCount = 0;
    public boolean isPause;
    FrameCounter frameCounter  = new FrameCounter(1);

    public static GameFrezzer instance;
    InputManager inputManager = InputManager.instance;

//    public GameFrezzer() {
//        instance = this;
//    }

    public void run() {
        if (frameCounter.run()) {
            frameCounter.reset();
            if (frezzeCount == 0) {
                isPause = true;
            }

            if(inputManager.spacePressed){
                isPause = false;
            }
        }
    }
}

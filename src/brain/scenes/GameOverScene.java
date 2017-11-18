package brain.scenes;

import bases.GameObject;
import bases.ImageRenderer;
import bases.Scene;
import bases.SceneManager;
import brain.input.InputManager;

public class GameOverScene extends GameObject implements Scene {
    @Override
    public void init() {

        GameObject background = new GameObject();
        background.renderer = new ImageRenderer("assets/images/Scenes/GameOverScene.png");
        background.position.set(192,300);
        GameObject.add(background);
        GameObject.add(new GameOverScene());

    }

    @Override
    public void run() {
        InputManager inputManager= InputManager.instance;


            if(inputManager.xPressed){
                SceneManager.changeScene(new GameReplayScene());

            }

        }



    @Override
    public void deinit() {

    }

}

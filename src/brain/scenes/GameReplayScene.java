package brain.scenes;

import bases.GameObject;
import bases.ImageRenderer;
import bases.Scene;
import bases.SceneManager;
import brain.background.LifesOfPlayer;

public class GameReplayScene extends GameObject implements Scene {

    public GameReplayScene(){
        LifesOfPlayer.life = 3;
    }
    @Override
    public void run() {
        SceneManager.changeScene(new GamePlaySceneReplay());
    }

    @Override
    public void init() {
        GameObject background = new GameObject();
        background.renderer = new ImageRenderer("assets/images/Scenes/GameOverScene.png");
        background.position.set(192,300);
        GameObject.add(background);
        GameObject.add(new GameReplayScene());
    }

    @Override
    public void deinit() {
        GameObject.clearAll();

    }
}

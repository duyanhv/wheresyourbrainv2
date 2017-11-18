package bases;

import brain.FallingObjects.FallingObjects;
import brain.input.InputManager;

import java.awt.*;
import java.util.Vector;

/**
 * Created by duyanh on 10/31/17.
 */
public class GameObject implements GameController{
    public Vector2D position;

    public static boolean isPause;
    
    public Renderer renderer;
    
    public boolean isActive;
    
    static Vector<GameObject> gameObjects = new Vector<>();
    
    static Vector<GameObject> newGameObjects = new Vector<>();

    static Vector<GameObject> rmGameObects = new Vector<>();

    public GameObject(){
        position = new Vector2D();
        isActive = true;
        isPause = false;
    }
    public static void add(GameObject gameObject){
        newGameObjects.add(gameObject);
    }

    public void render(Graphics g) {
        if(renderer != null){
            renderer.render(g,position);
        }
    }



    public void reset(){
        isActive = true;
    }

    public static <T extends GameObject> T recycle (Class<T> cls){
        for(GameObject gameObject : gameObjects){
            if(gameObject.getClass().equals(cls)){
                if(!gameObject.isActive){
                    gameObject.reset();

                    return (T) gameObject;
                }
            }
        }

        try {
            T newGameObject = cls.newInstance(); // = new
            add(newGameObject);
            return newGameObject;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void run() {

    }
    
    public static void runAll(){

            for(GameObject gameObject : gameObjects){
                if(gameObject.isActive){
                    gameObject.run();
                }
            }

        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
        gameObjects.removeAll(rmGameObects);
        rmGameObects.clear();
    }

    public static void remove(GameObject gameObject){
        rmGameObects.add(gameObject);
    }

    public static void renderAll(Graphics g){
        for(GameObject gameObject : gameObjects){
            if(gameObject.isActive ){
                gameObject.render(g);
            }
        }
    }


    @Override
    public void setPauseGame() {


    }
}

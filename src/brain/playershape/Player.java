package brain.playershape;

import bases.GameObject;
import bases.ImageRenderer;
import bases.Renderer;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import brain.input.InputManager;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by duyanh on 11/1/17.
 */
public class Player extends GameObject implements PhysicsBody{
    BoxCollider boxCollider;
    ArrayList<Renderer> listShape = new ArrayList<>();

    Renderer shape1;
    Renderer shape2;

    public Player(){


        position.set(192,500);

        boxCollider = new BoxCollider(20,20);

//        this.renderer = new ImageRenderer("assets/shape/circle.png");

        shape1 = new ImageRenderer("assets/shape/circle.png");

        shape2 = new ImageRenderer("assets/shape/Rectangle.png");

        this.renderer = shape1;

        listShape.add(shape1);

        listShape.add(shape2);

    }

    private void changeShape(){
        InputManager inputManager = InputManager.instance;
        if(inputManager.jPressed){
            this.renderer = shape2;

//            System.out.println("j is pressed");
        }

        if(inputManager.fPressed){
            this.renderer = shape1;
//            System.out.println("f is pressed");
        }

    }

    public void run(){
        changeShape();

        boxCollider.position.set(this.position);
    }


    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }

    @Override
    public void setIsActive(boolean isActive) {

    }
}

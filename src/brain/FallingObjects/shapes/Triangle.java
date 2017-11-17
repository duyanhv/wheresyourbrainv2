package brain.FallingObjects.shapes;


import bases.Animation;
import bases.GameObject;
import bases.ImageRenderer;
import bases.Utils;
import brain.FallingObjects.FallingObjects;
import brain.background.ParticleEffect;
import brain.background.Score;
import brain.playershape.PlayerLeftShape;
import brain.playershape.PlayerRightShape;

import java.awt.*;
import java.util.Random;

public class Triangle extends FallingObjects {

    public final int type = 2;

    public Triangle(){
        super();
//        this.renderer = new ImageRenderer("assets/shape/Triangle.png");
        this.renderer = new Animation(
                Utils.loadImage("assets/shape/Triangle.png"),
                Utils.loadImage("assets/shape/Triangle1.png"),
                Utils.loadImage("assets/shape/Triangle2.png"),
                Utils.loadImage("assets/shape/Triangle3.png"),
                Utils.loadImage("assets/shape/Triangle4.png"),
                Utils.loadImage("assets/shape/Triangle5.png")
        );
    }

    @Override
    public void run() {
        super.run();
        collide();
    }
    public void addParticle(boolean bool){

        int size = (int) (Math.random()*12);
//        int life = (int) Math.random()*(120)+380;
        int life =  100;

        GameObject.add(new ParticleEffect(position.x,position.y,size,life, Color.blue,bool));



    }


    public void collide(){
        if(this.position.x < 200){
            if(this.hitBox.collideWith(PlayerLeftShape.boxCollider) && this.type == PlayerLeftShape.currentType){
                Score.addScore(1);
                this.isActive = false;
                addParticle(true);addParticle(false);addParticle(true);
                addParticle(false);addParticle(true);addParticle(false);
                addParticle(true);addParticle(false);addParticle(true);
                addParticle(false);addParticle(true);addParticle(false);
                GameObject.remove(this);
            }
        }
        if(this.position.x > 200){
            if(this.hitBox.collideWith(PlayerRightShape.boxCollider) && this.type == PlayerRightShape.currentType ){
                Score.addScore(1);
                addParticle(true);addParticle(false);addParticle(true);
                addParticle(false);addParticle(true);addParticle(false);
                addParticle(true);addParticle(false);addParticle(true);
                addParticle(false);addParticle(true);addParticle(false);
                GameObject.remove(this);
            }
        }


    }
}

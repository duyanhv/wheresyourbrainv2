package brain.FallingObjects.shapes;

import bases.*;
import brain.FallingObjects.FallingObjects;
import brain.background.ParticleEffect;
import brain.background.Score;
import brain.playershape.PlayerLeftShape;
import brain.playershape.PlayerRightShape;

import java.awt.*;
import java.util.Random;


public class Circle extends FallingObjects {

    public final int type = 0;
    ParticleEffect pe;

    public Circle(){
        super();
//this.renderer = new ImageRenderer("assets/shape/circle.png");
        this.renderer = new Animation(
                Utils.loadImage("assets/shape/circle.png"),
                Utils.loadImage("assets/shape/circle1.png"),
                Utils.loadImage("assets/shape/circle2.png"),
                Utils.loadImage("assets/shape/circle3.png"),
                Utils.loadImage("assets/shape/circle4.png"),
                Utils.loadImage("assets/shape/circle5.png"),
                Utils.loadImage("assets/shape/circle6.png")

        );
        pe = new ParticleEffect();
    }

    @Override
    public void run() {
        super.run();
        collide();
    }

    public void addParticle(boolean bool){
        Random rdm = new Random();

        float dx,dy;
        if(bool){
//            dx = (int) ((Math.random())*5);
//            dy = (int) ((Math.random())*5);
            dx =  ((rdm.nextInt(10) - 5));
            dy =  ((rdm.nextInt(10) - 5));
        }
        else{
            dx =  ((rdm.nextInt(10) - 5));
            dy =  ((rdm.nextInt(10) - 5));
        }
        int size = (int) (Math.random()*12);
//        int life = (int) Math.random()*(120)+380;
        int life =  100;


        GameObject.add(new ParticleEffect(position.x,position.y,dx,dy,size,life, Color.yellow));



    }


    public void collide(){
        if(this.position.x < 200){
            if(this.hitBox.collideWith(PlayerLeftShape.boxCollider) && this.type == PlayerLeftShape.currentType){
                Score.addScore(1);

                addParticle(true);addParticle(false);addParticle(true);
                addParticle(false);addParticle(true);addParticle(false);
                addParticle(true);addParticle(false);addParticle(true);
                addParticle(false);addParticle(true);addParticle(false);

                GameObject.remove(this);//remove object from gameobject vector
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

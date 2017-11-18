package brain.FallingObjects.shapes;


import bases.GameObject;
import bases.ImageRenderer;
import brain.FallingObjects.FallingObjects;
import brain.background.ParticleEffect;
import brain.background.Score;
import brain.playershape.PlayerLeftShape;
import brain.playershape.PlayerRightShape;

import java.awt.*;


public class Diamond extends FallingObjects {

    public final int type = 3;
    public Diamond(){
        super();
        this.renderer = new ImageRenderer("assets/shape/Diamond.png");
    }

    @Override
    public void run() {
        super.run();
        collide();
    }

    public void addParticle(boolean bool){
        float dx,dy;
        if(bool){
            dx = (int) (Math.random()*5);
            dy = (int) (Math.random()*5);
        }
        else{
            dx = (int) (Math.random()*-5);
            dy = (int) (Math.random()*-5);
        }
        int size = (int) (Math.random()*12);
        int life = (int) Math.random()*(120)+380;

        GameObject.add(new ParticleEffect(position.x,position.y,dx,dy,size,life, Color.blue));
    }

    public void collide(){
        if(this.position.x < 200){
            if(this.hitBox.collideWith(PlayerLeftShape.boxCollider) && this.type == PlayerLeftShape.currentType){
                Score.addScore(1);

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

                GameObject.remove(this);
            }
        }

    }
}

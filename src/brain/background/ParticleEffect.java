package brain.background;

import bases.GameObject;
import brain.FallingObjects.FallingObjects;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 * Created by duyanh on 11/4/17.
 */
public class ParticleEffect extends GameObject {
    public float x;
    public float y;

    public float dx;

    public float dy;

    public float size;

    public float life;

    public Color color;

    public boolean bool;

    public ParticleEffect(float x, float y, float size, float life, Color color,boolean bool) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.life = life;
        this.color = color;
        this.bool = bool;
        generateAngle(this.bool);
    }
    public ParticleEffect(){

    }

    public void generateAngle(boolean bool){
        Random rdm = new Random();
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
    }

    public boolean update(){


//        float dx,dy;


        x += dx;

        y += dy;

        life--;

        if(life <= 0 || dx == 0 || dy == 0){
            return true;
        }

        return false;

    }



    @Override
    public void run() {
        super.run();
        if(update()){
            GameObject.remove(this);
        }
    }

    @Override
    public void render(Graphics g) {
        super.render(g);

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(color);

        Rectangle2D.Double rect = new Rectangle2D.Double(x - (size / 2), y - (size / 2), size, size);

//        g2d.fillRect(rect);

        g2d.draw(rect);

        g2d.fill(rect);

        g2d.dispose();
    }




}

package ie.tudublin;

import processing.core.PVector;

public class Missile extends GameObject
{
    public Missile(SC sc, float x, float y, float rotation)
    {
        super(sc, x, y, rotation, 5);
    }  

    public void render()
    {
        sc.pushMatrix();
        sc.translate(pos.x, pos.y);
        sc.rotate(rotation);
        sc.line(0, -5, 0, 5);
        sc.popMatrix();
    }

    public void checkCollisions()
    {
        float dist=0;
        //System.out.println(sc.wraithO.size());
        for(int i= sc.phoneixO.size() - 1; i >= 0; i--)
        {
            Phoneix w = sc.phoneixO.get(i);
            dist = PVector.dist(w.getPos(), pos);
            //System.out.println(sc.wraith.getPos() + " " + pos);
            if (dist < w.size / 2 && dist > 0)
            {
                //System.out.println(sc.wraith.getPos() + " " + pos);
                w.setHealth(w.getHealth() - 1);
                sc.gameObjects.remove(this);
            }
            
        }
        
    }

    public void update()
    {
        // static methods on the Math class
        forward.x = (float)Math.sin(rotation);
        forward.y = - (float)Math.cos(rotation);

        // pos += forward * speed
        pos.add(PVector.mult(forward, speed));

        // bullet exceed frame border
        if (pos.x < 0 || pos.x > sc.width || pos.y < sc.height * 1/ 7 || pos.y > sc.height * 5 / 7)
        {
            sc.gameObjects.remove(this);
        }
        alive += sc.timeDelta;
        if (alive >= 5.0)
        {
            sc.gameObjects.remove(this);
        }
        checkCollisions();
    }

    float alive;

}
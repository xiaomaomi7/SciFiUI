package ie.tudublin;

import processing.core.PVector;

public class Beam extends GameObject
{
    public Beam(SC sc, float x, float y, float rotation)
    {
        super(sc, x, y, rotation, 5);
    }  

    public void render()
    {
        sc.stroke(127,sc.random(255),sc.random(255));
        sc.pushMatrix();
        sc.translate(pos.x, pos.y);
        sc.rotate(rotation);
        sc.line(0, -7, 0, 7);
        sc.popMatrix();
    }

    public void checkCollisions()
    {
        float dist=0;
        //System.out.println(sc.wraithO.size());
        for(int i= sc.wraithO.size() - 1; i >= 0; i--)
        {
            Wraith w = sc.wraithO.get(i);
            dist = PVector.dist(w.getPos(), pos);
            //System.out.println(sc.wraith.getPos() + " " + pos);
            if (dist < w.size / 2 && dist > 0)
            {
                //System.out.println(sc.wraith.getPos() + " " + pos);
                w.setHealth(w.getHealth() - (sc.pAttack-sc.tArmor));
                if (w.getHealth() <= 0)
                {
                    sc.scoreP +=1;
                    sc.gameObjects.remove(w);
                    sc.wraithO.remove(w);
                    sc.tSupply -= 2;
                }
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
        if (alive >= 10.0)
        {
            sc.gameObjects.remove(this);
        }
        checkCollisions();
    }

    float alive;

}
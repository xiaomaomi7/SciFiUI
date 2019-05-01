package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class Phoneix extends GameObject
{
    float size;
    public int fireRate;
    private float toPass;
    private float ellapsed;
    private int health = sc.pHealth;
    private ArrayList<PVector> waypoints = new ArrayList<PVector>(); 

    public Phoneix(SC sc, float x, float y, float speed, float size)
    {
        super(sc, x, y, 0, 50);
        this.size = size;
        fireRate = 1;
        toPass = 1 / (float) fireRate;

        for(int i = 0 ; i < 5 ; i ++)
        {
            
            float r1 = sc.random(0,sc.width);
            float r2 = sc.random(0,sc.height * 4 / 7) + (sc.height * 1 / 7);
            System.out.println(r1 + " " + r2 );
            waypoints.add(new PVector(r1, r2));
        }

    }
    
    public void render()
    {
        sc.pushMatrix();
        sc.translate(pos.x, pos.y);
        sc.rotate(rotation-1.5f);
        sc.stroke(0, 0, 255);
        float halfSize = size / 2;
        sc.noFill();
        sc.rect(-(halfSize / 2),-(halfSize / 4), halfSize , halfSize / 2);
        sc.quad((halfSize / 2),-(halfSize / 4),(halfSize / 4),0 ,(halfSize / 2),halfSize / 4,(halfSize),0);

        sc.line(-(halfSize / 2),-(halfSize / 4), -halfSize , - (halfSize / 4));
        sc.line(-(halfSize),-(halfSize / 4), 0 , - (halfSize / 3));
        sc.line(-(halfSize * 3 / 8),-(halfSize / 2), 0 , - (halfSize / 2));
        sc.line(-(halfSize * 3 / 8),-(halfSize / 4), -(halfSize * 3 / 8) , - (halfSize / 2));
        
        sc.line(-(halfSize / 8),-(halfSize / 4), halfSize *3 /4 , - (halfSize* 3 /2));
        sc.line( halfSize *3 /4 , - (halfSize* 3 /2),  halfSize / 2,-(halfSize / 4));

        sc.line(-(halfSize / 2),(halfSize / 4), -halfSize ,  (halfSize / 4));
        sc.line(-(halfSize),(halfSize / 4), 0 ,  (halfSize / 3));
        sc.line(-(halfSize * 3 / 8),(halfSize / 2), 0 ,  (halfSize / 2));
        sc.line(-(halfSize * 3 / 8),(halfSize / 4), -(halfSize * 3 / 8) ,  (halfSize / 2));
        
        sc.line(-(halfSize / 8),(halfSize / 4), halfSize *3 /4 ,  (halfSize* 3 /2));
        sc.line( halfSize *3 /4 ,  (halfSize* 3 /2),  halfSize / 2,(halfSize / 4));


        sc.popMatrix();

        for(int i = 1 ; i <= waypoints.size() ; i ++)
        {
            PVector a = waypoints.get(i - 1);
            PVector b = waypoints.get(i % waypoints.size());
            sc.stroke(255, 0, 0);
            //sc.line(a.x, a.y, b.x, b.y);
        }
        sc.fill(255);    
        //sc.text("hp:" + health, pos.x + 30, pos.y);
        
        sc.fill(0,255,0);
        int hpBarNo = health * 10 / sc.pHealth ;
        for (int i = 0; i < hpBarNo; i ++){
            sc.rect(pos.x + 30 + i * 2, pos.y, 2, 2);
        }
    }

    int current = 0;

    public void update()
    {
        PVector toNext = PVector.sub(waypoints.get(current), pos);
        float dist = toNext.mag();
        toNext.normalize();
        pos.add(toNext);
        pos.add(toNext);
        rotation = (float) Math.atan2(toNext.y, toNext.x) + PApplet.HALF_PI;
        if (dist < 2)
        {
            current = (current + 1) % waypoints.size();
        }
        if (ellapsed >= toPass)
        {
            PVector spawnPoint = PVector.add(pos, PVector.mult(forward, 25));
            Beam b = new Beam(sc, spawnPoint.x, spawnPoint.y, rotation);
            sc.gameObjects.add(b);
            ellapsed = 0;
        }
        ellapsed += sc.timeDelta;
        //sc.text("Ellapsed: "+ ellapsed, 10, 200);
    }

    /**
     * @return the size
     */
    public float getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(float size) {
        this.size = size;
    }

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * @return the waypoints
     */
    public ArrayList<PVector> getWaypoints() {
        return waypoints;
    }

    /**
     * @param waypoints the waypoints to set
     */
    public void setWaypoints(ArrayList<PVector> waypoints) {
        this.waypoints = waypoints;
    }

    /**
     * @return the current
     */
    public int getCurrent() {
        return current;
    }

    /**
     * @param current the current to set
     */
    public void setCurrent(int current) {
        this.current = current;
    }

    /**
     * @return the fireRate
     */
    public int getFireRate() {
        return fireRate;
    }

    /**
     * @param fireRate the fireRate to set
     */
    public void setFireRate(int fireRate) {
        this.fireRate = fireRate;
    }

    /**
     * @return the toPass
     */
    public float getToPass() {
        return toPass;
    }

    /**
     * @param toPass the toPass to set
     */
    public void setToPass(float toPass) {
        this.toPass = toPass;
    }

    /**
     * @return the ellapsed
     */
    public float getEllapsed() {
        return ellapsed;
    }

    /**
     * @param ellapsed the ellapsed to set
     */
    public void setEllapsed(float ellapsed) {
        this.ellapsed = ellapsed;
    }
}
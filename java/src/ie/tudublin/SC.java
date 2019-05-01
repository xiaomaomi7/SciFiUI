package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class SC extends PApplet
{
    boolean[] keys = new boolean[1024];

    public ArrayList<GameObject> gameObjects = new ArrayList<GameObject>(); 
    public ArrayList<Wraith> wraithO = new ArrayList<Wraith>(); 
    public ArrayList<Phoneix> phoneixO = new ArrayList<Phoneix>(); 
    Wraith wraith;
    Frame frame;
    Phoneix phoneix;

    public int scoreP = 0;
    public int scoreT = 0;

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    public void keyReleased()
    {
        keys[keyCode] = false;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    
    public void settings()
    {
        size(2500, 1500);        
    }

    public float randomX(){
        return(random(0,width));
    }

    public float randomY(){
        return(random(0,height * 4 / 7) + (height * 1 / 7));
    }
    public void setup()
    {
        for(int i = 0; i < 5; i++)
        {
            wraith = new Wraith(this, randomX(), randomY(), 5, 50);
            gameObjects.add(wraith);
            wraithO.add(wraith);
            phoneix = new Phoneix(this, randomX(), randomY(), 5, 50);
            gameObjects.add(phoneix);
            phoneixO.add(phoneix);
        }
        
        
        frame = new Frame(this);
    }

    public float timeDelta;
    private float last;
    public void draw()
    {
        
        


        float now = millis();
        timeDelta = (now - last) / 1000.0f;
        last = now;
        background(255);
        frame.render();
        fill(0);
        textSize(20);
        text("Mineral: " + gameObjects.size(), 50, 50);
        text("Supply: " + gameObjects.size(), 50, 100);
        text("Score: " + scoreT, 50, 150);
        text("Mineral: " + gameObjects.size(), width - 200, 50);
        text("Supply: " + gameObjects.size(), width - 200, 100);
        text("Score: " + scoreP, width - 200, 150);
        for(int i= gameObjects.size() - 1; i >= 0; i--)
        {
            GameObject b = gameObjects.get(i);
            b.render();
            b.update();
            
        }
        update();
    }   
    public void update(){
        alive += timeDelta;
        if (alive >= 3.0)
        {
            phoneix = new Phoneix(this, randomX(), randomY(), 5, 50);
            gameObjects.add(phoneix);
            phoneixO.add(phoneix);
            wraith = new Wraith(this, randomX(), randomY(), 5, 50);
            gameObjects.add(wraith);
            wraithO.add(wraith);
            alive = 0;
        }
    }     
    float alive;
}



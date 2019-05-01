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

    public void setup()
    {
        for(int i = 0; i < 10; i++)
        {
            wraith = new Wraith(this, i * 100, height / 2, 5, 50);
            gameObjects.add(wraith);
            wraithO.add(wraith);
        }
        
        phoneix = new Phoneix(this, 750, height / 2, 5, 50);
        gameObjects.add(phoneix);
        phoneixO.add(phoneix);
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
        text("GameObjects: " + gameObjects.size(), 50, 100);
        for(int i= gameObjects.size() - 1; i >= 0; i--)
        {
            GameObject b = gameObjects.get(i);
            b.render();
            b.update();
            
        }
    }        
}



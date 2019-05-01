package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class SC extends PApplet
{
    boolean[] keys = new boolean[1024];

    public ArrayList<GameObject> gameObjects = new ArrayList<GameObject>(); 
    public ArrayList<Wraith> wraithO = new ArrayList<Wraith>(); 
    public ArrayList<Phoneix> phoneixO = new ArrayList<Phoneix>(); 
    public ArrayList<Button> buttonO = new ArrayList<Button>(); 
    Wraith wraith;
    Frame frame;
    Phoneix phoneix;

    public int scoreP = 0;
    public int scoreT = 0;
    public int pAttack = 6;
    public int pArmor = 1;
    public int pHealth = 100;
    public int pSupply = 0;
    public int pSupplyL = 30;
    public int pMins = 0;
    public int tAttack = 7;
    public int tArmor = 1;
    public int tHealth = 80;
    public int tSupply = 0;
    public int tSupplyL = 30;
    public int tMins = 0;

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

            pSupply += 2; tSupply += 2;
        }
        
        Button t1 = new Button(this, width /2 , height /2, width, height, "good day" );
        buttonO.add(t1);
        frame = new Frame(this);
    }

    public float timeDelta;
    private float last;
    public void draw()
    {
        float now = millis();
        timeDelta = (now - last) / 1000.0f;
        last = now;
        background(0);

        frame.render();
        
        fill(0);
        textSize(100);
        fill(255);
        text("Starcraft II", width /2 - 200 , 100);
        textSize(20);
        fill(255);
        text("Mineral: " + tMins, 50, 50);
        text("Supply: " + tSupply + "/" + tSupplyL, 50, 100);
        text("Score: " + scoreT, 50, 150);
        text("Mineral: " + pMins, width - 200, 50);
        text("Supply: " + pSupply + "/" + pSupplyL, width - 200, 100);
        text("Score: " + scoreP, width - 200, 150);
        for(int i= gameObjects.size() - 1; i >= 0; i--)
        {
            GameObject b = gameObjects.get(i);
            b.render();
            b.update();
            
        }
        for(int i= buttonO.size() - 1; i >= 0; i--)
        {
            Button b = buttonO.get(i);
            b.render();
            
        }
        update();
    }   
    public void update(){
        alive += timeDelta;
        mTime += timeDelta;
        if (alive >= 3.0)
        {
            if (pSupply < pSupplyL){
                phoneix = new Phoneix(this, randomX(), randomY(), 5, 50);
                gameObjects.add(phoneix);
                phoneixO.add(phoneix);
                pSupply += 2;
            }
            if (tSupply < tSupplyL){
                wraith = new Wraith(this, randomX(), randomY(), 5, 50);
                gameObjects.add(wraith);
                wraithO.add(wraith);
                tSupply += 2;
            }
            
            alive = 0;
        }

        if (mTime >= 0.2)
        {
            tMins += 1;
            pMins += 1;
            mTime = 0;
        }
    }     
    float alive; float mTime;
}



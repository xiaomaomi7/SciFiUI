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
    public void mousePressed() {
        if (mouseX >= 200 && mouseX <= 300 && tMins >= 100){ 
            if (mouseY >= (height * 5 / 7 + 75) && mouseY <= (height * 5 / 7 + 125)) {
                tAttack++;
                tMins -=100;
            } else if (mouseY >= (height * 5 / 7 + 175) && mouseY <= (height * 5 / 7 + 225)){
                tArmor++;
                tMins -=100;
            } else if (mouseY >= (height * 5 / 7 + 275) && mouseY <= (height * 5 / 7 + 325)){
                tHealth += 15;
                tMins -=100;
            } else if (mouseY >= (height * 5 / 7 + 375) && mouseY <= (height * 5 / 7 + 425)){
                tSupplyL += 5;
                tMins -=100;
            }
        } 
        if (mouseX >=  (width * 8 /10 + 200) && mouseX <= ( width * 8 /10 + 300) && pMins >= 100){ 
            if (mouseY >= (height * 5 / 7 + 75) && mouseY <= (height * 5 / 7 + 125)) {
                pAttack++;
                pMins -=100;
            } else if (mouseY >= (height * 5 / 7 + 175) && mouseY <= (height * 5 / 7 + 225)){
                pArmor++;
                pMins -=100;
            } else if (mouseY >= (height * 5 / 7 + 275) && mouseY <= (height * 5 / 7 + 325)){
                pHealth += 15;
                pMins -=100;
            } else if (mouseY >= (height * 5 / 7 + 375) && mouseY <= (height * 5 / 7 + 425)){
                pSupplyL += 5;
                pMins -=100;
            }
        } 
    }

public void mouseMoved() {
        textAlign(CENTER,CENTER);
        int n1 = width / 5;
        int n2 = height * 5 / 7;
        int n3 = width * 3 / 5;
        int n4 = height * 2 / 7;
        if (mouseX >= 200 && mouseX <= 300){ 
            if (mouseY >= (height * 5 / 7 + 75) && mouseY <= (height * 5 / 7 + 125)) {
                textSize(100); fill(random(255),random(255),random(255)); 
                text("Attack + 1, Cost 100 mins", n1, n2, n3, n4);
            } else if (mouseY >= (height * 5 / 7 + 175) && mouseY <= (height * 5 / 7 + 225)){
                textSize(100); fill(random(255),random(255),random(255));
                text("Armor + 1, Cost 100 mins",n1, n2, n3, n4);
            } else if (mouseY >= (height * 5 / 7 + 275) && mouseY <= (height * 5 / 7 + 325)){
                textSize(100); fill(random(255),random(255),random(255));
                text("Hit Point + 15, Cost 100 mins", n1, n2, n3, n4);
            } else if (mouseY >= (height * 5 / 7 + 375) && mouseY <= (height * 5 / 7 + 425)){
                textSize(100); fill(random(255),random(255),random(255));
                text("Supply limit + 5, Cost 100 mins", n1, n2, n3, n4);
            }
        } 
        if (mouseX >=  (width * 8 /10 + 200) && mouseX <= ( width * 8 /10 + 300)){ 
            if (mouseY >= (height * 5 / 7 + 75) && mouseY <= (height * 5 / 7 + 125)) {
                textSize(100); fill(random(255),random(255),random(255));
                text("Attack + 1, Cost 100 mins", n1, n2, n3, n4);
            } else if (mouseY >= (height * 5 / 7 + 175) && mouseY <= (height * 5 / 7 + 225)){
                textSize(100); fill(random(255),random(255),random(255));
                text("Armor + 1, Cost 100 mins", n1, n2, n3, n4);
            } else if (mouseY >= (height * 5 / 7 + 275) && mouseY <= (height * 5 / 7 + 325)){
                textSize(100); fill(random(255),random(255),random(255));
                text("Hit Point + 15, Cost 100 mins", n1, n2, n3, n4);
            } else if (mouseY >= (height * 5 / 7 + 375) && mouseY <= (height * 5 / 7 + 425)){
                textSize(100); fill(random(255),random(255),random(255));
                text("Supply limit + 5, Cost 100 mins", n1, n2, n3, n4);
            }
        } 
        textAlign(LEFT);
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
        for (int i = 0; i < 4; i++){
            Button button = new Button(this, 200 , height * 5 / 7 + 75 + i * 100, 100, 50, "upgrade" );
            buttonO.add(button);
            Button button2 = new Button(this, width * 8 /10 + 200 , height * 5 / 7 + 75 + i * 100, 100, 50, "upgrade" );
            buttonO.add(button2);
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
        background(0);

        frame.render();
        
        fill(0);
        textSize(100);
        fill(255);
        text("Starcraft II", width /2 - 200 , 150);
        textSize(20);
        fill(255);
        text("Mineral: " + tMins, 50, 50);
        text("Supply: " + tSupply + "/" + tSupplyL, 50, 100);
        text("Score: " + scoreT, 50, 150);
        text("Mineral: " + pMins, width - 200, 50);
        text("Supply: " + pSupply + "/" + pSupplyL, width - 200, 100);
        text("Score: " + scoreP, width - 200, 150);

        textSize(30);
        text("Protoss" , width / 10 * 9 - 50, height * 5 / 7 + 50);
        text("Terran" , width / 10 * 1 - 50, height * 5 / 7 + 50);
        textSize(20);
        text("Attack:" + tAttack , 20, height * 5 / 7 + 100);
        text("Armor:" + tArmor, 20, height * 5 / 7 + 200);
        text("HP:" + tHealth, 20, height * 5 / 7 + 300);
        text("Supply:" + tSupplyL, 20, height * 5 / 7 + 400);

        text("Attack:" + pAttack , width * 8 /10 + 20, height * 5 / 7 + 100);
        text("Armor:" + pArmor, width * 8 /10 + 20, height * 5 / 7 + 200);
        text("HP:" + pHealth,width * 8 /10 + 20, height * 5 / 7 + 300);
        text("Supply:" + pSupplyL, width * 8 /10 + 20, height * 5 / 7 + 400);
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
            textAlign(LEFT);
        }
        update();
        mouseMoved();
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



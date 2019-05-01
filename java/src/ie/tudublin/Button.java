package ie.tudublin;

import processing.core.PApplet;

public class Button
{
    
    private float x;
    private float y;
    private float width;
    private float height;
    private String text;
    protected SC sc;
    public Button(SC sc, float x, float y, float width, float height, String text)
    {
        this.sc = sc;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }

    public void render()
    {
        sc.textSize(20);
        sc.noFill();
        sc.stroke(255);
        sc.rect(x, y, width, height,7);
        sc.fill(255);
        sc.textAlign(PApplet.CENTER, PApplet.CENTER);
        sc.text(text, x + width * 0.5f, y + height * 0.5f);
    }
}
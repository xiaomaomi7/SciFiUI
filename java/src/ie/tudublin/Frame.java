package ie.tudublin;



import processing.core.PApplet;

public class Frame 
{
    protected SC sc;
    public Frame(SC sc)
    {
        this.sc = sc;
    }
    

    public void render()
    {
        // main frame
        sc.stroke(127, 0, 255); // purple

        // top
        sc.line(0,sc.height * 1/ 7, sc.width, sc.height * 1 / 7);
        sc.line(0,sc.height * 5/ 7, sc.width, sc.height * 5 / 7);

    }
    
}
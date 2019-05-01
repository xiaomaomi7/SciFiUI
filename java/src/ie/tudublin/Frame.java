package ie.tudublin;


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

        sc.line(sc.width / 10, 0, sc.width / 10, sc.height * 1 / 7);
        sc.line(sc.width * 9 / 10, 0, sc.width * 9 / 10, sc.height * 1 / 7);

        sc.line(sc.width / 5, sc.height * 5/ 7, sc.width / 5, sc.height);
        sc.line(sc.width * 4 / 5, sc.height * 5/ 7, sc.width * 4 / 5, sc.height);
    }
    
}
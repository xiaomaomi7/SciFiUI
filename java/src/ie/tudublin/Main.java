package ie.tudublin;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new UI());
		
	}

	public void sc()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new SC());
		
	}
	public static void main(String[] args)
	{
		Main main = new Main();
		main.sc();			
	}
}
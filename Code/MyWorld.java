import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Trang Tran) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    // use integers to determine your width, height, pixel of your world
    public static int WIDTH = 700;
    public static int HEIGHT = 600;
    public static int PIXEL =1;
    
    //use integers to make it easier for showing the instruction
    int xLoc = 350;
    int yLoc1=100;
    int yLoc2 = 150;
    int yLoc3 = 200;
    int yLoc4 = 250;
    int safeX = 675;
    int safeY = 475;
    
    public MyWorld()
    {    
        
        // Create a new world with 700x600 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, PIXEL); 
        
        
        //show the instruction for winning this game and how to start this game. You can use arrows as your remoter
        showText("Use arrows to move the penguin Tux.", xLoc, yLoc1);
        showText("Catch seven fish or 50 ballons in the color blue to win.", xLoc, yLoc2);
        showText("Touching a bomb will end the game.", xLoc, yLoc3);
        showText("Press |> Run to start then s.", xLoc, yLoc4);
        
        
    
    }
    //declare the method prepare in act and when pressing s you will start the game
    public void act()
    {   
        if (Greenfoot.isKeyDown("s"))
        { 
            prepare();
        }
    }
        
    

    private void prepare()
    {   //once s is hit the game will start the background change, the instruction will remove 
        setBackground("sand.jpg");
        
        showText(null, xLoc, yLoc1);
        showText(null, xLoc, yLoc2);
        showText(null, xLoc, yLoc3);
        showText(null, xLoc, yLoc4);
        
        //add objects like ballons, fish and a random bomb
        //add tux at the right bottom corner 
        Tux tux = new Tux();
        addObject(tux,getWidth()-50, getHeight()-50);
        //for loop for the 75  ballons getting random placed in the world beside at tux positions
        for (int i=0; i<= 74; i++)
        {
            int blueballonsX = Greenfoot.getRandomNumber (getWidth()-50);
            int blueballonsY = Greenfoot.getRandomNumber (getHeight()-50);
            
            BlueBallon blueballons = new BlueBallon();
            addObject(blueballons, blueballonsX, blueballonsY);
        }
        //for loop for the 10 fishes, they are getting random placed in the world beside at tux positions
        for (int j=0; j<= 9; j++)
        {
            int FishesX = Greenfoot.getRandomNumber (getWidth()-50);
            int FishesY = Greenfoot.getRandomNumber (getHeight()-50);
            
            Fish fishes = new Fish();
            addObject(fishes, FishesX, FishesY);
        }
        //for loop for the 15 bombs, they are getting random placed in the world. They are especially not at tux positions. 
        //Eitherwise the game will stop instantly
        for (int n=0; n< 14; n++)
        {
            int randombombsX = Greenfoot.getRandomNumber (getWidth()-100);
            int randombombsY = Greenfoot.getRandomNumber (getHeight()-80);
            
            RandomBomb randombombs = new RandomBomb();
            addObject(randombombs, randombombsX, randombombsY);
        }

}
}

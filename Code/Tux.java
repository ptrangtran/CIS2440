import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tux here.
 * 
 * @author (Trang Tran) 
 * @version (10/26/21)
 */
public class Tux extends Actor

{
    /**
     * Act - do whatever the Tux wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * declare methods checkKeyPress, look Out, and setSpeed
     */
    public void act()
    {   //methods to compile more activities
        checkKeyPress();
        lookOut();
        setSpeed();
    }
    public static void setSpeed()
    {   //set a random speed
        int speed = Greenfoot.getRandomNumber(100);
    }
    
    public void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("left")) 
        {
            setLocation(getX()-1, getY()); //tux can move to the left 
        }
        if (Greenfoot.isKeyDown("right")) 
        {
            setLocation(getX()+1, getY());  //tux can move to the right
        }
        if (Greenfoot.isKeyDown("up")) 
        {
            setLocation(getX(), getY()-1);  //tux can move up
        }
        if (Greenfoot.isKeyDown("down")) 
        {
            setLocation(getX(), getY()+1);  //tux can move down
        }
    }
    // integer to addscore for ballons and fishes
    private int ballonsPopped = 0;
    private int fishesCaught = 0;
    
    private void lookOut()
    {   //if tux is intersecting with a ballon it will play a sound, remove the ballon, add it to your ballon score
        if (isTouching(BlueBallon.class))
        {   
            removeTouching(BlueBallon.class);
            ballonsPopped++;
            getWorld().showText("Blue Ballon popped: " + ballonsPopped, 350, 500);
            Greenfoot.playSound("pop.wav");
            int toWin = 50; // once you collected 50 ballons you will win, the game will stop and play a sound too
            if (ballonsPopped == toWin)
            {
                Greenfoot.stop();
                getWorld().showText("You Won!", 350, 100);
                Greenfoot.playSound("fanfare.wav");
            }
        }
        // if tux is intersecting with a fish, it will play a sound, remove the fish, and add it to your fish score
        if (isTouching(Fish.class))
        { 
            removeTouching(Fish.class);
            fishesCaught++;
            getWorld().showText("Fishes Caught: " + fishesCaught, 350, 525);
            Greenfoot.playSound("pop.wav");
            int toWin = 7; //once you collected 7 fishes you will win the game and it will stop and play a sound
            if (fishesCaught == 7)
            { 
                Greenfoot.stop();
                getWorld().showText("You Won!", 350, 100);
                Greenfoot.playSound("fanfare.wav");
            }
            
        }
        // if tux is intersecting with a bomb, will play a sound, remove the fish, and you instantly lost the game
        if (isTouching(RandomBomb.class))
        {
            removeTouching(RandomBomb.class);
            Greenfoot.playSound("au.wav");
            Greenfoot.stop();
            getWorld().showText("Game Over, so sad.", 350, 100);
        }
}
}
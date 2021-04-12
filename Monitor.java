import java.util.Arrays;

/**
 * Class Monitor
 * To synchronize dining philosophers.
 */
public class Monitor
{
    /*
     * ------------
     * Data members
     * ------------
     */
    public boolean talk;
    public  int philosophers;
    public Chopstick[] Chopsticks;

    class Chopstick
    {
        boolean free;
        int prevuser;

        Chopstick()
        {
            free = true;
            prevuser = DiningPhilosophers.DEFAULT_NUMBER_OF_PHILOSOPHERS + 1;
        }

        void up(final int piTID)
        {
            free = false;
            prevuser = piTID;
        }

        void down(final int piTID)
        {
            free = true;
        }

        boolean unavailable(final int piTID)
        {
            return (piTID != prevuser) && !free;
        }
    }

    /**
     * Constructor
     */
    public Monitor(int piNumberOfPhilosophers)
    {
        talk = false;
        philosophers = piNumberOfPhilosophers;
        Chopsticks = new Chopstick[philosophers];
        Arrays.fill(Chopsticks, new Chopstick());
    }

    /**
     * Grants request (returns) to eat when both chopsticks/forks are available.
     * Else forces the philosopher to wait()
     */
    public synchronized void pickUp(final int piTID)
    {
        Chopstick leftPhilosopher = Chopsticks[piTID-1], rightPhilosopher = Chopsticks[piTID%philosophers];

        while(true)
        {
            // chopstick(s) are in use
            if ((leftPhilosopher.unavailable(piTID) || rightPhilosopher.unavailable(piTID)))
            {
                // pick up as many chopsticks as you can
                try
                {
                    if(leftPhilosopher.free && leftPhilosopher.prevuser!=piTID)
                    {
                        leftPhilosopher.up(piTID);
                    }

                    if(rightPhilosopher.free && rightPhilosopher.prevuser!=piTID)
                    {
                        rightPhilosopher.up(piTID);
                    }

                    wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            // free chopsticks
            else
            {
                leftPhilosopher.up(piTID);
                rightPhilosopher.up(piTID);
                break;
            }
        }
    }

    /**
     * When a given philosopher's done eating, they put the chopsticks/forks down
     * and let others know they are available.
     */
    public synchronized void putDown(final int piTID)
    {
        Chopsticks[piTID-1].down(piTID);
        Chopsticks[piTID%philosophers].down(piTID);
        notifyAll();
    }

    /**
     * Only one philosopher at a time is allowed to philosophy
     * (while she is not eating).
     */
    public synchronized void requestTalk()
    {
        while(true)
        {
            if(talk)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                talk = true;
                break;
            }
        }
    }

    /**
     * When one philosopher is done talking stuff, others
     * can feel free to start talking.
     */
    public synchronized void endTalk()
    {
        talk = false;
        notifyAll();
    }
}

// EOF
import java.util.Arrays;

/**
 * Class Monitor
 * To synchronize dining philosophers.
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca
 */
public class Monitor
{
    /*
     * ------------
     * Data members
     * ------------
     */

    public enum Status {
        THINKING, HUNGRY, EATING
    }

    public boolean talk;
    public  int philosophers;
    public Status[] states;

    /**
     * Constructor
     */
    public Monitor(int piNumberOfPhilosophers)
    {
        talk = false;
        philosophers = piNumberOfPhilosophers;
        states = new Status[philosophers];
        Arrays.fill(states, Status.THINKING);
    }

    /*
     * -------------------------------
     * User-defined monitor procedures
     * -------------------------------
     */
    public synchronized void test(final int piTID)
    {
        if(states[Math.abs((piTID-1)%philosophers)] != Status.EATING
                && states[Math.abs((piTID+1)%philosophers)] != Status.EATING
                && states[Math.abs((piTID)%philosophers)] == Status.HUNGRY)
        {
            states[piTID] = Status.EATING;
            notifyAll();
        }
    }
    /**
     * Grants request (returns) to eat when both chopsticks/forks are available.
     * Else forces the philosopher to wait()
     */
    public synchronized void pickUp(final int piTID)
    {
        int index = piTID - 1;
        states[Math.abs(index%philosophers)] = Status.HUNGRY;

        test(index);

        if(states[Math.abs(index%philosophers)] != Status.EATING)
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

        states[Math.abs(index%philosophers)] = Status.EATING;
        notifyAll();
    }

    /**
     * When a given philosopher's done eating, they put the chopsticks/forks down
     * and let others know they are available.
     */
    public synchronized void putDown(final int piTID)
    {
        int index = piTID - 1;
        states[Math.abs(index%philosophers)] = Status.THINKING;
        test(Math.abs((index-1)%philosophers));
        test(Math.abs((index+1)%philosophers));
    }

    /**
     * Only one philosopher at a time is allowed to philosophy
     * (while she is not eating).
     */
    public synchronized void requestTalk()
    {
        while(talk)
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

        talk = true;
        notifyAll();
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
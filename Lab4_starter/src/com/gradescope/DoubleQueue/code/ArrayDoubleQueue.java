/**
 * Team member names: Isiah Pham, Korey Bryant, Ben Nazurak, Kaylee Pierce
 */

package com.gradescope.DoubleQueue.code;

/**ArrayDoubleQueueContract
 * Array implementation for the Double queue.
 *
 * @invariant: queueMaxSize > 0
 *
 * @corresponds: max_queue_size = queueMaxSize
 *
 */
public class ArrayDoubleQueue implements IDoubleQueue
{
    private Double[] queue;
    private int queueMaxSize;

    /**ArrayDoubleQueueConstructorContact
     * Constructor for the arrayListDouble queue.
     *
     * @param maxSize max size of the array
     *
     * @pre maxSize > 0
     *
     * @post queueMaxSize = maxSize AND self = new Double[queueMaxSize].
     *
     */
    public ArrayDoubleQueue(int maxSize)
    {
        queue = new Double[maxSize];
        queueMaxSize = maxSize;
    }

    /**enqueueContact
     * Enqueue adds an item to the queue.
     *
     * @param val the Double to be added
     *
     * @pre |self| < queueMaxSize
     *
     * @post [self = #self with val added to left-most unoccupied index] AND queueMaxSize = #queueMaxSize
     *
     */
    @Override
    public void enqueue(Double val)
    {
        for (int i = 0; i < queueMaxSize; i++)
        {
            if (queue[i] == null)
            {
                queue[i] = val;
                i = queueMaxSize;
            }
        }
    }

    //Note: The below 3 functions intentionally do not have contracts. You do not need to add them.

    @Override
    public Double dequeue()
    {
        Double temp = queue[0];
        for (int i=1; i<queueMaxSize; i++) {
            queue[i-1] = queue[i];
        }
        queue[queueMaxSize-1] = null;
        return temp;
    }

    @Override
    public int length()
    {
        int i=-1;
        do {
            i++;
        } while (queue[i]!=null);
        return i;
    }

    public String toString()
    {
        String ret = "";
        for(Double d : queue)
        {
            ret += ("[" + d + "] ");
        }
        return ret;
    }

    //-----------------Ignore the functions below this line-----------------------
    public int getQueueMaxSize()
    {
        return this.queueMaxSize;
    }

    public Double[] getQueue()
    {
        return this.queue;
    }
}

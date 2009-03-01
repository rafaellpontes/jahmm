package be.ac.ulg.montefiore.run.distributions;

import java.io.*;


/** 
 * This interface must be implemented by all the package's classes implementing
 * a multi-variate random distribution.
 */
public interface MultiRandomDistribution 
extends Serializable
{   
    /**
     * Returns the dimension of the vectors handled by this random 
     * distribution.
     *
     * @return The generated vectors' dimension.
     */
    public int dimension();


    /**
     * Generates a pseudo-random vector.  The vectors generated by this function
     * must follow the pseudo-random distribution described by the object
     * that implements it.
     *
     * @return A pseudo-random vector.
     */
    public double[] generate();


    /**
     * Returns the probability (density) of a given vector.
     *
     * @param v A vector.
     * @return The probability of the vector <code>v</code>.
     */
    public double probability(double[] v);
}

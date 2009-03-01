package be.ac.ulg.montefiore.run.jahmm.io;

import java.io.IOException;
import java.io.Writer;

import be.ac.ulg.montefiore.run.jahmm.Observation;


/**
 * Writes an observation up to (and including) the semi-colon.
 * <p>
 * The syntax of each observation must be compatible with the corresponding
 * {@link ObservationReader ObservationReader}.
 */
public abstract class ObservationWriter<O extends Observation>
{	
	/**
	 * Writes an
	 * {@link be.ac.ulg.montefiore.run.jahmm.Observation Observation} (followed
	 * by a semi-colon) using a {@link java.io.Writer Writer}.
	 *
	 * @param observation The observation to write.
	 * @param writer The <code>writer</code> used to write the observations.
	 **/
	public abstract void write(O observation, Writer writer) 
	throws IOException;
}

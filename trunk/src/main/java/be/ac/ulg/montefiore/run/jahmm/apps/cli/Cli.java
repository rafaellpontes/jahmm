package be.ac.ulg.montefiore.run.jahmm.apps.cli;

import java.io.*;

import be.ac.ulg.montefiore.run.jahmm.io.FileFormatException;


/**
 * This class implements a command line interface for the Jahmm library.
 */
public class Cli
{
	/**
	 * The entry point of the CLI.
	 * 
	 * @param args Command line arguments.
	 */
	public static void main(String... args)
	throws IOException
	{
		try {
			System.exit(run(args));
		}
		catch (AbnormalTerminationException e) {
			System.err.println(e);
			System.exit(-1);
		}
	}
	
	
	static public int run(String... args)
	throws IOException, AbnormalTerminationException
	{
		// Allows this method to be called more than once
		CommandLineArguments.reset();
		
		ActionHandler.Actions action = CommandLineArguments.parseAction(args);
		if (action  == null)
			throw new WrongArgumentsException("Valid action required");
		
		ActionHandler actionHandler = null;
		
		try {
			actionHandler = action.handler().newInstance();
		} catch(Exception e) {
			throw new InternalError(e.toString());
		}
		
		actionHandler.parseArguments(args);
		
		try {
			actionHandler.act();
		} catch(FileNotFoundException e) {
			System.err.println(e);
			return -1;
		} catch(FileFormatException e) {
			System.err.println(e);
			return -1;
		}
		
		return 0;
	}
}			

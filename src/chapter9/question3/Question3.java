package chapter9.question3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Question3 {
	private static Logger logger = Logger.getLogger(Question3.class.toString());
		
	public static void process() throws FileNotFoundException, UnknownHostException {
		try {
			if (Math.random() < 0.5) {
				throw new FileNotFoundException();
			}
			
			if (Math.random() < 0.5) {
				throw new UnknownHostException();
			}
		} catch (FileNotFoundException | UnknownHostException e) {
			logger.log(Level.SEVERE, "...", e);
			throw e;
		}
	}
	
	public static void main(String[] args) throws IOException {
		process();
		// 8月 28, 2018 10:05:58 午後 chapter9.question3.Question3 process
		// 重大: ...
		// java.io.FileNotFoundException
		//     at chapter9.question3.Question3.process(Question3.java:15)
		//     at chapter9.question3.Question3.main(Question3.java:28)
		// 
		// Exception in thread "main" java.io.FileNotFoundException
		//     at chapter9.question3.Question3.process(Question3.java:15)
		//     at chapter9.question3.Question3.main(Question3.java:28)
	}

}

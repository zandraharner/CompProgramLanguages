import java.io.DataInputStream;
import java.io.IOException;

public class GradeDist {
	int newGrade, index, limit_1, limit_2;
	int[] freq = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; 
	
	void buildDist() throws IOException {
		DataInputStream in = new DataInputStream(System.in);
		try {
			while (true) {
				System.out.println("Please Input a grade");
				newGrade = Integer.parseInt(in.readLine());
				if (newGrade < 0) {
					// WHERE DOES IT GOTO
					throw new NegativeInputException();
				}
				index = newGrade/10;
				try {
					freq[index]++;
				} // end of inner try clause
				// 
				catch(ArrayIndexOutOfBoundsException e) {
					if (newGrade == 100)
						freq[9]++;
					else
						System.out.println("Error - new grade: " + newGrade + " is out of range [0, 100]");					
				} // end of catch ArrayIndexOutOfBoundsException
				catch(Exception e) {
					System.out.println("Exception - " + e.toString());		
				}
			} // end of while
		}// end of outer try
		catch (NegativeInputException e) {
			System.out.println("\nLimits Frequency \n");
			for (index = 0; index < 10; index++) {
				limit_1 = 10 * index;
				limit_2 = limit_1 + 9;
				if (index == 9)
					limit_2 = 100;
				System.out.println(" " + limit_1 + " - " + limit_2 + "     " + freq[index] );
			} // end of for
		} // end of catch NegativeInputException
		// ALWAYS GOOD PRACTICE to write more general exception after the specific exceptions
		catch (Exception e){
			System.out.println("Exception - " + e.toString());		
		}
		finally {
			System.out.println("Reaches Finally");
		}
	}
	
	
}

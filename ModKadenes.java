/**Modified Kadenes algorithm to return the indexes of the 
 * max value subarray. Works in linear time
 * 
 * @author madisonPickering
 * Last modified 2/29/20
 */

public class ModKadenes
{

	public static void main(String[] args)
	{
		/** sample inputs **/
		int[] inputOne = {5, -10, 30, -11, -12};
		int[] inputTwo = {-3, -7, -8, -2, -13};
		int[] inputThree = {-1, -10, -13, -16, -8};
		int[] inputFour = {-30, -72, 5, 10, -1, 12, -6};
		int[] inputFive = null;
		
		int[] best = modifiedKadenes(inputOne);
		if (best != null)
			System.out.println("Best sum: " + best[0] + "\nBestStart: " + best[1] + "\nBestEnd: " + best[2]);
		else
			System.out.println("Returned null");
	}
	
	/**runs a modified version of Kadene's algorithm. Takes O(n) time
	 * 
	 * @param numbers the integers to process.
	 * @return best an int[] where best[0] is the largest sum found, best[1] is
	 * 		the starting index of the subarray (inclusive), and best[2] is the ending index of
	 * 		the subarray (inclusive). Returns null if the input is null or has length zero.
	 */
	public static int[] modifiedKadenes(int[] numbers)
	{
		if (numbers == null || numbers.length == 0)
			return null;
		
		//initialization
		int bestSum = numbers[0];
		int currentSum = numbers[0];
		int bestStart = 0;
		int currentStart = 0;
		int bestEnd = 0;
		int currentEnd = 0;
		//compute max subarray
		for (int i = 1; i < numbers.length; i++)
		{
			currentEnd = i;
			
			//update the current sum to be max{numbers[i], localMax + numbers[i]}
			if ( (currentSum + numbers[i]) < numbers[i])
			{
				//if numbers[i] > localMax + numbers[i], start a new subarray count
				currentSum = numbers[i];
				currentStart = currentEnd;
			}
			else 
				currentSum += numbers[i];
			
			//update best info, if needed
			if (currentSum > bestSum)
			{
				bestSum = currentSum;
				bestStart = currentStart;
				bestEnd = currentEnd;
			}
		}
		
		int[] best = {bestSum, bestStart, bestEnd};
		return best;
		
	}

}

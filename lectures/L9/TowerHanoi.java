import java.util.Scanner;
public class TowerHanoi
{
	public static int moveTower(int n, char source, char dest, char temp)
	{
		System.out.println("moveTower: "+n+" items from "+source+
					" to "+dest);
		if (n == 1)
		{
			System.out.println("Move 1 from "+source+" to "+dest);
			return 1;
		}
		else
		{
			int num_moves;
			// move n-1 items from x to z
			num_moves = moveTower(n-1, source, temp, dest);
			System.out.println("Move "+n+" from "+source+" to "+dest);
			num_moves++;
				// move n-1 items from z to y
			num_moves += moveTower(n-1, temp, dest, source);
			return num_moves;
		}
	} // end moveTower

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int n;
		System.out.print("How many in the tower? ");
		n = input.nextInt();
		n = moveTower(n,'x','y','z');
		System.out.println("It took "+n+" moves");
	} // end of main
} // end of class TowerHanoi
	

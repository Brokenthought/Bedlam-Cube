package bedlam;

public class PieceTypes {
	
	public static  boolean shape[][][] = new boolean [4][4][4];

	public static void objectOne()
	{
		shape[0][0][1]= true;
		shape[0][1][0]= true;
		shape[0][1][1]= true;
		shape[0][2][1]= true;
		shape[0][1][2]= true;
	}
	public static void objectTwo()
	{
		shape[0][0][0]= true;
		shape[0][1][0]= true;
		shape[0][1][1]= true;
		shape[0][2][0]= true;
		shape[1][1][0]= true;		
	}
	public static void objectThree()
	{
		shape[0][0][0]= true;
		shape[0][1][0]= true;
		shape[0][1][1]= true;
		shape[0][2][1]= true;
		shape[0][2][2]= true;
	}
	public static void objectFour()
	{
		shape[0][0][1]= true;
		shape[0][1][0]= true;
		shape[0][1][1]= true;
		shape[1][1][0]= true;
		shape[1][2][0]= true;
	}
	public static void objectFive()
	{
		shape[0][0][0]= true;
		shape[0][1][0]= true;
		shape[0][2][0]= true;
		shape[0][0][1]= true;
		shape[1][2][0]= true;
	}

	public static void objectSix()
	{
		shape[0][0][1]= true;
		shape[0][1][0]= true;
		shape[0][2][0]= true;
		shape[0][1][1]= true;
		shape[1][2][0]= true;
	}
	public static void objectSeven()
	{
		shape[0][0][0]= true;
		shape[0][1][0]= true;
		shape[0][2][0]= true;
		shape[1][0][0]= true;
		shape[1][0][1]= true;
	}
	public static void objectEight()
	{
		shape[0][0][1]= true;
		shape[0][1][0]= true;
		shape[0][2][0]= true;
		shape[0][1][1]= true;
		shape[1][1][1]= true;
	}
	public static void objectNine()
	{
		shape[0][0][0]= true;
		shape[0][1][0]= true;
		shape[0][2][0]= true;
		shape[0][2][1]= true;
		shape[1][2][0]= true;
	}
	public static void objectTen()
	{
		shape[0][0][0]= true;
		shape[0][0][1]= true;
		shape[1][0][0]= true;
		shape[1][1][0]= true;
	}

	public static void objectEleven()
	{
		shape[0][0][0]= true;
		shape[0][1][1]= true;
		shape[0][1][0]= true;
		shape[0][2][0]= true;
		shape[1][2][0]= true;
	}

	public static void objectTweleve()
	{
		shape[0][0][1]= true;
		shape[0][1][1]= true;
		shape[0][1][2]= true;
		shape[0][2][0]= true;
		shape[0][2][1]= true;
	}

	public static void objectThirteen()
	{
		shape[0][0][0]= true;
		shape[0][1][0]= true;
		shape[0][2][0]= true;
		shape[0][1][1]= true;
		shape[1][1][1]= true;
	}


	public static void getPiece(int num)
	{
		if (num == 0)
		{
			objectOne();
		}
		if (num == 1)
		{
			objectTwo();
		}
		if (num == 2)
		{
			objectThree();
		}
		if (num == 3)
		{
			objectFour();
		}

		if (num == 4)
		{
			objectFive();
		}
		if (num == 5)
		{
			objectSix();
		}
		if (num == 6)
		{
			objectSeven();
		}
		if (num == 7)
		{
			objectEight();
		}
		if (num == 8)
		{
			objectNine();
		}
		if (num == 9)
		{
			objectTen();
		}
		if (num == 10)
		{
			objectEleven();
		}
		if (num == 11)
		{
			objectTweleve();
		}
		if (num == 12)
		{
			objectThirteen();
		}
	}

	public static void clearShapes()
	{
		int i,m,n;
		for (i=0;i<4;i++)
		{
			for (n=0;n<4;n++)
			{
				for (m=0;m<4;m++)
				{
					shape[i][n][m] = false;
				}
			}
		}
	}

}

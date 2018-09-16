package bedlam;

import java.util.Scanner;

public class Cube {

	public boolean cube[][][] = new boolean [4][4][4];
	public static int lowest = 50;

	public void printCube()
	{
		int i,m,n;
		boolean complete;

		complete = false;
		i=0;
		n=0;
		m=0;
		while(!complete)
		{
			if (cube[i][n][m])
			{
				System.out.print( i +""+ n +""+ m + "|");
			}
			else System.out.print("[__]");
			
			m++;
			if (m==4)
			{
				System.out.print("   ");
				i++;
				m=0;
			}
			if (i == 4)
			{
				System.out.println();
				i = 0;
				n++;
			}
			if (n == 4)
			{
				complete = true;
			}
		}
	}

	public boolean fitPiece(Piece piece)
	{	
		int pieceCoordinates[][] = new int[3][piece.size];

		for(int i=0; i< piece.orientationsCount;i++)
		{	
			for(int o=0; o< piece.size ;o++)
			{
				pieceCoordinates[0][o] = Character.getNumericValue(piece.orientations[i][o].charAt(0));	
				pieceCoordinates[1][o] = Character.getNumericValue(piece.orientations[i][o].charAt(1));	
				pieceCoordinates[2][o] = Character.getNumericValue(piece.orientations[i][o].charAt(2));	
			}
			if(place(pieceCoordinates, piece.size))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean solved()
	{
		int count=0;
		int x,y,z;
		boolean solved = true;
		for (x=0;x<4;x++)
		{
			for (y=0;y<4;y++)
			{
				for (z=0;z<4;z++)
				{

					if(!cube[x][y][z])
					{
						solved =  false;
						count++;
					}
				}
			}
		}
		if(count < lowest)
		{
			lowest = count;
		}
		//System.out.println(lowest);
		
		return solved;
	}


	//tried to place the piece into the cube
	public boolean place(int coordinates[][], int size)
	{
		int i;
		int x,y,z;
		boolean xBig=false;
		boolean xSmall=false;
		boolean yBig=false;
		boolean ySmall=false;
		boolean zBig=false;
		boolean zSmall=false;

		for(i=0; i< size ;i++)
		{
			if(cube[coordinates[0][i]]  [coordinates[1][i]]  [coordinates[2][i]])
			{
				return false;
			}
		}

		for(i=0; i< size ;i++)
		{
			cube[coordinates[0][i]]  [coordinates[1][i]]  [coordinates[2][i]] = true;
		}

		for (x=0;x<4;x++)
		{
			for (y=0;y<4;y++)
			{
				for (z=0;z<4;z++)
				{
					if(!cube[x][y][z])
					{

						if (x+1!=4)
						{
							if(cube[x+1][y][z])
							{
								xBig = true;
							}                  
						}
						else{xBig = true;}

						if (x-1!=-1)
						{
							if(cube[x-1][y][z])
							{
								xSmall = true;
							}                  
						}
						else{xSmall = true;}
						/////////////////////////////////////////////////////////////
						if (y+1!=4)
						{
							if(cube[x][y+1][z])
							{
								yBig = true;
							}                  
						}
						else{yBig = true;}

						if (y-1!=-1)
						{
							if(cube[x][y-1][z])
							{
								ySmall = true;
							}                  
						}
						else{ySmall = true;}
						/////////////////////////////////////////////////////////////
						if (z+1!=4)
						{
							if(cube[x][y][z+1])
							{
								zBig = true;
							}                  
						}
						else{zBig = true;}

						if (z-1!=-1)
						{
							if(cube[x][y][z-1])
							{
								zSmall = true;
							}                  
						}
						else{zSmall = true;}      
						
						if(xBig&&xSmall&&yBig&&ySmall&&zBig&zSmall)
						{
							for(i=0; i< size ;i++)
							{
								if(cube[coordinates[0][i]]  [coordinates[1][i]]  [coordinates[2][i]])
								{
									cube[coordinates[0][i]]  [coordinates[1][i]]  [coordinates[2][i]] = false;
								}
							}
							return false;
						}
						xBig = false;
						xSmall= false;
						yBig= false;
						ySmall= false;
						zBig= false;
						zSmall= false;                                
					}

				}

			}
		}

		return true;


	}
	public static void permute(String beginningString, String endingString,Piece[] piece) {	

		int orderArray[] = new int[13];     
		String order =""; 
		if (endingString.length() <= 1)
		{
			Cube cube = new Cube();
			
			System.out.println(beginningString+ endingString);
			
			order = beginningString+ endingString;

			for(int o = 0;o<order.length();o++)
			{   
							
				if(order.substring(o, o+1).equals("a"))
				{
					orderArray[o] = 10;
				}
				else if(order.substring(o, o+1).equals("b"))
				{
					orderArray[o] = 11;
				}
				else if(order.substring(o, o+1).equals("c"))
				{
					orderArray[o] = 12;
				}
				else
				{
					orderArray[o] = Character.getNumericValue(order.charAt(o));  
				}			
				
			} 
	
			for(int i = 12;i>=0;i--)
			{
		
				if(!cube.fitPiece(piece[orderArray[i]]))
				{
					
				}	
			}
			System.out.println();     
			cube.printCube();
			System.out.println();
            if(cube.solved())
            {
            	System.out.println();
            	//cube.printCube();
                System.exit(0);
                
            }
		}
		else{
			
			for (int i = 0; i < endingString.length(); i++) {

				String newString = endingString.substring(0, i) + endingString.substring(i + 1);

				permute(beginningString + endingString.charAt(i), newString,piece);
			}
		}
	}

	public static void main(String[] args) {
		//builds an array of all the valid possible positions for each piece
		Piece piece[] = new Piece[13];
		boolean isNum = false;
		int p =0;
		for(int i=0;i<13;i++)
		{
			piece[i] = new Piece(); 
			piece[i].findOrientations(i);
		}
		
		//cube.fitPiece(piece[0]);
		//cube.fitPiece(piece[1]);
		//cube.fitPiece(piece[2]);
		//cube.fitPiece(piece[3]);
		//cube.printCube();
		//permute("","0123456789abc",piece);	
		
	
		
		System.out.println("Enter 1 to search for a solution");
		;	
		
		String input = "";
		Scanner console = new Scanner(System.in);
		
		input = console. nextLine();
		//trys to find a solution from the seed
		if (input.equals("1"))
		{
			System.out.println("Enter a seed, e.g. 7c23456089ab1");	
			input = console. nextLine();
			if(input.length() == 13) {
				 permute("",input,piece);	
			}
	
		

		
		
		

				
	
	}





}


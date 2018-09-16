package bedlam;

public class Move{
	
	//contains methods to move the piece around

	//integer to represent x,y and z coordinates 
	int x,y,z;
	//integer to store the size of the piece
	int size;

	//method to move the piece up by one block
	public void up(boolean coordinates[][][],int pieceSize)
	{
	    size = 0;
	    //stops the method if the piece is already at the top of the cube
		for (x=0;x<4;x++)
		{
			for (y=0;y<4;y++)
			{
				for (z=0;z<4;z++)
				{
					if (coordinates[x][0][z] == true)
					{
						return;					
					}
				}
			}
		}

		//find the piece and then moves it up one block
		for (x=0;x<4;x++)
		{
			for (y=0;y<4;y++)
			{
				for (z=0;z<4;z++)
				{
					if(coordinates[x][y][z] && size != pieceSize)
					{
						size++;
						coordinates[x][y][z] = false;
						coordinates[x][y-1][z] = true;
					}
				}
			}
		}	
	}
	//does the reverse of the up method
	public void down(boolean coordinates[][][],int pieceSize)
	{
		size = 0;
		
		for (x=0;x<4;x++)
		{
			for (y=0;y<4;y++)
			{
				for (z=0;z<4;z++)
				{
					if (coordinates[x][3][z] == true)
					{
						return;
						
					}
				}
			}
		}
        // for loops are reversed to ensure that a block in the piece isn't merged with, or pushed into, another block
		for (x=3;x>-1;x--)
		{
			for (y=3;y>-1;y--)
			{
				for (z=3;z>-1;z--)
				{
					if(coordinates[x][y][z] && size != pieceSize )
					{
						size++;
						coordinates[x][y][z] = false;
						coordinates[x][y+1][z] = true;             
					}
				}
			}
		}

	}
	//left, right, forward and backward methods are the same as the up and down ones but on different axes 
	public void left(boolean coordinates[][][],int pieceSize)
	{
	    size = 0;
	    	
		for (x=0;x<4;x++)
		{
			for (y=0;y<4;y++)
			{
				for (z=0;z<4;z++)
				{
					if (coordinates[x][y][0] == true)
					{
						return;					
					}
				}
			}
		}

		for (x=0;x<4;x++)
		{
			for (y=0;y<4;y++)
			{
				for (z=0;z<4;z++)
				{
					if(coordinates[x][y][z] && size != pieceSize)
					{
						size++;
						coordinates[x][y][z] = false;
						coordinates[x][y][z-1] = true;
					}
				}
			}
		}

	}

	public void right(boolean coordinates[][][],int pieceSize)
	{
			
		for (x=0;x<4;x++)
		{
			for (y=0;y<4;y++)
			{
				for (z=0;z<4;z++)
				{
					if (coordinates[x][y][3] == true)
					{
						return;
						
					}
				}
			}
		}

		size = 0;

		for (x=3;x>-1;x--)
		{
			for (y=3;y>-1;y--)
			{
				for (z=3;z>-1;z--)
				{
					if(coordinates[x][y][z] && size != pieceSize )
					{
						size++;
						coordinates[x][y][z] = false;
						coordinates[x][y][z+1] = true;
					}
				}
			}
		}

	}

	public void forward(boolean coordinates[][][],int pieceSize)
	{
	    size = 0;
	    		
		for (x=0;x<4;x++)
		{
			for (y=0;y<4;y++)
			{
				for (z=0;z<4;z++)
				{
					if (coordinates[0][y][z] == true)
					{
						return;					
					}
				}
			}
		}

		for (x=0;x<4;x++)
		{
			for (y=0;y<4;y++)
			{
				for (z=0;z<4;z++)
				{
					if(coordinates[x][y][z] && size != pieceSize)
					{
						size++;
						coordinates[x][y][z] = false;
						coordinates[x-1][y][z] = true;
					}
				}
			}
		}
	}

	public void back(boolean coordinates[][][],int pieceSize)
	{
		size = 0;
		
		
		for (x=0;x<4;x++)
		{
			for (y=0;y<4;y++)
			{
				for (z=0;z<4;z++)
				{
					if (coordinates[3][y][z] == true)
					{
						return;					
					}
				}
			}
		}


		for (x=3;x>-1;x--)
		{
			for (y=3;y>-1;y--)
			{
				for (z=3;z>-1;z--)
				{
					if(coordinates[x][y][z] && size != pieceSize )
					{
						size++;
						coordinates[x][y][z] = false;
						coordinates[x+1][y][z] = true;
					}
				}
			}
		}
		

	}
	//rotating the piece proved to be a good deal more complicated than moving the piece left or right
	public void rotateXAxis(boolean coordinates[][][], int centerY, int centerZ)
	{
		//centerY and centerZ represent the center of rotation on the y and z axes
		int x,y,z;
		int newY;
		int newZ;
		int yMax = 0;
		int zMax = 0;
		int yMin = 0;
		int zMin = 0;
		int rotatedY;
		int rotatedZ;
		boolean check[][][] = new boolean [10][10][10];



		for (x=0;x<4;x++)
		{
			for (y=0;y<4;y++)
			{
				for (z=0;z<4;z++)
				{
					if(coordinates[x][y][z])
					{
						coordinates[x][y][z] = false;
						newY = y - centerY;
						newZ = z - centerZ;

						rotatedY = newZ*-1;
						rotatedZ = newY;

						check[x][rotatedY+centerY+3][rotatedZ+centerZ+3] = true;
					}
				}
			}
		}


		for (x=0;x<10;x++)
		{
			for (y=0;y<10;y++)
			{
				for (z=0;z<10;z++)
				{
					if(check[x][y][z] && y>6 && (y-6)>yMax)
					{
						yMax = y-6;
					}
					if(check[x][y][z]&& z>6 && (z-6)>zMax)
					{
						zMax = z-6;
					}

				}
			}
		}

		for (x=8;x>-1;x--)
		{
			for (y=8;y>-1;y--)
			{
				for (z=8;z>-1;z--)
				{
					if(check[x][y][z] && y<3 && y-3<yMin)
					{
						yMin = y-3;
					}
					if(check[x][y][z] && z<3 && z-3<zMin)
					{

						zMin = z-3;
					}
				}
			}
		}


		for (x=0;x<9;x++)
		{
			for (y=0;y<9;y++)
			{
				for (z=0;z<9;z++)
				{
					if (check[x][y][z])
					{
						coordinates[x][y-yMax-yMin-3][z-zMax-zMin-3] = check[x][y][z];
					}
				}
			}
		}

	}
	public void rotateYAxis(boolean coordinates[][][],int centerX, int centerZ)
	{		
		int newX;
		int newZ;
		int xMax = 0;
		int zMax = 0;
		int xMin = 0;
		int zMin = 0;
		int rotatedX;
		int rotatedZ;
		boolean check[][][] = new boolean [10][10][10];

		for (x=0;x<4;x++)
		{
			for (y=0;y<4;y++)
			{
				for (z=0;z<4;z++)
				{
					if(coordinates[x][y][z])
					{
						coordinates[x][y][z] = false;
						newX = x - centerX;
						newZ = z - centerZ;

						rotatedX = newZ*-1;
						rotatedZ = newX;

						check[rotatedX+centerX+3][y][rotatedZ+centerZ+3] = true;
					}
				}
			}
		}

		for (x=0;x<9;x++)
		{
			for (y=0;y<9;y++)
			{
				for (z=0;z<9;z++)
				{
					if(check[x][y][z] && x>6 && (x-6)>xMax)
					{
						xMax = x-6;
					}
					if(check[x][y][z] && z>6 && (z-6)>zMax)
					{
						zMax = z-6;
					}

				}
			}
		}

		for (x=8;x>-1;x--)
		{
			for (y=8;y>-1;y--)
			{
				for (z=8;z>-1;z--)
				{
					if(check[x][y][z] && x<3 && x-3<xMin)
					{
						xMin = x-3;
					}
					if(check[x][y][z] && z<3 && z-3<zMin)
					{
						zMin = z-3;
					}
				}
			}
		}


		for (x=0;x<9;x++)
		{
			for (y=0;y<9;y++)
			{
				for (z=0;z<9;z++)
				{
					if (check[x][y][z])
					{
						coordinates[x-xMax-xMin-3][y][z-zMax-zMin-3] = check[x][y][z];
					}
				}
			}
		}
	}

	public void rotateZAxis(boolean coordinates[][][],int centerX, int centerY)
	{
		int xMax = 0;
		int yMax = 0;
		int xMin = 0;
		int yMin = 0;
		int x,y,z;
		int newX;
		int newY;
		int rotatedX;
		int rotatedY;
		boolean check[][][] = new boolean [10][10][10];

		for (x=0;x<4;x++)
		{
			for (y=0;y<4;y++)
			{
				for (z=0;z<4;z++)
				{
					if(coordinates[x][y][z])
					{
						coordinates[x][y][z] = false;
						newX = x - centerX;
						newY = y - centerY;

						rotatedX = newY*-1;
						rotatedY = newX;

						check[rotatedX+centerX+3][rotatedY+centerY+3][z] = true;

					}
				}
			}
		}

		for (x=0;x<9;x++)
		{
			for (y=0;y<9;y++)
			{
				for (z=0;z<9;z++)
				{
					if(check[x][y][z] && x>6 && (x-6)>xMax)
					{
						xMax = x-6;
					}
					if(check[x][y][z] && y>6 && (y-6)>yMax)
					{
						yMax = y-6;
					}

				}
			}
		}

		for (x=8;x>-1;x--)
		{
			for (y=8;y>-1;y--)
			{
				for (z=8;z>-1;z--)
				{
					if(check[x][y][z] && x<3 && x-3<xMin)
					{
						xMin = x-3;
					}
					if(check[x][y][z] && y<3 && y-3<yMin)
					{
						yMin = y-3;
					}
				}
			}
		}

		for (x=0;x<9;x++)
		{
			for (y=0;y<9;y++)
			{
				for (z=0;z<9;z++)
				{
					if (check[x][y][z])
					{
						coordinates[x-xMax-xMin-3][y-yMax-yMin-3][z] = check[x][y][z];
					}
				}
			}
		}

	}
	

}

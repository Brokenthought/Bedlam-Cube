package bedlam;

//purpose of this class is to get all possible orientations of the piece entered
public class Orientations{
	
    Move move = new Move();
    private int pieceSize;
    public int orientationsCount = 0;
	private boolean[][][] coordinates = new boolean[4][4][4];
	public String orientations[][] = new String [700][5];	
	

	public String[] getOrientations(int orientationNum)
	{
		String orientation[] = new String[pieceSize];
		for(int i =0; i<pieceSize;i++)
		{
			orientations[orientationNum][i] = orientation[i];
		}
		
		return orientation;
	}
	
	public void clear()
	{
		for (int x=0;x<4;x++)
		{
			for (int y=0;y<4;y++)
			{
				for (int z=0;z<4;z++)
				{
				coordinates[x][y][z] =false;
			
				}
			}
		}
	}
    //method checks to see if the current orientation passed in by variable matches with any of the previous orientations stored in orientations
	public void orient()
	{
		int x,y,z;
		String match[] = new String[pieceSize];
		boolean foundMatch;
		int o;
		int i = 0;
		//converts the current orientation to a string so it can be compared with the previous orientations
		for (x=0;x<4;x++)
		{
			for (y=0;y<4;y++)
			{
				for (z=0;z<4;z++)
				{
					if (coordinates[x][y][z])
					{   				
						match[i] = Integer.toString(x) + Integer.toString(y) + Integer.toString(z);  									
						i++;   										
					}
				}
			}
		}				
		
		for (i=0;i<orientationsCount;i++)
		{	
			foundMatch = true;
			for(o=0;o<pieceSize;o++)
			{											
				if(!match[o].equals(orientations[i][o]))
				{					
					foundMatch = false;
					break;
				}
			}
			if(foundMatch)
			{          
				return;
			}
		}

		for(i=0;i<pieceSize;i++)
		{		
			orientations[orientationsCount][i] = match[i];
		}
		
		orientationsCount++;
	}
	//method to copy an array;
	public void copyArray(boolean array[][][])
	{
		int x,y,z;
		for (x=0;x<4;x++)
		{
			for (y=0;y<4;y++)
			{
				for (z=0;z<4;z++)
				{
					if(array[x][y][z])
					{
						coordinates[x][y][z]=true;
					}
					else
					{
						coordinates[x][y][z]=false;
					}
				}
			}
		}
	}

	public void getOrientations(boolean shape[][][],int size)
	{
		pieceSize = size;

		int o,p,n,k,u,x;
		o =0;
		p =0;
		n =0;
		k =0;
		u =0;
		x =0;
		
		copyArray(shape);
		orient();
		
		//very long loop to move the piece in all possible ways
		//probably should be done wit nested for loops but i thought this would be neater
		while(x!=3)
		{	
			if(o<4)
			{
				o++;
			}
			if (p<4 && o==4)
			{
				o=0;
				p++;
			}
			if (n<4 && p==4)
			{  
				p=0;
				o=0;
				n++;
			}
			if (k<4 && n==4)
			{
				p=0;
				o=0;
				n=0;
				k++;
			}
			if (u<4 && k==4)
			{
				p=0;
				o=0;
				n=0;
				k=0;
				u++;
			}
			if (x<4 && u==4)
			{
				p=0;
				o=0;
				n=0;
				k=0;
				u=0;
				x++;
			}		
			//resets the coordinate array	
			copyArray(shape);
	
			//rotates the piece a varying number of times
			YZtimes(o);
			XZtimes(p);
			XYtimes(n);

			//rotating the piece can cause it to wander, so the following move lines make sure its in the top, left, forward corner
			move.left(coordinates,size);
			move.left(coordinates,size);
			move.left(coordinates,size);
			move.up(coordinates,size);
			move.up(coordinates,size);
			move.up(coordinates,size);
			move.forward(coordinates,size);
			move.forward(coordinates,size);
			move.forward(coordinates,size);

			//moves the piece a varying number of times
			Rtimes(k);
			Dtimes(u);
			Btimes(x);
				
			orient();			
		}
	
	}
	

	public int[] getX()
	{
		int x,y,z;
		int U = 0;
		
		int data[] = new int [pieceSize];
		for (x=0;x<4;x++)
		{
			for (y=0;y<4;y++)
			{
				for (z=0;z<4;z++)
				{
					if (coordinates[x][y][z] == true)
					{				
						data[U] = x;
						U++;				
					}
				}
			}
		}
		return data;
	}

	public int[] getY()
	{
		int x,y,z;
		int U = 0;

		int data[] = new int [pieceSize];
		for (x=0;x<4;x++)
		{
			for (y=0;y<4;y++)
			{
				for (z=0;z<4;z++)
				{
					if (coordinates[x][y][z] == true)
					{	
						data[U] = y;
						U++;								
					}
				}
			}
		}
		
		return data;
	}
	
	public int[] getZ()
	{
		int x,y,z;
		int U = 0;
		
		int data[] = new int [pieceSize];
		for (x=0;x<4;x++)
		{
			for (y=0;y<4;y++)
			{
				for (z=0;z<4;z++)
				{
					if (coordinates[x][y][z] == true)
					{				

						data[U] = z;
						U++;
		
					}
				}
			}
		}
		return data;
	}
	
	public void Rtimes(int num)
	{
		for (int i=0;i<num;i++)
		{
			move.right(coordinates,pieceSize);
		}
	}

	public void Dtimes(int num)
	{
		for (int i=0;i<num;i++)
		{
			move.down(coordinates,pieceSize);
		}
	}

	public void Btimes(int num)
	{
		for (int i=0;i<num;i++)
		{
			move.back(coordinates,pieceSize);
		}
	}
	
	public void YZtimes(int num)
	{
		for (int i=0;i<num;i++)
		{
			move.rotateXAxis(coordinates,getY()[0],getZ()[0]);
		}
	}
	public void XZtimes(int num)
	{
		for (int i=0;i<num;i++)
		{
			move.rotateYAxis(coordinates,getX()[0],getZ()[0]);
		}
	}
	public void XYtimes(int num)
	{
		for (int i=0;i<num;i++)
		{
			move.rotateZAxis(coordinates,getX()[0],getY()[0]);
		}
	}	
	



}

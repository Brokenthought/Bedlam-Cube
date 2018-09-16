package bedlam;

public class Piece extends PieceTypes{
	
	public int size;
	public int orientationsCount;	
	public String orientations[][];		
	
	Orientations pieceOrientations = new Orientations();
	
	public void findOrientations(int piece)
	{
		
		clearShapes();
		
		getPiece(piece);
		
		checkSize();
		
		pieceOrientations.getOrientations(shape, size);	
		
		orientationsCount = pieceOrientations.orientationsCount;			
		
		orientations=pieceOrientations.orientations;				
	}	

	//gets the size of the size of the piece
	public void checkSize()
	{
		size=0;
		for (int i=0;i<4;i++)
		{
			for (int n=0;n<4;n++)
			{
				for (int m=0;m<4;m++)
				{
					if (shape[i][n][m])
					{
						size++;
					}
				}
			}
		}

	}
	

}



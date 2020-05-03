package model;

public class Tour extends AbstractPiece {
	
	public Tour(Couleur couleur_de_piece,Coord coord) {
		super(couleur_de_piece,coord);
		setName("tour");
	}
	
	public boolean isMoveOk(int xFinal,int yFinal) {
		boolean val_ret=false;
		if ((coord.x==xFinal) & (yFinal<=8) &  (yFinal>=1)) {
			val_ret=true;
		}
		
		if ((coord.y==yFinal) & (xFinal<=8) &  (xFinal>=1)) {
			val_ret=true;
		}
		return val_ret;	
	}
	
}
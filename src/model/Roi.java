package model;

public class Roi extends AbstractPiece {
	
	public Roi(Couleur couleur_de_piece,Coord coord) {
		super(couleur_de_piece,coord);
		setName("roi");
	}
	
	public boolean isMoveOk(int xFinal,int yFinal) {
		boolean val_ret=false;
		if ((Math.abs(coord.x-xFinal)==1) & ((Math.abs(coord.y-yFinal)==0 ) | (Math.abs(coord.y-yFinal)==1 )) & (yFinal<=8) &  (yFinal>=1) & (xFinal<=8) &  (xFinal>=1)) {
			val_ret=true;
		}
		if ((Math.abs(coord.x-xFinal)==0) & (Math.abs(coord.y-yFinal)==1 ) & (yFinal<=8) &  (yFinal>=1) & (xFinal<=8) &  (xFinal>=1)) {
			val_ret=true;	
		}


		return val_ret;	
	}
	
}


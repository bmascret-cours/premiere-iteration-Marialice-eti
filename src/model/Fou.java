package model;

public class Fou extends AbstractPiece {
	
	public Fou(Couleur couleur_de_piece,Coord coord) {
		super(couleur_de_piece,coord);
		setName("fou");
	}
	
	public boolean isMoveOk(int xFinal,int yFinal) {
		boolean val_ret=false;
		if ((Math.abs(coord.x-xFinal)==Math.abs(coord.y-yFinal))& (yFinal<=8) &  (yFinal>=1) & (xFinal<=8) &  (xFinal>=1)) {
			val_ret=true;
		}

		return val_ret;	
	}
	
}
package model;

public class Reine extends AbstractPiece {
	
	public Reine(Couleur couleur_de_piece,Coord coord) {
		super(couleur_de_piece,coord);
		setName("reine");
	}
	
	public boolean isMoveOk(int xFinal,int yFinal) {
		boolean val_ret=false;
		if ((Math.abs(coord.x-xFinal)==Math.abs(coord.y-yFinal))) {
			val_ret=true;
		}
		if ((coord.x==xFinal) & (yFinal<=8) &  (yFinal>=1)) {
			val_ret=true;
		}
		
		if ((coord.y==yFinal) & (xFinal<=8) &  (xFinal>=1)) {
			val_ret=true;
		}

		return val_ret;	
	}
	
}


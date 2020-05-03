package model;

public class Cavalier extends AbstractPiece {
	
	public Cavalier(Couleur couleur_de_piece,Coord coord) {
		super(couleur_de_piece,coord);
		setName("cavalier");
	}
	
	public boolean isMoveOk(int xFinal,int yFinal) {
		boolean val_ret=false;
		if ((Math.abs(coord.x-xFinal)==2) & ((Math.abs(coord.y-yFinal)==1)) & (yFinal<=8) &  (yFinal>=1) & (xFinal<=8) &  (xFinal>=1)) {
			val_ret=true;
		}
		
		if ((Math.abs(coord.y-yFinal)==2) & ((Math.abs(coord.x-xFinal)==1))& (yFinal<=8) &  (yFinal>=1) & (xFinal<=8) &  (xFinal>=1)) {
			val_ret=true;
		}
		return val_ret;	
	}
	
}
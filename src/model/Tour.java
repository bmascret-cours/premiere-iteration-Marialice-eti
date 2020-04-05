package model;

public class Tour extends AbstractPiece {
	
	public Tour(Couleur couleur_de_piece,Coord coord) {
		AbstractPiece(Couleur couleur,Coord coord);
	}
	
	public boolean isMoveOk(int xFinal,int yFinal) {
		if ((coord.x==xFinal) & (yFinal<=8) &  (yFinal>=1)) {
			return true
		}
		
		if ((coord.y==yFinal) & (xFinal<=8) &  (xFinal>=1)) {
			return true
		}
		return false	
	}
	
}
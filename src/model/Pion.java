package model;

public class Pion extends AbstractPiece {
	
	public Pion(Couleur couleur_de_piece,Coord coord) {
		super(couleur_de_piece,coord);
		setName("pion");
	}
	
	public boolean isMoveOk(int xFinal,int yFinal) {
		boolean val_ret=false;
		if ((this.couleur==Couleur.BLANC)& (coord.x==xFinal) & (yFinal-coord.y==1) & (yFinal<=8) &  (yFinal>=1) ) {
			val_ret=true;
		}
		if ((this.couleur==Couleur.NOIR)& (coord.x==xFinal) & (yFinal-coord.y==-1) & (yFinal<=8) &  (yFinal>=1) ) {
			val_ret=true;
		}
		return val_ret;	
	}
	
	public boolean isMoveDiagOk(int xFinal, int yFinal) {
		return false;
		
	}
	
	public boolean move(int x,int y) {
		boolean val_ret=false;
		if(isMoveOk(this.getX()+x,this.getY()+y)|isMoveDiagOk(this.getX()+x,this.getY()+y)) {
			coord.x+=x;
			coord.y+=y;
			val_ret=true;
		}
		return val_ret;
	}
		
	
}
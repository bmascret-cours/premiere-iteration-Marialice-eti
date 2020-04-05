package model;

/**
 * Gère le comportement commun à toutes les pièces.
 * Chaque classe dérivée (Pion, etc.) sera capable de dire si le déplacement est OK.
 * @author Marianne
 *
 */

public abstract class AbstractPiece extends java.lang.Object implements Pieces {

	private Couleur couleur;
	protected Coord coord;
	private name=getClass().getSimpleName();
	
	public AbstractPiece(Couleur couleur,Coord coord) {
		this.couleur = couleur;
		this.coord=coord;
	}
	
	public int getX() {
		return coord.x;
	}
	
	public int getY() {
		return coord.y;	
	}
	
	public Couleur getCouleur() {
		return couleur;
	}
	
	public java.lang.String toString(){
		/*le nom et les coordonnées x et y de la pièce*/
		return "Le nom de la piece: "+ name + ", coord x: " + this.getX() + ", coord x: " + this.getY();
	}
	
	public boolean move(int x,int y) {
		if(isMoveOk(this.getX()+x,this.getY()+y)) {
			coord.x+=x;
			coord.y+=y;
		}
	}
	public boolean capture() {
		coord.x=-1;
		coord.y=-1;
		return true
	};
	public abstract boolean isMoveOk(int xFinal,int yFinal);
	
	
	public static void main(String args[]) {
		Pieces maTour = new Tour(Couleur.NOIR, new Coord(0, 0));
		System.out.println(maTour);
		maTour.getX();
		maTour.getY();
		maTour.getCouleur();
		
		maTour.move(0,2);
		maTour.getX();
		maTour.getY();
		
		maTour.move(2,2);
		maTour.getX();
		maTour.getY();
		
		maTour.capture();
		maTour.getX();
		maTour.getY();
		
		
		

		



	}
	
	
}


package model;
/**
 * Gère le comportement commun à toutes les pièces.
 * Chaque classe dérivée (Pion, etc.) sera capable de dire si le déplacement est OK.
 * @author Marianne
 *
 */

import model.Pieces;
import model.Couleur;
import model.Coord;
import model.Tour;

public abstract class AbstractPiece extends java.lang.Object implements Pieces {

	protected Couleur couleur;
	protected Coord coord;
	private String name;
	
	public AbstractPiece(Couleur couleur,Coord coord) {
		this.couleur = couleur;
		this.coord=coord;
	}
	
	public int getX() {
		return coord.x;
	}
	
	public int getY () {
		return coord.y;	
	}
	
	public Couleur getCouleur() {
		return couleur;
	}
	
	public java.lang.String toString(){
		/*le nom et les coordonnées x et y de la pièce*/
		return "Le nom de la piece: "+ name + ", coord x: " + this.getX() + ", coord y: " + this.getY() + ", couleur: " + this.getCouleur();
	}
	
	public boolean move(int x,int y) {
		boolean val_ret=false;
		if(isMoveOk(this.getX()+x,this.getY()+y)) {
			coord.x+=x;
			coord.y+=y;
			val_ret=true;
		}
		return val_ret;
	}
	public boolean capture() {
		boolean val_ret=true;
		coord.x=-1;
		coord.y=-1;
		return val_ret;
	};
	
	
	public void setName(String name) {
		this.name = name;
	}

	public abstract boolean isMoveOk(int xFinal,int yFinal);
	
	
	public static void main(String args[]) {
		Pieces maTour = new Tour(Couleur.NOIR, new Coord(0, 0));
		System.out.println(maTour);
		/*maTour.getCouleur();
		
		maTour.move(0,2);
		System.out.println(maTour);
		
		maTour.move(2,2);
		System.out.println(maTour);
		
		maTour.capture();
		System.out.println(maTour);	
		
		maTour.move(0,9);
		System.out.println(maTour);
		
		Pieces monPion = new Pion(Couleur.NOIR, new Coord(0, 0));
		System.out.println(monPion);
		System.out.println(monPion.getCouleur());
		monPion.move(0,1);
		System.out.println(monPion);*/

	}
	
	
}


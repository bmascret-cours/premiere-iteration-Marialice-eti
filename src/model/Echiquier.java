package model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Echiquier implements BoardGames{
	private Couleur ColorCurrentPlayer= Couleur.BLANC;
	public String message = "";
	private Jeu jeu_blanc=new Jeu(Couleur.BLANC);
	private Jeu jeu_noir=new Jeu(Couleur.NOIR);


public Echiquier() {

}

public void switchJoueur() {
	if (getColorCurrentPlayer()==Couleur.BLANC) {
		setColorCurrentPlayer(Couleur.NOIR);
	}
	else {
		setColorCurrentPlayer(Couleur.BLANC);
	}
}
/*Permet de changer le joueur courant.*/

public java.util.List<PieceIHM> getPiecesIHM(){
	List<PieceIHM> Liste_pieces = new LinkedList<PieceIHM>();
	Liste_pieces.addAll(jeu_noir.getPiecesIHM());
	Liste_pieces.addAll(jeu_blanc.getPiecesIHM());
	return Liste_pieces;
	
}
/*Returns:
une liste de PieceIHM qui pourra �tre exploit�e par une IHM*/

public boolean isMoveOk(int xInit,
                        int yInit,
                        int xFinal,
                        int yFinal) {
	boolean val_ret=false;
	this.setMessage("ce d�placement est impossible");
			if (jeu_noir.isMoveOk(xInit, yInit, xFinal, yFinal)||jeu_blanc.isMoveOk(xInit, yInit, xFinal, yFinal)) {
				this.setMessage("ce d�placement est possible");
				val_ret = true;
			}
	return val_ret;
}
/*Permet de v�rifier si une pi�ce peut �tre d�plac�e.
L'algo est le suivant :
s'il n'existe pas de piece du jeu courant aux coordonn�es initiales --> false,
si les coordonn�es finales ne sont pas valides ou �gales aux initiales --> false,
si position finale ne correspond pas � algo de d�placement piece --> false,
s'il existe une pi�ce interm�diaire sur la trajectoire --> false (sauf cavalier),
s'il existe une pi�ce positionn�es aux coordonn�es finales :
si elle est de la m�me couleur --> false ou tentative roque du roi,
sinon : prendre la pi�ce interm�diaire (vigilance pour le cas du pion) et d�placer la pi�ce -->true,
sinon d�placer la pi�ce -->true

Parameters:
xInit - position initiale
yInit -
xFinal -
yFinal -
Returns:
true si le d�placement est effectu�, false sinon*/

public boolean move(int xInit,
                    int yInit,
                    int xFinal,
                    int yFinal) {
	boolean val_ret=false;
	if(this.isMoveOk(xInit,yInit,xFinal,yFinal)) {
		jeu_noir.move(xInit,yInit,xFinal,yFinal);
		jeu_blanc.move(xInit,yInit,xFinal,yFinal);
		val_ret=true;
	}
	
	return val_ret;
}
/*Permet de d�placer une pi�ce connaissant ses coordonn�es initiales vers ses coordonn�es finales. l'algo v�rifie que le d�placement est l�gal, effectue ce d�placement avec l'�ventuelle capture, rembobine si le d�placement et la capture ont mis le roi en �chec
Specified by:
move in interface BoardGames
Parameters:
xInit - position initiale
yInit -
xFinal -
yFinal -
Returns:
true si le d�placement est effectu�, false sinon*/

public java.lang.String toString(){
	String ret = jeu_blanc.toString() +"\n"+ jeu_noir.toString();
	return ret;	
}
/*Overrides:
toString in class java.lang.Object*/

public Couleur getColorCurrentPlayer() {
	return this.ColorCurrentPlayer;
}
/*Specified by:
getColorCurrentPlayer in interface BoardGames
Returns:
couleur du jeu courant*/

private void setColorCurrentPlayer(Couleur colorCurrentPlayer) {
	ColorCurrentPlayer = colorCurrentPlayer;
}

public Couleur getPieceColor(int x,
                             int y) {
	Couleur val_ret=null;
	if(jeu_noir.isPieceHere(x,y)) {
		val_ret=Couleur.NOIR;
	}
	else if(jeu_blanc.isPieceHere(x,y)) {
		val_ret=Couleur.BLANC;
	}
		
	return val_ret;
}
/*Specified by:
getPieceColor in interface BoardGames
Returns:
la couleur de la pi�ce s�lectionn�e*/


public java.lang.String getMessage(){
	return this.message;
}
/*Specified by:
getMessage in interface BoardGames
Returns:
message relatif aux d�placement, capture, etc.*/

private void setMessage(String message) {
	this.message = message;
}

public boolean isEnd() {
	//TODO
	boolean val_ret=false;
	return val_ret;
}
/*Specified by:
isEnd in interface BoardGames
Returns:
true si c'est la fin du jeu*/
public static void main(String[] args) {
	Echiquier monEchiquier = new Echiquier();
	System.out.println(monEchiquier);
	System.out.println(monEchiquier.getColorCurrentPlayer());
	monEchiquier.switchJoueur();
	System.out.println(monEchiquier.getColorCurrentPlayer());
	System.out.println(monEchiquier.getPieceColor(0,0));
	
}
	
}

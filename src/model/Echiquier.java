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
une liste de PieceIHM qui pourra être exploitée par une IHM*/

public boolean isMoveOk(int xInit,
                        int yInit,
                        int xFinal,
                        int yFinal) {
	boolean val_ret=false;
	this.setMessage("ce déplacement est impossible");
			if (jeu_noir.isMoveOk(xInit, yInit, xFinal, yFinal)||jeu_blanc.isMoveOk(xInit, yInit, xFinal, yFinal)) {
				this.setMessage("ce déplacement est possible");
				val_ret = true;
			}
	return val_ret;
}
/*Permet de vérifier si une piéce peut être déplacée.
L'algo est le suivant :
s'il n'existe pas de piece du jeu courant aux coordonnées initiales --> false,
si les coordonnées finales ne sont pas valides ou égales aux initiales --> false,
si position finale ne correspond pas à algo de déplacement piece --> false,
s'il existe une piéce intermédiaire sur la trajectoire --> false (sauf cavalier),
s'il existe une piéce positionnées aux coordonnées finales :
si elle est de la méme couleur --> false ou tentative roque du roi,
sinon : prendre la piéce intermédiaire (vigilance pour le cas du pion) et déplacer la piéce -->true,
sinon déplacer la piéce -->true

Parameters:
xInit - position initiale
yInit -
xFinal -
yFinal -
Returns:
true si le déplacement est effectué, false sinon*/

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
/*Permet de déplacer une piéce connaissant ses coordonnées initiales vers ses coordonnées finales. l'algo vérifie que le déplacement est légal, effectue ce déplacement avec l'éventuelle capture, rembobine si le déplacement et la capture ont mis le roi en échec
Specified by:
move in interface BoardGames
Parameters:
xInit - position initiale
yInit -
xFinal -
yFinal -
Returns:
true si le déplacement est effectué, false sinon*/

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
la couleur de la pièce sélectionnée*/


public java.lang.String getMessage(){
	return this.message;
}
/*Specified by:
getMessage in interface BoardGames
Returns:
message relatif aux déplacement, capture, etc.*/

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

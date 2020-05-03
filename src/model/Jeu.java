package model;

import java.util.LinkedList;
import java.util.List;

import tools.ChessPiecesFactory;

public class Jeu {
	private Couleur couleur;
	private List<Pieces> pieces;
	private boolean castling;
	
	public Jeu(Couleur couleur) {
		this.couleur = couleur;
		this.pieces = ChessPiecesFactory.newPieces(couleur);
		this.castling = false;
	}
	
	public java.lang.String toString(){
		/*le nom et les coordonnées x et y de la pièce*/
		String str_piece="";
		for (Pieces p : pieces) {
			str_piece = str_piece + " " + p.toString();
		}
		return str_piece;
	}

	

	public boolean isPieceHere(int x, int y) {
		boolean val_ret=false; 
		for (Pieces p : pieces) {
			if (x == p.getX() && y == p.getY()) {
				val_ret=true;
			}
		}
		return val_ret;
	}
	
	private Pieces findPiece(int x, int y){
		if (isPieceHere(x, y)) {
			for (Pieces p : pieces) {
				if (x == p.getX() && y == p.getY()) {
					return p;
				}
			}
		}
		return null;
	}
	


public boolean isMoveOk(int xInit,
                        int yInit,
                        int xFinal,
                        int yFinal) {
	boolean val_ret=false; 
	Pieces piece = findPiece(xInit,yInit);
	if (piece != null) {
		val_ret=piece.isMoveOk(xFinal, yFinal);
	}
	
	return val_ret;
}
/*Parameters:
xInit -
yInit -
xFinal -
yFinal -
Returns:
true si piece du jeu peut être déplacée aux coordonnées finales, false sinon*/

public boolean move(int xInit,
                    int yInit,
                    int xFinal,
                    int yFinal) {
	boolean val_ret=false; 
	if (isMoveOk(xInit,yInit,xFinal,yFinal)) {
		Pieces piece = findPiece(xInit,yInit);
		piece.move(xFinal,yFinal);
		val_ret=true;
	}
	
	return val_ret;
}


/*Parameters:
xInit -
yInit -
xFinal -
yFinal -
Returns:
true si déplacement pièce effectué*/

public void setPossibleCapture(){
	
}
/*
 * PAS A FAIRE POUR LA 1ERE IT
 *  Si une capture d'une pièce de l'autre jeu est possible met à jour 1 booléen
capture*/

/*public boolean capture(int xCatch,
                       int yCatch){}*/
/*
 * PAS A FAIRE POUR LA 1ERE IT
 * Parameters:
xCatch -
yCatch -
Returns:
true si la piece aux coordonnées finales a été capturée*/


public Couleur getPieceColor(int x,
                             int y){
	
	Couleur couleur = null;
	Pieces piece = findPiece(x,y);
	if (piece!=null) {
		couleur = piece.getCouleur();
	}
	return couleur;
}
/*Parameters:
x -
y -
Returns:
couleur de la pièce aux coordonnées x, y*/

public java.lang.String getPieceType(int x,
                                     int y){
	String type=null;
	Pieces piece = findPiece(x,y);
	if (piece!=null) {
		type = piece.getClass().getSimpleName();
	}
	return type;
}
/*Parameters:
x -
y -
Returns:
type de la pi�ce aux coordonn�es x,y c'est � dire le nom de la classe : maPiece.getClass().getSimpleName();*/

public Couleur getCouleur(){
	return this.couleur;
}
/*Returns:
couleur du jeu
*/

/**
* @return une vue de la liste des pièces en cours
* ne donnant que des accès en lecture sur des PieceIHM
* (type piece + couleur + liste de coordonnées)
*/
/**
* @return une vue de la liste des pièces en cours
* ne donnant que des accès en lecture sur des PieceIHM
* (type piece + couleur + liste de coordonnées)
*/
public List<PieceIHM> getPiecesIHM(){
	PieceIHM newPieceIHM = null;
	List<PieceIHM> list = new LinkedList<PieceIHM>();
	for (Pieces piece : pieces){
		boolean existe = false;
		// si le type de piece existe déjà dans la liste de PieceIHM
		// ajout des coordonnées de la pièce dans la liste de Coord de ce type
		// si elle est toujours en jeu (x et y != -1)
		for ( PieceIHM pieceIHM : list){
			if ((pieceIHM.getTypePiece()).equals(piece.getClass().getSimpleName())){
				existe = true;
				if (piece.getX() != -1){
					pieceIHM.add(new Coord(piece.getX(), piece.getY()));
				}
			}
		}
		// sinon, création d'une nouvelle PieceIHM si la pièce est toujours en jeu
		if (! existe) {
			if (piece.getX() != -1){
				newPieceIHM = new PieceIHM(piece.getClass().getSimpleName(),
				piece.getCouleur());
				newPieceIHM.add(new Coord(piece.getX(), piece.getY()));
				list.add(newPieceIHM);
			}
		}
	}
	return list;
}
public void setCastling(){
	this.castling=true;
}
/*met à jour un booléen pour activer l'hypothèse d'un roque du roi*/

/*public void undoMove(){}*/

/*public void undoCapture(){}*/


public boolean isPawnPromotion(int xFinal, int yFinal) {
	boolean val_ret=false; 
	Pieces piece = findPiece(xFinal, yFinal);
		if (piece.getClass().getSimpleName() == "Pion" && (yFinal == 0 || yFinal == 7)) {
			val_ret=true;
		}
		return val_ret;
}

/*Parameters:
xFinal -
yfinal -
Returns:
true si on est bien dans le cas d'une promotion du pion*/

public boolean pawnPromotion(int xFinal,
                             int yFinal,
                             java.lang.String type){
	boolean val_ret=false; 
	if (isPawnPromotion(xFinal,yFinal)) {
		if (type == "Cavalier" || type == "Fou" || type == "Reine" || type == "Tour") {
			val_ret=true;
			Pieces new_piece = null;
			Coord coord_piece = new Coord(xFinal,yFinal);

			if (type == "Cavalier") {
				new_piece = new Cavalier(this.couleur, coord_piece);
			}
			else if (type == "Fou") {
				new_piece = new Fou(this.couleur, coord_piece);
			}
			else if(type == "Reine"){
				new_piece = new Reine(this.couleur, coord_piece);
			}
			else{
				new_piece = new Tour(this.couleur, coord_piece);
					}
			
			Pieces old_piece = findPiece(xFinal, yFinal);
			this.pieces.remove(old_piece);
			this.pieces.add(new_piece);
			
		}
	}
	return val_ret;
}

/*Parameters:
yfinal -
xFinal -
type - = type de Pieces dans lequel le pion est promu
Returns:
true si promotion OK*/

public Coord getKingCoord(){
	Coord coord_piece = null;
	for (Pieces piece : pieces) {
		if (piece.getClass().getSimpleName() == "Roi") {
			int x = piece.getX();
			int y = piece.getY();
			coord_piece = new Coord(x,y);
		}
	}
	return coord_piece;
}
/*Returns:
coordonnées du roi*/
	
	
	public static void main(String[] args) {
		Jeu monJeu = new Jeu(Couleur.NOIR);
		System.out.println(monJeu);
	}
}










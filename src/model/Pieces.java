package model;

/**
 * @author Marianne
 */
public interface Pieces {
	
	/**
	 * Renvoie l'indice de la colonne o� est positionn�e la piece
	 * @return
	 */
	public int getX();
	
	/**
	 * Renvoie l'indice de la ligne o� est positionn�e la piece
	 * @return
	 */
	public int getY();
	
	/**
	 * Renvoie la couleur de la piece
	 * @return
	 */
	public Couleur getCouleur();
	
	/**
	 * Renvoie true si d�placement l�gal en fonction des algo de d�placement sp�cifique de chaque pi�ce
	 * @param xFinal, yFinal
	 * @return 
	 */
	public boolean isMoveOk(int xFinal, int yFinal)
	
	/**
	 * Renvoie true si le d�placement est effectu�
	 * @param xFinal, yFinal
	 * @return 
	 */
	public boolean move(int xFinal, int yFinal)
	
	/**
	 * Renvoie true si piece effectivement captur�e 
	 * Positionne x et y � -1
	 * @return 
	 */
	public boolean capture();
	
	
}
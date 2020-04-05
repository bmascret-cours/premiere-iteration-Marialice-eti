package model;

/**
 * @author Marianne
 */
public interface Pieces {
	
	/**
	 * Renvoie l'indice de la colonne où est positionnée la piece
	 * @return
	 */
	public int getX();
	
	/**
	 * Renvoie l'indice de la ligne où est positionnée la piece
	 * @return
	 */
	public int getY();
	
	/**
	 * Renvoie la couleur de la piece
	 * @return
	 */
	public Couleur getCouleur();
	
	/**
	 * Renvoie true si déplacement légal en fonction des algo de déplacement spécifique de chaque pièce
	 * @param xFinal, yFinal
	 * @return 
	 */
	public boolean isMoveOk(int xFinal, int yFinal)
	
	/**
	 * Renvoie true si le déplacement est effectué
	 * @param xFinal, yFinal
	 * @return 
	 */
	public boolean move(int xFinal, int yFinal)
	
	/**
	 * Renvoie true si piece effectivement capturée 
	 * Positionne x et y à -1
	 * @return 
	 */
	public boolean capture();
	
	
}
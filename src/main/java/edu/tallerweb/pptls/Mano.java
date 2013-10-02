package edu.tallerweb.pptls;

import java.util.ArrayList;

/**
 * Representa una de las Manos involucradas en el juego
 */
public class Mano {
	private final Forma forma;
	private final ArrayList<Integer> perdioCon = new ArrayList<Integer>();
	/**
	 * Toda Mano debe crearse con una forma dada, que será
	 * la que determine su condición en el juego.
	 * @param forma, la Forma que adopta la Mano.
	 */
	public Mano(final Forma forma) {
		this.forma=forma;
		this.perdioCon.add(getNext(0));
		this.perdioCon.add(getNext(1));
	}
	/**
	 se reservan para evaluar estados del Resultado.
	 */
	public Resultado jugarCon(final Mano otra) {
		if(this.forma.getValor().equals(otra.forma.getValor()))
			return Resultado.EMPATA;
		if(this.perdioCon.contains(otra.forma.getValor()))
			return Resultado.GANA;
		return Resultado.PIERDE;
	}
/*
 * es necesario que al recorrerlo compare con los proximos 2, 
 * ya que a los demas les gana y con simismo empata.
 * */
	private Integer getNext(int out){
		if(this.forma.getValor()-out>4){
			return (this.forma.getValor()-out-5);		
		}
		return this.forma.getValor()-out;
	}

}

package Logica;


import java.awt.List;
import java.util.ArrayList;

public class Vertice {

	private int id;
	private String label;
	private double peso;
	
	
	//atributos de auxilio para diskjtra
	private Aresta arestaCaminho;
	private double pesoMinCaminho;
	private double pesoMaxCaminho;
	private boolean naFila;
	private int grupo;
	
	public Aresta getArestaCaminho() {
		return arestaCaminho;
	}

	public void setArestaCaminho(Aresta arestaCaminho) {
		this.arestaCaminho = arestaCaminho;
	}

	public double getPesoMinCaminho() {
		return pesoMinCaminho;
	}

	public void setPesoMinCaminho(double pesoMinCaminho) {
		this.pesoMinCaminho = pesoMinCaminho;
	}

	public double getPesoMaxCaminho() {
		return pesoMaxCaminho;
	}

	public void setPesoMaxCaminho(double pesoMaxCaminho) {
		this.pesoMaxCaminho = pesoMaxCaminho;
	}

	public boolean isNaFila() {
		return naFila;
	}

	public void setNaFila(boolean naFila) {
		this.naFila = naFila;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

	public Vertice(int id) {
		super();
		this.id = id;
	}

	public Vertice(int id, String label, double peso) {
		super();
		this.id = id;
		this.label = label;
		this.peso = peso;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * @param peso
	 *            the peso to set
	 */
	public void setPeso(double peso) {

		if (peso > 0)
			this.peso = peso;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (!(obj instanceof Vertice))
			return false;

		Vertice other = (Vertice) obj;

		if (id != other.id)

			return false;
		return true;
	}

	public String toString() {

		return "Vertice(" + id + ")";
	}

	
	
	}
	

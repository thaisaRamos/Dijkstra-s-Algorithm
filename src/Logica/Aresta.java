package Logica;


public class Aresta {

	private int id;
	private String label;
	private double preco;
	private double tempo;

	private Vertice v1;
	private Vertice v2;
	private double peso;
	private boolean ehDirecionada;


	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getTempo() {
		return tempo;
	}

	public void setTempo(double tempo) {
		this.tempo = tempo;
	}

	public Aresta(int id) {
		super();
		this.id = id;
	}

	public Aresta(int id, String label, Vertice v1, Vertice v2, double peso,double preco,double tempo,
			boolean ehDirecionada) {
		super();
		this.id = id;
		this.v1 = v1;
		this.v2 = v2;
		this.peso = peso;
		this.ehDirecionada = ehDirecionada;
		this.label = label;
		this.preco =preco;
		this.tempo=tempo;
	}

	public Vertice getOposto(Vertice v) {

		if (v1.equals(v)) {

			return v2;
		} else {
			return v1;

		}

	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	/**
	 * @return the v1
	 */
	public Vertice getV1() {
		return v1;
	}

	/**
	 * @param v1
	 *            the v1 to set
	 */
	public void setV1(Vertice v1) {
		this.v1 = v1;
	}

	/**
	 * @return the v2
	 */
	public Vertice getV2() {
		return v2;
	}

	/**
	 * @param v2
	 *            the v2 to set
	 */
	public void setV2(Vertice v2) {
		this.v2 = v2;
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
	public void setPeso(int peso) {
		this.peso = peso;
	}

	/**
	 * @return the ehDirecionada
	 */
	public boolean isEhDirecionada() {
		return ehDirecionada;
	}

	/**
	 * @param ehDirecionada
	 *            the ehDirecionada to set
	 */
	public void setEhDirecionada(boolean ehDirecionada) {
		this.ehDirecionada = ehDirecionada;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
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
		if (getClass() != obj.getClass())
			return false;
		Aresta other = (Aresta) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

	public String toString(){
		
		return "Rota ("+v1.getLabel()+","+v2.getLabel()+")";
	}

}

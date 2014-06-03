package Logica;

import java.util.Comparator;


public class ComparadorVerticeMinPesoCaminho implements Comparator<Vertice> {

	@Override
	public int compare(Vertice v1, Vertice v2) {
		
		return (int) ( (v1.getPesoMinCaminho() - v2.getPesoMinCaminho()) );
	}
	// retorna 0 se for igual, negativo se v1 for menor que v2, e positivo caso contrario.
}

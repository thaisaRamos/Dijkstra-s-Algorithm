package Logica;

import java.util.List;

import exception.ArestaComVerticeInvalidoException;


public class GrafoLista implements Grafo{

	
	public int getNumeroVertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumeroArestas() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void adicionarVertice(Vertice v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adicionarAresta(Aresta a)
			throws ArestaComVerticeInvalidoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerVertice(Vertice v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerAresta(Aresta a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vertice getVertice(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Aresta getAresta(String nome1, String nome2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vertice[] getVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getArestas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getArestasIncidentes(Vertice v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getVerticesAdjacentes(Vertice v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aresta> dijkstra(Vertice vi, Vertice vf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void imprime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Aresta> dijkstra(int vi, int vf) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
package Logica;
import java.util.List;

import exceçao.ArestaComVerticeInvalidoException;
import exceçao.VerticeDuplicadoException;



public interface Grafo {
	
	
	int getNumeroVertices();
	int getNumeroArestas();
		
	void adicionarVertice(Vertice v) throws VerticeDuplicadoException;
	void adicionarAresta(Aresta a) throws ArestaComVerticeInvalidoException;
	void removerVertice(Vertice v) throws VerticeDuplicadoException;
	void removerAresta(Aresta a);
	
	//Retorna o v�rtice que tem essa identifica��o
	Vertice getVertice (String nome);	
	
	//Retorna a aresta que tem vertice1 como origem e vertice2 como destino
	Aresta getAresta (String nome1 , String nome2);
		
	Vertice[] getVertices();
	List getArestas();
	
    List getArestasIncidentes(Vertice v);
    List getVerticesAdjacentes(Vertice v);
    List<Aresta> dijkstra(Vertice vi, Vertice vf);
    List<Aresta> dijkstra(int vi, int vf);
    void imprime ();
        
    
    

}

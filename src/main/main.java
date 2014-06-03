package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import GUI.JanelaPrincipal;



public class main {


	public static void main(String[] args) {
		JanelaPrincipal main =new JanelaPrincipal();

		/*GrafoMatriz g = new GrafoMatriz();
		Vertice v1 = new Vertice(01, "vertice1", 10);
		Vertice v2 = new Vertice(02, "vertice2", 20);
		Vertice v3 = new Vertice(03, "vertice3", 30);
		Vertice v9 = new Vertice(10, "vertice9", 90);
		Vertice v20 = new Vertice(20, "vertice90", 20);
		Aresta a = new Aresta(01, "aresta1", v1, v2,1,80,30, true);
		Aresta a2 = new Aresta(03, "aresta2", v1, v3, 50,80,20, true);
		Aresta a9 = new Aresta(07,"",v2,v9,50,70,100,true);
		Aresta a10 = new Aresta(07,"",v3,v9,100,70,60,true);
		Aresta a40 = new Aresta(07,"",v1,v20,100,70,60,true);
		try{
		g.adicionarVertice(v1);
		g.adicionarVertice(v2);
		g.adicionarVertice(v3);
		g.adicionarVertice(v9);
		g.adicionarVertice(v20);
		}
		catch (VerticeDuplicadoException e) {
			System.out.println("vertice ja existe");
		}
		try{
			g.adicionarAresta(a);
			g.adicionarAresta(a2);
			g.adicionarAresta(a9);
			g.adicionarAresta(a10);
			g.adicionarAresta(a40);
		}
		catch (ArestaComVerticeInvalidoException e) {
			System.out.println("aresta invalida");
		}

		System.out.println(g.getAresta("vertice1", "vertice2"));
		g.removerAresta(a10);
		g.imprime();
		try{
			System.out.println(" EX");
		g.removerVertice(v20);
		g.removerVertice(v20);
		}
		catch (VerticeDuplicadoException e) {
			System.out.println("Vertice duplicado");
		}
		g.imprime();
		System.out.println(g.getNumeroVertices());
		System.out.println(g.getVertice("vertice1"));
		
		List arestas = new ArrayList();
		arestas = g.getArestas();
		System.out.println(" LISTA DE TODAS AS ROTAS" +arestas.toString());
		
		List aI = new ArrayList();
		aI = g.getArestasIncidentes(v1);
		System.out.println("AKI DOIS "+aI.toString());
		
		List lAA = new ArrayList();
		lAA = g.getVerticesAdjacentes(v1);
		System.out.println(" AKI ___"+lAA.toString());

		List aD = new ArrayList();
		aD = g.dijkstraMenorTempo(v1, v9);
		Collections.reverse(aD);
		System.out.println(aD.toString());

		g.imprime();

	}

*/
	}

}
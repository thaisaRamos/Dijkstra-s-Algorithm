package Facade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Logica.Aresta;
import Logica.Grafo;
import Logica.GrafoMatriz;
import Logica.Vertice;

import exception.ArestaComVerticeDuplicadoException;
import exception.ArestaComVerticeInvalidoException;
import exception.NenhumaRotaException;
import exception.PesoInvalidoException;
import exception.VerticeDuplicadoException;
import exception.VerticeNaoExistenteExeception;


public class AirportServices {
	Grafo g = new GrafoMatriz();
	int i =0;
	//uso do pradrao singleton 
	private static AirportServices instance;

	private AirportServices(Grafo g) {
		if (g != null)
			this.g = g;
	}

	public static AirportServices getInstance() {
		if (instance == null)
			instance = new AirportServices(null);
		return instance;
	}

	public static AirportServices getInstance(Grafo g) {
		if (instance == null)
			instance = new AirportServices(g);
		return instance;
	}


	public void adicionarAeroporto(String nome) throws VerticeDuplicadoException{
		
		Vertice v = new Vertice (i,nome,00);
		i++;
		try{
		g.adicionarVertice(v);
	}
		catch (VerticeDuplicadoException e) {
			throw new VerticeDuplicadoException();
		}
	}
	public void adicionarRota(String Aeroporto1 , String Aeroporto2,double distancia,double preco,double tempo) throws ArestaComVerticeInvalidoException, PesoInvalidoException, ArestaComVerticeDuplicadoException{

		Aresta a;

		try{

			Vertice v1 ,v2;

			v1 = g.getVertice(Aeroporto1);
			v2 = g.getVertice(Aeroporto2);

			if (distancia <= 0) {
				throw new PesoInvalidoException();
			}

			if (v1.equals(v2)) {
				
				throw new ArestaComVerticeDuplicadoException();
			}

			a = new Aresta(0,"rotas",v1 ,v2 , distancia,tempo,preco, true);

			g.adicionarAresta(a);
		}
		catch (NullPointerException e) {
			throw new ArestaComVerticeInvalidoException();
		}

	}

	public Vertice getVertices(String nomeAero){
		return g.getVertice(nomeAero);
	}

	public boolean ExisteVertice(String nomeAero){
		if(g.getVertice(nomeAero)!=null){
		return true;
	}	
		else{
			return false;
		}
	}
	
	public void RemoverAeroporto(String nome) throws VerticeNaoExistenteExeception{
		try{
		Vertice v1;
		v1 =g.getVertice(nome);
		
		g.removerVertice(v1);
		
		}
		catch (VerticeDuplicadoException ase) {
			
			throw new VerticeNaoExistenteExeception();
		}
	}
	public void removerRota(String nome1 , String nome2) throws NenhumaRotaException{
		try {
			Aresta a;
			a = g.getAresta(nome1, nome2);
			g.removerAresta(a);
		} catch (NullPointerException npe) {
			throw new NenhumaRotaException();
		}
	}

	public double LocalizaRota(String aero1,String aero2){
		Aresta a;
		a = g.getAresta(aero1, aero2);
		return a.getPeso();
	}

	public List listarTodosOsAeroportos(){
		Vertice vertics[];
		vertics=g.getVertices();
		
		List aux = new ArrayList();
		for(int i =0;i<g.getNumeroVertices();i++){
			if(vertics[i]!=null){
			aux.add(vertics[i].getLabel());
			}
		}
		return aux;
	}

	public List listarTodosAsRotas(){
		
		List aux = new ArrayList();
		aux = g.getArestas();
		
	
		return aux;
	}

	public List calcularMenorCam(String nome1 , String nome2){
		
		int v1 =((GrafoMatriz) g).getVert(nome1);
		int v2 = ((GrafoMatriz) g).getVert(nome2);
		
		List aux = new ArrayList<Aresta>();
		aux = ((GrafoMatriz)g).dijkstra(v1, v2);
		Collections.reverse(aux);
		return aux;
	}


	public List calcularMenorPreco(String nome1 , String nome2){
		
		Vertice v1 ,v2;
		v1 = g.getVertice(nome1);
		v2 = g.getVertice(nome2);
		
		List aux = new ArrayList<Aresta>();
		aux = ((GrafoMatriz)g).dijkstraMenorPreco(v1, v2);
		Collections.reverse(aux);
		return aux;
	}

	
	public List calcularMenorTempo(String nome1 , String nome2){
		
		Vertice v1 ,v2;
		v1 = g.getVertice(nome1);
		v2 = g.getVertice(nome2);
		
		List aux = new ArrayList<Aresta>();
		aux = ((GrafoMatriz)g).dijkstraMenorTempo(v1, v2);
		Collections.reverse(aux);
		return aux;
	}

}
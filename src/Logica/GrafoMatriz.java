package Logica;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import exception.ArestaComVerticeInvalidoException;
import exception.VerticeDuplicadoException;



public class GrafoMatriz implements Grafo {

	private Aresta[][] arestas;
	private Vertice[] vertices;
	private int numeroVertices;
	private int TAMANHO_MAXIMO = 10;
	private int TAMANHO_MAXIMO_MAX=10;
	private int numeroArestas;
	private int numeroRealVertices=0;


	public GrafoMatriz() {
		this.arestas = new Aresta[TAMANHO_MAXIMO][TAMANHO_MAXIMO];
		this.vertices = new Vertice[TAMANHO_MAXIMO];
		this.numeroVertices = 0;
		this.numeroArestas =0;

	}
	public Aresta[][] gettArestas(){
		return arestas;
	}

	public void setTAMAHO_MAXIMO_MAX(){
		this.TAMANHO_MAXIMO_MAX = TAMANHO_MAXIMO_MAX *2;
	}


	public int getNumeroVertices() {
		return numeroRealVertices;
	}


	public int getNumeroArestas() {
		return numeroArestas;

	}



	public void adicionarVertice(Vertice v) throws VerticeDuplicadoException
	{
		if (numeroVertices <TAMANHO_MAXIMO){
			for(int i =0;i<numeroVertices;i++){
				if(vertices[i].getLabel().equals(v.getLabel()))
					throw new VerticeDuplicadoException();
			}

			vertices[numeroVertices] = v;
			numeroVertices++;
			numeroRealVertices++;
		}
		else {

			realocarVertices();
			realocarArestas();

		}
	}








	public void adicionarAresta(Aresta a) throws ArestaComVerticeInvalidoException
	{

		int i1 , i2;
		Vertice v1 , v2;
		v1 = a.getV1();
		v2 = a.getV2();
		i1=-1;
		i2=-1;
		//i1 = getVert(v1.getLabel());
		//i2= getVert(v2.getLabel());

		for(int k=0;k<numeroVertices;k++){

			if (vertices[k].equals(v1)){

				i1=k;
			}
			if (vertices[k].equals(v2)){
				i2= k;
			}



		}

		if (i1 == -1 || i2 == -1){
			throw new ArestaComVerticeInvalidoException();
		}

		if (a.isEhDirecionada()){
			arestas[i1][i2]= a;
			numeroArestas = numeroArestas +1 ;
		} else {
			arestas[i1][i2]=a;
			arestas[i2][i1]=a;
			numeroArestas = numeroArestas +2 ;
		}
	}




	public void removerVertice(Vertice v) throws VerticeDuplicadoException {
		int n=-1;
		for (int i=0 ; i < numeroVertices ; i++){
			if (vertices[i]!=null && vertices[i].equals(v)){
				n = i;
				vertices[i] = null;
				numeroRealVertices = numeroRealVertices -1;
				if(n!=-1){
				for(int j =0 ; j < numeroVertices ; j++){
					if (arestas[n][j]!= null)
						numeroArestas= numeroArestas -1;
					if (arestas[n][j]!= null)
						numeroArestas= numeroArestas -1;
					arestas[n][j] = null;
					arestas[j][n] = null;
				}
				}			
				else{
					throw new VerticeDuplicadoException();
				}
			}
		}
	}

	



	public void removerAresta(Aresta a) {
		Vertice v1 , v2;
		int i1, i2;
		v1 = a.getV1();
		v2 = a.getV2();

		i1 = -1;
		i2 =-1;
		for (int i =0; i<numeroVertices ;i++){
			if (vertices[i].equals(v1)){
				i1 = i;
			}

			if (vertices[i].equals(v2)){
				i2= i;
			}



		}
		arestas[i1][i2] = null;
		numeroArestas = numeroArestas -1;

		if(!a.isEhDirecionada()){
			arestas[i2][i1] = null;
			numeroArestas = numeroArestas -1 ;

		}



	}


	public Vertice getVertice(String nome) {

		for (int i = 0; i < vertices.length; i++) {
			String label = vertices[i].getLabel();
			if(label.compareTo(nome) == 0){
				return vertices[i];
			}
		} 
		return null;
	}

	public int getVert(String nome){

		for (int i=0;i< numeroVertices;i++){
			String label = vertices[i].getLabel();
			if(label.equals(nome)){
				return i;
			}
		}
		return -1;

	}



	public Aresta getAresta(String vert1 , String vert2) {
		Vertice ve1 ,ve2;
		ve1 = getVertice(vert1);
		ve2 = getVertice(vert2);
		for (int i =0; i < numeroVertices; i++){
			for (int j =0;j < numeroVertices;j++){
				if (arestas[i][j]!= null){
					if (ve1.equals(arestas[i][j].getV1()) && ve2.equals((arestas[i][j].getV2()))){
						return arestas[i][j];
					}
				}
			}
		}
		return null;
	}

	@Override
	public Vertice[] getVertices() {
		return vertices;
	}

	@Override
	public List getArestas() {
		List todasasArestas = new ArrayList();
	
		int k=0;

		for (int i =0 ; i<numeroVertices;i++){
			for (int j=0;j<numeroVertices;j++){
				if(arestas[i][j] != null){
					todasasArestas.add(arestas[i][j]);
					k++;	

				}			
			}

		}

		
		return todasasArestas;

	}

	@Override
	public List<Aresta> getArestasIncidentes(Vertice v) {

		List<Aresta> arestasIncidentes = new ArrayList<Aresta>();

		int indV = -1;

		for (int i = 0; i < numeroVertices; i++) {
			if(vertices[i]!=null){
			if (vertices[i].equals(v)) {
				indV = i;
			}
			}
		}


		for (int i = 0; i < numeroVertices; i++) {

			if (arestas[indV][i] != null) {

				arestasIncidentes.add(arestas[indV][i]);

			}
		}

		return arestasIncidentes;
	}

	@Override


	public List getVerticesAdjacentes(Vertice v) {

		List verticesAdjacentes = new ArrayList();


		List arestasIncidentes = getArestasIncidentes(v);


		for (Object aresta : arestasIncidentes) {

			Vertice vOposto = ((Aresta) aresta).getOposto(v);

			verticesAdjacentes.add(vOposto);


		}



		return verticesAdjacentes;


	}




	private void realocarVertices() {
		Vertice novoArray[]; 
		setTAMAHO_MAXIMO_MAX();
		novoArray = new Vertice[TAMANHO_MAXIMO_MAX];


		System.arraycopy(vertices, 0, novoArray, 0, TAMANHO_MAXIMO);

		vertices = novoArray;


	}

	private void realocarArestas() {
		Aresta novaMatriz[][];
		novaMatriz= new Aresta[TAMANHO_MAXIMO_MAX][TAMANHO_MAXIMO_MAX];
		for (int i=0; i<TAMANHO_MAXIMO; i++){

			System.arraycopy(arestas[i], 0, novaMatriz[i], 0, TAMANHO_MAXIMO);
		}


		TAMANHO_MAXIMO = TAMANHO_MAXIMO_MAX;

		arestas = novaMatriz;
	}


	public void imprime () {
		System.out.print ("   ");
		for (int i = 0; i < this.numeroVertices; i++) 
			System.out.print (i + "   "); 
		System.out.println ();
		for (int i = 0; i < this.numeroVertices; i++) { 
			System.out.print (i + "  ");
			for (int j = 0; j < this.numeroVertices; j++)
				System.out.print (this.arestas[i][j] + "   ");
			System.out.println ();
		}

	}





	public List percursoLargura(Vertice vo){

		List verticesVisitados = new ArrayList();
		Queue filaVertices = new LinkedList();
		filaVertices.add(vo);
		while(!filaVertices.isEmpty()){
			Vertice vAtual =  (Vertice) filaVertices.poll();
			verticesVisitados.add(vAtual);				
			List<Vertice> adjacentes =new ArrayList<Vertice>();

			adjacentes= getVerticesAdjacentes(vAtual);
			for(Object adjacente : adjacentes){
				if(!filaVertices.contains(adjacente)&&
						!verticesVisitados.contains(adjacente)){
					filaVertices.add(adjacentes);
				}
			}
		}

		return verticesVisitados;
	}


	public List<Aresta> dijkstra(Vertice vi, Vertice vf) {
		
		Comparator<Vertice> comparador = new ComparadorVerticeMinPesoCaminho();
		PriorityQueue<Vertice> Q = new PriorityQueue<Vertice>(numeroVertices, comparador);
		
		for(Vertice v : vertices){
			if(v != vi){
				if (v != null){
					v.setNaFila(true);
					v.setPesoMinCaminho(Double.MAX_VALUE);
					Q.add(v);
				}
			}
		}
		vi.setPesoMinCaminho(0);
		Q.add(vi);
	
		while(!Q.isEmpty()){
			Vertice v = Q.poll();
			v.setNaFila(false);
			for(Aresta a : getArestasIncidentes(v)){
				Vertice w = a.getOposto(v);
				if(w.isNaFila() && v.getPesoMinCaminho() + a.getPeso() < w.getPesoMinCaminho()){
					Q.remove(w);
					w.setPesoMinCaminho(v.getPesoMinCaminho() + a.getPeso());
					w.setArestaCaminho(a);
					Q.add(w);
				}
			}
		}

		List<Aresta> res = new ArrayList<Aresta>();
		Vertice temp = vf;
		
		while(!temp.equals(vi)){
			if (temp != null) {
				Aresta aTemp = temp.getArestaCaminho();
				if (aTemp != null) {
					res.add(aTemp);
					Vertice aux = aTemp.getOposto(temp);
					temp = aux;
				}
			}
		}
		return res;
	}
	
public List<Aresta> dijkstraMenorTempo(Vertice vi, Vertice vf) {
		
		Comparator<Vertice> comparador = new ComparadorVerticeMinPesoCaminho();
		PriorityQueue<Vertice> Q = new PriorityQueue<Vertice>(numeroVertices, comparador);
		
		for(Vertice v : vertices){
			if(v != vi){
				if (v != null){
					v.setNaFila(true);
					v.setPesoMinCaminho(Double.MAX_VALUE);
					Q.add(v);
				}
			}
		}
		vi.setPesoMinCaminho(0);
		Q.add(vi);
	
		while(!Q.isEmpty()){
			Vertice v = Q.poll();
			v.setNaFila(false);
			for(Aresta a : getArestasIncidentes(v)){
				Vertice w = a.getOposto(v);
				if(w.isNaFila() && v.getPesoMinCaminho() + a.getTempo() < w.getPesoMinCaminho()){
					Q.remove(w);
					w.setPesoMinCaminho(v.getPesoMinCaminho() + a.getTempo());
					w.setArestaCaminho(a);
					Q.add(w);
				}
			}
		}

		List<Aresta> res = new ArrayList<Aresta>();
		Vertice temp = vf;
		
		while(!temp.equals(vi)){
			if (temp != null) {
				Aresta aTemp = temp.getArestaCaminho();
				if (aTemp != null) {
					res.add(aTemp);
					Vertice aux = aTemp.getOposto(temp);
					temp = aux;
				}
			}
		}
		return res;
	}


public List<Aresta> dijkstraMenorPreco(Vertice vi, Vertice vf) {
	
	Comparator<Vertice> comparador = new ComparadorVerticeMinPesoCaminho();
	PriorityQueue<Vertice> Q = new PriorityQueue<Vertice>(numeroVertices, comparador);
	
	for(Vertice v : vertices){
		if(v != vi){
			if (v != null){
				v.setNaFila(true);
				v.setPesoMinCaminho(Double.MAX_VALUE);
				Q.add(v);
			}
		}
	}
	vi.setPesoMinCaminho(0);
	Q.add(vi);

	while(!Q.isEmpty()){
		Vertice v = Q.poll();
		v.setNaFila(false);
		for(Aresta a : getArestasIncidentes(v)){
			Vertice w = a.getOposto(v);
			if(w.isNaFila() && v.getPesoMinCaminho() + a.getPreco() < w.getPesoMinCaminho()){
				Q.remove(w);
				w.setPesoMinCaminho(v.getPesoMinCaminho() + a.getPreco());
				w.setArestaCaminho(a);
				Q.add(w);
			}
		}
	}

	List<Aresta> res = new ArrayList<Aresta>();
	Vertice temp = vf;
	
	while(!temp.equals(vi)){
		if (temp != null) {
			Aresta aTemp = temp.getArestaCaminho();
			if (aTemp != null) {
				res.add(aTemp);
				Vertice aux = aTemp.getOposto(temp);
				temp = aux;
			}
		}
	}
	return res;
}

	public List<Aresta> dijkstra(int v1, int v2) {

		Comparator<Vertice> comparador = new ComparadorVerticeMinPesoCaminho();
		PriorityQueue<Vertice> Q = new PriorityQueue<Vertice>(numeroVertices, comparador);
		Vertice vi = getVertices()[v1];
		Vertice vf = getVertices()[v2];
		
		for(Vertice v : vertices){
			if(v != vi){
				if (v != null){
					v.setNaFila(true);
					v.setPesoMinCaminho(Double.MAX_VALUE);
					Q.add(v);
				}
			}
		}
		vi.setPesoMinCaminho(0);
		Q.add(vi);
		
		while(!Q.isEmpty()){
			Vertice v = Q.poll();
			v.setNaFila(false);
			for(Aresta a : getArestasIncidentes(v)){
				Vertice w = a.getOposto(v);
				if(w.isNaFila() && v.getPesoMinCaminho() + a.getPeso() < w.getPesoMinCaminho()){
					Q.remove(w);
					w.setPesoMinCaminho(v.getPesoMinCaminho() + a.getPeso());
					w.setArestaCaminho(a);
					Q.add(w);
				}
			}
		}

		List<Aresta> res = new ArrayList<Aresta>();
		Vertice temp = vf;
		
		while(!temp.equals(vi)){
			if (temp != null) {
				Aresta aTemp = temp.getArestaCaminho();
				if (aTemp != null) {
					res.add(aTemp);
					Vertice aux = aTemp.getOposto(temp);
					temp = aux;
				}
			}
		}
		return res;
	}


}






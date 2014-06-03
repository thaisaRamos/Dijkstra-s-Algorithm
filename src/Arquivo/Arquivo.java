package Arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Logica.Aresta;
import Logica.GrafoMatriz;
import Logica.Vertice;

import exceçao.ArestaComVerticeInvalidoException;
import exceçao.VerticeDuplicadoException;



public class Arquivo {

	public static void main(String[] args) {

		File arquivo = new File("C:/Users/wilsa/Desktop/Grafos.txt.txt");

		try {

			GrafoMatriz g = new GrafoMatriz();
			
			FileReader reader = new FileReader(arquivo);
			BufferedReader buffer = new BufferedReader(reader);


			String linha = null;
			int qtdVertices = 0;
			int qtdArestas =0;


			linha = buffer.readLine();

			if(linha !=null){

				qtdVertices = Integer.parseInt(linha);



				for (int i = 0; i < qtdVertices; i++) {

					linha = buffer.readLine();

					int indSeparador = -1;

					indSeparador = linha.indexOf(";");

					String id = linha.substring(0,indSeparador);
					String label = linha.substring(indSeparador+1);

					int idVertice = Integer.parseInt(id);

					Vertice v = new Vertice(idVertice, label, 0);
					try{
					g.adicionarVertice(v);
					}
					catch (VerticeDuplicadoException e){
						System.out.println("ATEN�AO Este vertice ja existe");
					}
					System.out.println(id+ "-------"+label);
					g.imprime();

				}
				
				
				linha = buffer.readLine();
				qtdArestas = Integer.parseInt(linha);

				for (int i = 0; i < qtdArestas; i++) {

					linha = buffer.readLine();

					int indSeparador = -1;

					indSeparador = linha.indexOf(";");
					
					int indseparador2=-1;
					indseparador2 = linha.indexOf(";",indSeparador+1);
					
					int indseparador3=-1;
					indseparador3 = linha.indexOf(";",indseparador2+1);
					
					int indseparador4=-1;
					indseparador4 = linha.indexOf(";",indseparador3+1);
					
					int indseparador5=-1;
					indseparador5 = linha.indexOf(";",indseparador4+1);
					
					int indseparador6=-1;
					indseparador6 = linha.indexOf(";",indseparador5+1);
					
					
					int indseparador7=-1;
					indseparador7 = linha.indexOf(";",indseparador6+1);
					
					String id = linha.substring(0,indSeparador);
					String label = linha.substring(indSeparador+1,indseparador2);
					String vertice1 = linha.substring(indseparador2+1,indseparador3);
					String vertice2 = linha.substring(indseparador3+1,indseparador4);
					String peso = linha.substring(indseparador4+1,indseparador5);
					String preco = linha.substring(indseparador5+1,indseparador6);
					String tempo = linha.substring(indseparador6+1,indseparador7);
					String direcionada = linha.substring(indseparador7+1);
					
					
					int idAresta = Integer.parseInt(id);
					int pesoAresta = Integer.parseInt(peso);
					int precoAresta = Integer.parseInt(preco);
					int tempoAresta = Integer.parseInt(tempo);
					boolean ehDirecionada = Boolean.parseBoolean(direcionada);
					
					Vertice v1 ,v2;
					v1 = g.getVertice(vertice1);
					v2 = g.getVertice(vertice2);
					
					System.out.println(id+ "---"+label + " ---" + vertice1 + "---"+vertice2 +"---"+ peso+ "---"+preco+"---"+tempo+"---" +direcionada);
					Aresta a = new Aresta(idAresta, label, v1, v2, pesoAresta, precoAresta, tempoAresta, ehDirecionada);
					try	{
					g.adicionarAresta(a);
					}
					catch (ArestaComVerticeInvalidoException avi) {
						System.out.println("Aresta com vertice invalido");
					}
					
					g.imprime();
				}
				Aresta a;
				
				a = g.getAresta("Sao Paulo","Natal");
				g.removerAresta(a);
				g.imprime();
				List menorCam = new ArrayList();
				List menorPrec = new ArrayList();
				List menorTemp = new ArrayList();
				Vertice v1 ,v2;
				v1 = g.getVertice("Sao Paulo");
				v2 = g.getVertice("Natal");
				menorCam = g.dijkstra(v1, v2);
				menorTemp = g.dijkstraMenorTempo(v1, v2);
				menorPrec= g.dijkstraMenorPreco(v1, v2);
				
				Collections.reverse(menorCam);
				System.out.println("A menor rota �");
				System.out.println(menorCam.toString());
		
				Collections.reverse(menorTemp);
				System.out.println("A menor rota por tempo �:");
				System.out.println(menorTemp.toString());
		
				Collections.reverse(menorPrec);
				System.out.println("A menor rota por pre�o �:");
				System.out.println(menorPrec.toString());
			}

			do{

			}while (linha != null);

		} catch (Exception e) {
			System.out.println("Arquivo nao encontrado");
		}
	}

}

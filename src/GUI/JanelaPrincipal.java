package GUI;




import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.text.html.HTMLEditorKit;

import exceçao.ArestaComVerticeDuplicadoException;
import exceçao.ArestaComVerticeInvalidoException;
import exceçao.NenhumaRotaException;
import exceçao.PesoInvalidoException;
import exceçao.VerticeDuplicadoException;
import exceçao.VerticeNaoExistenteExeception;
import fachada.ServicosAeroporto;


public class JanelaPrincipal extends JFrame {

	private JTabbedPane aba;
	private ServicosAeroporto f;
	private JButton localiza;
	private DefaultComboBoxModel modelo;
	private DefaultComboBoxModel modelo2;
	private JComboBox combo;
	private JComboBox combo2;
	private DefaultComboBoxModel modeloDe;
	private DefaultComboBoxModel modeloAte;
	private JComboBox combode;
	private JComboBox comboate;
	private JEditorPane txtLog;
	private JEditorPane txtLog2;
	private JEditorPane txtLog3;
	private JButton criarAresta;
	private JButton removerAresta;
	private JButton criarNo;
	private JButton removerNo;
	private JButton btnCalcular;
	private JButton login;
	private JButton cadastra;
	private JButton listaRota;
	private JButton listaAero;
	private JTextField fieldAeroporto1;
	
	private JTextField fieldDist;
	private JTextField fieldTempo;
	private JTextField fieldPreco;
	private JPanel painelLogin;
	private JPanel paineltest;
	private JPanel painel1;
	private JButton finalizarCadastro;
	private StringBuffer log = new StringBuffer();
	private StringBuffer log2 = new StringBuffer();
	private StringBuffer log3 = new StringBuffer();
	private JRadioButton rb1 = new JRadioButton();
	private JRadioButton rb2 = new JRadioButton();
	private JRadioButton rb3 = new JRadioButton();
	private ButtonGroup grup = new ButtonGroup();
	
	private JLabel nomeCompleto;
	private JTextField fieldNome;
	private JLabel email;
	private JTextField fieldEmail;
	private JLabel telefone;
	private JTextField fieldTelefone;
	
	private JLabel endereco;
	private JLabel cpf;
	
	JTextField end = new JTextField(5);
	JTextField cpffield = new JTextField(5);
	
	
	public JanelaPrincipal() {
        super("Viagens");
		
        this.setSize(600,400);
		this.setLocation(310, 120);
        this.inicializarComponentes();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		//GrafoLista gl = new GrafoLista();
		f = ServicosAeroporto.getInstance();
		
		
	}

	
	private void inicializarComponentes() {
		Container contentPane = this.getContentPane();
		aba = new JTabbedPane();
		ButtonListener ouvinte = new ButtonListener();
		
		contentPane.add(aba);
		
		
		
		
		//PRIMEIRA ABA
		/*painel1 = new JPanel();
		
		JPanel painel111=new JPanel();
		JPanel painel0 = new JPanel();
		JPanel painel01= new JPanel();
		
		
		painel1.setLayout(new BorderLayout());
		
		
		
		painel0.setLayout(new GridLayout(4, 2, 20, 70));
		painel01.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		JTextField texto = new JTextField(5);
		JPasswordField pass = new JPasswordField(5);
		JLabel rotulo1 = new JLabel("Usuario");
		JLabel rotulo2 = new JLabel("Senha");
		texto.setSize(5,5);
		
		pass.setSize(5,5);
		rotulo1.setLabelFor(texto);
		rotulo2.setLabelFor(pass);
		
		painel0.add(rotulo1);
		painel0.add(texto);
		painel0.add(rotulo2);
		painel0.add(pass);
		
		
		painel111.setLayout(new BorderLayout());
		
		login = new JButton ("Login");
		cadastra = new JButton("Cadastra");
		
		login.addActionListener(ouvinte);
		cadastra.addActionListener(ouvinte);
		
		painel0.add(login);
		painel0.add(cadastra);
		
		painel1.setLayout(new BorderLayout());
		desenharRetangulo retangulo1 = new desenharRetangulo();

		
		painel1.add(retangulo1, BorderLayout.CENTER);
		
		painel1.add(painel0,BorderLayout.WEST);
		
		
		
		
		
		painel0.setBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder("Minha conta"),
						BorderFactory.createEmptyBorder(5,5,5,5))
						
				);
	*/	
	
		
		
		
		paineltest = new JPanel();
		paineltest.setLayout(new GridLayout(7,2,15,15));
		painelLogin = new JPanel();
		painelLogin.setLayout(new BorderLayout());
		
		paineltest.setBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder("Dados Pessoais"),
						BorderFactory.createEmptyBorder(25,25,25,25))
						
				);
		
		
		nomeCompleto = new JLabel("Nome Completo:");
		fieldNome = new JTextField(5);
		email = new JLabel("Email:");
		fieldEmail = new JTextField(5);
		telefone = new JLabel("Telefone");
		fieldTelefone = new JTextField(5);
		
		endereco = new JLabel("Endere�o");
		cpf = new JLabel("CPF:");
		
		end = new JTextField(5);
		cpffield = new JTextField(5);
		
		
		
		
		finalizarCadastro = new JButton("Finalizar Cadastro");
		finalizarCadastro.addActionListener(ouvinte);
		
		paineltest.add(nomeCompleto);
		paineltest.add(fieldNome);
		paineltest.add(cpf);
		paineltest.add(cpffield);
		paineltest.add(telefone);
		paineltest.add(fieldTelefone);
		paineltest.add(email);
		paineltest.add(fieldEmail);
		paineltest.add(endereco);
		paineltest.add(end);
		
		paineltest.add(finalizarCadastro);
		
		painelLogin.add(paineltest,BorderLayout.WEST);
		aba.addTab("Cadastro", null, painelLogin, null);
		//SEGUNDA ABA
		JPanel principal2 = new JPanel();
		JPanel painel2 = new JPanel();
		JPanel paineldeSuporte = new JPanel();

		modeloDe = new DefaultComboBoxModel();
		modeloAte = new DefaultComboBoxModel();

     
   
		combode = new JComboBox(modeloDe);
		comboate = new JComboBox(modeloAte);
   
		modeloDe.addElement(null);
		modeloAte.addElement(null);
		
		JLabel partindoDe = new JLabel("Partida de:");
		
		
		JLabel chegadaEm = new JLabel("Chegada em:");
		
		
		JLabel dataPartida = new JLabel("-----------------------------");
		//JTextField datPart = new JTextField(5);
		
		//JLabel dataRetorno = new JLabel("Data do retorno");
		//JTextField datRet = new JTextField(5);
		
		rb1 = new JRadioButton("Menor pre�o");
		rb2 = new JRadioButton("Menor distancia");
		rb3 = new JRadioButton("Menor tempo");
		grup = new ButtonGroup();
		grup.add(rb1);
		grup.add(rb2);
		grup.add(rb3);
		
		localiza = new JButton ("localizar");
		localiza.addActionListener(ouvinte);
		
		painel2.setLayout(new GridLayout(6,2,20,30));
		paineldeSuporte.setLayout(new GridLayout(4,3,20,20));
		JTextField rot1 = new JTextField();
		JTextField rot2 = new JTextField();
		
		painel2.add(rb1);
		painel2.add(rb2);
		painel2.add(rb3);
		painel2.add(dataPartida);
		//painel2.add(paineldeSuporte);
		painel2.add(partindoDe);
		painel2.add(chegadaEm);
		painel2.add(combode);
		painel2.add(comboate);
		
		/*painel2.add(dataPartida);
		painel2.add(dataRetorno);
		painel2.add(datPart);
		painel2.add(datRet);*/
		painel2.add(localiza);
		
		painel2.setBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder("Buscar Por:"),
						BorderFactory.createEmptyBorder(10,10,10,10))
						
				);
		
		principal2.setLayout(new BorderLayout());
		
		txtLog2 = new JEditorPane();
		txtLog2.setContentType("text/html");
		txtLog2.setEditorKit(new HTMLEditorKit());
		txtLog2.setEditable(false);
		txtLog2.setPreferredSize(new Dimension(20, 20));
		
		//desenharRetangulo retangulo2 =new desenharRetangulo();
		principal2.add(txtLog2, BorderLayout.CENTER);
		
		principal2.add(painel2,BorderLayout.WEST);
		
		
		
		//TERCEIRA ABA
		JPanel principal3 = new JPanel();
		JPanel painelCalcularV1 = new JPanel();
		JLabel partidaDe = new JLabel("Partida de:");
		JLabel chegadaEmCal = new JLabel("Chegada em:");
		JLabel qtdDePasg = new JLabel("Qtd passageiros");
		
		JSpinner qtdPas = new JSpinner();
		JTextField rot3 = new JTextField();
		JTextField rot4 = new JTextField();
		
		
		painelCalcularV1.setLayout(new GridLayout(4, 2, 20, 70));
		painelCalcularV1.add(partidaDe);
		painelCalcularV1.add(rot3);
		painelCalcularV1.add(chegadaEmCal);
		painelCalcularV1.add(rot4);
		painelCalcularV1.add(qtdDePasg);
		painelCalcularV1.add(qtdPas);
		
		painelCalcularV1.setBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder("Dados da viagem"),
						BorderFactory.createEmptyBorder(10,10,10,10))
						
				);
		
	
		
principal3.setLayout(new BorderLayout());
		
		desenharRetangulo retangulo3 =new desenharRetangulo();
		principal3.add(retangulo3, BorderLayout.CENTER);
		
		principal3.add(painelCalcularV1,BorderLayout.WEST);
		//quarta aba
		
		
		JPanel painelCadastro2 = new JPanel();
		JPanel painelCadastro3 = new JPanel();
		JPanel painelCadastro = new JPanel();
		JPanel painelCadastro4 = new JPanel();
		JPanel painelCadastro5 = new JPanel();
		painelCadastro.setLayout(new GridLayout(4, 2, 10, 60) );
		
		
		
		
		
		
		JLabel aeroporto = new JLabel("Nome:");
		fieldAeroporto1 = new JTextField();
		
		
		fieldDist = new JTextField();
		
		
		
		painelCadastro.add(aeroporto);
		painelCadastro.add(fieldAeroporto1);
		
		
		
		criarNo = new JButton("criar");
		
		criarNo.addActionListener(ouvinte);
		
		painelCadastro.add(criarNo);
		
		removerNo = new JButton("remover");
		
		removerNo.addActionListener(ouvinte);
		
		painelCadastro.add(removerNo);
		
		listaAero=new JButton("Lista Aeroportos");
		listaAero.addActionListener(ouvinte);
		painelCadastro.add(listaAero);
		painelCadastro.setBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder("Aeroporto"),
						BorderFactory.createEmptyBorder(10,10,10,10))
						
				);
		
		
		
		txtLog3 = new JEditorPane();
		txtLog3.setContentType("text/html");
		txtLog3.setEditorKit(new HTMLEditorKit());
		txtLog3.setEditable(false);
		txtLog3.setPreferredSize(new Dimension(40, 40));
		
		painelCadastro5.setLayout(new BorderLayout());
		painelCadastro5.add(txtLog3, BorderLayout.CENTER);
		painelCadastro5.add(painelCadastro,BorderLayout.WEST);
		
		//quinta aba
		painelCadastro4.setLayout(new GridLayout(7, 2, 10, 10) );
		modelo = new DefaultComboBoxModel();
		modelo2 = new DefaultComboBoxModel();

     
   
		combo = new JComboBox(modelo);
		combo2 = new JComboBox(modelo2);
   
		modelo.addElement(null);
		modelo2.addElement(null);
		
		
		JLabel dista = new JLabel("Distancia");
		painelCadastro4.add(combo);
		painelCadastro4.add(combo2);
		criarAresta = new JButton("Criar Rota");
		
		criarAresta.addActionListener(ouvinte);
		
		removerAresta = new JButton("Remover Rota");
		
		removerAresta.addActionListener(ouvinte);
		listaRota=new JButton("Lista rotas");
		listaRota.addActionListener(ouvinte);
		
		JLabel tempo = new JLabel("Tempo de voo");
		JLabel preco = new JLabel("Pre�o");
		
		fieldTempo = new JTextField();
		fieldPreco = new JTextField();
		
		fieldTempo.setSize(5,5);
		painelCadastro4.add(dista);
		painelCadastro4.add(fieldDist);
		painelCadastro4.add(tempo);
		painelCadastro4.add(fieldTempo);
		painelCadastro4.add(preco);
		painelCadastro4.add(fieldPreco);
		
		painelCadastro4.add(criarAresta);
		painelCadastro4.add(removerAresta);
		
		
		
		
		painelCadastro4.add(listaRota);
		
		painelCadastro4.setBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder("Distancia entre Aeroportos"),
						BorderFactory.createEmptyBorder(10,10,10,10))
						
				);
		
		
		btnCalcular = new JButton("Calcular o menor caminho");
		
		btnCalcular.addActionListener(ouvinte);
		
		txtLog = new JEditorPane();
		txtLog.setContentType("text/html");
		txtLog.setEditorKit(new HTMLEditorKit());
		txtLog.setEditable(false);
		txtLog.setPreferredSize(new Dimension(300, 170));
		
		painelCadastro2.add(txtLog);
		//painelCadastro.add(btnCalcular);
		painelCadastro3.setLayout(new BorderLayout());
		
		
        painelCadastro3.add(txtLog, BorderLayout.CENTER);
		
		painelCadastro3.add(painelCadastro4,BorderLayout.WEST);
		
		
		aba.addTab("Reserva viagem", null, principal2, null);
		aba.addTab("Calcular viagem",null,principal3,null);
		aba.addTab("Adicionar Aeroporto", null,painelCadastro5,null);
		aba.addTab("Adicionar Rota",null,painelCadastro3,null);
		
		
	}
	
	
	

	
	class ButtonListener implements ActionListener {
		
		public void appendLog(String color, String text) {
			log.append("<font color=\"" + color + "\">" + text + "</font><br>");
			txtLog.setText(log.toString());
			
			
		}
		
		public void appendLog2(String color, String text) {
			
			
			log2.append("<font color=\"" + color + "\">" + text + "</font><br>");
			txtLog2.setText(log2.toString());
		}
		
		public void appendLog3(String color, String text) {
			
			
			log3.append("<font color=\"" + color + "\">" + text + "</font><br>");
			txtLog3.setText(log3.toString());
		}
		
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			
			if (obj == criarNo){
				try{
					f.adicionarAeroporto(fieldAeroporto1.getText());
				
				
					modelo.addElement(fieldAeroporto1.getText());
					modelo2.addElement(fieldAeroporto1.getText());
					modeloDe.addElement(fieldAeroporto1.getText());
					modeloAte.addElement(fieldAeroporto1.getText());
					this.appendLog3("green", "Aeroporto \"" + fieldAeroporto1.getText() + "\" criado.");
				}
				catch (VerticeDuplicadoException vd) {
					this.appendLog3("red", "Este Aeroporto ja existe ");
				}
			
			}
			if(obj==criarAresta){
				 
				double peso , temp,prec; 
				
				try{
				peso = Integer.parseInt(fieldDist.getText());
				temp=Integer.parseInt(fieldTempo.getText()); 
				prec=Integer.parseInt(fieldPreco.getText());
				
				f.adicionarRota((String)modelo.getSelectedItem(),(String)modelo2.getSelectedItem(),peso,prec,temp);
	
				this.appendLog("green", "Rota \"" + modelo.getSelectedItem() + "--"+ modelo2.getSelectedItem() + "\" criada.");
				}
			
				catch (ArestaComVerticeInvalidoException arestaInv) {
					this.appendLog("red", "Rota com aeroporto invalido");
				}
				
				catch (PesoInvalidoException pesoInv) {
					this.appendLog("red", "Rota com peso invalido");
				}
				
				catch (NumberFormatException pesoInv) {
					this.appendLog("red", "Distancia deve ser um n�mero");
				} catch (ArestaComVerticeDuplicadoException avd) {
					
					this.appendLog("red", "N�o � permitido adicionar rotas de um mesmo aeroporto");
				}
				
			}

			
			if (obj==removerNo){
				try{
				f.RemoverAeroporto(fieldAeroporto1.getText());
				modelo.removeElement(fieldAeroporto1.getText());
				modelo2.removeElement(fieldAeroporto1.getText());
				
				this.appendLog3("green", "Aeroporto \"" + fieldAeroporto1.getText() + "\" removido.");
			}
				catch (VerticeNaoExistenteExeception vne) {
					this.appendLog3("red", "Nao existe nenhum aeroporto com esse nome para ser removido");
				}
					
				
			}
			if(obj==removerAresta){
				try {
				f.removerRota((String)modelo.getSelectedItem(),(String)modelo2.getSelectedItem());
				this.appendLog("green", "Rota removida");
				} catch (NenhumaRotaException nre) {
					this.appendLog("red", "N�o existem rotas a serem removidas");	
				}
			}
		
			if(obj==listaAero){
				List tdsAero=new ArrayList();
				tdsAero.addAll(f.listarTodosOsAeroportos());
				
				for(int i=0;i<tdsAero.size();i++){
					
				
				this.appendLog3("green","Aeroporto: "+ tdsAero.get(i));
				}
				
			}
				if(obj==listaRota){
					List tdsRotas = new ArrayList();
					
					tdsRotas=f.listarTodosAsRotas();
					
					
					
					this.appendLog("green","Rota: "+ tdsRotas.toString());
						
				
			}
			
			if(obj==localiza){
				if(rb2.isSelected()){
					List rotaMenorCaminho = new ArrayList();
					String nomeVert = (String)modeloDe.getSelectedItem();
					String nomeVert2 =(String)modeloAte.getSelectedItem();
					rotaMenorCaminho = f.calcularMenorCam(nomeVert,nomeVert2);
					this.appendLog2("green", "Menor Rota � "+ rotaMenorCaminho.toString());
				}
				if(rb1.isSelected()){
					List rotaMenorPreco = new ArrayList();
					String nomeVert = (String)modeloDe.getSelectedItem();
					String nomeVert2 =(String)modeloAte.getSelectedItem();
					rotaMenorPreco = f.calcularMenorPreco(nomeVert,nomeVert2);
					this.appendLog2("green", "Rota de menor Pre�o � "+ rotaMenorPreco.toString());
					
					/*
				double peso=0;
				
				peso = f.LocalizaRota((String)modeloDe.getSelectedItem(),(String)modeloAte.getSelectedItem());
				
				this.appendLog2("green", "Rota "+ modeloDe.getSelectedItem() + " -- " + modeloAte.getSelectedItem()+" distancia : " + peso + "km" );
				*/
				}
			}
			if (obj == cadastra){
				
				
				aba.setComponentAt(0, painelLogin);
			}
			if(obj == finalizarCadastro){
				 JOptionPane.showMessageDialog(null, "Cadastro realizado", null,JOptionPane.INFORMATION_MESSAGE);
				
				
			}
		}
	}
	


	}


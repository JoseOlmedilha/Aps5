package chat;

import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient {
	
	static JFrame chatJanela = new JFrame("Meu Chat");
	static JTextArea chatMensagens = new JTextArea(22, 40);
	static JTextField chatNovaMensagem = new JTextField(40);
	static JButton chatBotaoEnviar = new JButton("Enviar");
	static BufferedReader entrada;
	static PrintWriter saida;
	
	public ChatClient() {
		chatJanela.setLayout(new FlowLayout());
		chatJanela.add(new JScrollPane(chatMensagens));
		chatJanela.add(chatNovaMensagem);
		chatJanela.add(chatBotaoEnviar);
		
		chatJanela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chatJanela.setSize(475, 500);
		chatJanela.setVisible(true);
		chatMensagens.setEditable(false);
		chatNovaMensagem.setEditable(false);
		
	}

	
	public void iniciarChat() throws Exception{
		String endereçoIP = JOptionPane.showInputDialog(chatJanela, "Endereço IP do servidor: ","Informação",JOptionPane.PLAIN_MESSAGE);
		Socket usuario = new Socket(endereçoIP,9086);
	
		entrada = new BufferedReader(new InputStreamReader(usuario.getInputStream()));
		saida = new PrintWriter(usuario.getOutputStream(),  true);
		
		while (true) {
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		ChatClient chat = new ChatClient();
		chat.iniciarChat();
		
		
		
		
	}

}
